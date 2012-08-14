/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.playground;

import com.google.api.client.util.Key;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class Location {
  
  @Key("@id")
  public String id;

  @Key("text()")
  private String value;
  
  @Override
  public String toString() {
    
    return "\tlocation id : " + id + " , value : " + value;
    
  }
  
}
