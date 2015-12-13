

豆瓣OAuth2 API Java SDK (几乎完全版) v0.727
======================================

注意
---
现在本SDK是基于豆瓣OAuth 2.0 API的v1版，也就是使用GData 和 Atom作为数据传输类型的版本，使用JSON的v2版本尚未支持。
由于主作者没有更多时间来更新这个SDK，欢迎大家Fork本SDK,如果您做了更新，欢迎发Pull Request给我，我会及时Merge.

功能/优点
---
+ **豆瓣Oauth2认证流程** - `用户登录`
从引导用户，用户批准权限换code到用code换accessToken
+ **完备的模型(Model)以及转换器(Parser)** - `无需担心数据转换和提取`
完美转换豆瓣API所使用的GData/Atom类型的xml以及json致简单易读易懂易用的JavaBean
+ **'豆瓣社区/书影音/豆瓣说'全覆盖** - `全面支持豆瓣开放了的API`
几乎支持全部豆瓣开放平台中开放了的API
+ **错误处理** - `轻松了解为何出错`
对各种Exception的包装，使得错误信息明了，使用简单(无需分门别类catch一大堆Exception)
+ **防误调用** - `减少调用中的问题`
精心设计的调用接口，使得无需阅读大量文档也可以轻松使用
+ **多线程/并发支持** - `虽然没测大量并发`
但是，谁用谁知道。在**没有bug的情况下**服务应该是线程安全的 :)

安装使用
---
有两种方式来整合SDK到您自己的项目中:

* **使用Maven编译打包** - `(**推荐**)`
由于项目本身就是一个Maven项目，所以使用Maven最方便.
如果您的项目本身就是一个Maven项目，那么直接在您项目的pom.xml中加入依赖:

```xml
<dependency>
  <groupId>com.zhibo</groupId>
  <artifactId>Douban4jOAuth2</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>
```

然后编译SDK,**编译时请务必跳过所有test**(不然会通不过无法编译，因为很多测试用例都是需要accessToken的),编译命令使用mvn package或mvn install,根据您自己的需要(如果您不明白两者的区别，请google Maven的基础知识)。例子如下:
```
mvn package -Dmaven.test.skip=true
```

* **在您的项目中包含SDK全部源码** `(**如果能使用Maven请尽量使用Maven,尽量不要使用这种方式**)`
那么，您需要自己下载以下依赖:
  * commons-codec-1.9.jar
  * commons-lang-2.6.jar
  * google-http-client-1.10.3-beta.jar
  * gson-2.4.jar
  * guava-14.0.1.jar
  * httpclient-4.5.1.jar
  * httpcore-4.4.3.jar
  * jackson-core-asl-1.9.13.jar
  * json-lib-2.4-jdk15.jar
  * protobuf-java-2.4.1.jar
  * xmlpull-1.1.3.1.jar

可以到这儿下载：http://www.mvnrepository.com/

OAuth认证流程
---
1. 初始化:
```js
OAuthDoubanProvider oauth = new OAuthDoubanProvider();
oauth.setApiKey("xxx").setSecretKey("xxx");//设置Apikey和secretKey.
/*
也可以在DefaultConfigs中直接填入您的apikey和secretKey，那么就不需要每次都设置这两个值.
*/
oauth.addScope(RequestGrantScope.BASIC_COMMON_SCOPE).addScope(......).//设置权限范围
oauth.setRedirectUrl("http://www.dongxuexidu.com");//设置回调地址
.........
```

2. 引导用户至豆瓣认证页面,该页面地址可以通过以下代码拿到:
```js
String redirectUrl = oauth.getGetCodeRedirectUrl();
```

3. 通过你的回调地址获得code.
```js
String code = howeverYouGetIt();
```

4. 用code换accessToken.
```js
AccessToken at = oauth.tradeAccessTokenWithCode(code);
```

整个流程在PlayGround.java里面的testAccessToken()方法内有详细可以测试的例子。

豆瓣API调用
---
请详见Test目录下的全部测试用例

其他说明
---
* **参数类型** 方法参数中类型为基本类型(如int, long)的说明该参数为必须，参数为包装类型(Integer, Long)的说明可为null且不会有任何问题。
* **缺豆瓣说里面部分评论相关API** 懒了没写
* **未测试方法** 部分未测试方法前含有@UnTested的Annotation,其余皆为已经测试通过的.
* **未实现部分分支** 如豆邮过多需要验证码的引导,如上传本地图片至豆瓣说广播等.
* **使用实例** 使用实例都可以在PlayGround,java和Test目录下找到.
* **欢迎** 有兴趣的同学来一起继续完善这个SDK

开源使用协议
---
MIT License

Contributors
---
- [UglyTroLL](https://github.com/UglyTroLL)
- [Sean Guo](https://github.com/seanguo)
- [SuperWang](https://github.com/SuperWang)
- [wellno](https://github.com/wellno)
