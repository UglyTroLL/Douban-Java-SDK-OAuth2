package com.dongxuexidu.douban4j.model;

import net.sf.json.JSON;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public interface IDoubanObject {
  
  String getObjName();
  
  IDoubanObject ConvertFrom(JSON json);
  
}
