package com.dongxuexidu.douban4j.constants;

import com.dongxuexidu.douban4j.model.app.RequestGrantScope;
import com.google.api.client.xml.XmlNamespaceDictionary;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DefaultConfigs {
  
  public static final String API_KEY = "0141ca38326e382503c55ea8974aa86f";
  public static final String SECRET_KEY = "cd60c949d7e1dd2e";
  public static final String API_URL_PREFIX = "https://api.douban.com";
  public static final String AUTH_URL = "https://www.douban.com/service/auth2/auth";
  public static final String ACCESS_TOKEN_URL = "https://www.douban.com/service/auth2/token";
  public static final String ACCESS_TOKEN_REDIRECT_URL = "https://www.dongxuexidu.com";
  
  public static final RequestGrantScope SCOPE_SHUO_READ = new RequestGrantScope("DoubanShuoRead", "shuo_basic_r", "豆瓣说读取权限");
  public static final RequestGrantScope SCOPE_SHUO_WRITE = new RequestGrantScope("DoubanShuoWrite", "shuo_basic_w", "豆瓣说写入权限");
  
  public static final XmlNamespaceDictionary DOUBAN_XML_NAMESPACE = new XmlNamespaceDictionary()
          .set("", "http://www.w3.org/2005/Atom")
          .set("db", "http://www.douban.com/xmlns/")
          .set("gd", "http://schemas.google.com/g/2005")
          .set("opensearch", "http://a9.com/-/spec/opensearchrss/1.0/");
  
}
