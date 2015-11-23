/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import com.dongxuexidu.douban4j.model.collection.DoubanCollectionFeedObj;
import com.dongxuexidu.douban4j.model.collection.DoubanCollectionObj;
import com.dongxuexidu.douban4j.service.DoubanCollectionService.CollectionCategory;
import com.dongxuexidu.douban4j.service.DoubanCollectionService.CollectionStatus;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanCollectionServiceTest extends TestCase {
  
  private String accessToken = "xxx";

  /**
   * Test of getCollectionById method, of class DoubanCollectionService.
   */
  public void testGetCollectionById() throws Exception {
    System.out.println("getCollectionById");
    Long collectionId = 562332459L;
    DoubanCollectionService instance = new DoubanCollectionService();
    DoubanCollectionObj result = instance.getCollectionById(collectionId);
    assertEquals(result.getSubject().getTitle(), "你好，郑州");
    assertTrue(result.getSubject().getCategory().getTerm().contains("music"));
  }

  /**
   * Test of getUsersCollection method, of class DoubanCollectionService.
   */
  public void testGetUsersCollection_String() throws Exception {
    System.out.println("getUsersCollection");
    String userId = "xxx";
    DoubanCollectionService instance = new DoubanCollectionService();
    DoubanCollectionFeedObj result = instance.getUsersCollection(userId);
    for (DoubanCollectionObj col : result.getCollections()) {
      System.out.println("col title : " + col.getTitle());
      System.out.println("col id : " + col.getId());
      System.out.println("col subject title : " + col.getSubject().getTitle());
    }
    assertTrue(result.getCollections().size() > 0);
  }

  /**
   * Test of getUsersCollection method, of class DoubanCollectionService.
   */
  public void testGetUsersCollection_8args() throws Exception {
    System.out.println("getUsersCollection");
    String userId = "xxx";
    CollectionCategory category = CollectionCategory.Music;
    String tag = "";
    CollectionStatus status = CollectionStatus.MusicEd;
    Integer startIndex = 0;
    Integer maxResult = 2;
    Date startDate = null;
    Date endDate = null;
    DoubanCollectionService instance = new DoubanCollectionService();
    DoubanCollectionFeedObj result = instance.getUsersCollection(userId, category, tag, status, startIndex, maxResult, startDate, endDate);
    for (DoubanCollectionObj col : result.getCollections()) {
      System.out.println("col title : " + col.getTitle());
      System.out.println("col id : " + col.getId());
      System.out.println("col user summary : " + col.getSummary());
//      System.out.println("col subject title : " + col.getSubject().getTitle());
    }
    assertTrue(result.getCollections().size() > 0);
  }

  /**
   * Test of createNewCollection method, of class DoubanCollectionService.
   */
  public void testCreateNewCollection() throws Exception {
    System.out.println("createNewCollection");
    CollectionStatus status = CollectionStatus.MovieEd;
    List<String> tags = new ArrayList<String>();
    tags.add("test");
    tags.add("dongxuexidu");
    int rating = 5;
    String content = "Test From Dongxuexidu";
    long subjectId = 00000000l;
    boolean isPrivate = false;
    DoubanCollectionService instance = new DoubanCollectionService();
    boolean result = instance.createNewCollection(status, tags, rating, content, subjectId, isPrivate, accessToken);
    assertTrue(result);
  }

  /**
   * Test of updateCollection method, of class DoubanCollectionService.
   */
  public void testUpdateCollection() throws Exception {
    System.out.println("updateCollection");
    Long collectionId = 00000000L;
    CollectionStatus status = CollectionStatus.MusicEd;
    List<String> tags = new ArrayList<String>();
    tags.add("test");
    tags.add("dongxuexidu");
    int rating = 5;
    String content = "Test From Dongxuexidu";
    long subjectId = 00000000l;
    DoubanCollectionService instance = new DoubanCollectionService();
    boolean result = instance.updateCollection(collectionId, status, tags, rating, content, subjectId, accessToken);
    assertTrue(result);
  }

  /**
   * Test of deleteCollection method, of class DoubanCollectionService.
   */
  public void testDeleteCollection() throws Exception {
    System.out.println("deleteCollection");
    Long collectionId = 00000000l;
    DoubanCollectionService instance = new DoubanCollectionService();
    boolean result = instance.deleteCollection(collectionId, accessToken);
    assertTrue(result);
  }
}
