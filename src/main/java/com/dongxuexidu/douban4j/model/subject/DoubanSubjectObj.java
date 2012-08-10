/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.model.subject;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.dongxuexidu.douban4j.model.common.DoubanAttributeObj;
import com.dongxuexidu.douban4j.model.common.DoubanAuthorObj;
import com.dongxuexidu.douban4j.model.common.DoubanCategoryObj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanSubjectObj implements IDoubanObject {

  @Override
  public String getObjName() {
    return "subject";
  }
  private DoubanCategoryObj category;
  private List<DoubanAuthorObj> authors = new ArrayList<DoubanAuthorObj>();
  private String title;
  private Map<String, String> links = new HashMap<String, String>();
  private List<DoubanAttributeObj> attributes = new ArrayList<DoubanAttributeObj>();
  private String id;

  /**
   * @return the category
   */
  public DoubanCategoryObj getCategory() {
    return category;
  }

  /**
   * @param category the category to set
   */
  public void setCategory(DoubanCategoryObj category) {
    this.category = category;
  }

  /**
   * @return the authors
   */
  public List<DoubanAuthorObj> getAuthors() {
    return authors;
  }

  /**
   * @param authors the authors to set
   */
  public void setAuthors(List<DoubanAuthorObj> authors) {
    this.authors = authors;
  }

  public void addAuthor(DoubanAuthorObj author) {
    this.authors.add(author);
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  public String getSelfLink() {
    return this.links.containsKey("self") ? this.links.get("self") : null;
  }

  public String getAlternateLink() {
    return this.links.containsKey("alternate") ? this.links.get("alternate") : null;
  }

  public String getImageLink() {
    return this.links.containsKey("image") ? this.links.get("image") : null;
  }

  public String getMobileLink() {
    return this.links.containsKey("mobile") ? this.links.get("mobile") : null;
  }

  /**
   * @param links the links to set
   */
  public void setLinks(Map<String, String> links) {
    this.links = links;
  }

  public void addLink(String rel, String href) {
    this.links.put(rel, href);
  }

  /**
   * @return the attributes
   */
  public List<DoubanAttributeObj> getAttributes() {
    return attributes;
  }

  /**
   * @param attributes the attributes to set
   */
  public void addAttribute(DoubanAttributeObj attribute) {
    this.attributes.add(attribute);
  }

  /**
   * @return the id
   */
  public String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(String id) {
    this.id = id;
  }

  @Override
  public IDoubanObject ConvertFrom(JSON json) {
    JSONObject jObj = (JSONObject) json;
    if (jObj.containsKey("category")) {
      JSONObject temp = jObj.getJSONObject("category");
      this.setCategory((DoubanCategoryObj) new DoubanCategoryObj().ConvertFrom(temp));
    }
    if (jObj.containsKey("author")) {
      JSONArray arrAuthor = jObj.getJSONArray("author");
      for (int i = 0; i < arrAuthor.size(); i++) {
        JSONObject temp = arrAuthor.getJSONObject(i);
        this.addAuthor((DoubanAuthorObj) new DoubanAuthorObj().ConvertFrom(temp));
      }
    }
    if (jObj.containsKey("title")) {
      this.setTitle(jObj.getJSONObject("title").getString("$t"));
    }
    if (jObj.containsKey("link")) {
      JSONArray arrLink = jObj.getJSONArray("link");
      for (int i = 0 ; i < arrLink.size() ; i ++) {
        JSONObject obj = arrLink.getJSONObject(i);
        this.addLink(obj.getString("@rel"), obj.getString("@href"));
      }
    }
    this.setId(jObj.containsKey("id") ? jObj.getJSONObject("id").getString("$t") : "");
    if (jObj.containsKey("db:attribute")) {
      JSONArray arr = jObj.getJSONArray("db:attribute");
      for (int i = 0 ; i < arr.size() ; i ++) {
        JSONObject obj = arr.getJSONObject(i);
        this.addAttribute((DoubanAttributeObj)new DoubanAttributeObj().ConvertFrom(obj));
      }
    }
    return this;
  }
}
