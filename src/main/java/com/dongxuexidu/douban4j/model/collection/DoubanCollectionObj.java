package com.dongxuexidu.douban4j.model.collection;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.dongxuexidu.douban4j.model.common.DoubanRatingObj;
import com.dongxuexidu.douban4j.model.common.DoubanTagObj;
import com.dongxuexidu.douban4j.model.subject.DoubanSubjectObj;
import com.dongxuexidu.douban4j.model.user.DoubanUserObj;
import com.dongxuexidu.douban4j.utils.Converters;
import java.util.ArrayList;
import java.util.Date;
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
public class DoubanCollectionObj implements IDoubanObject{

  @Override
  public String getObjName() {
    return "doubancollection";
  }
  
  private Date updateTime = null;
  private List<DoubanTagObj> tags = new ArrayList<DoubanTagObj>();
  private DoubanUserObj author = null;
  private String title = "";
  private Map<String, String> links = new HashMap<String, String>();
  private String id;
  private DoubanSubjectObj subject = null;
  private String status;
  private DoubanRatingObj rating = null;

  /**
   * @return the updateTime
   */
  public Date getUpdateTime() {
    return updateTime;
  }

  /**
   * @param updateTime the updateTime to set
   */
  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  /**
   * @return the tags
   */
  public List<DoubanTagObj> getTags() {
    return tags;
  }

  /**
   * @param tags the tags to set
   */
  public void setTags(List<DoubanTagObj> tags) {
    this.tags = tags;
  }
  
  public void addTag (DoubanTagObj tag) {
    this.tags.add(tag);
  }

  /**
   * @return the author
   */
  public DoubanUserObj getAuthor() {
    return author;
  }

  /**
   * @param author the author to set
   */
  public void setAuthor(DoubanUserObj author) {
    this.author = author;
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

  /**
   * @return the links
   */
  public String getSelfLink () {
    return this.links.containsKey("self") ? this.links.get("self") : null;
  }
  
  public String getSubjectLink () {
    return this.links.containsKey("subject") ? this.links.get("subject") : null;
  }
  
  public void addLink (String rel, String href) {
    if (rel.contains("subject")) {
      this.links.put("subject", href);
    } else {
      this.links.put(rel, href);
    }
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

  /**
   * @return the subject
   */
  public DoubanSubjectObj getSubject() {
    return subject;
  }

  /**
   * @param subject the subject to set
   */
  public void setSubject(DoubanSubjectObj subject) {
    this.subject = subject;
  }

  /**
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(String status) {
    this.status = status;
  }

  @Override
  public IDoubanObject ConvertFrom(JSON json) {
    JSONObject jObj = (JSONObject)json;
    if (jObj.containsKey("updated")) {
      JSONObject jObjUpdated = jObj.getJSONObject("updated");
      Date updatedDate = Converters.jsonTimeStampToDate(jObjUpdated.getString("$t"));
      if (updatedDate != null) {
        this.setUpdateTime(updatedDate);
      }
    }
    if (jObj.containsKey("author")) {
      JSONObject jObjAuthor = jObj.getJSONObject("author");
      this.setAuthor((DoubanUserObj)new DoubanUserObj().ConvertFrom(jObjAuthor));
    }
    if (jObj.containsKey("title")) {
      JSONObject jObjTitle = jObj.getJSONObject("title");
      this.setTitle(jObjTitle.getString("$t"));
    }
    if (jObj.containsKey("db:subject")) {
      JSONObject jObjSubject = jObj.getJSONObject("db:subject");
      this.setSubject((DoubanSubjectObj)new DoubanSubjectObj().ConvertFrom(jObjSubject));
    }
    if (jObj.containsKey("link")) {
      JSONArray arrLink = jObj.getJSONArray("link");
      for (int i = 0 ; i < arrLink.size() ; i ++) {
        JSONObject obj = arrLink.getJSONObject(i);
        this.addLink(obj.getString("@rel"), obj.getString("@href"));
      }
    }
    this.setId(jObj.containsKey("id") ? jObj.getJSONObject("id").getString("$t") : "");
    this.setStatus(jObj.containsKey("db:status") ? jObj.getJSONObject("db:status").getString("$t") : "");
    if (jObj.containsKey("gd:rating")) {
      JSONObject obj = jObj.getJSONObject("gd:rating");
      this.setRating((DoubanRatingObj) new DoubanRatingObj().ConvertFrom(obj));
    }
    return this;
  }

  /**
   * @return the rating
   */
  public DoubanRatingObj getRating() {
    return rating;
  }

  /**
   * @param rating the rating to set
   */
  public void setRating(DoubanRatingObj rating) {
    this.rating = rating;
  }
  
}
