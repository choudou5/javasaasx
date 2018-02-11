<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>admin-</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>

<body>
<div class="container-fluid">
    <div class="header text-center">
        <h3 class="title"><a href="javascript:;" id="IconToogle">图片库（点击切换）</a></h3>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="card card-plain">
                <div class="card-content">
                    <div class="iframe-container hidden-sm hidden-xs">
                        <iframe id="fontawesomeIco" src="http://fontawesome.io/icons/#icons " style="height: 600px;">
                            <p>Your browser does not support iframes.</p>
                        </iframe>
                        <iframe id="materialIco" src="https://material.io/icons/" style="height: 600px;display: none;">
                            <p>Your browser does not support iframes.</p>
                        </iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<%@include file="/include/scriptLib.jsp" %>
<script type="text/javascript">
	$("#IconToogle").on("click", function(){
		$("#materialIco").toggle();
		$("#fontawesomeIco").toggle();
	});
</script>
</html>