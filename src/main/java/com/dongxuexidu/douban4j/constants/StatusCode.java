package com.dongxuexidu.douban4j.constants;

/**
 *
 * @author Zhibo Wei <uglytroll@dongxuexidu.com>
 */
public class StatusCode {
  
  public static final int HTTP_STATUS_OK = 200; //请求成功
  public static final int HTTP_STATUS_CREATED = 201; //创建成功
  public static final int HTTP_STATUS_ACCEPTED = 202; //更新成功
  public static final int HTTP_STATUS_BAD_REQUEST = 400; //请求的地址不存在或者包含不支持的参数
  public static final int HTTP_STATUS_UNAUTHORIZED = 401; //未授权
  public static final int HTTP_STATUS_FORBIDDEN = 403; //被禁止访问
  public static final int HTTP_STATUS_NOT_FOUND = 404; //请求的资源不存在
  public static final int HTTP_STATUS_INTERNAL_SERVER_ERROR = 500; //内部错误

  /**
   *  100	invalid_request_scheme 错误的请求协议
      101	invalid_request_method 错误的请求方法
      102	access_token_is_missing 未找到access_token
      103	invalid_access_token access_token不存在或已被用户删除
      104	invalid_apikey apikey不存在或已删除
      105	apikey_is_blocked apikey已被禁用
      106	access_token_has_expired access_token已过期
      107	invalid_request_uri 请求地址未注册
      108	invalid_credencial1 用户未授权访问此数据
      109	invalid_credencial2 apikey未申请此权限
      110	not_trial_user 未注册的测试用户
      111	rate_limit_exceeded1 用户访问速度限制
      112	rate_limit_exceeded2 IP访问速度限制
      113	required_parameter_is_missing 缺少参数
      114	unsupported_grant_type 错误的grant_type
      115	unsupported_response_type 错误的response_type
      116	client_secret_mismatch client_secret不匹配
      117	redirect_uri_mismatch redirect_uri不匹配
      118	invalid_authorization_code authorization_code不存在或已过期
      119	invalid_refresh_token refresh_token不存在或已过期
      120	username_password_mismatch 用户名密码不匹配
      121	invalid_user 用户不存在或已删除
      122	user_has_blocked 用户已被屏蔽
      123	access_token_has_expired_since_password_changed 因用户修改密码而导致access_token过期
      124	access_token_has_not_expired access_token未过期
      125	invalid_request_scope 访问的scope不合法，开发者不用太关注，一般不会出现该错误
      999	unknown 未知错误
      * 
      *
      * I guess we don't need these? Since the error description is already in the return message
   */
  public static final int API_CODE_INVALID_REQUEST_SCHEME = 100;
  public static final int API_CODE_INVALID_REQUEST_METHOD = 101;
  public static final int API_CODE_ACCESS_TOKEN_IS_MISSING = 102;
  public static final int API_CODE_INVALID_ACCESS_TOKEN = 103;
  public static final int API_CODE_INVALID_APIKEY = 104;
  public static final int API_CODE_APIKEY_IS_BLOCKED = 105;
  public static final int API_CODE_ACCESS_TOKEN_HAS_EXPIRED = 106;
  public static final int API_CODE_INVALID_REQUEST_URI = 107;
  public static final int API_CODE_INVALID_CREDENCIAL_NO_USER_PERMISSION = 108;
  public static final int API_CODE_INVALID_CREDENCIAL_NO_API_PERMISSION = 109;
  public static final int API_CODE_NOT_TRIAL_USER = 110;
  public static final int API_CODE_RATE_LIMIT_EXCEEDED_USER = 111;
  public static final int API_CODE_RATE_LIMIT_EXCEEDED_IP = 112;
  public static final int API_CODE_REQUIRED_PARAMETER_IS_MISSING = 113;
  public static final int API_CODE_UNSUPPORTED_GRANT_TYPE = 114;
  public static final int API_CODE_UNSUPPORTED_RESPONSE_TYPE = 115;
  public static final int API_CODE_CLIENT_SECRET_MISMATCH = 116;
  public static final int API_CODE_REDIRECT_URI_MISMATCH = 117;
  public static final int API_CODE_INVALID_AUTHORIZATION_CODE = 118;
  public static final int API_CODE_INVALID_REFRESH_TOKEN = 119;
  public static final int API_CODE_USERNAME_PASSWORD_MISMATCH = 120;
  public static final int API_CODE_INVALID_USER = 121;
  public static final int API_CODE_USER_HAS_BEEN_BLOCKED = 122;
  public static final int API_CODE_ACCESS_TOKEN_EXPIRED_SINCE_PASSWORD_CHANGED = 123;
  public static final int API_CODE_ACCESS_TOKEN_HAS_NOT_EXPIRED = 124;
  public static final int API_CODE_INVALID_REQUEST_SCOPE = 125;
  public static final int API_CODE_UNKNOWN_DAMN_IT = 999;
  
}
