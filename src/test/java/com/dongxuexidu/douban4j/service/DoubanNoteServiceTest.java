/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.service;

import junit.framework.TestCase;

import com.dongxuexidu.douban4j.model.note.DoubanNoteEntryObj;
import com.dongxuexidu.douban4j.model.note.DoubanNoteFeedObj;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanNoteServiceTest extends TestCase {
  
  private String accessToken = "xxx";

  /**
   * Test of getNoteById method, of class DoubanNoteService.
   */
  public void testGetNoteById() throws Exception {
    System.out.println("getNoteById");
    long noteId = 1231L;
    DoubanNoteService instance = new DoubanNoteService();
    DoubanNoteEntryObj result = instance.getNoteById(noteId);
    assertEquals(result.getAuthor().getName(),"张君雅");
  }

  /**
   * Test of getAllNotesFromUser method, of class DoubanNoteService.
   */
  public void testGetAllNotesFromUser_String() throws Exception {
    System.out.println("getAllNotesFromUser");
    String userId = "xxxx";
    DoubanNoteService instance = new DoubanNoteService();
    DoubanNoteFeedObj result = instance.getAllNotesFromUser(userId);
    assertTrue(result.getEntries().size() > 0);
    result = instance.getAllNotesFromUser("xxx");
    assertTrue(result.getEntries() == null || result.getEntries().isEmpty());
  }

  /**
   * Test of getAllNotesFromUser method, of class DoubanNoteService.
   */
  public void testGetAllNotesFromUser_3args() throws Exception {
    System.out.println("getAllNotesFromUser");
    String userId = "xxx";
    Integer startIndex = 0;
    Integer maxResult = 2;
    DoubanNoteService instance = new DoubanNoteService();
    DoubanNoteFeedObj result = instance.getAllNotesFromUser(userId, startIndex, maxResult);
    assertTrue(result.getEntries().size() <= 2);
  }

  /**
   * Test of createNewNote method, of class DoubanNoteService.
   */
  public void testCreateNewNote() throws Exception {
    System.out.println("createNewNote");
    String title = "Test from Dongxuexidu";
    String content = "Will be deleted in 1mins, whoever (you fxxking lucky bastard) sees this will get blessed.";
    boolean isPrivate = false;
    boolean canReply = true;
    DoubanNoteService instance = new DoubanNoteService();
    boolean result = instance.createNewNote(title, content, isPrivate, canReply, accessToken);
    assertTrue(result);
  }

  /**
   * Test of updateNote method, of class DoubanNoteService.
   */
  public void testUpdateNote() throws Exception {
    System.out.println("updateNote");
    long noteId = 234003718L;
    String title = "Test from Dongxuexidu again";
    String content = "Will be deleted in 1mins, whoever (you fxxking lucky boy) sees this will get blessed. A-men";
    boolean isPrivate = false;
    boolean canReply = true;
    DoubanNoteService instance = new DoubanNoteService();
    boolean result = instance.updateNote(noteId, title, content, isPrivate, canReply, accessToken);
    assertTrue(result);
  }

  /**
   * Test of deleteNote method, of class DoubanNoteService.
   */
  public void testDeleteNote() throws Exception {
    System.out.println("deleteNote");
    long noteId = 23412321313131718L;
    DoubanNoteService instance = new DoubanNoteService();
    boolean result = instance.deleteNote(noteId, accessToken);
    assertTrue(result);
  }
}
