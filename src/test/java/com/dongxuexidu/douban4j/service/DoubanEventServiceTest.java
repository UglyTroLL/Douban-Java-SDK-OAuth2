/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.service;

import java.util.Calendar;
import java.util.Date;

import junit.framework.TestCase;

import com.dongxuexidu.douban4j.service.DoubanEventService.EventType;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanEventServiceTest extends TestCase {
  
  private String accessToken = "xxxx";

//  /**
//   * Test of getEventById method, of class DoubanEventService.
//   */
//  public void testGetEventById() throws Exception {
//    System.out.println("getEventById");
//    long eventId = 16564220L;
//    DoubanEventService instance = new DoubanEventService();
//    DoubanEventEntryObj result = instance.getEventById(eventId);
//    assertTrue(result.getTitle().contains("李志旧金山"));
//  }
//
//  /**
//   * Test of getParticipantsByEventId method, of class DoubanEventService.
//   */
//  public void testGetParticipantsByEventId() throws Exception {
//    System.out.println("getParticipantsByEventId");
//    long eventId = 16564220L;
//    DoubanEventService instance = new DoubanEventService();
//    DoubanUserFeedObj result = instance.getParticipantsByEventId(eventId);
//    assertTrue(result.getUsers().size() > 0);
//  }
//
//  /**
//   * Test of getUsersWhoWantsToBeThereByEventId method, of class DoubanEventService.
//   */
//  public void testGetUsersWhoWantsToBeThereByEventId() throws Exception {
//    System.out.println("getUsersWhoWantsToBeThereByEventId");
//    long eventId = 16564220L;
//    DoubanEventService instance = new DoubanEventService();
//    DoubanUserFeedObj result = instance.getUsersWhoWantsToBeThereByEventId(eventId);
//    assertTrue(result.getUsers().size() > 0);
//  }
//
//  /**
//   * Test of getAllUsersEventsByUserId method, of class DoubanEventService.
//   */
//  public void testGetAllUsersEventsByUserId_String() throws Exception {
//    System.out.println("getAllUsersEventsByUserId");
//    String userId = "uglytroll";
//    DoubanEventService instance = new DoubanEventService();
//    DoubanEventFeedObj result = instance.getAllUsersEventsByUserId(userId);
//    for (DoubanEventEntryObj event : result.getEntries()) {
//      System.out.println("event : " + event.getTitle());
//    }
//    assertEquals(result.getEntries().size(), 2);
//  }
//
//  /**
//   * Test of getAllUsersEventsByUserId method, of class DoubanEventService.
//   */
//  public void testGetAllUsersEventsByUserId_3args() throws Exception {
//    System.out.println("getAllUsersEventsByUserId");
//    String userId = "uglytroll";
//    Integer startIndex = 0;
//    Integer maxResult = 1;
//    DoubanEventService instance = new DoubanEventService();
//    DoubanEventFeedObj result = instance.getAllUsersEventsByUserId(userId, startIndex, maxResult);
//    for (DoubanEventEntryObj event : result.getEntries()) {
//      System.out.println("event : " + event.getTitle());
//    }
//    assertEquals(result.getEntries().size(), 1);
//  }
//
//  /**
//   * Test of getAllUserInitiateEventsByUserId method, of class DoubanEventService.
//   */
//  public void testGetAllUserInitiateEventsByUserId_String() throws Exception {
//    System.out.println("getAllUserInitiateEventsByUserId");
//    String userId = "uglytroll";
//    DoubanEventService instance = new DoubanEventService();
//    DoubanEventFeedObj result = instance.getAllUserInitiateEventsByUserId(userId);
//    assertTrue(result.getEntries() == null);
//  }
//
//  /**
//   * Test of getAllUserInitiateEventsByUserId method, of class DoubanEventService.
//   */
//  public void testGetAllUserInitiateEventsByUserId_3args() throws Exception {
//    System.out.println("getAllUserInitiateEventsByUserId");
//    String userId = "uglytroll";
//    Integer startIndex = 0;
//    Integer maxResult = 100;
//    DoubanEventService instance = new DoubanEventService();
//    DoubanEventFeedObj result = instance.getAllUserInitiateEventsByUserId(userId, startIndex, maxResult);
//    assertTrue(result.getEntries() == null);
//  }
//
//  /**
//   * Test of getAllUserParticipateEventsByUserId method, of class DoubanEventService.
//   */
//  public void testGetAllUserParticipateEventsByUserId_String() throws Exception {
//    System.out.println("getAllUserParticipateEventsByUserId");
//    String userId = "uglytroll";
//    DoubanEventService instance = new DoubanEventService();
//    DoubanEventFeedObj result = instance.getAllUserParticipateEventsByUserId(userId);
//    for (DoubanEventEntryObj event : result.getEntries()) {
//      System.out.println("event : " + event.getTitle());
//    }
//    assertEquals(result.getEntries().size(), 2);
//  }
//
//  /**
//   * Test of getAllUserParticipateEventsByUserId method, of class DoubanEventService.
//   */
//  public void testGetAllUserParticipateEventsByUserId_3args() throws Exception {
//    System.out.println("getAllUserParticipateEventsByUserId");
//    String userId = "uglytroll";
//    Integer startIndex = 0;
//    Integer maxResult = 100;
//    DoubanEventService instance = new DoubanEventService();
//    DoubanEventFeedObj result = instance.getAllUserParticipateEventsByUserId(userId, startIndex, maxResult);
//    for (DoubanEventEntryObj event : result.getEntries()) {
//      System.out.println("event : " + event.getTitle());
//    }
//    assertEquals(result.getEntries().size(), 2);
//  }
//
//  /**
//   * Test of getAllUserWishEventsByUserId method, of class DoubanEventService.
//   */
//  public void testGetAllUserWishEventsByUserId_String() throws Exception {
//    System.out.println("getAllUserWishEventsByUserId");
//    String userId = "uglytroll";
//    DoubanEventService instance = new DoubanEventService();
//    DoubanEventFeedObj result = instance.getAllUserWishEventsByUserId(userId);
//    assertTrue(result.getEntries() == null);
//  }
//
//  /**
//   * Test of getAllUserWishEventsByUserId method, of class DoubanEventService.
//   */
//  public void testGetAllUserWishEventsByUserId_3args() throws Exception {
//    System.out.println("getAllUserWishEventsByUserId");
//    String userId = "uglytroll";
//    Integer startIndex = 0;
//    Integer maxResult = 10;
//    DoubanEventService instance = new DoubanEventService();
//    DoubanEventFeedObj result = instance.getAllUserWishEventsByUserId(userId, startIndex, maxResult);
//    assertTrue(result.getEntries() == null);
//  }
//
//  /**
//   * Test of getAllEventsByLocationId method, of class DoubanEventService.
//   */
//  public void testGetAllEventsByLocationId() throws Exception {
//    System.out.println("getAllEventsByLocationId");
//    String locationId = "beijing";
//    DoubanEventService instance = new DoubanEventService();
//    DoubanEventFeedObj result = instance.getAllEventsByLocationId(locationId);
//    assertTrue(result.getEntries().size() > 0);
//  }
//
//  /**
//   * Test of getEventsByLocationIdAndType method, of class DoubanEventService.
//   */
//  public void testGetEventsByLocationIdAndType() throws Exception {
//    System.out.println("getEventsByLocationIdAndType");
//    String locationId = "beijing";
//    EventType type = EventType.Music;
//    DoubanEventService instance = new DoubanEventService();
//    DoubanEventFeedObj result = instance.getEventsByLocationIdAndType(locationId, type);
//    for (DoubanEventEntryObj event : result.getEntries()) {
//      assertTrue(event.getCategory().getTerm().contains("music"));
//    }
//  }
//
//  /**
//   * Test of getEventsByLocationId method, of class DoubanEventService.
//   */
//  public void testGetEventsByLocationId() throws Exception {
//    System.out.println("getEventsByLocationId");
//    String locationId = "beijing";
//    Integer startIndex = 0;
//    Integer maxResult = 10;
//    EventType type = EventType.Music;
//    DoubanEventService instance = new DoubanEventService();
//    DoubanEventFeedObj result = instance.getEventsByLocationId(locationId, startIndex, maxResult, type);
//    for (DoubanEventEntryObj event : result.getEntries()) {
//      assertTrue(event.getCategory().getTerm().contains("music"));
//    }
//    assertEquals(result.getEntries().size(), 10);
//  }
//
//  /**
//   * Test of searchEvent method, of class DoubanEventService.
//   */
//  public void testSearchEvent_String() throws Exception {
//    System.out.println("searchEvent");
//    String keyword = "郭德纲";
//    DoubanEventService instance = new DoubanEventService();
//    DoubanEventFeedObj result = instance.searchEvent(keyword);
//    assertTrue(result.getEntries().size() > 0);
//  }
//
//  /**
//   * Test of searchEventInLocation method, of class DoubanEventService.
//   */
//  public void testSearchEventInLocation() throws Exception {
//    System.out.println("searchEventInLocation");
//    String keyword = "郭德纲";
//    String locationId = "beijing";
//    DoubanEventService instance = new DoubanEventService();
//    DoubanEventFeedObj result = instance.searchEventInLocation(keyword, locationId);
//    assertTrue(result.getEntries().size() > 0);
//  }
//
//  /**
//   * Test of searchEvent method, of class DoubanEventService.
//   */
//  public void testSearchEvent_4args() throws Exception {
//    System.out.println("searchEvent");
//    String keyword = "郭德纲";
//    Integer startIndex = 0;
//    Integer maxResultCount = 5;
//    String locationId = "beijing";
//    DoubanEventService instance = new DoubanEventService();
//    DoubanEventFeedObj result = instance.searchEvent(keyword, startIndex, maxResultCount, locationId);
//    assertEquals(result.getEntries().size(), 5);
//  }

  /**
   * Test of postNewEvent method, of class DoubanEventService.
   */
  public void testPostNewEvent() throws Exception {
    System.out.println("postNewEvent");
    String title = "Test from Dongxuexidu";
    EventType type = EventType.Salon;
    String content = "Test from Dongxuexidu";
    boolean inviteOnly = true;
    boolean canInvite = false;
    Date startTime = new Date();
    Calendar cal = Calendar.getInstance();
    cal.add(Calendar.DAY_OF_MONTH, 10);
    Date endTime = cal.getTime();
    String where = "san francisco";
    DoubanEventService instance = new DoubanEventService();
    boolean result = instance.postNewEvent(title, type, content, inviteOnly, canInvite, startTime, endTime, where, accessToken);
    assertTrue(result);
  }
  
    /**
   * Test of updateEvent method, of class DoubanEventService.
   */
  public void testUpdateEvent() throws Exception {
    System.out.println("updateEvent");
    long eventId = 16564220L;
    String title = "Test from Dongxuexidu";
    EventType type = EventType.Music;
    String content = "Test from Dongxuexidu";
    boolean inviteOnly = false;
    boolean canInvite = false;
    Date startTime = null;
    Date endTime = null;
    String where = "";
    DoubanEventService instance = new DoubanEventService();
    boolean expResult = false;
    boolean result = instance.updateEvent(eventId, title, type, content, inviteOnly, canInvite, startTime, endTime, where, accessToken);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of deleteEvent method, of class DoubanEventService.
   */
  public void testDeleteEvent() throws Exception {
    System.out.println("deleteEvent");
    long eventId = 0L;
    String content = "";
    DoubanEventService instance = new DoubanEventService();
    boolean expResult = false;
    boolean result = instance.deleteEvent(eventId, content, accessToken);
    assertEquals(expResult, result);
    // TODO review the generated test code and remove the default call to fail.
    fail("The test case is a prototype.");
  }

  /**
   * Test of participateEvent method, of class DoubanEventService.
   */
//  public void testParticipateEvent() throws Exception {
//    System.out.println("participateEvent");
//    long eventId = 17126718L;
//    DoubanEventService instance = new DoubanEventService();
//    boolean result = instance.participateEvent(eventId, accessToken);
//    assertTrue(result);
//  }

  /**
   * Test of wantToBeInAEvent method, of class DoubanEventService.
   */
//  public void testWantToBeInAEvent() throws Exception {
//    System.out.println("wantToBeInAEvent");
//    long eventId = 16573959L;
//    DoubanEventService instance = new DoubanEventService();
//    boolean result = instance.wantToBeInAEvent(eventId, accessToken);
//    assertTrue(result);
//  }

  /**
   * Test of quitEvent method, of class DoubanEventService.
   */
//  public void testQuitEvent() throws Exception {
//    System.out.println("quitEvent");
//    long eventId = 17126718L;
//    DoubanEventService instance = new DoubanEventService();
//    boolean result = instance.quitEvent(eventId, accessToken);
//    assertTrue(result);
//  }

  /**
   * Test of nolongInterestedInEvent method, of class DoubanEventService.
   */
//  public void testNolongInterestedInEvent() throws Exception {
//    System.out.println("nolongInterestedInEvent");
//    long eventId = 16573959L;
//    DoubanEventService instance = new DoubanEventService();
//    boolean result = instance.nolongInterestedInEvent(eventId, accessToken);
//    assertTrue(result);
//  }
}
