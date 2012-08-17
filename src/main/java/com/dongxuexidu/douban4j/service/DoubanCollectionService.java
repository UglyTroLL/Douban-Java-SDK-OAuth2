package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.constants.StatusCode;
import com.dongxuexidu.douban4j.constants.RequestUrls;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.dongxuexidu.douban4j.model.collection.DoubanCollectionFeedObj;
import com.dongxuexidu.douban4j.model.collection.DoubanCollectionObj;
import com.dongxuexidu.douban4j.model.common.DoubanAttributeObj;
import com.dongxuexidu.douban4j.model.common.DoubanRatingObj;
import com.dongxuexidu.douban4j.model.common.DoubanTagObj;
import com.dongxuexidu.douban4j.model.subject.DoubanSubjectObj;
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
public class DoubanCollectionService extends DoubanService {

  Logger logger = Logger.getLogger(DoubanCollectionService.class.getName());

  public static enum CollectionCategory {

    Movie {
      @Override
      public String getValue() {
        return "movie";
      }
    },
    Book {
      @Override
      public String getValue() {
        return "book";
      }
    },
    Tv {
      @Override
      public String getValue() {
        return "tv";
      }
    },
    Music {
      @Override
      public String getValue() {
        return "music";
      }
    };

    public abstract String getValue();
  }

  public enum CollectionStatus {

    BookWill(CollectionCategory.Book) {
      @Override
      public String getValue() {
        return "wish";
      }
    },
    BookIng(CollectionCategory.Book) {
      @Override
      public String getValue() {
        return "reading";
      }
    },
    BookEd(CollectionCategory.Book) {
      @Override
      public String getValue() {
        return "read";
      }
    },
    MovieWill(CollectionCategory.Movie) {
      @Override
      public String getValue() {
        return "wish";
      }
    },
    MovieEd(CollectionCategory.Movie) {
      @Override
      public String getValue() {
        return "watched";
      }
    },
    TvWill(CollectionCategory.Tv) {
      @Override
      public String getValue() {
        return "wish";
      }
    },
    TvIng(CollectionCategory.Tv) {
      @Override
      public String getValue() {
        return "watching";
      }
    },
    TvEd(CollectionCategory.Tv) {
      @Override
      public String getValue() {
        return "watched";
      }
    },
    MusicWill(CollectionCategory.Music) {
      @Override
      public String getValue() {
        return "wish";
      }
    },
    MusicIng(CollectionCategory.Music) {
      @Override
      public String getValue() {
        return "listening";
      }
    },
    MusicEd(CollectionCategory.Music) {
      @Override
      public String getValue() {
        return "listened";
      }
    };
    CollectionCategory category;

    CollectionStatus(CollectionCategory category) {
      this.category = category;
    }

    public CollectionCategory getCategory() {
      return this.category;
    }

    public abstract String getValue();
  }

  public DoubanCollectionService() {
    super();
  }

  public DoubanCollectionService(String accessToken) {
    super(accessToken);
  }

  public DoubanCollectionObj getCollectionById(Long collectionId) throws DoubanException, IOException {
    //System.out.println("url : " + RequestUrls.DOUBAN_COLLECTION_PREFIX + "/" + collectionId);
    DoubanCollectionObj result = this.client.getResponse(RequestUrls.DOUBAN_COLLECTION_PREFIX + "/" + collectionId, null, DoubanCollectionObj.class, false);
    return result;
  }

  public DoubanCollectionFeedObj getUsersCollection(String userId) throws DoubanException, IOException {
    return getUsersCollection(userId, null, null, null, null, null, null, null);
  }

