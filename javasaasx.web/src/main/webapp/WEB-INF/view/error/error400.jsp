<%@include file="/include/tagLib.jsp" %>
<%@page language="java" isErrorPage="true" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>400-请求参数语法格式有误</title>
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
            <h1>Error 400</h1>
            <div class="widget-box">
              <div class="widget-content">
                <div class="error_ex">
                  <h3>很抱歉，请求参数语法格式有误！</h3>
                  <div class="errorMessage">
                    请联系系统管理员，谢谢！<br/> <br/>
                  </div>
                  <div>
                    <a class="btn btn-warning btn-big" href="/console/page?path=/index">返回首页</a>&nbsp;&nbsp;&nbsp;
                    <a href="javascript:" onclick="history.go(-1);" class="btn">返回</a>
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