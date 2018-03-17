package com.choudou5.javasaasx.base.constant;

/**
 * @Name：错误码
 * @Author：xuhaowen
 * @Date：2018-03-17
 */
public interface ErrorCodes {

    /** 操作成功 **/
    public static final Integer SUCCESS = 1000;

    /** 操作失败 **/
    public static final Integer FAIL = 1001;

    /** 网络故障,系统出错 */
    public static final Integer NOMAL = 0;

    /** 网络故障,系统出错 */
    public static final Integer SYS_OR_NET_ERROR = 100001;

    /** 数据库错误 */
    public static final Integer DB_ERROR = 101001;

    /** 不可预知错误 */
    public static final Integer UNKNOWN_ERROR = 102001;

    /** 数据异常，请稍后重试 */
    public static final Integer DB_EXCEPTION = 103001;

    /** 请求参数异常 */
    public static final Integer REQUEST_PARAM_EXCEPTION = 103002;

    /** 响应参数异常 */
    public static final Integer RESPONSE_PARAM_EXCEPTION = 103003;

    /** 内部异常 */
    public static final Integer INTERNAL_EXCEPTION = 1004001;

    /** 内部异常 */
    public static final Integer NO_SUCH_REQUEST_HANDLING_METHOD_EXCEPTION = 1004002;

    /** http请求方法不支持 */
    public static final Integer HTTPREQUEST_METHOD_NOTSUPPORTED_EXCEPTION = 1004003;

    /** http媒体类型不支持 */
    public static final Integer HTTP_MEDIATYPE_NOTSUPPORTED_EXCEPTION = 1004004;

    /** 客户端无法支持的媒体类型 */
    public static final Integer HTTP_MEDIATYPE_NOTACCEPTABLE_EXCEPTION = 1004005;

    /** 缺少请求路径的变量 */
    public static final Integer MISSING_PATH_VARIABL_EEXCEPTION = 1004006;

    /** 缺少必须请求参数 */
    public static final Integer MISSING_SERVLET_REQUEST_PARAMETER_EXCEPTION = 1004007;

    /** 请求参数无法绑定 */
    public static final Integer SERVLETREQUEST_BINDING_EXCEPTION = 1004008;

    /** 转换出错*/
    public static final Integer CONVERSION_NOTSUPPORTED_EXCEPTION = 1004009;

    /** 类型不匹配 */
    public static final Integer TYPEM_ISMATCH_EXCEPTION = 1004010;

    /** 消息不可读  */
    public static final Integer HTTP_MESSAGE_NOTREADABLE_EXCEPTION = 1004011;

    /** 消息不可写  */
    public static final Integer HTTP_MESSAGE_NOTWRITABLE_EXCEPTION = 1004012;

    /** 方法参数验证不正确  */
    public static final Integer METHOD_ARGUMENT_NOTVALID_EXCEPTION = 1004013;

    /** 缺少请求体 */
    public static final Integer MISSING_SERVLET_REQUESTPART_EXCEPTION = 1004014;

    /** 绑定异常 */
    public static final Integer BIND_EXCEPTION = 1004015;

    /**
     * 重复提交（针对APP、前端重复提交表单）
     */
    public static final Integer REPEAT_SUBMIT = 1004016;// TODO 禁止修改其值或其他项的值与其冲突

    /** End --> */

    /** dubbo异常 */
    public static final Integer INTERNAL_DUBBO_EXCEPTION = 1004017;

    /** SQL异常 */
    public static final Integer INTERNAL_SQL_EXCEPTION = 1004018;

}
