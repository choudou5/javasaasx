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
    <div class="wrapper">
        <%@include file="/include/sidebar.jsp" %>
        <div class="main-panel">
            <%@include file="/include/sidebarHead.jsp" %>
            <div class="content">
                <div class="container-fluid">
                    <div class="header text-center">
                        <h3 class="title">Sweet Alert 2</h3>
                        <p class="category">A beautiful plugin, that replace the classic alert, Handcrafted by our friend
                            <a target="_blank" href="javascript:if(confirm(%27https://twitter.com/t4t5  \n\nThis file was not retrieved by Teleport Ultra, because it is addressed on a domain or path outside the boundaries set for its Starting Address.  \n\nDo you want to open it from the server?%27))window.location=%27https://twitter.com/t4t5%27" tppabs="https://twitter.com/t4t5">Tristan Edwards</a>. Please check out the
                            <a href="javascript:if(confirm(%27http://limonte.github.io/sweetalert2/  \n\nThis file was not retrieved by Teleport Ultra, because it is addressed on a domain or path outside the boundaries set for its Starting Address.  \n\nDo you want to open it from the server?%27))window.location=%27http://limonte.github.io/sweetalert2/%27" tppabs="http://limonte.github.io/sweetalert2/" target="_blank">full documentation.</a>
                        </p>
                    </div>
                    <div class="places-sweet-alerts">
                        <div class="row">
                            <div class="col-md-3">
                                <div class="card">
                                    <div class="card-content text-center">
                                        <h5>Basic example</h5>
                                        <button class="btn btn-rose btn-fill" onclick="demo.showSwal('basic')">Try me!</button>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="card">
                                    <div class="card-content text-center">
                                        <h5>A title with a text under</h5>
                                        <button class="btn btn-rose btn-fill" onclick="demo.showSwal('title-and-text')">Try me!</button>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="card">
                                    <div class="card-content text-center">
                                        <h5>A success message</h5>
                                        <button class="btn btn-rose btn-fill" onclick="demo.showSwal('success-message')">Try me!</button>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="card">
                                    <div class="card-content text-center">
                                        <h5>Custom HTML description</h5>
                                        <button class="btn btn-rose btn-fill" onclick="demo.showSwal('custom-html')">Try me!</button>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="card">
                                    <div class="card-content text-center">
                                        <h5>A warning message, with a function attached to the "Confirm" Button...</h5>
                                        <button class="btn btn-rose btn-fill" onclick="demo.showSwal('warning-message-and-confirmation')">Try me!</button>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="card">
                                    <div class="card-content text-center">
                                        <h5>...and by passing a parameter, you can execute something else for "Cancel"</h5>
                                        <button class="btn btn-rose btn-fill" onclick="demo.showSwal('warning-message-and-cancel')">Try me!</button>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="card">
                                    <div class="card-content text-center">
                                        <h5>A message with auto close timer set to 2 seconds</h5>
                                        <button class="btn btn-rose btn-fill" onclick="demo.showSwal('auto-close')">Try me!</button>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-3">
                                <div class="card">
                                    <div class="card-content text-center">
                                        <h5>Modal window with input field</h5>
                                        <button class="btn btn-rose btn-fill" onclick="demo.showSwal('input-field')">Try me!</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="/include/footer.jsp" %>
        </div>
    </div>
    <%@include file="/include/sidebarRight.jsp" %>
</body>
<%@include file="/include/scriptLib.jsp" %>
</html>