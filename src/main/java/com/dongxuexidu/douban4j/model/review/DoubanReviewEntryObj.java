package com.dongxuexidu.douban4j.model.review;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.dongxuexidu.douban4j.model.common.DoubanAuthorObj;
import com.dongxuexidu.douban4j.model.common.DoubanCountObj;
import com.dongxuexidu.douban4j.model.common.DoubanLinkObj;
import com.dongxuexidu.douban4j.model.common.DoubanRatingObj;
import com.dongxuexidu.douban4j.model.subject.DoubanSubjectObj;
import com.google.api.client.util.Key;
import java.util.List;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanReviewEntryObj implements IDoubanObject {

  @Override
  public String getObjName() {
    return "doubanreviewentry";
  }
  
  @Key
  private String id;
  
  @Key
  private String title;
  
  @Key("author")
  private DoubanAuthorObj author;
  
  @Key("published")
  private String publishedTime;
  
  @Key("content")
  private String content;
  
  @Key("updated")
  private String updatedTime;
  
  @Key("link")
  private List<DoubanLinkObj> links;
  
  @Key("summary")
  private String summary;
  
  @Key("db:comments")
  private DoubanCountObj commentsCount;
  
  @Key("db:subject")
  private DoubanSubjectObj subject;
  
  @Key("db:useless")
  private DoubanCountObj uselessCount;
  
  @Key("db:votes")
  private DoubanCountObj usefulCount;
  
  @Key("gd:rating")
  private DoubanRatingObj rating;

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
   * @return the publishedTime
   */
  public String getPublishedTime() {
    return publishedTime;
  }

  /**
   * @param publishedTime the publishedTime to set
   */
  public void setPublishedTime(String publishedTime) {
    this.publishedTime = publishedTime;
  }

  /**
   * @return the updatedTime
   */
  public String getUpdatedTime() {
    return updatedTime;
  }

  /**
   * @param updatedTime the updatedTime to set
   */
  public void setUpdatedTime(String updatedTime) {
    this.updatedTime = updatedTime;
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
   * @return the commentsCount
   */
  public DoubanCountObj getCommentsCount() {
    return commentsCount;
  }

  /**
   * @param commentsCount the commentsCount to set
   */
  public void setCommentsCount(DoubanCountObj commentsCount) {
    this.commentsCount = commentsCount;
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
   * @return the uselessCount
   */
  public DoubanCountObj getUselessCount() {
    return uselessCount;
  }

  /**
   * @param uselessCount the uselessCount to set
   */
  public void setUselessCount(DoubanCountObj uselessCount) {
    this.uselessCount = uselessCount;
  }

  /**
   * @return the usefulCount
   */
  public DoubanCountObj getUsefulCount() {
    return usefulCount;
  }

  /**
   * @param usefulCount the usefulCount to set
   */
  public void setUsefulCount(DoubanCountObj usefulCount) {
    this.usefulCount = usefulCount;
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
  
}
