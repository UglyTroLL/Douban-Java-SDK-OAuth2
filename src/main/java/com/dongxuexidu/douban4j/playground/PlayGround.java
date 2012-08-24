package com.dongxuexidu.douban4j.playground;

import com.dongxuexidu.douban4j.model.app.AccessToken;
import com.dongxuexidu.douban4j.model.app.DoubanException;
import com.dongxuexidu.douban4j.model.app.RequestGrantScope;
import com.dongxuexidu.douban4j.provider.OAuthDoubanProvider;
import com.dongxuexidu.douban4j.service.DoubanMailService;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.client.xml.XmlNamespaceDictionary;
import com.google.api.client.xml.XmlObjectParser;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
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
    testSendingDoumail();
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
      //oauth.addScope(new RequestGrantScope("", RequestGrantScope.SCOPE_MAIL_READ, "")).addScope(new RequestGrantScope("", RequestGrantScope.SCOPE_MAIL_WRITE, ""));
      oauth.setRedirectUrl("http://www.dongxuexidu.com");
      BrowserLauncher.openURL(oauth.getGetCodeRedirectUrl());
      System.out.println(oauth.getGetCodeRedirectUrl());
      System.out.print("Hit enter when it's done.[Enter]:");
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
  
}
