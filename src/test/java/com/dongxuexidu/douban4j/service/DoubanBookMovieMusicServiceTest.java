/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dongxuexidu.douban4j.service;

import junit.framework.TestCase;

import com.dongxuexidu.douban4j.model.subject.DoubanSubjectFeedObj;
import com.dongxuexidu.douban4j.model.subject.DoubanSubjectObj;
import com.dongxuexidu.douban4j.model.v2.DoubanSubjectListObj;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanBookMovieMusicServiceTest extends TestCase {

  private String accessToken = "xxx";

  /**
   * Test of getBookInfoById method, of class DoubanBookMovieMusicService.
   */
  public void testGetBookInfoById() throws Exception {
    System.out.println("getBookInfoById");
    long bookId = 10440147L;
    DoubanBookMovieMusicService instance = new DoubanBookMovieMusicService();
    DoubanSubjectObj result = instance.getBookInfoById(bookId);
    assertEquals(result.getTitle(), "世间的名字");
  }

  /**
   * Test of getBookInfoByISBN method, of class DoubanBookMovieMusicService.
   */
  public void testGetBookInfoByISBN() throws Exception {
    System.out.println("getBookInfoByISBN");
    String isbn = "9787208104815";
    DoubanBookMovieMusicService instance = new DoubanBookMovieMusicService();
    DoubanSubjectObj result = instance.getBookInfoByISBN(isbn);
    assertEquals(result.getTitle(), "世间的名字");
  }

  /**
   * Test of getMovieInfoById method, of class DoubanBookMovieMusicService.
   */
  public void testGetMovieInfoById() throws Exception {
    System.out.println("getMovieInfoById");
    long movieId = 6041191L;
    DoubanBookMovieMusicService instance = new DoubanBookMovieMusicService();
    DoubanSubjectObj result = instance.getMovieInfoById(movieId);
    System.out.println("title : " + result.getTitle());
    assertEquals(result.getTitle(), "听风者");
  }

  /**
   * Test of getMovieInfoByIMDBId method, of class DoubanBookMovieMusicService.
   */
  public void testGetMovieInfoByIMDBId() throws Exception {
    System.out.println("getMovieInfoByIMDBId");
    String imdbId = "tt2078768";
    DoubanBookMovieMusicService instance = new DoubanBookMovieMusicService();
    DoubanSubjectObj result = instance.getMovieInfoByIMDBId(imdbId);
    System.out.println("title : " + result.getTitle());
    assertEquals(result.getTitle(), "听风者");
  }
  
  /**
   * Test of getMoviesTop250 method, of class DoubanBookMovieMusicService.
   */
  public void testGetMoviesTop250() throws Exception {
	  System.out.println("getMoviesTop250");
	  int start = 0;
	  int count = 10;
	  DoubanBookMovieMusicService instance = new DoubanBookMovieMusicService();
	  DoubanSubjectListObj result = instance.getMoviesTop250(start, count);
	  System.out.println("title : " + result.getTitle());
	  assertEquals(result.getTitle(), "豆瓣电影Top250");
  }

  /**
   * Test of getV2MovieInfoById method, of class DoubanBookMovieMusicService.
   */
  public void testGetV2MovieInfoById() throws Exception {
    System.out.println("getV2MovieInfoById");
    long movieId = 6041191L;
    DoubanBookMovieMusicService instance = new DoubanBookMovieMusicService();
    com.dongxuexidu.douban4j.model.v2.DoubanSubjectObj result = instance.getV2MovieInfoById(movieId);
    System.out.println("title : " + result.getTitle());
    assertEquals(result.getTitle(), "听风者");
  }
  
  /**
   * Test of getMusicInfoById method, of class DoubanBookMovieMusicService.
   */
  public void testGetMusicInfoById() throws Exception {
    System.out.println("getMusicInfoById");
    long musicId = 4753298L;
    DoubanBookMovieMusicService instance = new DoubanBookMovieMusicService();
    DoubanSubjectObj result = instance.getMusicInfoById(musicId);
    System.out.println("title : " + result.getTitle());
    assertEquals(result.getTitle(), "艺术男儿裆自强");
  }

  /**
   * Test of searchBook method, of class DoubanBookMovieMusicService.
   */
  public void testSearchBook_String_String() throws Exception {
    System.out.println("searchBook");
    String q = "C语言";
    String tag = null;
    DoubanBookMovieMusicService instance = new DoubanBookMovieMusicService();
    DoubanSubjectFeedObj result = instance.searchBook(q, tag);
    assertTrue(result.getSubjects().size() > 0);
  }

  /**
   * Test of searchBook method, of class DoubanBookMovieMusicService.
   */
  public void testSearchBook_4args() throws Exception {
    System.out.println("searchBook");
    String q = "C语言";
    String tag = "C";
    int startIndex = 0;
    int maxResult = 2;
    DoubanBookMovieMusicService instance = new DoubanBookMovieMusicService();
    DoubanSubjectFeedObj result = instance.searchBook(q, tag, startIndex, maxResult);
    assertTrue(result.getSubjects().size() == 2);
  }

  /**
   * Test of searchMovie method, of class DoubanBookMovieMusicService.
   */
  public void testSearchMovie_String_String() throws Exception {
    System.out.println("searchMovie");
    String q = "batman";
    String tag = null;
    DoubanBookMovieMusicService instance = new DoubanBookMovieMusicService();
    DoubanSubjectFeedObj result = instance.searchMovie(q, tag);
    assertTrue(result.getSubjects().size() > 0);
  }

  /**
   * Test of searchMovie method, of class DoubanBookMovieMusicService.
   */
  public void testSearchMovie_4args() throws Exception {
    System.out.println("searchMovie");
    String q = "batman";
    String tag = "蝙蝠侠";
    int startIndex = 0;
    int maxResult = 2;
    DoubanBookMovieMusicService instance = new DoubanBookMovieMusicService();
    DoubanSubjectFeedObj result = instance.searchMovie(q, tag, startIndex, maxResult);
    assertTrue(result.getSubjects().size() == 2);
  }

  /**
   * Test of searchMusic method, of class DoubanBookMovieMusicService.
   */
  public void testSearchMusic_String_String() throws Exception {
    System.out.println("searchMusic");
    String q = "歌";
    String tag = null;
    DoubanBookMovieMusicService instance = new DoubanBookMovieMusicService();
    DoubanSubjectFeedObj result = instance.searchMusic(q, tag);
    assertTrue(result.getSubjects().size() > 0);
  }

  /**
   * Test of searchMusic method, of class DoubanBookMovieMusicService.
   */
  public void testSearchMusic_4args() throws Exception {
    System.out.println("searchMusic");
    String q = "歌";
    String tag = "歌";
    int startIndex = 0;
    int maxResult = 2;
    DoubanBookMovieMusicService instance = new DoubanBookMovieMusicService();
    DoubanSubjectFeedObj result = instance.searchMusic(q, tag, startIndex, maxResult);
    assertTrue(result.getSubjects().size() == 2);
  }
}
