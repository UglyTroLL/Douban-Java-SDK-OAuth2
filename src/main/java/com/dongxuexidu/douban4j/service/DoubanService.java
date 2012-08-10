package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.utils.HttpManager;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public abstract class DoubanService {
  
  protected HttpManager client = null;
  
  protected DoubanService () {
    this.client = new HttpManager();
  }
  
  protected DoubanService (String accessToken) {
    this.client = new HttpManager(accessToken);
  }
  
}
