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
        <h3 class="title">FullCalendar.io</h3>
        <p class="category">Handcrafted by our friends from
            <a target="_blank" href="javascript:if(confirm(%27https://fullcalendar.io/  \n\nThis file was not retrieved by Teleport Ultra, because it is addressed on a domain or path outside the boundaries set for its Starting Address.  \n\nDo you want to open it from the server?%27))window.location=%27https://fullcalendar.io/%27" tppabs="https://fullcalendar.io/">FullCalendar.io</a>. Please checkout their
            <a href="javascript:if(confirm(%27https://fullcalendar.io/docs/  \n\nThis file was not retrieved by Teleport Ultra, because it is addressed on a domain or path outside the boundaries set for its Starting Address.  \n\nDo you want to open it from the server?%27))window.location=%27https://fullcalendar.io/docs/%27" tppabs="https://fullcalendar.io/docs/" target="_blank">full documentation.</a>
        </p>
    </div>
    <div class="row">
        <div class="col-md-10 col-md-offset-1">
            <div class="card card-calendar">
                <div class="card-content" class="ps-child">
                    <div id="fullCalendar"></div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<%@include file="/include/scriptLib.jsp" %>
<script type="text/javascript">
    $(document).ready(function() {
        demo.initFullCalendar();
    });
</script>

</html>