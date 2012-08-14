package com.dongxuexidu.douban4j.utils;

import com.dongxuexidu.douban4j.constants.DefaultConfigs;
import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.dongxuexidu.douban4j.model.common.PlainTextObj;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.apache.ApacheHttpTransport;
import com.google.api.client.http.xml.atom.AtomContent;
import com.google.api.client.xml.XmlObjectParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class HttpManager {

  private static final ApacheHttpTransport APACHE_HTTP_TRANSPORT = new ApacheHttpTransport();
  private static final String CHARSET = "UTF-8";
  private String accessToken = null;
  HttpRequestFactory requestFactory = null;

  public HttpManager() {
    requestFactory = APACHE_HTTP_TRANSPORT.createRequestFactory(new HttpRequestInitializer() {
      @Override
      public void initialize(HttpRequest hr) throws IOException {
        hr.setParser(new XmlObjectParser(DefaultConfigs.DOUBAN_XML_NAMESPACE));
        HttpHeaders header = new HttpHeaders();
        header.setUserAgent("Dongxuexidu - Java SDK");
        hr.setHeaders(header);
        hr.setNumberOfRetries(3);
      }
    });
  }

  public HttpManager(String accessToken) {
    this();
    this.accessToken = accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }

  private boolean hasAccessTokenBeenSet() {
    return !(this.accessToken == null || this.accessToken.isEmpty());
  }

  public <T extends IDoubanObject> T getResponse(String url, Map<String, String> params, Class<T> responseType, boolean needAccessToken) throws DoubanException {
    try {
      if (params != null && params.size() > 0) {
        String encodedParams = encodeParameters(params);
        url = url + "?" + encodedParams;
      }
      HttpRequest method = requestFactory.buildGetRequest(new GenericUrl(url));
      return httpRequest(method, needAccessToken, responseType);
    } catch (IOException ex) {
      throw ErrorHandler.getCustomDoubanException(100, "Error happened in requesting API : " + ex.toString());
    }
  }

  public <T, W extends IDoubanObject> W postResponse(String url, T requestObj, Class<W> responseType, boolean needAccessToken) throws DoubanException {
    try {
      AtomContent content = AtomContent.forEntry(DefaultConfigs.DOUBAN_XML_NAMESPACE, requestObj);
      HttpRequest method = requestFactory.buildPostRequest(new GenericUrl(url), content);
      return httpRequest(method, needAccessToken, responseType);
    } catch (IOException ex) {
      throw ErrorHandler.getCustomDoubanException(100, "Error happened in requesting API : " + ex.toString());
    }
  }

  public String postResponseAsString(String url, List<NameValuePair> params) throws UnsupportedEncodingException, IOException {
    HttpClient client = APACHE_HTTP_TRANSPORT.getHttpClient();
    HttpPost post = new HttpPost(url);
    post.setEntity(new UrlEncodedFormEntity(params));
    BufferedReader rd = new BufferedReader(new InputStreamReader(client.execute(post).getEntity().getContent()));
    StringBuilder result = new StringBuilder();
    String line = null;
    while ((line = rd.readLine()) != null) {
      result.append(line);
    }
    return result.toString();
  }

  private <T extends IDoubanObject> T httpRequest(HttpRequest method, boolean needToken, Class<T> responseType) throws DoubanException {
    try {
      if (needToken) {
        if (!hasAccessTokenBeenSet()) {
          throw ErrorHandler.accessTokenNotSet();
        }
        HttpHeaders headers = method.getHeaders();
        headers.setAuthorization("Bearer " + this.accessToken);
      }
      HttpResponse res = method.execute();
      return res.parseAs(responseType);
    } catch (HttpResponseException ex) {
      throw ErrorHandler.getCustomDoubanException(100, "Error happened in requesting API : " + ex.toString());
    } catch (IOException ex) {
      throw ErrorHandler.getCustomDoubanException(100, "Error happened in requesting API : " + ex.toString());
    }
  }

  private static String encodeParameters(Map<String, String> params) {
    StringBuilder buf = new StringBuilder();
    int j = 0;
    for (String key : params.keySet()) {
      if (j != 0) {
        buf.append("&");
      }
      j++;
      try {
        buf.append(URLEncoder.encode(key, CHARSET)).append("=").append(URLEncoder.encode(params.get(key), CHARSET));
      } catch (java.io.UnsupportedEncodingException ex) {
        System.out.println("Shouldn't go this far");
      }
    }
    return buf.toString();
  }
}
