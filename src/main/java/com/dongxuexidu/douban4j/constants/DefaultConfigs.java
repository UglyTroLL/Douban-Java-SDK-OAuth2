package com.dongxuexidu.douban4j.constants;

import com.dongxuexidu.douban4j.model.app.RequestGrantScope;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DefaultConfigs {
  
  public static final String API_KEY = "blahblah";
  public static final String SECRET_KEY = "blahblah2";
  public static final String API_URL_PREFIX = "https://api.douban.com";
  public static final String AUTH_URL = "https://www.douban.com/service/auth2/auth";
  public static final String ACCESS_TOKEN_URL = "https://www.douban.com/service/auth2/token";
  public static final String ACCESS_TOKEN_REDIRECT_URL = "https://www.dongxuexidu.com";
  
  public static final RequestGrantScope SCOPE_SHUO_READ = new RequestGrantScope("DoubanShuoRead", "shuo_basic_r", "豆瓣说读取权限");
  public static final RequestGrantScope SCOPE_SHUO_WRITE = new RequestGrantScope("DoubanShuoWrite", "shuo_basic_w", "豆瓣说写入权限");
  
}
