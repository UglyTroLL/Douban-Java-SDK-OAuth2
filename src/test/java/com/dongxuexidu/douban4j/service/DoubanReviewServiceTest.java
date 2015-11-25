/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.service;

import junit.framework.TestCase;

import com.dongxuexidu.douban4j.model.review.DoubanReviewEntryObj;
import com.dongxuexidu.douban4j.model.review.DoubanReviewFeedObj;
import com.dongxuexidu.douban4j.service.DoubanReviewService.ReviewOrderBy;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanReviewServiceTest extends TestCase {
  
  private String accessToken = "xxxxx";

  /**
   * Test of getReviewById method, of class DoubanReviewService.
   */
  public void testGetReviewById() throws Exception {
    System.out.println("getReviewById");
    long reviewId = 1096809;
    DoubanReviewService instance = new DoubanReviewService();
    DoubanReviewEntryObj result = instance.getReviewById(reviewId);
    assertEquals(result.getTitle(), "生活是粗砺的沙");
    assertEquals(result.getRating().getValue(), 4);
  }

  /**
   * Test of getUsersReview method, of class DoubanReviewService.
   */
  public void testGetUsersReview() throws Exception {
    System.out.println("getUsersReview");
    String userId = "senseless";
    DoubanReviewService instance = new DoubanReviewService();
    DoubanReviewFeedObj result = instance.getUsersReview(userId);
    assertTrue(result.getReviews().size() > 0);
    result = instance.getUsersReview("xxxx");
    assertTrue(result.getReviews() == null || result.getReviews().isEmpty());
  }

  /**
   * Test of getBookReviewsBySubjectId method, of class DoubanReviewService.
   */
  public void testGetBookReviewsBySubjectId_String() throws Exception {
    System.out.println("getBookReviewsBySubjectId");
    long subjectId = 11525211;
    DoubanReviewService instance = new DoubanReviewService();
    DoubanReviewFeedObj result = instance.getBookReviewsBySubjectId(subjectId);
    assertTrue(result.getReviews().size() > 0);
  }

  /**
   * Test of getBookReviewsBySubjectId method, of class DoubanReviewService.
   */
  public void testGetBookReviewsBySubjectId_4args() throws Exception {
    System.out.println("getBookReviewsBySubjectId");
    long subjectId = 11525211;
    int startIndex = 0;
    int maxResult = 10;
    ReviewOrderBy orderBy = ReviewOrderBy.Score;
    DoubanReviewService instance = new DoubanReviewService();
    DoubanReviewFeedObj result = instance.getBookReviewsBySubjectId(subjectId, startIndex, maxResult, orderBy);
    for (DoubanReviewEntryObj review : result.getReviews()) {
      System.out.println("review title : " + review.getTitle());
    }
    assertTrue(result.getReviews().size() <= 10);
  }

  /**
   * Test of getBookReviewsByISBNId method, of class DoubanReviewService.
   */
  public void testGetBookReviewsByISBNId_String() throws Exception {
    System.out.println("getBookReviewsByISBNId");
    String isbnId = "9787214082060";
    DoubanReviewService instance = new DoubanReviewService();
    DoubanReviewFeedObj result = instance.getBookReviewsByISBNId(isbnId);
    assertTrue(result.getReviews().size() > 0);
  }

  /**
   * Test of getBookReviewsByISBNId method, of class DoubanReviewService.
   */
  public void testGetBookReviewsByISBNId_4args() throws Exception {
    System.out.println("getBookReviewsByISBNId");
    String isbnId = "9787214082060";
    int startIndex = 0;
    int maxResult = 10;
    ReviewOrderBy orderBy = ReviewOrderBy.Score;
    DoubanReviewService instance = new DoubanReviewService();
    DoubanReviewFeedObj result = instance.getBookReviewsByISBNId(isbnId, startIndex, maxResult, orderBy);
    for (DoubanReviewEntryObj review : result.getReviews()) {
      System.out.println("review title : " + review.getTitle());
    }
    assertTrue(result.getReviews().size() <= 10);
  }

  /**
   * Test of getMovieReviewsBySubjectId method, of class DoubanReviewService.
   */
  public void testGetMovieReviewsBySubjectId_String() throws Exception {
    System.out.println("getMovieReviewsBySubjectId");
    long subjectId = 3338851;
    DoubanReviewService instance = new DoubanReviewService();
    DoubanReviewFeedObj result = instance.getMovieReviewsBySubjectId(subjectId);
    assertTrue(result.getReviews().size() > 0);
  }

  /**
   * Test of getMovieReviewsBySubjectId method, of class DoubanReviewService.
   */
  public void testGetMovieReviewsBySubjectId_4args() throws Exception {
    System.out.println("getMovieReviewsBySubjectId");
    long subjectId = 3338851;
    int startIndex = 0;
    int maxResult = 10;
    ReviewOrderBy orderBy = ReviewOrderBy.Score;
    DoubanReviewService instance = new DoubanReviewService();
    DoubanReviewFeedObj result = instance.getMovieReviewsBySubjectId(subjectId, startIndex, maxResult, orderBy);
    for (DoubanReviewEntryObj review : result.getReviews()) {
      System.out.println("review title : " + review.getTitle());
    }
    assertTrue(result.getReviews().size() <= 10);
  }

  /**
   * Test of getMovieReviewsByIMDBId method, of class DoubanReviewService.
   */
  public void testGetMovieReviewsByIMDBId_String() throws Exception {
    System.out.println("getMovieReviewsByIMDBId");
    String imdbId = "tt1340800";
    DoubanReviewService instance = new DoubanReviewService();
    DoubanReviewFeedObj result = instance.getMovieReviewsByIMDBId(imdbId);
    assertTrue(result.getReviews().size() > 0);
  }

  /**
   * Test of getMovieReviewsByIMDBId method, of class DoubanReviewService.
   */
  public void testGetMovieReviewsByIMDBId_4args() throws Exception {
    System.out.println("getMovieReviewsByIMDBId");
    String imdbId = "tt1340800";
    int startIndex = 0;
    int maxResult = 10;
    ReviewOrderBy orderBy = ReviewOrderBy.Score;
    DoubanReviewService instance = new DoubanReviewService();
    DoubanReviewFeedObj result = instance.getMovieReviewsByIMDBId(imdbId, startIndex, maxResult, orderBy);
    for (DoubanReviewEntryObj review : result.getReviews()) {
      System.out.println("review title : " + review.getTitle());
    }
    assertTrue(result.getReviews().size() <= 10);
  }

  /**
   * Test of getMusicReviewsBySubjectId method, of class DoubanReviewService.
   */
  public void testGetMusicReviewsBySubjectId_String() throws Exception {
    System.out.println("getMusicReviewsBySubjectId");
    long subjectId = 4753298;
    DoubanReviewService instance = new DoubanReviewService();
    DoubanReviewFeedObj result = instance.getMusicReviewsBySubjectId(subjectId);
    assertTrue(result.getReviews().size() > 0);
  }

  /**
   * Test of getMusicReviewsBySubjectId method, of class DoubanReviewService.
   */
  public void testGetMusicReviewsBySubjectId_4args() throws Exception {
    System.out.println("getMusicReviewsBySubjectId");
    long subjectId = 4753298;
    int startIndex = 0;
    int maxResult = 10;
    ReviewOrderBy orderBy = ReviewOrderBy.Score;
    DoubanReviewService instance = new DoubanReviewService();
    DoubanReviewFeedObj result = instance.getMusicReviewsBySubjectId(subjectId, startIndex, maxResult, orderBy);
    for (DoubanReviewEntryObj review : result.getReviews()) {
      System.out.println("review title : " + review.getTitle());
    }
    assertTrue(result.getReviews().size() <= 10);
  }

  /**
   * Test of addNewReview method, of class DoubanReviewService.
   */
  public void testAddNewReview() throws Exception {
    System.out.println("addNewReview");
    long subjectId = 4753298;
    String content = "This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.";
    int rating = 4;
    String title = "Test";
    DoubanReviewService instance = new DoubanReviewService();
    boolean result = instance.addNewReview(subjectId, content, rating, title, accessToken);
    assertTrue(result);
  }

//  /**
//   * Test of updateReview method, of class DoubanReviewService.
//   */
  public void testUpdateReview() throws Exception {
    System.out.println("updateReview");
    long reviewId = 5566315;
    long subjectId = 4753298;
    String content = "This will be deleted in 1mins, forgive me.This will be deleted in 1mins, forgive me.This will be deleted in 1mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.This will be deleted in 3mins, forgive me.";
    int rating = 5;
    String title = "Test";
    DoubanReviewService instance = new DoubanReviewService();
    boolean result = instance.updateReview(reviewId, subjectId, content, title, rating, accessToken);
    assertTrue(result);
  }
//
//  /**
//   * Test of deleteReview method, of class DoubanReviewService.
//   */
  public void testDeleteReview() throws Exception {
    System.out.println("deleteReview");
    long reviewId = 5566315;
    DoubanReviewService instance = new DoubanReviewService();
    boolean result = instance.deleteReview(reviewId, accessToken);
    assertTrue(result);
  }
}
