package com.dongxuexidu.douban4j.model.shuo;

import com.dongxuexidu.douban4j.model.IDoubanObject;
import com.google.api.client.util.Key;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanShuoStatusObj implements IDoubanObject{
  
  @Key("reshared_count")
  private int resharedCount = 0;
  
  @Key("text")
  private String text;
  
  @Key("liked")
  private boolean liked = false;
  
  @Key("like_count")
  private int likeCount = 0;
  
  @Key("object_id")
  private String objectId;
  
  @Key("id")
  private long id;
  
  @Key("category")
  private String category;
  
  //WTF with this one?
//  @Key("can_reply")
//  private boolean canReply;
  
//  @Key("layout")
//  private int layout;
  
  @Key("title")
  private String title;
  
  @Key("muted")
  private boolean muted = false;
  
  @Key("favorited")
  private boolean favorited = false;
  
  @Key("created_at")
  private String createdTime;
  
  @Key("target_type")
  private String targetType;
  
  @Key("short_title")
  private String shortTitle;
  
  @Key("comments_count")
  private int commentsCount;
  
  @Key("render_success")
  private boolean renderSuccess;
  
  @Key("action")
  private String action;
  
//  @Key("tmpl_ver")
//  private int tmplVer;
  
  @Key("type")
  private String type;
  
  @Key("source")
  private String source;
  
  @Key("user")
  private DoubanShuoUserObj user;
  
  @Key("attachments")
  private List<DoubanShuoAttachementObj> attachements = new ArrayList<DoubanShuoAttachementObj>();

  @Override
  public String getObjName() {
    return "doubanshuostatus";
  }

  /**
   * @return the resharedCount
   */
  public int getResharedCount() {
    return resharedCount;
  }

  /**
   * @param resharedCount the resharedCount to set
   */
  public void setResharedCount(int resharedCount) {
    this.resharedCount = resharedCount;
  }

  /**
   * @return the text
   */
  public String getText() {
    return text;
  }

  /**
   * @param text the text to set
   */
  public void setText(String text) {
    this.text = text;
  }

  /**
   * @return the liked
   */
  public boolean isLiked() {
    return liked;
  }

  /**
   * @param liked the liked to set
   */
  public void setLiked(boolean liked) {
    this.liked = liked;
  }

  /**
   * @return the likeCount
   */
  public int getLikeCount() {
    return likeCount;
  }

  /**
   * @param likeCount the likeCount to set
   */
  public void setLikeCount(int likeCount) {
    this.likeCount = likeCount;
  }

  /**
   * @return the objectId
   */
  public String getObjectId() {
    return objectId;
  }

  /**
   * @param objectId the objectId to set
   */
  public void setObjectId(String objectId) {
    this.objectId = objectId;
  }

  /**
   * @return the id
   */
  public long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * @return the category
   */
  public String getCategory() {
    return category;
  }

  /**
   * @param category the category to set
   */
  public void setCategory(String category) {
    this.category = category;
  }

//  /**
//   * @return the canReply
//   */
//  public boolean canReply() {
//    return canReply;
//  }
//
//  /**
//   * @param canReply the canReply to set
//   */
//  public void setCanReply(boolean canReply) {
//    this.canReply = canReply;
//  }

//  /**
//   * @return the layout
//   */
//  public int getLayout() {
//    return layout;
//  }
//
//  /**
//   * @param layout the layout to set
//   */
//  public void setLayout(int layout) {
//    this.layout = layout;
//  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @param title the title to set
   */
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * @return the muted
   */
  public boolean isMuted() {
    return muted;
  }

  /**
   * @param muted the muted to set
   */
  public void setMuted(boolean muted) {
    this.muted = muted;
  }

  /**
   * @return the createdTime
   */
  public String getCreatedTime() {
    return createdTime;
  }

  /**
   * @param createdTime the createdTime to set
   */
  public void setCreatedTime(String createdTime) {
    this.createdTime = createdTime;
  }

  /**
   * @return the targetType
   */
  public String getTargetType() {
    return targetType;
  }

  /**
   * @param targetType the targetType to set
   */
  public void setTargetType(String targetType) {
    this.targetType = targetType;
  }

  /**
   * @return the shortTitle
   */
  public String getShortTitle() {
    return shortTitle;
  }

  /**
   * @param shortTitle the shortTitle to set
   */
  public void setShortTitle(String shortTitle) {
    this.shortTitle = shortTitle;
  }

  /**
   * @return the commentsCount
   */
  public int getCommentsCount() {
    return commentsCount;
  }

  /**
   * @param commentsCount the commentsCount to set
   */
  public void setCommentsCount(int commentsCount) {
    this.commentsCount = commentsCount;
  }

  /**
   * @return the renderSuccess
   */
  public boolean isRenderSuccess() {
    return renderSuccess;
  }

  /**
   * @param renderSuccess the renderSuccess to set
   */
  public void setRenderSuccess(boolean renderSuccess) {
    this.renderSuccess = renderSuccess;
  }

  /**
   * @return the action
   */
  public String getAction() {
    return action;
  }

  /**
   * @param action the action to set
   */
  public void setAction(String action) {
    this.action = action;
  }

//  /**
//   * @return the tmplVer
//   */
//  public int getTmplVer() {
//    return tmplVer;
//  }
//
//  /**
//   * @param tmplVer the tmplVer to set
//   */
//  public void setTmplVer(int tmplVer) {
//    this.tmplVer = tmplVer;
//  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @param type the type to set
   */
  public void setType(String type) {
    this.type = type;
  }

  /**
   * @return the user
   */
  public DoubanShuoUserObj getUser() {
    return user;
  }

  /**
   * @param user the user to set
   */
  public void setUser(DoubanShuoUserObj user) {
    this.user = user;
  }

  /**
   * @return the attachements
   */
  public List<DoubanShuoAttachementObj> getAttachements() {
    return attachements;
  }

  /**
   * @param attachements the attachements to set
   */
  public void setAttachements(List<DoubanShuoAttachementObj> attachements) {
    this.attachements = attachements;
  }

  /**
   * @return the favorited
   */
  public boolean isFavorited() {
    return favorited;
  }

  /**
   * @param favorited the favorited to set
   */
  public void setFavorited(boolean favorited) {
    this.favorited = favorited;
  }

  /**
   * @return the source
   */
  public String getSource() {
    return source;
  }

  /**
   * @param source the source to set
   */
  public void setSource(String source) {
    this.source = source;
  }
  
}
