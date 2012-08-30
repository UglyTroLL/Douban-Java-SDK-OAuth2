package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.model.user.DoubanUserFeedObj;
import com.dongxuexidu.douban4j.model.user.DoubanUserObj;
import com.dongxuexidu.douban4j.playground.PlayGround;
import junit.framework.TestCase;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanUserServiceTest extends TestCase {
  
  private String accessToken = "";
  
  @Override
  protected void setUp() throws Exception {
    super.setUp();
    if (accessToken == null) {
      this.accessToken = PlayGround.testAccessToken();
    }
  }

  /**
   * Test of getUserProfileByUid method, of class DoubanUserService.
   */
  public void testGetUserProfileByUid() throws Exception {
    System.out.println("getUserProfileByUid");
    String uid = "xxx";
    DoubanUserService instance = new DoubanUserService();
    DoubanUserObj result = instance.getUserProfileByUid(uid);
    assertEquals(result.getTitle(), "xxx");
  }

  /**
   * Test of getLoggedInUserProfile method, of class DoubanUserService.
   */
  public void testGetLoggedInUserProfile() throws Exception {
    System.out.println("getLoggedInUserProfile");
    if (accessToken == null) {
      accessToken = PlayGround.testAccessToken();
    }
    DoubanUserService instance = new DoubanUserService();
    DoubanUserObj result = instance.getLoggedInUserProfile(accessToken);
    assertEquals(result.getTitle(), "xxx");
  }

  /**
   * Test of searchUserProfile method, of class DoubanUserService.
   */
  public void testSearchUserProfile_String() throws Exception {
    System.out.println("searchUserProfile");
    String keyword = "xxx";
    DoubanUserService instance = new DoubanUserService();
    DoubanUserFeedObj result = instance.searchUserProfile(keyword);
    assertTrue(result.getUsers().size() > 0);
  }

  /**
   * Test of searchUserProfile method, of class DoubanUserService.
   */
  public void testSearchUserProfile_3args() throws Exception {
    System.out.println("searchUserProfile");
    String keyword = "douban";
    Integer startIndex = 0;
    Integer maxResultCount = 2;
    DoubanUserService instance = new DoubanUserService();
    DoubanUserFeedObj result = instance.searchUserProfile(keyword, startIndex, maxResultCount);
    //System.out.println("size : " + result.getUsers().size());
    assertTrue(result.getUsers().size() == 3); // This is the problem of their API, no my problem
  }

  /**
   * Test of getUsersFriendsList method, of class DoubanUserService.
   */
  public void testGetUsersFriendsList_String_String() throws Exception {
    System.out.println("getUsersFriendsList");
    String uid = "xxx";
    if (accessToken == null) {
      accessToken = PlayGround.testAccessToken();
    }
    DoubanUserService instance = new DoubanUserService();
    DoubanUserFeedObj result = instance.getUsersFriendsList(uid, accessToken);
    assertTrue(result.getUsers().size() > 0);
  }

  /**
   * Test of getUsersFriendsList method, of class DoubanUserService.
   */
  public void testGetUsersFriendsList_4args() throws Exception {
    System.out.println("getUsersFriendsList");
    String uid = "xxx";
    Integer startIndex = 0;
    Integer maxResultCount = 2;
    if (accessToken == null) {
      accessToken = PlayGround.testAccessToken();
    }
    DoubanUserService instance = new DoubanUserService();
    DoubanUserFeedObj result = instance.getUsersFriendsList(uid, startIndex, maxResultCount, accessToken);
    assertTrue(result.getUsers().size() == 2);
  }

  /**
   * Test of getUsersContactsList method, of class DoubanUserService.
   */
  public void testGetUsersContactsList_String() throws Exception {
    System.out.println("getUsersContactsList");
    String uid = "xxx";
    DoubanUserService instance = new DoubanUserService();
    DoubanUserFeedObj result = instance.getUsersContactsList(uid);
    assertTrue(result.getUsers().size() > 0);
  }

  /**
   * Test of getUsersContactsList method, of class DoubanUserService.
   */
  public void testGetUsersContactsList_3args() throws Exception {
    System.out.println("getUsersContactsList");
    String uid = "xxx";
    Integer startIndex = 0;
    Integer maxResultCount = 2;
    DoubanUserService instance = new DoubanUserService();
    DoubanUserFeedObj result = instance.getUsersContactsList(uid, startIndex, maxResultCount);
    assertTrue(result.getUsers().size() == 2);
  }
}
