package com.dongxuexidu.douban4j.model.subject;

import java.util.ArrayList;
import java.util.List;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.dongxuexidu.douban4j.model.common.DoubanAttributeObj;
import com.dongxuexidu.douban4j.model.common.DoubanAuthorObj;
import com.dongxuexidu.douban4j.model.common.DoubanCategoryObj;
import com.dongxuexidu.douban4j.model.common.DoubanLinkObj;
import com.dongxuexidu.douban4j.model.common.DoubanRatingObj;
import com.dongxuexidu.douban4j.model.common.DoubanTagObj;
import com.google.api.client.util.Key;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanSubjectObj implements IDoubanObject {

  @Override
  public String getObjName() {
    return "subject";
  }
  
  @Key("category")
  private DoubanCategoryObj category;
  
  @Key("author")
  private List<DoubanAuthorObj> authors = new ArrayList<DoubanAuthorObj>();
  
  @Key
  private String title;
  
  @Key("summary")
  private String summary;
  
  @Key("link")
  private List<DoubanLinkObj> links = new ArrayList<DoubanLinkObj>();
  
  @Key("db2:tag")
  private List<DoubanTagObj> tags = new ArrayList<DoubanTagObj>();
  
  @Key("db2:attribute")
  private List<DoubanAttributeObj> attributes = new ArrayList<DoubanAttributeObj>();
  
  @Key
  private String id;
  
  @Key("gd:rating")
  private DoubanRatingObj rating;

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

  /**
   * @param links the links to set
   */
  public void setLinks(List<DoubanLinkObj> links) {
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
    if (this.tags == null) {
      this.tags = new ArrayList<DoubanTagObj>();
    }
    this.tags.add(tag);
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
}
