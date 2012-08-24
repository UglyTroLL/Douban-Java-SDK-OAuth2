package com.dongxuexidu.douban4j.model.event;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.dongxuexidu.douban4j.model.common.DoubanAuthorObj;
import com.dongxuexidu.douban4j.model.common.DoubanLinkObj;
import com.google.api.client.util.Key;
import java.util.List;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanEventFeedObj implements IDoubanObject{
  
  @Key
  private String title;
  
  @Key("author")
  private DoubanAuthorObj author;
  
  @Key("link")
  private List<DoubanLinkObj> links;
  
  @Key("opensearch:itemsPerPage")
  private int itemsPerPage;
  
  @Key("opensearch:startIndex")
  private int startIndex;
  
  @Key("opensearch:totalResults")
  private int totalResult;
  
  @Key("entry")
  private List<DoubanEventEntryObj> entries;

  @Override
  public String getObjName() {
    return "doubaneventfeed";
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
   * @return the itemsPerPage
   */
  public int getItemsPerPage() {
    return itemsPerPage;
  }

  /**
   * @param itemsPerPage the itemsPerPage to set
   */
  public void setItemsPerPage(int itemsPerPage) {
    this.itemsPerPage = itemsPerPage;
  }

  /**
   * @return the startIndex
   */
  public int getStartIndex() {
    return startIndex;
  }

  /**
   * @param startIndex the startIndex to set
   */
  public void setStartIndex(int startIndex) {
    this.startIndex = startIndex;
  }

  /**
   * @return the totalResult
   */
  public int getTotalResult() {
    return totalResult;
  }

  /**
   * @param totalResult the totalResult to set
   */
  public void setTotalResult(int totalResult) {
    this.totalResult = totalResult;
  }

  /**
   * @return the entries
   */
  public List<DoubanEventEntryObj> getEntries() {
    return entries;
  }

  /**
   * @param entries the entries to set
   */
  public void setEntries(List<DoubanEventEntryObj> entries) {
    this.entries = entries;
  }
  
  
}
