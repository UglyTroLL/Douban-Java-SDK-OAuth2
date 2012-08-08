package com.dongxuexidu.douban4j.utils;

import com.dongxuexidu.douban4j.model.DoubanException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.DeleteMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.PutMethod;
import org.apache.commons.httpclient.methods.multipart.FilePart;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;
import org.apache.commons.httpclient.methods.multipart.PartBase;
import org.apache.commons.httpclient.methods.multipart.StringPart;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.protocol.Protocol;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class HttpManager {

  private HttpClient client = null;
  private static final String CHARSET = "UTF-8";
  private String accessToken = null;

  public HttpManager() {
    this(150, 2000, 2000);
  }
  
  public HttpManager (String accessToken) {
    this();
    this.accessToken = accessToken;
  }

  public HttpManager(int connectionPerHost, int connectionTimeOutDuration, int socketTimeoutDuration) {
    MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
    HttpConnectionManagerParams params = connectionManager.getParams();
    params.setDefaultMaxConnectionsPerHost(connectionPerHost);
    params.setConnectionTimeout(connectionTimeOutDuration);
    params.setSoTimeout(socketTimeoutDuration);

    HttpClientParams clientParams = new HttpClientParams();
    clientParams.setCookiePolicy(CookiePolicy.IGNORE_COOKIES);
    client = new org.apache.commons.httpclient.HttpClient(clientParams,
            connectionManager);
    Protocol myhttps = new Protocol("https", new DoubanSSLSocketFactory(), 443);
    Protocol.registerProtocol("https", myhttps);
    client.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, CHARSET);
  }

  public HttpManager setAccessToken(String accessToken) {
    this.accessToken = accessToken;
    return this;
  }

  private boolean hasAccessTokenBeenSet() {
    return !(this.accessToken == null || this.accessToken.isEmpty());
  }
  
  public String getResponse (String url, List<NameValuePair> params, boolean needAccessToken) throws DoubanException {
    if (params != null && params.size() > 0) {
      String encodedParams = encodeParameters(params);
      url = url + "?" + encodedParams + "&alt=json";
    } else {
      url = url + "?alt=json";
    }
    GetMethod method = new GetMethod(url);
    return httpRequest(method, needAccessToken);
  }
  
  public String postResponse (String url, List<NameValuePair> params, boolean needAccessToken) throws DoubanException {
    url = url + "?alt=json";
    PostMethod method = new PostMethod(url);
    if (params != null && params.size() > 0) {
      for (NameValuePair nvp : params) {
        method.addParameter(nvp);
      }
    }
    return httpRequest(method, needAccessToken);
  }
  
  private String httpRequest(HttpMethod method) throws DoubanException {
    return httpRequest(method, true);
  }

  private String httpRequest(HttpMethod method, boolean needToken) throws DoubanException {
    try {
      if (needToken) {
        if (!hasAccessTokenBeenSet()) {
          throw ErrorHandler.accessTokenNotSet();
        }
        List<Header> headers = new ArrayList<Header>();
        headers.add(new Header("Authorization", "Bearer " + this.accessToken));
        client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
      }
      method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
      client.executeMethod(method);
      int statusCode = method.getStatusCode();
      String responseStr = method.getResponseBodyAsString();
      if (statusCode != ErrorHandler.HTTP_STATUS_OK) {
        throw ErrorHandler.handleError(statusCode, responseStr);
      } else {
        return responseStr;
      }
    } catch (IOException ex) {
      Logger.getLogger(HttpManager.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    } finally {
      method.releaseConnection();
    }
  }

  private static String encodeParameters(List<NameValuePair> params) {
    StringBuilder buf = new StringBuilder();
    for (int j = 0; j < params.size(); j++) {
      if (j != 0) {
        buf.append("&");
      }
      try {
        buf.append(URLEncoder.encode(params.get(j).getName(), CHARSET)).append("=").append(URLEncoder.encode(params.get(j).getValue(),CHARSET));
      } catch (java.io.UnsupportedEncodingException ex) {
        System.out.println("Shouldn't go this far");
      }
    }
    return buf.toString();
  }
}
