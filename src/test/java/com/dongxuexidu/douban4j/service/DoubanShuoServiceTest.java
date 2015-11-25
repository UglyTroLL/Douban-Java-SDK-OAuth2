/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.service;

import junit.framework.TestCase;

import com.dongxuexidu.douban4j.constants.DefaultConfigs;
import com.dongxuexidu.douban4j.model.shuo.DoubanShuoStatusObj;
import com.dongxuexidu.douban4j.model.shuo.DoubanShuoUserObj;
import com.dongxuexidu.douban4j.service.DoubanShuoService.DoubanShuoCategory;
import com.dongxuexidu.douban4j.service.DoubanShuoService.DoubanShuoRelation;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanShuoServiceTest extends TestCase {
  
  private String accessToken = "783da7bbc18ce1af68b8f73344a6a50d";

  /**
   * Test of getStatusesForLoggedInUser method, of class DoubanShuoService.
   */
  public void testGetStatusesForLoggedInUser_String() throws Exception {
    System.out.println("getStatusesForLoggedInUser");
    DoubanShuoService instance = new DoubanShuoService();
    DoubanShuoStatusObj[] result = instance.getHomeTimelineForLoggedInUser(accessToken);
    for (DoubanShuoStatusObj obj : result) {
      System.out.println("obj id : " + obj.getId());
      System.out.println("obj.text : " + obj.getText());
    }
    assertTrue(result.length > 0);
  }

  /**
   * Test of getStatusesForLoggedInUser method, of class DoubanShuoService.
   */
  public void testGetStatusesForLoggedInUser_5args() throws Exception {
    System.out.println("getStatusesForLoggedInUser");
    Long sinceId = 998808639L;
    Long untilId = 998894357L;
    Integer count = 10;
    DoubanShuoCategory category = null;
    DoubanShuoService instance = new DoubanShuoService();
    DoubanShuoStatusObj[] result = instance.getHomeTimelineForLoggedInUser(accessToken, sinceId, untilId, count, category);
    System.out.println("length : " + result.length);
    assertEquals(result.length, 10);
  }

  /**
   * Test of getStatusesByUserId method, of class DoubanShuoService.
   */
  public void testGetStatusesByUserId_String() throws Exception {
    System.out.println("getStatusesByUserId");
    String uid = "xxx";
    DoubanShuoService instance = new DoubanShuoService();
    DoubanShuoStatusObj[] result = instance.getStatusesByUserId(uid);
    for (DoubanShuoStatusObj obj : result) {
      System.out.println("obj.text : " + obj.getText());
    }
    assertTrue(result.length > 0);
  }

  /**
   * Test of getStatusesByUserId method, of class DoubanShuoService.
   */
  public void testGetStatusesByUserId_3args() throws Exception {
    System.out.println("getStatusesByUserId");
    String uid = "xxx";
    Long sinceId = 998808639L;
    Long untilId = 998894357L;
    DoubanShuoService instance = new DoubanShuoService();
    DoubanShuoStatusObj[] result = instance.getStatusesByUserId(uid, sinceId, untilId);
    System.out.println("length : " + result.length);
    assertEquals(result.length, 20);
  }

  /**
   * Test of postNewStatus method, of class DoubanShuoService.
   * 
   * Tested in playground
   */
//  public void testPostNewStatus() throws Exception {
//    System.out.println("postNewStatus");
//    String content = "Not again";
//    DoubanShuoAttachementObj att = null;
//    DoubanShuoService instance = new DoubanShuoService();
//    boolean expResult = false;
//    boolean result = instance.postNewStatus(content, att, accessToken);
//    assertEquals(expResult, result);
//    // TODO review the generated test code and remove the default call to fail.
//    fail("The test case is a prototype.");
//  }

  /**
   * Test of getUserInfoById method, of class DoubanShuoService.
   */
  public void testGetUserInfoById() throws Exception {
    System.out.println("getUserInfoById");
    String userId = "xxx";
    DoubanShuoService instance = new DoubanShuoService();
    DoubanShuoUserObj result = instance.getUserInfoById(userId);
    assertEquals(result.getScreenName(), "xxx");
  }

  /**
   * Test of getFollowingUserByUserId method, of class DoubanShuoService.
   * 
   * Tested in playground
   */
  public void testGetFollowingUserByUserId() throws Exception {
    System.out.println("getFollowingUserByUserId");
    String userId = "xxx";
    DoubanShuoService instance = new DoubanShuoService();
    DoubanShuoUserObj[] result = instance.getFollowingUserByUserId(userId);
    for (DoubanShuoUserObj user : result) {
      System.out.println("user uid : " + user.getUid());
      System.out.println("user id : " + user.getId());
      System.out.println("user name : " + user.getScreenName());
    }
  }

  /**
   * Test of getFollowersByUserId method, of class DoubanShuoService.
   * 
   * Tested in playground
   */
  public void testGetFollowersByUserId() throws Exception {
    System.out.println("getFollowersByUserId");
    String userId = "";
    DoubanShuoService instance = new DoubanShuoService();
    DoubanShuoUserObj[] expResult = null;
    DoubanShuoUserObj[] result = instance.getFollowersByUserId(userId);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of followUser method, of class DoubanShuoService.
   * 
   * Tested in playground
   */
  public void testFollowUser() throws Exception {
    System.out.println("followUser");
    String targetId = "xxx";
    DoubanShuoService instance = new DoubanShuoService();
    boolean result = instance.followUser(targetId, DefaultConfigs.API_KEY, accessToken);
    assertTrue(result);
  }

  /**
   * Test of getRelationship method, of class DoubanShuoService.
   * 
   * Tested in playground
   */
  public void testGetRelationship() throws Exception {
    System.out.println("getRelationship");
    String sourceId = "";
    String targetId = "";
    DoubanShuoService instance = new DoubanShuoService();
    DoubanShuoRelation expResult = null;
    DoubanShuoRelation result = instance.getRelationship(sourceId, targetId, DefaultConfigs.API_KEY);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }
}
