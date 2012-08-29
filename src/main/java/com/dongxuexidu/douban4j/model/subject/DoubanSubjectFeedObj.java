package com.dongxuexidu.douban4j.model.subject;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.google.api.client.util.Key;
import java.util.List;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanSubjectFeedObj implements IDoubanObject{
  
  @Key
  private String title;
  
  @Key("opensearch:itemsPerPage")
  private int itemsPerPage;
  
  @Key("opensearch:startIndex")
  private int startIndex;
  
  @Key("opensearch:totalResults")
  private int totalResult;
  
  @Key("entry")
  private List<DoubanSubjectObj> subjects;

  @Override
  public String getObjName() {
    return "subjectfeed";
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

  /**
   * @return the subjects
   */
  public List<DoubanSubjectObj> getSubjects() {
    return subjects;
  }

  /**
   * @param subjects the subjects to set
   */
  public void setSubjects(List<DoubanSubjectObj> subjects) {
    this.subjects = subjects;
  }
  
}
