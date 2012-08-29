package com.dongxuexidu.douban4j.model.shuo;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.google.api.client.util.Key;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanShuoAttachementObj implements IDoubanObject {
  
  @Key("description")
  private String description;
  
  @Key("title")
  private String title;
  
  @Key("media")
  private List<DoubanShuoMediaObj> medias = new ArrayList<DoubanShuoMediaObj>();
  
  @Key("expaned_href")
  private String expanedHref;
  
  @Key("href")
  private String href;
  
  @Key("caption")
  private String caption;
  
  @Key("type")
  private String type;

  @Override
  public String getObjName() {
    return "doubanshuoattachement";
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
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
   * @return the medias
   */
  public List<DoubanShuoMediaObj> getMedias() {
    return medias;
  }

  /**
   * @param medias the medias to set
   */
  public void setMedias(List<DoubanShuoMediaObj> medias) {
    this.medias = medias;
  }

  /**
   * @return the expanedHref
   */
  public String getExpanedHref() {
    return expanedHref;
  }

  /**
   * @param expanedHref the expanedHref to set
   */
  public void setExpanedHref(String expanedHref) {
    this.expanedHref = expanedHref;
  }

  /**
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * @param href the href to set
   */
  public void setHref(String href) {
    this.href = href;
  }

  /**
   * @return the caption
   */
  public String getCaption() {
    return caption;
  }

  /**
   * @param caption the caption to set
   */
  public void setCaption(String caption) {
    this.caption = caption;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }
  
}
