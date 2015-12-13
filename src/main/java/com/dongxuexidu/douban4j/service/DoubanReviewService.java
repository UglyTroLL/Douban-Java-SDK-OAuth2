package com.dongxuexidu.douban4j.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.dongxuexidu.douban4j.constants.RequestUrls;
import com.dongxuexidu.douban4j.constants.StatusCode;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.dongxuexidu.douban4j.model.common.DoubanRatingObj;
import com.dongxuexidu.douban4j.model.review.DoubanReviewEntryObj;
import com.dongxuexidu.douban4j.model.review.DoubanReviewFeedObj;
import com.dongxuexidu.douban4j.model.subject.DoubanSubjectObj;
import com.dongxuexidu.douban4j.utils.ErrorHandler;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanReviewService extends DoubanService {
  
  Logger logger = Logger.getLogger(DoubanReviewService.class.getName());
  
  public enum ReviewOrderBy {
    Time {
      @Override
      public String getValue() {
        return "time";
      }
    },
    Score {
      @Override
      public String getValue() {
        return "score";
      }
    };
    public abstract String getValue();
  }
  
  public DoubanReviewService () {
    super();
  }
  
  public DoubanReviewService (String accessToken) {
    super(accessToken);
  }
  
  public DoubanReviewEntryObj getReviewById (long reviewId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_REVIEW_PREFIX + "/" + reviewId;
    DoubanReviewEntryObj result = this.client.getResponse(url, null, DoubanReviewEntryObj.class, false);
    return result;
  }
  
  public DoubanReviewFeedObj getUsersReview (String userId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_USER_PREFIX + "/" + userId + "/reviews";
    DoubanReviewFeedObj result = this.client.getResponse(url, null, DoubanReviewFeedObj.class, false);
    return result;
  }
  
  /**
   * Book
   */
  
  public DoubanReviewFeedObj getBookReviewsBySubjectId (long subjectId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_BOOK_SUBJECT_PREFIX + "/" + subjectId + "/reviews";
    return getReviewList(url, null, null, null);
  }
  
  public DoubanReviewFeedObj getBookReviewsBySubjectId (long subjectId, int startIndex, int maxResult, ReviewOrderBy orderBy) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_BOOK_SUBJECT_PREFIX + "/" + subjectId + "/reviews";
    return getReviewList(url, startIndex, maxResult, orderBy);
  }
  
  public DoubanReviewFeedObj getBookReviewsByISBNId (String isbnId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_BOOK_SUBJECT_PREFIX + "/isbn/" + isbnId + "/reviews";
    return getReviewList(url, null, null, null);
  }
  
  public DoubanReviewFeedObj getBookReviewsByISBNId (String isbnId, int startIndex, int maxResult, ReviewOrderBy orderBy) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_BOOK_SUBJECT_PREFIX + "/isbn/" + isbnId + "/reviews";
    return getReviewList(url, startIndex, maxResult, orderBy);
  }
  
  /**
   * Movie
   */
  
  public DoubanReviewFeedObj getMovieReviewsBySubjectId (long subjectId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_MOVIE_SUBJECT_PREFIX + "/" + subjectId + "/reviews";
    return getReviewList(url, null, null, null);
  }
  
  public DoubanReviewFeedObj getMovieReviewsBySubjectId (long subjectId, int startIndex, int maxResult, ReviewOrderBy orderBy) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_MOVIE_SUBJECT_PREFIX + "/" + subjectId + "/reviews";
    return getReviewList(url, startIndex, maxResult, orderBy);
  }
  
  public DoubanReviewFeedObj getMovieReviewsByIMDBId (String imdbId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_MOVIE_SUBJECT_PREFIX + "/imdb/" + imdbId + "/reviews";
    return getReviewList(url, null, null, null);
  }
  
  public DoubanReviewFeedObj getMovieReviewsByIMDBId (String imdbId, int startIndex, int maxResult, ReviewOrderBy orderBy) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_MOVIE_SUBJECT_PREFIX + "/imdb/" + imdbId + "/reviews";
    return getReviewList(url, startIndex, maxResult, orderBy);
  }
  
  /**
   * Music
   */
  
  public DoubanReviewFeedObj getMusicReviewsBySubjectId (long subjectId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_MUSIC_SUBJECT_PREFIX + "/" + subjectId + "/reviews";
    return getReviewList(url, null, null, null);
  }
  
  public DoubanReviewFeedObj getMusicReviewsBySubjectId (long subjectId, int startIndex, int maxResult, ReviewOrderBy orderBy) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_MUSIC_SUBJECT_PREFIX + "/" + subjectId + "/reviews";
    return getReviewList(url, startIndex, maxResult, orderBy);
  }

  private DoubanReviewFeedObj getReviewList (String url, Integer startIndex, Integer maxResult, ReviewOrderBy orderBy) throws DoubanException, IOException {
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (startIndex != null) {
      params.add(new BasicNameValuePair("start-index", startIndex.toString()));
    }
    if (maxResult != null) {
      params.add(new BasicNameValuePair("max-results", maxResult.toString()));
    }
    if (orderBy != null) {
      params.add(new BasicNameValuePair("orderby", orderBy.getValue()));
    }
    DoubanReviewFeedObj result = this.client.getResponse(url, params, DoubanReviewFeedObj.class, false);
    return result;
  }

  public boolean addNewReview (long subjectId, String content, int rating, String title, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    DoubanReviewEntryObj obj = generateReviewObj(subjectId, content, rating, title, null);
    if (obj == null) {
      throw ErrorHandler.getCustomDoubanException(100, "Review data is not correct, please double check");
    }
    try {
      int responseCode = this.client.postResponseCodeOnly(RequestUrls.DOUBAN_REVIEW_PREFIX + "s", obj, true);
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

  public boolean updateReview (long reviewId, long subjectId, String content, String title, int rating, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    DoubanReviewEntryObj obj = generateReviewObj(subjectId, content, rating, title, reviewId);
    if (obj == null) {
      throw ErrorHandler.getCustomDoubanException(100, "Review data is not correct, please double check");
    }
    try {
      int responseCode = this.client.putResponseCodeOnly(RequestUrls.DOUBAN_REVIEW_PREFIX + "/" + reviewId, obj, true);
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

  public boolean deleteReview (long reviewId, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    try {
      int responseCode = this.client.deleteResponse(RequestUrls.DOUBAN_REVIEW_PREFIX + "/" + reviewId, true);
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
  
  private DoubanReviewEntryObj generateReviewObj (long subjectId, String content, int rating, String title, Long reviewUrl) {
    DoubanReviewEntryObj obj = new DoubanReviewEntryObj();
    if (reviewUrl != null) {
      obj.setId(RequestUrls.DOUBAN_REVIEW_PREFIX + "/" + reviewUrl);
    }
    DoubanSubjectObj sub = new DoubanSubjectObj();
    sub.setId("" + subjectId);
    obj.setSubject(sub);
    if (content != null && content.length() > 0) {
      obj.setContent(content);
    } else {
      obj.setContent("");
    }
    if (title != null && title.length() > 0) {
      obj.setTitle(title);
    } else {
      obj.setTitle("");
    }
    DoubanRatingObj rat = new DoubanRatingObj();
    if (rating > 5) {
      rating = 5;
    } else if (rating < 1) {
      rating = 1;
    }
    rat.setValue(rating);
    obj.setRating(rat);
    return obj;
  }
  
}
