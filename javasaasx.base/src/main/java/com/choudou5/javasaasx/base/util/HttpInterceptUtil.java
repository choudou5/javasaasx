package com.choudou5.javasaasx.base.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @Name：Http拦截
 * @Author：xuhaowen
 * @Date：2018-01-21
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */
public class HttpInterceptUtil {

    /**
     * 是否是Ajax异步请求
     * @param request
     */
    public static boolean isAjaxRequest(HttpServletRequest request){
        String accept = request.getHeader("accept");
        String xRequestedWith = request.getHeader("X-Requested-With");
        // 如果是异步请求或是手机端，则直接返回信息
        return ((accept != null && accept.indexOf("application/json") != -1
                || (xRequestedWith != null && xRequestedWith.indexOf("XMLHttpRequest") != -1)));
    }
}
