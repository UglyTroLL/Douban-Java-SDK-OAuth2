package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.constants.RequestUrls;
import com.dongxuexidu.douban4j.constants.StatusCode;
import com.dongxuexidu.douban4j.model.UnTested;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.dongxuexidu.douban4j.model.common.DoubanAttributeObj;
import com.dongxuexidu.douban4j.model.common.DoubanCategoryObj;
import com.dongxuexidu.douban4j.model.common.DoubanWhenObj;
import com.dongxuexidu.douban4j.model.common.DoubanWhereObj;
import com.dongxuexidu.douban4j.model.event.DoubanEventEntryObj;
import com.dongxuexidu.douban4j.model.event.DoubanEventFeedObj;
import com.dongxuexidu.douban4j.model.user.DoubanUserFeedObj;
import com.dongxuexidu.douban4j.utils.Converters;
import com.dongxuexidu.douban4j.utils.ErrorHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanEventService extends DoubanService {

  final static Logger logger = Logger.getLogger(DoubanEventService.class.getName());

  public static enum EventType {

    Commonweal {
      @Override
      public String getValue() {
        return "commonweal";
      }
    },
    Drama {
      @Override
      public String getValue() {
        return "drama";
      }
    },
    Exhibition {
      @Override
      public String getValue() {
        return "exhibition";
      }
    },
    Film {
      @Override
      public String getValue() {
        return "film";
      }
    },
    Music {
      @Override
      public String getValue() {
        return "music";
      }
    },
    Others {
      @Override
      public String getValue() {
        return "others";
      }
    },
    Party {
      @Override
      public String getValue() {
        return "party";
      }
    },
    Salon {
      @Override
      public String getValue() {
        return "salon";
      }
    },
    Sports {
      @Override
      public String getValue() {
        return "sports";
      }
    },
    Travel {
      @Override
      public String getValue() {
        return "travel";
      }
    };

    public abstract String getValue();
  }

  public DoubanEventService() {
    super();
  }

  public DoubanEventService(String accessToken) {
    super(accessToken);
  }

  public DoubanEventEntryObj getEventById(long eventId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_EVENT_PREFIX + "/" + eventId;
    DoubanEventEntryObj result = this.client.getResponse(url, null, DoubanEventEntryObj.class, false);
    return result;
  }

  public DoubanUserFeedObj getParticipantsByEventId(long eventId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_EVENT_PREFIX + "/" + eventId + "/participants";
    DoubanUserFeedObj result = this.client.getResponse(url, null, DoubanUserFeedObj.class, false);
    return result;
  }

  public DoubanUserFeedObj getUsersWhoWantsToBeThereByEventId(long eventId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_EVENT_PREFIX + "/" + eventId + "/wishers";
    DoubanUserFeedObj result = this.client.getResponse(url, null, DoubanUserFeedObj.class, false);
    return result;
  }

  public DoubanEventFeedObj getAllUsersEventsByUserId(String userId) throws DoubanException, IOException {
    return getAllUsersEventsByUserId(userId, null, null);
  }

  public DoubanEventFeedObj getAllUsersEventsByUserId(String userId, Integer startIndex, Integer maxResult) throws DoubanException, IOException {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (startIndex != null) {
      params.add(new BasicNameValuePair("start-index", "" + startIndex));
    }
    if (maxResult != null) {
      params.add(new BasicNameValuePair("max-results", "" + maxResult));
    }
    String url = RequestUrls.DOUBAN_USER_PREFIX + "/" + userId + "/events";
    DoubanEventFeedObj events = this.client.getResponse(url, params, DoubanEventFeedObj.class, false);
    return events;
  }

  public DoubanEventFeedObj getAllUserInitiateEventsByUserId(String userId) throws DoubanException, IOException {
    return getAllUserInitiateEventsByUserId(userId, null, null);
  }

  public DoubanEventFeedObj getAllUserInitiateEventsByUserId(String userId, Integer startIndex, Integer maxResult) throws DoubanException, IOException {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (startIndex != null) {
      params.add(new BasicNameValuePair("start-index", "" + startIndex));
    }
    if (maxResult != null) {
      params.add(new BasicNameValuePair("max-results", "" + maxResult));
    }
    String url = RequestUrls.DOUBAN_USER_PREFIX + "/" + userId + "/events/initiate";
    DoubanEventFeedObj events = this.client.getResponse(url, params, DoubanEventFeedObj.class, false);
    return events;
  }

  public DoubanEventFeedObj getAllUserParticipateEventsByUserId(String userId) throws DoubanException, IOException {
    return getAllUserParticipateEventsByUserId(userId, null, null);
  }

  public DoubanEventFeedObj getAllUserParticipateEventsByUserId(String userId, Integer startIndex, Integer maxResult) throws DoubanException, IOException {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (startIndex != null) {
      params.add(new BasicNameValuePair("start-index", "" + startIndex));
    }
    if (maxResult != null) {
      params.add(new BasicNameValuePair("max-results", "" + maxResult));
    }
    String url = RequestUrls.DOUBAN_USER_PREFIX + "/" + userId + "/events/participate";
    DoubanEventFeedObj events = this.client.getResponse(url, params, DoubanEventFeedObj.class, false);
    return events;
  }

  public DoubanEventFeedObj getAllUserWishEventsByUserId(String userId) throws DoubanException, IOException {
    return getAllUserWishEventsByUserId(userId, null, null);
  }

  public DoubanEventFeedObj getAllUserWishEventsByUserId(String userId, Integer startIndex, Integer maxResult) throws DoubanException, IOException {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (startIndex != null) {
      params.add(new BasicNameValuePair("start-index", "" + startIndex));
    }
    if (maxResult != null) {
      params.add(new BasicNameValuePair("max-results", "" + maxResult));
    }
    String url = RequestUrls.DOUBAN_USER_PREFIX + "/" + userId + "/events/wish";
    DoubanEventFeedObj events = this.client.getResponse(url, params, DoubanEventFeedObj.class, false);
    return events;
  }

  public DoubanEventFeedObj getAllEventsByLocationId(String locationId) throws DoubanException, IOException {
    return getEventsByLocationId(locationId, null, null, null);
  }

  public DoubanEventFeedObj getEventsByLocationIdAndType(String locationId, EventType type) throws DoubanException, IOException {
    return getEventsByLocationId(locationId, null, null, type);
  }

  public DoubanEventFeedObj getEventsByLocationId(String locationId, Integer startIndex, Integer maxResult, EventType type) throws DoubanException, IOException {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (startIndex != null) {
      params.add(new BasicNameValuePair("start-index", "" + startIndex));
    }
    if (maxResult != null) {
      params.add(new BasicNameValuePair("max-results", "" + maxResult));
    }
    if (type != null) {
      params.add(new BasicNameValuePair("type", type.getValue()));
    }
    String url = RequestUrls.DOUBAN_EVENT_PREFIX + "/location/" + locationId;
    DoubanEventFeedObj events = this.client.getResponse(url, params, DoubanEventFeedObj.class, false);
    return events;
  }

  public DoubanEventFeedObj searchEvent(String keyword) throws DoubanException, IOException {
    return searchEvent(keyword, null, null, null);
  }

  public DoubanEventFeedObj searchEventInLocation(String keyword, String locationId) throws DoubanException, IOException {
    return searchEvent(keyword, null, null, locationId);
  }

  public DoubanEventFeedObj searchEvent(String keyword, Integer startIndex, Integer maxResultCount, String locationId) throws DoubanException, IOException {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (keyword != null && keyword.length() > 0) {
      params.add(new BasicNameValuePair("q", keyword));
    } else {
      throw ErrorHandler.missingRequiredParam();
    }
    if (startIndex != null) {
      params.add(new BasicNameValuePair("start-index", startIndex.toString()));
    }
    if (maxResultCount != null) {
      params.add(new BasicNameValuePair("max-results", maxResultCount.toString()));
    }
    if (locationId != null && locationId.length() > 0) {
      params.add(new BasicNameValuePair("location", locationId));
    } else {
      params.add(new BasicNameValuePair("location", "all"));
    }
    DoubanEventFeedObj result = this.client.getResponse(RequestUrls.DOUBAN_EVENT_PREFIX + "s", params, DoubanEventFeedObj.class, false);
    return result;
  }
  
  @UnTested
  public boolean updateEvent(long eventId, String title, EventType type, String content, boolean inviteOnly, boolean canInvite, Date startTime, Date endTime, String where, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    DoubanEventEntryObj entry = generateEventEntryObj(title, type, content, inviteOnly, canInvite, startTime, endTime, where);
    if (entry == null) {
      throw ErrorHandler.getCustomDoubanException(100, "Illegal event data provided");
    }
    try {
      int responseCode = this.client.putResponseCodeOnly(RequestUrls.DOUBAN_EVENT_PREFIX + "/" + eventId, entry, true);
      if (responseCode != StatusCode.HTTP_STATUS_ACCEPTED) {
        return false;
      }
      return true;
    } catch (DoubanException ex) {
      if (ex.getErrorCode() == ErrorHandler.HTTP_RESPONSE_ERROR_STATUS_CODE) {
        logger.warning(ex.getErrorMsg());
        return false;
      } else {
        throw ex;
      }
    }
  }

  @UnTested
  public boolean postNewEvent(String title, EventType type, String content, boolean inviteOnly, boolean canInvite, Date startTime, Date endTime, String where, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    DoubanEventEntryObj entry = generateEventEntryObj(title, type, content, inviteOnly, canInvite, startTime, endTime, where);
    System.out.println("cat string : " + Converters.parseDoubanObjToXMLStr(entry));
    if (entry == null) {
      throw ErrorHandler.getCustomDoubanException(100, "Illegal event data provided");
    }
    try {
      int responseCode = this.client.postResponseCodeOnly(RequestUrls.DOUBAN_EVENT_PREFIX + "s", entry, true);
      if (responseCode != StatusCode.HTTP_STATUS_CREATED) {
        //System.out.println("code : " + responseCode);
        return false;
      }
      return true;
    } catch (DoubanException ex) {
      if (ex.getErrorCode() == ErrorHandler.HTTP_RESPONSE_ERROR_STATUS_CODE) {
        logger.warning(ex.getErrorMsg());
        return false;
      } else {
        throw ex;
      }
    }
  }
  
  @UnTested
  public boolean deleteEvent (long eventId, String content, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    DoubanEventEntryObj entry = new DoubanEventEntryObj();
    entry.setContent(content);
    String url = RequestUrls.DOUBAN_EVENT_PREFIX + "/" + eventId + "/delete";
    try {
      int responseCode = this.client.postResponseCodeOnly(url, entry, true);
      if (responseCode != StatusCode.HTTP_STATUS_OK) {
        return false;
      }
      return true;
    } catch (DoubanException ex) {
      if (ex.getErrorCode() == ErrorHandler.HTTP_RESPONSE_ERROR_STATUS_CODE) {
        logger.warning(ex.getErrorMsg());
        return false;
      } else {
        throw ex;
      }
    }
  }
  
  public boolean participateEvent (long eventId, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    String url = RequestUrls.DOUBAN_EVENT_PREFIX + "/" + eventId + "/participants";
    try {
      int responseCode = this.client.postResponseCodeOnly(url, null, true);
      if (responseCode != StatusCode.HTTP_STATUS_CREATED) {
        return false;
      }
      return true;
    } catch (DoubanException ex) {
      if (ex.getErrorCode() == ErrorHandler.HTTP_RESPONSE_ERROR_STATUS_CODE) {
        logger.warning(ex.getErrorMsg());
        return false;
      } else {
        throw ex;
      }
    }
  }
  
  public boolean wantToBeInAEvent (long eventId, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    String url = RequestUrls.DOUBAN_EVENT_PREFIX + "/" + eventId + "/wishers";
    try {
      int responseCode = this.client.postResponseCodeOnly(url, null, true);
      if (responseCode != StatusCode.HTTP_STATUS_CREATED) {
        return false;
      }
      return true;
    } catch (DoubanException ex) {
      if (ex.getErrorCode() == ErrorHandler.HTTP_RESPONSE_ERROR_STATUS_CODE) {
        logger.warning(ex.getErrorMsg());
        return false;
      } else {
        throw ex;
      }
    }
  }
  
  public boolean quitEvent (long eventId, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    String url = RequestUrls.DOUBAN_EVENT_PREFIX + "/" + eventId + "/participants";
    try {
      int responseCode = this.client.deleteResponse(url, true);
      if (responseCode != StatusCode.HTTP_STATUS_OK) {
        return false;
      }
      return true;
    } catch (DoubanException ex) {
      if (ex.getErrorCode() == ErrorHandler.HTTP_RESPONSE_ERROR_STATUS_CODE) {
        logger.warning(ex.getErrorMsg());
        return false;
      } else {
        throw ex;
      }
    }
  }
  
  public boolean nolongInterestedInEvent (long eventId, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    String url = RequestUrls.DOUBAN_EVENT_PREFIX + "/" + eventId + "/wishers";
    try {
      int responseCode = this.client.deleteResponse(url, true);
      if (responseCode != StatusCode.HTTP_STATUS_OK) {
        return false;
      }
      return true;
    } catch (DoubanException ex) {
      if (ex.getErrorCode() == ErrorHandler.HTTP_RESPONSE_ERROR_STATUS_CODE) {
        logger.warning(ex.getErrorMsg());
        return false;
      } else {
        throw ex;
      }
    }
  }

  private DoubanEventEntryObj generateEventEntryObj(String title, EventType type, String content, boolean inviteOnly, boolean canInvite, Date startTime, Date endTime, String where) {
    DoubanEventEntryObj entry = new DoubanEventEntryObj();
    if (title != null && title.length() > 0) {
      entry.setTitle(title);
    } else {
      return null;
    }
    if (content != null && content.length() > 0) {
      entry.setContent(content);
    } else {
      return null;
    }
    if (type == null) {
      return null;
    }
    String typeStr = "http://www.douban.com/2007#event." + type.getValue();
    
    //<category scheme="http://www.douban.com/2007#kind" term="http://www.douban.com/2007#event.music"/>
    DoubanCategoryObj cat = new DoubanCategoryObj();
    cat.setScheme("http://www.douban.com/2007#kind");
    cat.setTerm(typeStr);
    entry.setCategory(cat);
    DoubanAttributeObj inviteOnlyAtt = new DoubanAttributeObj();
    inviteOnlyAtt.setName("invite_only");
    DoubanAttributeObj canInviteAtt = new DoubanAttributeObj();
    canInviteAtt.setName("can_invite");
    if (inviteOnly) {
      inviteOnlyAtt.setValue("yes");
    } else {
      inviteOnlyAtt.setValue("no");
    }
    if (canInvite) {
      canInviteAtt.setValue("yes");
    } else {
      canInviteAtt.setValue("no");
    }
    List<DoubanAttributeObj> atts = new ArrayList<DoubanAttributeObj>();
    atts.add(canInviteAtt);
    atts.add(inviteOnlyAtt);
    entry.setAttrs(atts);
    if (startTime.after(endTime)) {
      return null;
    }
    String startTimeStr = Converters.convertDateToStringInRFC3339(startTime);
    String endTimeStr = Converters.convertDateToStringInRFC3339(endTime);
    DoubanWhenObj when = new DoubanWhenObj();
    when.setStartTime(startTimeStr);
    when.setEndTime(endTimeStr);
    entry.setWhen(when);
    DoubanWhereObj whereObj = new DoubanWhereObj();
    whereObj.setValue(where);
    entry.setWhere(whereObj);
    return entry;
  }
}
