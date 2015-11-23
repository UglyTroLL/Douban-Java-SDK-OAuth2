package com.dongxuexidu.douban4j.model.collection;

import java.util.ArrayList;
import java.util.List;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.dongxuexidu.douban4j.model.common.DoubanAuthorObj;
import com.google.api.client.util.Key;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanCollectionFeedObj implements IDoubanObject{
  
  @Key("entry") 
  private List<DoubanCollectionObj> collections = new ArrayList<DoubanCollectionObj>();
  
  @Key("author")
  private DoubanAuthorObj author;
  
  @Key
  private String title;
  
  @Key("opensearch:itemsPerPage")
  private int itemsPerPage;
  
  @Key("opensearch:startIndex")
  private int startIndex;
  
  @Key("opensearch:totalResults")
  private int totalResult;

  @Override
  public String getObjName() {
    return "doubancollectionfeed";
  }

  /**
   * @return the collections
   */
  public List<DoubanCollectionObj> getCollections() {
    return collections;
  }

  /**
   * @param collections the collections to set
   */
  public void setCollections(List<DoubanCollectionObj> collections) {
    this.collections = collections;
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
  
  public boolean hasCollectionEntries () {
    return (this.collections != null && this.collections.size() > 0);
  }
  
}
