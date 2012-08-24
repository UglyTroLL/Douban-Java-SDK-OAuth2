package com.dongxuexidu.douban4j.model.doumail;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.dongxuexidu.douban4j.model.common.DoubanAttributeObj;
import com.dongxuexidu.douban4j.model.common.DoubanAuthorObj;
import com.dongxuexidu.douban4j.model.common.DoubanEntityObj;
import com.dongxuexidu.douban4j.model.common.DoubanLinkObj;
import com.google.api.client.util.Key;
import java.util.List;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanMailEntryObj implements IDoubanObject{
  
  @Key
  private String id;
  
  @Key
  private String title;
  
  @Key("author")
  private DoubanAuthorObj author;
  
  @Key("published")
  private String published;
  
  @Key("link")
  private List<DoubanLinkObj> links;
  
  @Key("content")
  private String content;
  
  @Key("db:entity")
  private DoubanEntityObj entity;
  
  @Key("db:attribute")
  private DoubanAttributeObj attr;

  @Override
  public String getObjName() {
    return "doubanmailentry";
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
   * @return the author
   */
  public DoubanAuthorObj getAuthor() {
    return author;
  }

  /**
   * @param author the author to set
   */
  public void setAuthor(DoubanAuthorObj author) {
    this.author = author;
  }

  /**
   * @return the published
   */
  public String getPublished() {
    return published;
  }

  /**
   * @param published the published to set
   */
  public void setPublished(String published) {
    this.published = published;
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
   * @return the entity
   */
  public DoubanEntityObj getEntity() {
    return entity;
  }

  /**
   * @param entity the entity to set
   */
  public void setEntity(DoubanEntityObj entity) {
    this.entity = entity;
  }

  /**
   * @return the attr
   */
  public DoubanAttributeObj getAttr() {
    return attr;
  }

  /**
   * @param attr the attr to set
   */
  public void setAttr(DoubanAttributeObj attr) {
    this.attr = attr;
  }
  
}
