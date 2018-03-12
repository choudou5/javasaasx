<%@include file="/include/tagLib.jsp" %>
<%
  response.setStatus(500);
// 获取异常类
  Throwable ex = Exceptions.getThrowable(request);
  if (ex != null){
    LoggerFactory.getLogger("500.jsp").error(ex.getMessage(), ex);
  }

// 编译错误信息
  StringBuilder sb = new StringBuilder("错误信息：\n");
  if (ex != null) {
    sb.append(Exceptions.getStackTraceAsString(ex));
  } else {
    sb.append("未知错误.\n\n");
  }

  // 如果是异步请求或是手机端，则直接返回信息
  if (HttpInterceptUtil.isAjaxRequest(request)) {
    out.print(sb);
  }
  // 输出异常信息页面
  else {
%>
<%@page import="org.slf4j.Logger,org.slf4j.LoggerFactory"%>
<%@page import="com.choudou5.javasaasx.base.util.HttpInterceptUtil"%>
<%@page import="com.choudou5.base.exception.Exceptions"%>
<%@ page import="com.choudou5.base.util.StrUtil" %>
<%@ page import="cn.hutool.http.HtmlUtil" %>
<%@page language="java" isErrorPage="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>500-服务器内部错误</title>
<%@include file="/include/cssLib.jsp" %>
<script type="text/javascript" src="${ctxStatic }/jquery-plugs/jquery-3.2.1.min.js"></script>
</head>
<body>

<div class="wrapper">
  <div class="main-panel">
    <div class="content">
      <div class="container-fluid">
        <div class="row">
          <div class="col-md-10">
            <h1>Error 500</h1>
            <div class="widget-box">
              <div class="widget-content">
                <div class="error_ex">
                  <h3>很抱歉，服务器内部错误！</h3>
                  <div class="errorMessage">
                    错误信息：<span class="text-danger"><%=ex==null?"未知错误.":ex.getMessage()%></span> <br/> <br/>
                    请点击“查看详细信息”按钮，将详细错误信息发送给系统管理员，谢谢！<br/> <br/>
                  </div>
                  <div class="errorMessage scroll-y" style="display: none;height: 400px;">
                    <%=sb.toString()%> <br/>
                  </div>
                  <div>
                    <a class="btn btn-warning btn-big" href="/console/page?path=/index">返回首页</a>&nbsp;&nbsp;&nbsp;
                    <a href="javascript:" onclick="history.go(-1);" class="btn">返回上一页</a> &nbsp;
                    <a href="javascript:" onclick="$('.errorMessage').toggle();" class="btn">详细信息</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
<%
  } out = pageContext.pushBody();
%>
