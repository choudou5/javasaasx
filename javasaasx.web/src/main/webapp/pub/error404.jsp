<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>404-找不到页面</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="shortcut icon" href="/static/images/favicon.ico">
<link rel="stylesheet" href="/static/console/css/bootstrap.min.css" />
<link rel="stylesheet" href="/static/console/css/matrix-style.css" />
<link href='/static/console/css/fonts.googleapis.com.css' rel='stylesheet' type='text/css'>
</head>
<body>

<div id="content" style="margin-left: 0px;min-height:90%;">
  <div id="content-header" style="margin-top: -20px;">
    <h1>Error 404</h1>
  </div>
  <div class="container-fluid">
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-content">
            <div class="error_ex">
              <h1>404</h1>
              <h3>很抱歉，您所访问的页面不存在！</h3>
              <a class="btn btn-warning btn-big" href="/console/page?path=/index">返回首页</a>&nbsp;&nbsp;&nbsp;
              <a class="btn btn-big" href="javascript:history.go(-1);">返回上一页</a>
             </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!--Footer-part-->
<div class="row-fluid">
  <div id="footer" class="span12"> 2017 &copy; Solr Home by <a href="#">choudoufu</a> </div>
</div>
<!--end-Footer-part-->
</body>
</html>
