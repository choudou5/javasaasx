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
    <%@include file="/include/normalHead.jsp" %>
    <div class="wrapper wrapper-full-page">
        <div class="full-page pricing-page" data-image="${ossImg}bg-pricing.jpeg">
            <div class="content">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 col-md-offset-3 text-center">
                            <h2 class="title">Pick the best plan for you</h2>
                            <h5 class="description">You have Free Unlimited Updates and Premium Support on each package.</h5>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-md-3">
                            <div class="card card-pricing card-plain">
                                <div class="card-content">
                                    <h6 class="category">Freelancer</h6>
                                    <div class="icon">
                                        <i class="material-icons">weekend</i>
                                    </div>
                                    <h3 class="card-title">FREE</h3>
                                    <p class="card-description">
                                        This is good if your company size is between 2 and 10 Persons.
                                    </p>
                                    <a href="#pablo" class="btn btn-white btn-round">Choose Plan</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="card card-pricing card-raised">
                                <div class="card-content">
                                    <h6 class="category">Small Company</h6>
                                    <div class="icon icon-rose">
                                        <i class="material-icons">home</i>
                                    </div>
                                    <h3 class="card-title">$29</h3>
                                    <p class="card-description">
                                        This is good if your company size is between 2 and 10 Persons.
                                    </p>
                                    <a href="#pablo" class="btn btn-rose btn-round">Choose Plan</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="card card-pricing card-plain">
                                <div class="card-content">
                                    <h6 class="category">Medium Company</h6>
                                    <div class="icon">
                                        <i class="material-icons">business</i>
                                    </div>
                                    <h3 class="card-title">$69</h3>
                                    <p class="card-description">
                                        This is good if your company size is between 11 and 99 Persons.
                                    </p>
                                    <a href="#pablo" class="btn btn-white btn-round">Choose Plan</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-3">
                            <div class="card card-pricing card-plain">
                                <div class="card-content">
                                    <h6 class="category">Enterprise</h6>
                                    <div class="icon">
                                        <i class="material-icons">account_balance</i>
                                    </div>
                                    <h3 class="card-title">$159</h3>
                                    <p class="card-description">
                                        This is good if your company size is 99+ persons.
                                    </p>
                                    <a href="#pablo" class="btn btn-white btn-round">Choose Plan</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="/include/footer.jsp" %>
        </div>
    </div>
</body>
<div class="fixed-plugin">
    <div class="dropdown show-dropdown">
        <a href="#" data-toggle="dropdown">
            <i class="fa fa-cog fa-2x"> </i>
        </a>
        <ul class="dropdown-menu">
            <li class="header-title">Background Style</li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger">
                    <p>Background Image</p>
                    <div class="togglebutton switch-sidebar-image">
                        <label>
                            <input type="checkbox" checked="">
                        </label>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="adjustments-line">
                <a href="javascript:void(0)" class="switch-trigger active-color">
                    <p>Filters</p>
                    <div class="badge-colors pull-right">
                        <span class="badge filter active" data-color="black"></span>
                        <span class="badge filter badge-blue" data-color="blue"></span>
                        <span class="badge filter badge-green" data-color="green"></span>
                        <span class="badge filter badge-orange" data-color="orange"></span>
                        <span class="badge filter badge-red" data-color="red"></span>
                        <span class="badge filter badge-purple" data-color="purple"></span>
                        <span class="badge filter badge-rose" data-color="rose"></span>
                    </div>
                    <div class="clearfix"></div>
                </a>
            </li>
            <li class="header-title">Background Images</li>
            <li class="active">
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="${ossImg}sidebar-1.jpg" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="${ossImg}sidebar-2.jpg" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="${ossImg}sidebar-3.jpg" />
                </a>
            </li>
            <li>
                <a class="img-holder switch-trigger" href="javascript:void(0)">
                    <img src="${ossImg}sidebar-4.jpg" />
                </a>
            </li>
            <li class="button-container">
                <div class="">
                    <a href="javascript:if(confirm(%27http://www.creative-tim.com/product/material-dashboard-pro  \n\nThis file was not retrieved by Teleport Ultra, because it is addressed on a domain or path outside the boundaries set for its Starting Address.  \n\nDo you want to open it from the server?%27))window.location=%27http://www.creative-tim.com/product/material-dashboard-pro%27">Buy Now!</a>
                </div>
                <div class="">
                    <a href="javascript:if(confirm(%27http://www.creative-tim.com/product/material-dashboard  \n\nThis file was not retrieved by Teleport Ultra, because it is addressed on a domain or path outside the boundaries set for its Starting Address.  \n\nDo you want to open it from the server?%27))window.location=%27http://www.creative-tim.com/product/material-dashboard%27">Get Free Demo</a>
                </div>
            </li>
            <li class="header-title">Thank you for 95 shares!</li>
            <li class="button-container">
                <button id="twitter" class="btn btn-social btn-twitter btn-round"><i class="fa fa-twitter"></i> &middot; 45</button>
                <button id="facebook" class="btn btn-social btn-facebook btn-round"><i class="fa fa-facebook-square"></i> &middot; 50</button>
            </li>
        </ul>
    </div>
</div>
</body>
<%@include file="/include/scriptLib.jsp" %>
<script type="text/javascript">
    $().ready(function() {
        demo.checkFullPageBackgroundImage();

        setTimeout(function() {
            // after 1000 ms we add the class animated to the login/register card
            $('.card').removeClass('card-hidden');
        }, 700)
    });
</script>

</html>