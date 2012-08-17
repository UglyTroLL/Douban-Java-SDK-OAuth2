/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.model.user;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.dongxuexidu.douban4j.model.common.DoubanAuthorObj;
import com.google.api.client.util.Key;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanUserFeedObj implements IDoubanObject {
  
  @Key("entry") 
  private List<DoubanUserObj> users = new ArrayList<DoubanUserObj>();
  
  @Key("author")
  private DoubanAuthorObj author;
  
  @Key
  private String title;
  
  @Key("openSearch:itemsPerPage")
  private int itemsPerPage;
  
  @Key("openSearch:startIndex")
  private int startIndex;
  
  @Key("openSearch:totalResults")
  private int totalResult;

  /**
   * @return the users
   */
  public List<DoubanUserObj> getUsers() {
    return users;
  }

  /**
   * @param users the users to set
   */
  public void setUsers(List<DoubanUserObj> users) {
    this.users = users;
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

  @Override
  public String getObjName() {
    return "doubanuserfeed";
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
  
  public boolean hasUserEntries () {
    return (this.users != null && this.users.size() > 0);
  }
  
}
