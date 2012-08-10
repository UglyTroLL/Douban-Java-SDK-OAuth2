/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.model.common;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import net.sf.json.JSON;
import net.sf.json.JSONObject;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanCategoryObj implements IDoubanObject {

  @Override
  public String getObjName() {
    return "category";
  }
  
  private String scheme = "";
  private String term = "";

  /**
   * @return the scheme
   */
  public String getScheme() {
    return scheme;
  }

  /**
   * @param scheme the scheme to set
   */
  public void setScheme(String scheme) {
    this.scheme = scheme;
  }

  /**
   * @return the term
   */
  public String getTerm() {
    return term;
  }

  /**
   * @param term the term to set
   */
  public void setTerm(String term) {
    this.term = term;
  }

  @Override
  public IDoubanObject ConvertFrom(JSON json) {
    JSONObject jObj = (JSONObject)json;
    if (jObj.containsKey("@scheme")) {
      this.setScheme(jObj.getString("@scheme"));
    }
    if (jObj.containsKey("@term")) {
      this.setTerm(jObj.getString("@term"));
    }
    return this;
  }
  
}
