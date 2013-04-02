package com.dongxuexidu.douban4j.model.v2;

import java.util.ArrayList;
import java.util.List;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.dongxuexidu.douban4j.model.common.DoubanImageObj;
import com.google.api.client.util.Key;

/**
 * 
 * @author Sean Guo <seanguo85@qq.com>
 *
 */
public class DoubanSubjectObj implements IDoubanObject {
  
  @Key
  private DoubanRatingObj rating;
  
  @Key
  private String title;
  
  @Key
  private String original_title;
  
  @Key
  private String year;
  
  @Key
  private String subtype;
  
  @Key
  private DoubanImageObj images;
  
  @Key
  private String alt;
  
  @Key
  private String id;
  
  @Key
  private String summary;
  
  @Key
  private List<DoubanCastObject> casts = new ArrayList<DoubanCastObject>();
  
  @Key
  private List<DoubanDirectorObj> directors = new ArrayList<DoubanDirectorObj>();
  
  @Key
  private List<String> aka = new ArrayList<String>();
  
  @Key
  private List<String> genres = new ArrayList<String>();
  
  @Key
  private List<String> countries = new ArrayList<String>();
  
  @Key
  private int comments_count;
  
  @Key
  private int ratings_count;

  @Override
  public String getObjName() {
    return "DoubanSubjectObj";
  }

  public DoubanRatingObj getRating() {
    return rating;
  }

  public String getTitle() {
    return title;
  }

  public String getOriginal_title() {
    return original_title;
  }

  public String getYear() {
    return year;
  }

  public String getSubtype() {
    return subtype;
  }

  public DoubanImageObj getImages() {
    return images;
  }

  public String getAlt() {
    return alt;
  }

  public String getId() {
    return id;
  }

  public String getSummary() {
    return summary;
  }

  public List<DoubanCastObject> getCasts() {
    return casts;
  }

  public List<String> getAka() {
    return aka;
  }

  public int getComments_count() {
    return comments_count;
  }

  public int getRatings_count() {
    return ratings_count;
  }

  public List<String> getGenres() {
    return genres;
  }

  public List<String> getCountries() {
    return countries;
  }

  public List<DoubanDirectorObj> getDirectors() {
    return directors;
  }
}
