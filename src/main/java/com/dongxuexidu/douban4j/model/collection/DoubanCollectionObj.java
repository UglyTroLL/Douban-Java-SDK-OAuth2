package com.dongxuexidu.douban4j.model.collection;

import java.util.ArrayList;
import java.util.List;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.dongxuexidu.douban4j.model.common.DoubanAttributeObj;
import com.dongxuexidu.douban4j.model.common.DoubanLinkObj;
import com.dongxuexidu.douban4j.model.common.DoubanRatingObj;
import com.dongxuexidu.douban4j.model.common.DoubanTagObj;
import com.dongxuexidu.douban4j.model.subject.DoubanSubjectObj;
import com.dongxuexidu.douban4j.model.user.DoubanUserObj;
import com.google.api.client.util.Key;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanCollectionObj implements IDoubanObject{

  @Override
  public String getObjName() {
    return "doubancollection";
  }
  
  @Key("updated")
  private String updateTime = null;
  
  @Key("db:tag")
  private List<DoubanTagObj> tags = new ArrayList<DoubanTagObj>();
  
  @Key("author")
  private DoubanUserObj author = null;
  
  @Key
  private String title = "";
  
  @Key("link")
  private List<DoubanLinkObj> links = new ArrayList<DoubanLinkObj>();
  
  @Key
  private String id;
  
  @Key("db:subject")
  private DoubanSubjectObj subject = null;
  
  @Key("db:status")
  private String status;
  
  @Key("gd:rating")
  private DoubanRatingObj rating = null;
  
  @Key("content")
  private String content;
  
  @Key("db:attribute")
  private List<DoubanAttributeObj> att;


  @Key("summary")
  private String summary;

  /**
  * @return user summary on current collection
  * */
  public String getSummary() {
    return summary;
  }

  /**
  * @param summary to set
  * */
  public void setSummary(String summary) {
    this.summary = summary;
  }


  /**
   * @return the updateTime
   */
  public String getUpdateTime() {
    return updateTime;
  }

  /**
   * @param updateTime the updateTime to set
   */
  public void setUpdateTime(String updateTime) {
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
  
  public void setLinks (List<DoubanLinkObj> links) {
    this.links = links;
  }
  
  public void addLink(DoubanLinkObj link) {
    this.links.add(link);
  }
  
  public String getLinkByRel (String rel) {
    for (DoubanLinkObj obj : this.links) {
      if (obj.getRel().equalsIgnoreCase(rel)) {
        return obj.getHref();
      }
    }
    return null;
  }
  
  public List<DoubanLinkObj> getLinks() {
    return this.links;
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

  /**
   * @return the content
   */
  public String getContent() {
    return content;
  }

  /**
   * @param content the content to set
   */
  public void setContent(String content) {
    this.content = content;
  }

  /**
   * @return the att
   */
  public List<DoubanAttributeObj> getAtt() {
    return att;
  }

  /**
   * @param att the att to set
   */
  public void setAtt(List<DoubanAttributeObj> att) {
    this.att = att;
  }
  
}
