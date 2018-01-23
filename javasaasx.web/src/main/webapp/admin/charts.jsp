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
        <h3 class="title">Chartist.js</h3>
        <p class="category">Handcrafted by our friends from
            <a target="_blank" href="javascript:if(confirm(%27https://gionkunz.github.io/chartist-js/  \n\nThis file was not retrieved by Teleport Ultra, because it is addressed on a domain or path outside the boundaries set for its Starting Address.  \n\nDo you want to open it from the server?%27))window.location=%27https://gionkunz.github.io/chartist-js/%27" tppabs="https://gionkunz.github.io/chartist-js/">Chartist.js</a>. Please checkout their
            <a href="javascript:if(confirm(%27https://gionkunz.github.io/chartist-js/getting-started.html  \n\nThis file was not retrieved by Teleport Ultra, because it is addressed on a domain or path outside the boundaries set for its Starting Address.  \n\nDo you want to open it from the server?%27))window.location=%27https://gionkunz.github.io/chartist-js/getting-started.html%27" tppabs="https://gionkunz.github.io/chartist-js/getting-started.html" target="_blank">full documentation.</a>
        </p>
    </div>
    <div class="row">
        <div class="col-md-4">
            <div class="card card-chart">
                <div class="card-header" data-background-color="rose">
                    <div id="roundedLineChart" class="ct-chart"></div>
                </div>
                <div class="card-content">
                    <h4 class="card-title">Rounded Line Chart</h4>
                    <p class="category">Line Chart</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card card-chart">
                <div class="card-header" data-background-color="orange">
                    <div id="straightLinesChart" class="ct-chart"></div>
                </div>
                <div class="card-content">
                    <h4 class="card-title">Straight Lines Chart</h4>
                    <p class="category">Line Chart with Points</p>
                </div>
            </div>
        </div>
        <div class="col-md-4">
            <div class="card card-chart">
                <div class="card-header" data-background-color="blue">
                    <div id="simpleBarChart" class="ct-chart"></div>
                </div>
                <div class="card-content">
                    <h4 class="card-title">Simple Bar Chart</h4>
                    <p class="category">Bar Chart</p>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header card-header-icon" data-background-color="blue">
                    <i class="material-icons">timeline</i>
                </div>
                <div class="card-content">
                    <h4 class="card-title">Coloured Line Chart
                        <small> - Rounded</small>
                    </h4>
                </div>
                <div id="colouredRoundedLineChart" class="ct-chart"></div>
            </div>
        </div>
        <div class="col-md-6">
            <div class="card">
                <div class="card-header card-header-icon" data-background-color="rose">
                    <i class="material-icons">insert_chart</i>
                </div>
                <div class="card-content">
                    <h4 class="card-title">Multiple Bars Chart
                        <small>- Bar Chart</small>
                    </h4>
                </div>
                <div id="multipleBarsChart" class="ct-chart"></div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-7">
            <div class="card">
                <div class="card-header card-header-icon" data-background-color="blue">
                    <i class="material-icons">timeline</i>
                </div>
                <div class="card-content">
                    <h4 class="card-title">Coloured Bars Chart
                        <small> - Rounded</small>
                    </h4>
                </div>
                <div id="colouredBarsChart" class="ct-chart"></div>
            </div>
        </div>
        <div class="col-md-5">
            <div class="card">
                <div class="card-header card-header-icon" data-background-color="red">
                    <i class="material-icons">pie_chart</i>
                </div>
                <div class="card-content">
                    <h4 class="card-title">Pie Chart</h4>
                </div>
                <div id="chartPreferences" class="ct-chart"></div>
                <div class="card-footer">
                    <h6>Legend</h6>
                    <i class="fa fa-circle text-info"></i> Apple
                    <i class="fa fa-circle text-warning"></i> Samsung
                    <i class="fa fa-circle text-danger"></i> Windows Phone
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<%@include file="/include/scriptLib.jsp" %>
<script>
    $(document).ready(function() {
        demo.initCharts();
    });
</script>

</html>