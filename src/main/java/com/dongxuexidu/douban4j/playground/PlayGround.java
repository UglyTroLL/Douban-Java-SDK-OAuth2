package com.dongxuexidu.douban4j.playground;

import com.dongxuexidu.douban4j.constants.DefaultConfigs;
import com.dongxuexidu.douban4j.model.app.AccessToken;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.dongxuexidu.douban4j.model.app.RequestGrantScope;
import com.dongxuexidu.douban4j.model.common.DoubanAttributeObj;
import com.dongxuexidu.douban4j.model.common.DoubanTagObj;
import com.dongxuexidu.douban4j.model.shuo.DoubanShuoAttachementObj;
import com.dongxuexidu.douban4j.model.shuo.DoubanShuoMediaObj;
import com.dongxuexidu.douban4j.model.shuo.DoubanShuoStatusObj;
import com.dongxuexidu.douban4j.model.shuo.DoubanShuoUserObj;
import com.dongxuexidu.douban4j.model.subject.DoubanSubjectObj;
import com.dongxuexidu.douban4j.provider.OAuthDoubanProvider;
import com.dongxuexidu.douban4j.service.DoubanBookMovieMusicService;
import com.dongxuexidu.douban4j.service.DoubanMailService;
import com.dongxuexidu.douban4j.service.DoubanShuoService;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.client.xml.XmlNamespaceDictionary;
import com.google.api.client.xml.XmlObjectParser;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class PlayGround {

  /**
   * <entry xmlns="http://www.w3.org/2005/Atom"
   * xmlns:db="http://www.douban.com/xmlns/"
   * xmlns:gd="http://schemas.google.com/g/2005"
   * xmlns:openSearch="http://a9.com/-/spec/opensearchrss/1.0/"
   * xmlns:opensearch="http://a9.com/-/spec/opensearchrss/1.0/"> @param args
   */
  public static void main(String[] args) {
    testAccessToken();
  }
  
  public static void testAtomParse () {
    FileInputStream fis = null;
    try {
      XmlNamespaceDictionary nameSpace = new XmlNamespaceDictionary().set("", "http://www.w3.org/2005/Atom").set("db", "http://www.douban.com/xmlns/").set("gd", "http://schemas.google.com/g/2005").set("openSearch", "http://a9.com/-/spec/opensearchrss/1.0/").set("opensearch", "http://a9.com/-/spec/opensearchrss/1.0/");
      XmlObjectParser parser = new XmlObjectParser(nameSpace);
      //JsonObjectParser parser = new JsonObjectParser(new JacksonFactory());
      fis = new FileInputStream("/home/zwei/doubantestxml");
      DoubanPeopleEntry result = parser.parseAndClose(fis, Charset.forName("utf-8"), DoubanPeopleEntry.class);
      System.out.println("result : " + result);
    } catch (FileNotFoundException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      try {
        fis.close();
      } catch (IOException ex) {
        Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  public static String testAccessToken() {
    try {
      OAuthDoubanProvider oauth = new OAuthDoubanProvider();
      oauth.setApiKey("xxx").setSecretKey("xxx");
      oauth.addScope(RequestGrantScope.BASIC_COMMON_SCOPE).addScope(RequestGrantScope.SHUO_READ_SCOPE).addScope(RequestGrantScope.SHUO_WRITE_SCOPE)
              .addScope(RequestGrantScope.BASIC_NOTE_SCOPE).addScope(RequestGrantScope.BOOK_READ_SCOPE).addScope(RequestGrantScope.EVENT_READ_SCOPE).addScope(RequestGrantScope.EVENT_WRITE_SCOPE)
              .addScope(RequestGrantScope.MAIL_READ_SCOPE).addScope(RequestGrantScope.MAIL_WRITE_SCOPE).addScope(RequestGrantScope.MOVIE_READ_SCOPE).addScope(RequestGrantScope.MUSIC_READ_SCOPE);
      oauth.setRedirectUrl("http://www.dongxuexidu.com");
      BrowserLauncher.openURL(oauth.getGetCodeRedirectUrl());
      System.out.println(oauth.getGetCodeRedirectUrl());
      System.out.print("Put the code you got here.[Enter]:");
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String code = br.readLine();
      System.out.println("code : " + code);
      AccessToken at = oauth.tradeAccessTokenWithCode(code);
      System.out.println("at : " + at.getAccessToken());
      System.out.println("uid : " + at.getDoubanUserId());
      return at.getAccessToken();
    } catch (DoubanException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    } catch (IOException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
      return null;
    }
  }
  
  public static void testSendingDoumail () {
    try {
      String accessToken = testAccessToken();
      DoubanMailService service = new DoubanMailService(accessToken);
      if (service.sendMail("abei", "test!", "ceshi")) {
        System.out.println("done!");
      } else {
        System.out.println("o shit");
      }
    } catch (DoubanException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public static void testGetBookInfo () {
    try {
      // long bookId = 2023013;
      DoubanBookMovieMusicService service = new DoubanBookMovieMusicService();
      DoubanSubjectObj book = service.getMusicInfoById(2272292);
      System.out.println("title : " + book.getTitle());
      for (DoubanTagObj tag : book.getTags()) {
        System.out.println("tag, count : " + tag.getCount() + " , name : " + tag.getName());
      }
      System.out.println("rating, min : " + book.getRating().getMin() + ", max : " + book.getRating().getMax() + " , value : " + book.getRating().getValue() + " , count : " + book.getRating().getNumberOfRaters() + " , avg : " + book.getRating().getAverage());
      System.out.println("author : " + book.getAuthors().get(0).getName());
      for (DoubanAttributeObj att : book.getAttributes()) {
        System.out.println("att, name : " + att.getName() + " , value : " + att.getValue());
      }
      System.out.println("summary : " + book.getSummary());
    } catch (DoubanException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public static void testGetDoubanShuoStatuses () {
    try {
      DoubanShuoService service = new DoubanShuoService();
      DoubanShuoStatusObj[] result = service.getStatusesByUserId("xxx");
      System.out.println("size : " + result.length);
      for (DoubanShuoStatusObj s : result) {
        System.out.println("text : " + s.getText() + " , title : " + s.getTitle());
      }
    } catch (DoubanException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public static void testPostStatus () {
    try {
      String accessToken = testAccessToken();
      DoubanShuoService service = new DoubanShuoService();
      DoubanShuoAttachementObj att = generateAtt();
      if (service.postNewStatus("I like..", att, DefaultConfigs.API_KEY, accessToken)) {
        System.out.println("done!");
      } else {
        System.out.println("failed!");
      }
    } catch (DoubanException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public static void testGetDoubanShuoUser () {
    try {
      DoubanShuoService service = new DoubanShuoService();
      DoubanShuoUserObj[] users = service.getFollowingUserByUserId("xxx");
      for (DoubanShuoUserObj user : users) {
        System.out.println("user name : " + user.getScreenName());
        System.out.println("user id : " + user.getUid());
        System.out.println("user full id : " + user.getId());
      }
      System.out.println("size : " + users.length);
    } catch (DoubanException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public static void testFollowUser () {
    try {
      String accessToken = testAccessToken();
      DoubanShuoService service = new DoubanShuoService();
      boolean result = service.followUser("xxx", DefaultConfigs.API_KEY,accessToken);
      if (result) {
        System.out.println("done!");
      } else {
        System.out.println("failed!");
      }
    } catch (DoubanException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  public static void testGetRelationShip() {
    try {
      DoubanShuoService service = new DoubanShuoService();
      DoubanShuoService.DoubanShuoRelation relation = service.getRelationship("xxx", "xxx", DefaultConfigs.API_KEY);
      if (relation == DoubanShuoService.DoubanShuoRelation.FollowingOnly) {
        System.out.println("following");
      } else if (relation == DoubanShuoService.DoubanShuoRelation.BeFollowedOnly) {
        System.out.println("followed by");
      } else if (relation == DoubanShuoService.DoubanShuoRelation.Friend) {
        System.out.println("friend");
      } else {
        System.out.println("stranger");
      }
    } catch (DoubanException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  private static void parseJson () {
    try {
      DoubanShuoAttachementObj att = generateAtt();
      JsonHttpContent content = new JsonHttpContent(new JacksonFactory(), att);
      ByteArrayOutputStream os = new ByteArrayOutputStream();
      content.writeTo(os);
      String result = new String(os.toByteArray());
      System.out.println("result ! : " + result);
      System.out.println("getdate : " + (String)content.getData());
    } catch (IOException ex) {
      Logger.getLogger(PlayGround.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
  private static DoubanShuoAttachementObj generateAtt () {
    DoubanShuoMediaObj media = new DoubanShuoMediaObj();
    media.setHref("http://www.dongxuexidu.com");
    media.setSrc("http://www.dongxuexidu.com/img/logo75.jpg");
    media.setType("image");
    DoubanShuoAttachementObj att = new DoubanShuoAttachementObj();
    List<DoubanShuoMediaObj> ms = new ArrayList<DoubanShuoMediaObj>();
    ms.add(media);
    att.setMedias(ms);
    att.setDescription("http://www.dongxuexidu.com");
    att.setCaption("");
    att.setExpanedHref("http://www.dongxuexidu.com");
    att.setHref("http://www.dongxuexidu.com");
    att.setTitle("东学西读");
    att.setType("");
    return att;
  }
  
}