  public DoubanCollectionFeedObj getUsersCollection(String userId, CollectionCategory category, String tag, CollectionStatus status, Integer startIndex, Integer maxResult, Date startDate, Date endDate) throws DoubanException, IOException {
    if (category != null && status != null) {
      if (status.getCategory() != category) {
        throw ErrorHandler.getCustomDoubanException(100, "Collection category and status doesn't match");
      }
    }
    if (category == null && status != null) {
      throw ErrorHandler.getCustomDoubanException(100, "Collection category field is needed when you specified a status");
    }
    List<NameValuePair> params = new ArrayList<NameValuePair>();
    if (userId == null || userId.isEmpty()) {
      throw ErrorHandler.getCustomDoubanException(100, "user id cannot be null/empty when you're trying to get his/her collection");
    }
    String url = RequestUrls.DOUBAN_USER_PREFIX + "/" + userId + "/collection";

    if (category != null) {
      params.add(new BasicNameValuePair("cat", category.getValue()));
    }
    if (tag != null && tag.length() > 0) {
      params.add(new BasicNameValuePair("tag", tag));
    }
    if (status != null) {
      params.add(new BasicNameValuePair("status", status.getValue()));
    }
    if (startIndex != null) {
      params.add(new BasicNameValuePair("start-index", startIndex.toString()));
    }
    if (maxResult != null) {
      params.add(new BasicNameValuePair("max-results", maxResult.toString()));
    }
    if (startDate != null) {
      params.add(new BasicNameValuePair("updated-min", Converters.convertDateToStringInRFC3339(startDate)));
    }
    if (endDate != null) {
      params.add(new BasicNameValuePair("updated-max", Converters.convertDateToStringInRFC3339(endDate)));
    }
    DoubanCollectionFeedObj result = this.client.getResponse(url, params, DoubanCollectionFeedObj.class, false);
    return result;
  }

  public boolean createNewCollection(CollectionStatus status, List<String> tags, int rating, String content, String subjectId, boolean isPrivate, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    DoubanCollectionObj collection = generateCollection(null, status, tags, rating, content, subjectId, isPrivate);
    if (collection == null) {
      throw ErrorHandler.getCustomDoubanException(100, "Collection data is not correct, please double check");
    }
    try {
      int responseCode = this.client.postResponseCodeOnly(RequestUrls.DOUBAN_COLLECTION_PREFIX, collection, true);
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
  
  private DoubanCollectionObj generateCollection (Long id, CollectionStatus status, List<String> tags, int rating, String content, String subjectId, Boolean isPrivate) {
    DoubanCollectionObj col = new DoubanCollectionObj();
    if (status != null) {
      col.setStatus(status.getValue());
    } else {
      return null;
    }
    if (id != null) {
      col.setId(RequestUrls.DOUBAN_COLLECTION_PREFIX + "/" + id);
    }
    DoubanRatingObj rat = new DoubanRatingObj();
    if (rating > 5) {
      rating = 5;
    } else if (rating < 1) {
      rating = 1;
    }
    rat.setValue("" + rating);
    col.setRating(rat);
    if (tags != null && !tags.isEmpty()) {
      List<DoubanTagObj> tagsList = new ArrayList<DoubanTagObj>();
      for (String t : tags) {
        DoubanTagObj tag = new DoubanTagObj();
        tag.setName(t);
        tagsList.add(tag);
      }
      col.setTags(tagsList);
    }
    if (subjectId == null || subjectId.isEmpty()) {
      return null;
    }
    DoubanSubjectObj sub = new DoubanSubjectObj();
    sub.setId(subjectId);
    col.setSubject(sub);
    col.setContent(content == null ? "" : content);
    if (isPrivate != null && isPrivate) {
      List<DoubanAttributeObj> atts = new ArrayList<DoubanAttributeObj>();
      DoubanAttributeObj att = new DoubanAttributeObj();
      att.setName("privacy");
      att.setValue("private");
      atts.add(att);
      col.setAtt(atts);
    }
    return col;
  }

  public boolean updateCollection(Long collectionId, CollectionStatus status, List<String> tags, int rating, String content, String subjectId, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    DoubanCollectionObj collection = generateCollection(collectionId, status, tags, rating, content, subjectId, null);
    if (collection == null || collectionId == null) {
      throw ErrorHandler.getCustomDoubanException(100, "Collection data is not correct, please double check");
    }
    try {
      int responseCode = this.client.putResponseCodeOnly(RequestUrls.DOUBAN_COLLECTION_PREFIX + "/" + collectionId, collection, true);
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

  public boolean deleteCollection(Long collectionId, String accessToken) throws DoubanException, IOException {
    setAccessToken(accessToken);
    if (collectionId == null) {
      throw ErrorHandler.getCustomDoubanException(100, "New collection object cannot be null");
    }
    try {
      int responseCode = this.client.deleteResponse(RequestUrls.DOUBAN_COLLECTION_PREFIX + "/" + collectionId, true);
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
}
