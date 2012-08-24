package com.dongxuexidu.douban4j.model.event;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.dongxuexidu.douban4j.model.common.DoubanAttributeObj;
import com.dongxuexidu.douban4j.model.common.DoubanAuthorObj;
import com.dongxuexidu.douban4j.model.common.DoubanCategoryObj;
import com.dongxuexidu.douban4j.model.common.DoubanLinkObj;
import com.dongxuexidu.douban4j.model.common.DoubanLocationObj;
import com.dongxuexidu.douban4j.model.common.DoubanWhenObj;
import com.dongxuexidu.douban4j.model.common.DoubanWhereObj;
import com.google.api.client.util.Key;
import java.util.List;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanEventEntryObj implements IDoubanObject{

  @Override
  public String getObjName() {
    return "doubanevent";
  }
  
  @Key
  private String id;
  
  @Key
  private String title;
  
  @Key("category")
  private DoubanCategoryObj category;
  
  @Key("author")
  private DoubanAuthorObj author;
  
  @Key("link")
  private List<DoubanLinkObj> links;
  
  @Key("summary")
  private String summary;
  
  @Key("content")
  private String content;
  
  @Key("db:attribute")
  private List<DoubanAttributeObj> attrs;
  
  @Key("db:location")
  private DoubanLocationObj locaiton;
  
  @Key("gd:when")
  private DoubanWhenObj when;
  
  @Key("gd:where")
  private DoubanWhereObj where;

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
   * @return the attrs
   */
  public List<DoubanAttributeObj> getAttrs() {
    return attrs;
  }

  /**
   * @param attrs the attrs to set
   */
  public void setAttrs(List<DoubanAttributeObj> attrs) {
    this.attrs = attrs;
  }

  /**
   * @return the locaiton
   */
  public DoubanLocationObj getLocaiton() {
    return locaiton;
  }

  /**
   * @param locaiton the locaiton to set
   */
  public void setLocaiton(DoubanLocationObj locaiton) {
    this.locaiton = locaiton;
  }

  /**
   * @return the when
   */
  public DoubanWhenObj getWhen() {
    return when;
  }

  /**
   * @param when the when to set
   */
  public void setWhen(DoubanWhenObj when) {
    this.when = when;
  }

  /**
   * @return the where
   */
  public DoubanWhereObj getWhere() {
    return where;
  }

  /**
   * @param where the where to set
   */
  public void setWhere(DoubanWhereObj where) {
    this.where = where;
  }
  
}
