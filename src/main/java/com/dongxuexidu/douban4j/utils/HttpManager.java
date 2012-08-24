package com.dongxuexidu.douban4j.utils;

import com.dongxuexidu.douban4j.constants.DefaultConfigs;
import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.dongxuexidu.douban4j.model.app.DoubanException;
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
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.IOUtils;
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

  public <T extends IDoubanObject> T getResponse(String url, List<NameValuePair> params, Class<T> responseType, boolean needAccessToken) throws DoubanException, IOException {
    if (params != null && params.size() > 0) {
      String encodedParams = encodeParameters(params);
      url = url + "?" + encodedParams;
    }
    HttpRequest method = requestFactory.buildGetRequest(new GenericUrl(url));
    return httpRequest(method, needAccessToken).parseAs(responseType);
  }

  public <T, W extends IDoubanObject> W postResponse(String url, T requestObj, Class<W> responseType, boolean needAccessToken) throws DoubanException, IOException {
    AtomContent content = AtomContent.forEntry(DefaultConfigs.DOUBAN_XML_NAMESPACE, requestObj);
    HttpRequest method = requestFactory.buildPostRequest(new GenericUrl(url), content);
    return httpRequest(method, needAccessToken).parseAs(responseType);
  }

  public <T extends IDoubanObject> int postResponseCodeOnly(String url, T requestObj, boolean needAccessToken) throws DoubanException, IOException {
    AtomContent content = null;
    if (requestObj != null) {
      content = AtomContent.forEntry(DefaultConfigs.DOUBAN_XML_NAMESPACE, requestObj);
    }
    //System.out.println("content : " + content.toString());
//    OutputStream out = new FileOutputStream("/home/zwei/testdouban.file");
//    content.writeTo(out);
    HttpRequest method = requestFactory.buildPostRequest(new GenericUrl(url), content);
    HttpResponse response = httpRequest(method, needAccessToken);
    return response.getStatusCode();
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

  public <T, W extends IDoubanObject> W putResponse(String url, T requestObj, Class<W> responseType, boolean needAccessToken) throws DoubanException, IOException {
    AtomContent content = AtomContent.forEntry(DefaultConfigs.DOUBAN_XML_NAMESPACE, requestObj);
    HttpRequest method = requestFactory.buildPutRequest(new GenericUrl(url), content);
    return httpRequest(method, needAccessToken).parseAs(responseType);
  }

  public <T extends IDoubanObject> int putResponseCodeOnly(String url, T requestObj, boolean needAccessToken) throws DoubanException, IOException {
    AtomContent content = AtomContent.forEntry(DefaultConfigs.DOUBAN_XML_NAMESPACE, requestObj);
    HttpRequest method = requestFactory.buildPutRequest(new GenericUrl(url), content);
    return httpRequest(method, needAccessToken).getStatusCode();
  }

  public int deleteResponse(String url, boolean needAccessToken) throws DoubanException, IOException {
    HttpRequest method = requestFactory.buildDeleteRequest(new GenericUrl(url));
    return httpRequest(method, needAccessToken).getStatusCode();
  }

  private HttpResponse httpRequest(HttpRequest method, boolean needToken) throws DoubanException, IOException {
    try {
      if (needToken) {
        if (!hasAccessTokenBeenSet()) {
          throw ErrorHandler.accessTokenNotSet();
        }
        HttpHeaders headers = method.getHeaders();
        headers.setAuthorization("Bearer " + this.accessToken);
      }
      HttpResponse res = method.execute();
      return res;
    } catch (HttpResponseException ex) {
      throw ErrorHandler.handleHttpResponseError(ex);
    }
  }

  private static String encodeParameters(List<NameValuePair> params) {
    StringBuilder buf = new StringBuilder();
    int j = 0;
    for (NameValuePair nvp : params) {
      if (j != 0) {
        buf.append("&");
      }
      j++;
      try {
        buf.append(URLEncoder.encode(nvp.getName(), CHARSET)).append("=").append(URLEncoder.encode(nvp.getValue(), CHARSET));
      } catch (java.io.UnsupportedEncodingException ex) {
        System.out.println("Shouldn't go this far");
      }
    }
    return buf.toString();
  }
}
