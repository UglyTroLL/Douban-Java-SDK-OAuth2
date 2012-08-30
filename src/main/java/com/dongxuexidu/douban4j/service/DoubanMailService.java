package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.constants.RequestUrls;
import com.dongxuexidu.douban4j.constants.StatusCode;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.dongxuexidu.douban4j.model.common.DoubanAttributeObj;
import com.dongxuexidu.douban4j.model.common.DoubanEntityObj;
import com.dongxuexidu.douban4j.model.doumail.DoubanMailEntryObj;
import com.dongxuexidu.douban4j.model.doumail.DoubanMailFeedObj;
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
public class DoubanMailService extends DoubanService {

  final static Logger logger = Logger.getLogger(DoubanMailService.class.getName());

  public DoubanMailService(String accessToken) {
    super(accessToken);
  }

  public DoubanMailFeedObj getMailsFromInbox() throws DoubanException, IOException {
    return getMailsFromInbox(null, null);
  }

  public DoubanMailFeedObj getMailsFromInbox(Integer startIndex, Integer maxResult) throws DoubanException, IOException {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (startIndex != null) {
      params.add(new BasicNameValuePair("start-index", "" + startIndex));
    }
    if (maxResult != null) {
      params.add(new BasicNameValuePair("max-results", "" + maxResult));
    }
    String url = RequestUrls.DOUBAN_MAIL_PREFIX + "/inbox";
    DoubanMailFeedObj result = this.client.getResponse(url, params, DoubanMailFeedObj.class, true);
    return result;
  }

  public DoubanMailFeedObj getMailsFromOutbox() throws DoubanException, IOException {
    return getMailsFromOutbox(null, null);
  }

  public DoubanMailFeedObj getMailsFromOutbox(Integer startIndex, Integer maxResult) throws DoubanException, IOException {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (startIndex != null) {
      params.add(new BasicNameValuePair("start-index", "" + startIndex));
    }
    if (maxResult != null) {
      params.add(new BasicNameValuePair("max-results", "" + maxResult));
    }
    String url = RequestUrls.DOUBAN_MAIL_PREFIX + "/outbox";
    DoubanMailFeedObj result = this.client.getResponse(url, params, DoubanMailFeedObj.class, true);
    return result;
  }

  public DoubanMailFeedObj getUnreadMails() throws DoubanException, IOException {
    return getUnreadMails(null, null);
  }

  public DoubanMailFeedObj getUnreadMails(Integer startIndex, Integer maxResult) throws DoubanException, IOException {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (startIndex != null) {
      params.add(new BasicNameValuePair("start-index", "" + startIndex));
    }
    if (maxResult != null) {
      params.add(new BasicNameValuePair("max-results", "" + maxResult));
    }
    String url = RequestUrls.DOUBAN_MAIL_PREFIX + "/inbox/unread";
    DoubanMailFeedObj result = this.client.getResponse(url, params, DoubanMailFeedObj.class, true);
    return result;
  }

  public DoubanMailEntryObj getMailById(long mailId, boolean keepUnread) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_MAIL_PREFIX + "/" + mailId;
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (keepUnread) {
      params.add(new BasicNameValuePair("keep-unread", "true"));
    }
    DoubanMailEntryObj result = this.client.getResponse(url, params, DoubanMailEntryObj.class, true);
    return result;
  }

  /**
   * Didn't do anything with the Captcha
   * 
   * @param receiverId
   * @param content
   * @param title
   * @return true if successfully sent (or captcha is needed), false otherwise
   * @throws DoubanException
   * @throws IOException 
   */
  public boolean sendMail(String receiverId, String content, String title) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_MAIL_PREFIX + "s";
    DoubanMailEntryObj entry = generateDoubanMailEntryObj(receiverId, content, title);
    if (entry == null) {
      throw ErrorHandler.getCustomDoubanException(100, "Illegal mail data provided");
    }
    try {
      int responseCode = this.client.postResponseCodeOnly(url, entry, true);
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

  public boolean markMailAsRead(long mailId) throws IOException, DoubanException {
    String url = RequestUrls.DOUBAN_MAIL_PREFIX + "/" + mailId;
    DoubanMailEntryObj requestEntry = generateOnlyAttribute(null, true);
    try {
      int responseCode = this.client.putResponseCodeOnly(url, requestEntry, true);
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

  public boolean deleteMail(long mailId) throws IOException, DoubanException {
    String url = RequestUrls.DOUBAN_MAIL_PREFIX + "/" + mailId;
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

  public boolean markMailReadInBatch(List<Long> ids) throws IOException, DoubanException {
    List<DoubanMailEntryObj> entries = new ArrayList<DoubanMailEntryObj>();
    for (long id : ids) {
      DoubanMailEntryObj entry = generateOnlyAttribute("" + id, true);
      entries.add(entry);
    }
    DoubanMailFeedObj feed = new DoubanMailFeedObj();
    feed.setEntries(entries);
    String url = RequestUrls.DOUBAN_MAIL_PREFIX + "/";
    try {
      int responseCode = this.client.putResponseCodeOnly(url, feed, true);
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

  public boolean deleteMailsInBatch(List<Long> ids) throws IOException, DoubanException {
    List<DoubanMailEntryObj> entries = new ArrayList<DoubanMailEntryObj>();
    for (long id : ids) {
      DoubanMailEntryObj entry = generateOnlyAttribute("" + id, false);
      entries.add(entry);
    }
    DoubanMailFeedObj feed = new DoubanMailFeedObj();
    feed.setEntries(entries);
    String url = RequestUrls.DOUBAN_MAIL_PREFIX + "/delete";
    try {
      int responseCode = this.client.postResponseCodeOnly(url, feed, true);
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

  private DoubanMailEntryObj generateOnlyAttribute(String id, boolean hasAttr) {
    DoubanMailEntryObj entity = new DoubanMailEntryObj();
    if (hasAttr) {
      DoubanAttributeObj att = new DoubanAttributeObj();
      att.setName("unread");
      att.setValue("false");
      entity.setAttr(att);
    }
    if (id != null) {
      if (!id.startsWith("http://")) {
        id = "http://api.douban.com/doumail/" + id;
      }
      entity.setId(id);
    }
    return entity;
  }

  private DoubanMailEntryObj generateDoubanMailEntryObj(String receiverId, String content, String title) {
    if (content == null || content.isEmpty() || title == null || title.isEmpty() || receiverId == null || receiverId.isEmpty()) {
      return null;
    }
    String fullId = receiverId;
    if (!receiverId.startsWith("http://")) {
      fullId = "http://api.douban.com/people/" + receiverId;
    }
    DoubanEntityObj entity = new DoubanEntityObj();
    entity.setName("receiver");
    entity.setUri(fullId);
    DoubanMailEntryObj obj = new DoubanMailEntryObj();
    obj.setEntity(entity);
    obj.setTitle(title);
    obj.setContent(content);
    return obj;
  }
}
