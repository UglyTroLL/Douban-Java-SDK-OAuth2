/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.model.user.DoubanUserFeedObj;
import com.dongxuexidu.douban4j.model.user.DoubanUserObj;
import junit.framework.TestCase;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanUserServiceTest extends TestCase {
  /**
   * Test of searchUserProfileInJSONObj method, of class DoubanUserService.
   */
  public void testSearchUserProfileInJSONObj() throws Exception {
    System.out.println("searchUserProfileInJSONObj");
    String keyword = "uglytroll";
    int startIndex = 10;
    int maxResultCount = 5;
    DoubanUserService instance = new DoubanUserService();
    DoubanUserFeedObj result = instance.getUsersContactsList(keyword, startIndex, maxResultCount);
    for (DoubanUserObj user : result.getUsers()) {
      System.out.println("name : " + user.getTitle());
      if (user.getLocation() != null) {
        System.out.println("location : " + user.getLocation().getValue());
      }
    }
  }
}
