/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.model.collection.DoubanCollectionObj;
import junit.framework.TestCase;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanCollectionServiceTest extends TestCase {
  
  /**
   * Test of getCollectionById method, of class DoubanCollectionService.
   */
  public void testGetCollectionById() throws Exception {
    System.out.println("getCollectionById");
    String collectionId = "2154169";
    DoubanCollectionService instance = new DoubanCollectionService();
    DoubanCollectionObj result = instance.getCollectionById(collectionId);
    assertEquals(result.getAuthor().getUri(), "http://api.douban.com/people/1029974");
    System.out.println("uri : " + result.getAuthor().getUri());
    assertEquals(result.getId(), "http://api.douban.com/collection/2154169");
    System.out.println("id : " + result.getId());
    assertEquals(result.getRating().getValue(), "4");
    System.out.println("rating : " + result.getRating().getValue());
    assertEquals(result.getSubject().getId(), "http://api.douban.com/movie/subject/1291824");
    System.out.println("sub id : " + result.getSubject().getId());
  }
  
}
