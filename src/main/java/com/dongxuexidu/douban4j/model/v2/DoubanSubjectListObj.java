package com.dongxuexidu.douban4j.model.v2;

import java.util.ArrayList;
import java.util.List;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.google.api.client.util.Key;

public class DoubanSubjectListObj implements IDoubanObject {
  
  @Key
  private int count;
  
  @Key
  private int start;
  
  @Key
  private int total;
  
  @Key
  private List<DoubanV2SubjectObj> subjects = new ArrayList<DoubanV2SubjectObj>();
  
  @Key
  private String title;

  @Override
  public String getObjName() {
    return "DoubanSubjectList";
  }

  public int getCount() {
    return count;
  }

  public int getStart() {
    return start;
  }

  public int getTotal() {
    return total;
  }

  public List<DoubanV2SubjectObj> getSubjects() {
    return subjects;
  }

  public String getTitle() {
    return title;
  }
}
