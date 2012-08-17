package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.constants.RequestUrls;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.dongxuexidu.douban4j.model.review.DoubanReviewEntryObj;
import com.dongxuexidu.douban4j.model.review.DoubanReviewFeedObj;
import java.io.IOException;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanReviewService extends DoubanService {
  
  public DoubanReviewService () {
    super();
  }
  
  public DoubanReviewService (String accessToken) {
    super(accessToken);
  }
  
  public DoubanReviewEntryObj getReviewById (String reviewId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_REVIEW_PREFIX + "/" + reviewId;
    DoubanReviewEntryObj result = this.client.getResponse(url, null, DoubanReviewEntryObj.class, false);
    return result;
  }
  
  public DoubanReviewFeedObj getUsersReview (String userId) throws DoubanException, IOException {
    String url = RequestUrls.DOUBAN_USER_PREFIX + "/" + userId + "/reviews";
    DoubanReviewFeedObj result = this.client.getResponse(url, null, DoubanReviewFeedObj.class, false);
    return result;
  }
  
}
