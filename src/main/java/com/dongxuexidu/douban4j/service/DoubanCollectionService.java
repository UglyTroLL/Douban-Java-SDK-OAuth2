package com.dongxuexidu.douban4j.service;

import com.dongxuexidu.douban4j.constants.RequestUrls;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.dongxuexidu.douban4j.model.collection.DoubanCollectionObj;
import com.dongxuexidu.douban4j.utils.Converters;
import com.dongxuexidu.douban4j.utils.ErrorHandler;
import net.sf.json.JSONObject;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class DoubanCollectionService extends DoubanService {
  
  public DoubanCollectionService() {
    super();
  }
  
  public DoubanCollectionService(String accessToken) {
    super(accessToken);
  }
  
  public JSONObject getCollectionByIdInJSON (String collectionId) throws DoubanException {
    String resultStr = this.client.getResponse(RequestUrls.GET_COLLECTION_BY_ID_URL + collectionId, null, false);
    DoubanException exp = ErrorHandler.handleError(resultStr);
    if (exp != null) {
      throw exp;
    }
    JSONObject jObj = Converters.toJsonObj(resultStr);
    return jObj;
  }
  
  public DoubanCollectionObj getCollectionById (String collectionId) throws DoubanException {
    JSONObject jObj = getCollectionByIdInJSON(collectionId);
    return (DoubanCollectionObj)new DoubanCollectionObj().ConvertFrom(jObj);
  }
  
}
