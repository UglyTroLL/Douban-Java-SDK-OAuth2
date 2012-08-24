package com.dongxuexidu.douban4j.model.note;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.dongxuexidu.douban4j.model.common.DoubanAttributeObj;
import com.dongxuexidu.douban4j.model.common.DoubanAuthorObj;
import com.dongxuexidu.douban4j.model.common.DoubanLinkObj;
import com.google.api.client.util.Key;
import java.util.List;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanNoteEntryObj implements IDoubanObject{
  
  @Key
  private String id;
  
  @Key
  private String title;
  
  @Key("author")
  private DoubanAuthorObj author;
  
  @Key("published")
  private String published;
  
  @Key("updated")
  private String updated;
  
  @Key("link")
  private List<DoubanLinkObj> links;
  
  @Key
  private String summary;
  
  @Key
  private String content;
  
  @Key("db:attribute")
  private List<DoubanAttributeObj> attributes;

  @Override
  public String getObjName() {
    return "doubannote";
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

  /**
   * @return the updated
   */
  public String getUpdated() {
    return updated;
  }

  /**
   * @param updated the updated to set
   */
  public void setUpdated(String updated) {
    this.updated = updated;
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
   * @return the summary
   */
  public String getSummary() {
    return summary;
  }

  /**
   * @param summary the summary to set
   */
  public void setSummary(String summary) {
    this.summary = summary;
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
   * @return the attributes
   */
  public List<DoubanAttributeObj> getAttributes() {
    return attributes;
  }

  /**
   * @param attributes the attributes to set
   */
  public void setAttributes(List<DoubanAttributeObj> attributes) {
    this.attributes = attributes;
  }
  
}
