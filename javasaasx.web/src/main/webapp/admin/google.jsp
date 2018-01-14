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
                    <div class="row">
                        <div class="col-md-12">
                            <div class="card">
                                <div class="card-header card-header-text" data-background-color="rose">
                                    <h4 class="card-title">Satellite Map</h4>
                                </div>
                                <div class="card-content">
                                    <div id="satelliteMap" class="map map-big"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header card-header-icon" data-background-color="rose">
                                    <i class="material-icons">add_location</i>
                                </div>
                                <div class="card-content">
                                    <h4 class="card-title">Regular Map</h4>
                                    <div id="regularMap" class="map"></div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-header card-header-icon" data-background-color="rose">
                                    <i class="material-icons">room</i>
                                </div>
                                <div class="card-content">
                                    <h4 class="card-title">Custom Skin & Settings Map</h4>
                                    <div id="customSkinMap" class="map"></div>
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
<script>
    $(document).ready(function() {
        demo.initSmallGoogleMaps();
    });
</script>

</html>