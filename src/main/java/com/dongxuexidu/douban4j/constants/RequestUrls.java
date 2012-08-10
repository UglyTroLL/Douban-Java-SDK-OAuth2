/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.constants;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class RequestUrls {
  
  /**
   * User services
   */
  public static final String GET_USER_PROFILE_URL = DefaultConfigs.API_URL_PREFIX + "/people/";
  public static final String GET_CURRENT_USER_PROFILE_URL = GET_USER_PROFILE_URL + "@me";
  public static final String SEARCH_USER_URL = DefaultConfigs.API_URL_PREFIX + "/people";
  
  /**
   * Collection services
   */
  public static final String GET_COLLECTION_BY_ID_URL = DefaultConfigs.API_URL_PREFIX + "/collection/";
  
}
