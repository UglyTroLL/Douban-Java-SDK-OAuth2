package com.dongxuexidu.douban4j.model.app;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class RequestGrantScope {
  
  private String description;
  private String value;
  private String name;
  
  private static final String SCOPE_SHUO_READ = "shuo_basic_r";
  private static final String SCOPE_SHUO_WRITE = "shuo_basic_w";
  private static final String SCOPE_MAIL_READ = "community_advanced_doumail_r";
  private static final String SCOPE_MAIL_WRITE = "community_advanced_doumail_w";
  private static final String SCOPE_BASIC_COMMON = "douban_basic_common";
  private static final String SCOPE_BASIC_NOTE = "community_basic_note";
  private static final String SCOPE_BOOK_READ = "book_basic_r";
  private static final String SCOPE_MOVIE_READ = "movie_basic_r";
  private static final String SCOPE_MUSIC_READ = "music_basic_r";
  private static final String SCOPE_EVENT_READ = "event_basic_r";
  private static final String SCOPE_EVENT_WRITE = "event_basic_w";
  
  public static final RequestGrantScope SHUO_READ_SCOPE = new RequestGrantScope("DoubanShuoRead", RequestGrantScope.SCOPE_SHUO_READ, "豆瓣说读取权限");
  public static final RequestGrantScope SHUO_WRITE_SCOPE = new RequestGrantScope("DoubanShuoWrite", RequestGrantScope.SCOPE_SHUO_WRITE, "豆瓣说写入权限");
  public static final RequestGrantScope BASIC_COMMON_SCOPE = new RequestGrantScope("BasicCommon", RequestGrantScope.SCOPE_BASIC_COMMON, "豆瓣基本权限");
  public static final RequestGrantScope MAIL_READ_SCOPE = new RequestGrantScope("MailRead", RequestGrantScope.SCOPE_MAIL_READ, "豆邮读权限");
  public static final RequestGrantScope MAIL_WRITE_SCOPE = new RequestGrantScope("DoubanShuoWrite", RequestGrantScope.SCOPE_MAIL_WRITE, "豆邮写权限");
  public static final RequestGrantScope BASIC_NOTE_SCOPE = new RequestGrantScope("BasicNote", RequestGrantScope.SCOPE_BASIC_NOTE, "日记读写权限");
  public static final RequestGrantScope BOOK_READ_SCOPE = new RequestGrantScope("BookRead", RequestGrantScope.SCOPE_BOOK_READ, "豆瓣读书");
  public static final RequestGrantScope MOVIE_READ_SCOPE = new RequestGrantScope("MovieRead", RequestGrantScope.SCOPE_MOVIE_READ, "豆瓣电影");
  public static final RequestGrantScope MUSIC_READ_SCOPE = new RequestGrantScope("MusicRead", RequestGrantScope.SCOPE_MUSIC_READ, "豆瓣音乐");
  public static final RequestGrantScope EVENT_READ_SCOPE = new RequestGrantScope("EventRead", RequestGrantScope.SCOPE_EVENT_READ, "豆瓣同城读权限");
  public static final RequestGrantScope EVENT_WRITE_SCOPE = new RequestGrantScope("EventWrite", RequestGrantScope.SCOPE_EVENT_WRITE, "豆瓣同城写权限");
  
  private RequestGrantScope (String name, String value, String description) {
    this.description = description;
    this.name = name;
    this.value = value;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
  
}
