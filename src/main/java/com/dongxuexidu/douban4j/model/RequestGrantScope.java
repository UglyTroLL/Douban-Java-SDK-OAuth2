package com.dongxuexidu.douban4j.model;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class RequestGrantScope {
  
  private String description;
  private String value;
  private String name;
  
  public static final String SCOPE_SHUO_READ = "shuo_basic_r";
  public static final String SCOPE_SHUO_WRITE = "shuo_basic_w";
  
  public RequestGrantScope (String name, String value, String description) {
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
   * @param description the description to set
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * @return the value
   */
  public String getValue() {
    return value;
  }

  /**
   * @param value the value to set
   */
  public void setValue(String value) {
    this.value = value;
  }

  /**
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  
}
