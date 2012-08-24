package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.constants.RequestUrls;
import com.dongxuexidu.douban4j.constants.StatusCode;
import com.dongxuexidu.douban4j.model.UnTested;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.dongxuexidu.douban4j.model.common.DoubanAttributeObj;
import com.dongxuexidu.douban4j.model.note.DoubanNoteEntryObj;
import com.dongxuexidu.douban4j.model.note.DoubanNoteFeedObj;
import com.dongxuexidu.douban4j.utils.ErrorHandler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanNoteService extends DoubanService {
  
  final static Logger logger = Logger.getLogger(DoubanNoteService.class.getName());
  
  public DoubanNoteService() {
    super();
  }
  
  public DoubanNoteService(String accessToken) {
    super(accessToken);
  }

  public DoubanNoteEntryObj getNoteById(long noteId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_NOTE_PREFIX + "/" + noteId;
    DoubanNoteEntryObj result = this.client.getResponse(url, null, DoubanNoteEntryObj.class, false);
    return result;
  }
  
  public DoubanNoteFeedObj getAllNotesFromUser(String userId) throws DoubanException, IOException {
    return getAllNotesFromUser(userId, null, null);
  }
  
  public DoubanNoteFeedObj getAllNotesFromUser (String userId, Integer startIndex, Integer maxResult) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_USER_PREFIX + "/" + userId + "/notes";
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (startIndex != null) {
      params.add(new BasicNameValuePair("start-index", "" + startIndex));
    }
    if (maxResult != null) {
      params.add(new BasicNameValuePair("max-results", "" + maxResult));
    }
    DoubanNoteFeedObj result = this.client.getResponse(url, params, DoubanNoteFeedObj.class, false);
    return result;
  }
  
  @UnTested
  public boolean createNewNote (String title, String content, boolean isPrivate, boolean canReply, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    DoubanNoteEntryObj entry = generateDoubanNoteEntry(title, content, isPrivate, canReply);
    if (entry == null) {
      throw ErrorHandler.getCustomDoubanException(100, "Note data is not correct, please double check");
    }
    try {
      int responseCode = this.client.postResponseCodeOnly(RequestUrls.DOUBAN_NOTE_PREFIX + "s", entry, true);
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
  
  @UnTested
  public boolean updateNote (long noteId, String title, String content, boolean isPrivate, boolean canReply, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    DoubanNoteEntryObj entry = generateDoubanNoteEntry(title, content, isPrivate, canReply);
    if (entry == null) {
      throw ErrorHandler.getCustomDoubanException(100, "Note data is not correct, please double check");
    }
    try {
      int responseCode = this.client.putResponseCodeOnly(RequestUrls.DOUBAN_NOTE_PREFIX + "/" + noteId, entry, true);
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
  public boolean deleteNote (long noteId, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    try {
      int responseCode = this.client.deleteResponse(RequestUrls.DOUBAN_NOTE_PREFIX + "/" + noteId, true);
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
  
  private DoubanNoteEntryObj generateDoubanNoteEntry (String title, String content, boolean isPrivate, boolean canReply) {
    DoubanNoteEntryObj entry = new DoubanNoteEntryObj();
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
    List<DoubanAttributeObj> atts = new ArrayList<DoubanAttributeObj>();
    if (isPrivate) {
      DoubanAttributeObj privateAtt = new DoubanAttributeObj();
      privateAtt.setName("privacy");
      privateAtt.setValue("private");
      atts.add(privateAtt);
    }
    DoubanAttributeObj replyAtt = new DoubanAttributeObj();
    replyAtt.setName("can_reply");
    replyAtt.setValue(canReply ? "yes" : "no");
    atts.add(replyAtt);
    entry.setAttributes(atts);
    return entry;
  }
  
}
