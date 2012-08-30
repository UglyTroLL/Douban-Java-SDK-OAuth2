/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.model.doumail.DoubanMailEntryObj;
import com.dongxuexidu.douban4j.model.doumail.DoubanMailFeedObj;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanMailServiceTest extends TestCase {
  
  private String accessToken = "xxx";

  /**
   * Test of getMailsFromInbox method, of class DoubanMailService.
   */
  public void testGetMailsFromInbox_0args() throws Exception {
    System.out.println("getMailsFromInbox");
    DoubanMailService instance = new DoubanMailService(accessToken);
    DoubanMailFeedObj result = instance.getMailsFromInbox();
    for (DoubanMailEntryObj mail : result.getEntries()) {
      System.out.println("title : " + mail.getTitle());
      System.out.println("author : " + mail.getAuthor().getName());
    }
    assertTrue(result.getEntries().size() > 0);
  }

  /**
   * Test of getMailsFromInbox method, of class DoubanMailService.
   */
  public void testGetMailsFromInbox_Integer_Integer() throws Exception {
    System.out.println("getMailsFromInbox");
    Integer startIndex = 0;
    Integer maxResult = 2;
    DoubanMailService instance = new DoubanMailService(accessToken);
    DoubanMailFeedObj result = instance.getMailsFromInbox(startIndex, maxResult);
    assertEquals(result.getEntries().size(), 2);
  }

  /**
   * Test of getMailsFromOutbox method, of class DoubanMailService.
   */
  public void testGetMailsFromOutbox_0args() throws Exception {
    System.out.println("getMailsFromOutbox");
    DoubanMailService instance = new DoubanMailService(accessToken);
    DoubanMailFeedObj result = instance.getMailsFromOutbox();
    for (DoubanMailEntryObj mail : result.getEntries()) {
      System.out.println("title : " + mail.getTitle());
    }
    assertTrue(result.getEntries().size() > 0);
  }

  /**
   * Test of getMailsFromOutbox method, of class DoubanMailService.
   */
  public void testGetMailsFromOutbox_Integer_Integer() throws Exception {
    System.out.println("getMailsFromOutbox");
    Integer startIndex = 0;
    Integer maxResult = 2;
    DoubanMailService instance = new DoubanMailService(accessToken);
    DoubanMailFeedObj result = instance.getMailsFromOutbox(startIndex, maxResult);
    assertEquals(result.getEntries().size(), 2);
  }

  /**
   * Test of getUnreadMails method, of class DoubanMailService.
   */
  public void testGetUnreadMails_0args() throws Exception {
    System.out.println("getUnreadMails");
    DoubanMailService instance = new DoubanMailService(accessToken);
    DoubanMailFeedObj result = instance.getUnreadMails();
    assertTrue(result.getEntries() == null || result.getEntries().isEmpty());
  }

  /**
   * Test of getUnreadMails method, of class DoubanMailService.
   */
  public void testGetUnreadMails_Integer_Integer() throws Exception {
    System.out.println("getUnreadMails");
    Integer startIndex = 0;
    Integer maxResult = 2;
    DoubanMailService instance = new DoubanMailService(accessToken);
    DoubanMailFeedObj result = instance.getUnreadMails(startIndex, maxResult);
    assertTrue(result.getEntries() == null || result.getEntries().isEmpty());
  }

  /**
   * Test of getMailById method, of class DoubanMailService.
   */
  public void testGetMailById() throws Exception {
    System.out.println("getMailById");
    long mailId = 193287780L;
    boolean keepUnread = false;
    DoubanMailService instance = new DoubanMailService(accessToken);
    DoubanMailEntryObj result = instance.getMailById(mailId, keepUnread);
    assertEquals(result.getTitle(), "好资源分享——中国的iTune U");
  }

  /**
   * Test of sendMail method, of class DoubanMailService.
   */
  public void testSendMail() throws Exception {
    System.out.println("sendMail");
    String receiverId = "xxx";
    String content = "nihao";
    String title = "woshi zhu";
    DoubanMailService instance = new DoubanMailService(accessToken);
    boolean result = instance.sendMail(receiverId, content, title);
    assertTrue(result);
  }

  /**
   * Test of markMailAsRead method, of class DoubanMailService.
   */
  public void testMarkMailAsRead() throws Exception {
    System.out.println("markMailAsRead");
    long mailId = 263961976L;
    DoubanMailService instance = new DoubanMailService(accessToken);
    boolean result = instance.markMailAsRead(mailId);
    assertTrue(result);
  }

  /**
   * Test of deleteMail method, of class DoubanMailService.
   */
  public void testDeleteMail() throws Exception {
    System.out.println("deleteMail");
    long mailId = 201129794L;
    DoubanMailService instance = new DoubanMailService(accessToken);
    boolean result = instance.deleteMail(mailId);
    assertTrue(result);
  }

  /**
   * Test of markMailReadInBatch method, of class DoubanMailService.
   */
  public void testMarkMailReadInBatch() throws Exception {
    System.out.println("markMailReadInBatch");
    List<Long> ids = new ArrayList<Long>();
    DoubanMailService instance = new DoubanMailService(accessToken);
    boolean expResult = false;
    boolean result = instance.markMailReadInBatch(ids);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of deleteMailsInBatch method, of class DoubanMailService.
   */
  public void testDeleteMailsInBatch() throws Exception {
    System.out.println("deleteMailsInBatch");
    List<Long> ids = new ArrayList<Long>();
    ids.add(199384010L);
    ids.add(195886356L);
    DoubanMailService instance = new DoubanMailService(accessToken);
    boolean result = instance.deleteMailsInBatch(ids);
    assertTrue(result);
  }
}
