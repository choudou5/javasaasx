<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!--sidebar-menu-->
<div class="sidebar" data-active-color="grey" data-background-color="black">
    <!--
    Tip 1: You can change the color of active element of the sidebar using: data-active-color="purple | blue | green | orange | red | rose"
    Tip 2: you can also add an image using data-image tag
    Tip 3: you can change the color of the sidebar with data-background-color="white | black"
-->
    <div class="logo">
        <a href="#" class="simple-text">${siteName}</a>
    </div>
    <div class="sidebar-wrapper">
        <div class="user">
            <div class="photo">
                <img src="${ctxStaticImg }avatar.jpg" />
            </div>
            <div class="info">
                <a data-toggle="collapse" href="#collapseExample" class="collapsed">
                    ${user_session.email }
                    <b class="caret"></b>
                </a>
                <div class="collapse" id="collapseExample">
                    <ul class="nav">
                        <li>
                            <a href="javascript:;" href-url="${ctx }/sys/user/updateProfile">编辑资料</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/sys/user/updatePwd">修改密码</a>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        <ul class="nav layui-nav layui-nav-tree" lay-filter="side">
            <li class="active layui-nav-item">
                <a href="javascript:;" href-url="${ctx }/sys/index">
                    <i class="layui-icon">&#xe629;</i>
                    <p>控制台</p>
                </a>
            </li>
            <li class="layui-nav-item">
                <a data-toggle="collapse" href="#sysExamples">
                    <i class="layui-icon">&#xe620;</i>
                    <p>系统管理<b class="caret"></b></p>
                </a>
                <div class="collapse" id="sysExamples">
                    <ul class="nav layui-nav-child">
                        <li>
                            <a href="javascript:;" href-url="${ctx }/sys/sysMenu">菜单管理</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }pricing.jsp">系统设置</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }timeline.jsp">系统日志</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/sys/sysUser">用户管理</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/console/sys/menu2">角色管理</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }login.jsp">机构管理</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="layui-nav-item">
                <a data-toggle="collapse" href="#safeExamples">
                    <i class="material-icons">verified_user</i>
                    <p>安全管理<b class="caret"></b></p>
                </a>
                <div class="collapse" id="safeExamples">
                    <ul class="nav layui-nav-child">
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }timeline.jsp">屏蔽词管理</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }login.jsp">黑名单</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }login.jsp">在线用户</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="layui-nav-item">
                <a data-toggle="collapse" href="#baseExamples">
                    <i class="material-icons">settings_input_component</i>
                    <p>基础管理<b class="caret"></b></p>
                </a>
                <div class="collapse" id="baseExamples">
                    <ul class="nav layui-nav-child">
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }pricing.jsp">字典管理</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }pricing.jsp">分类管理</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }timeline.jsp">地区管理</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }timeline.jsp">OSS配置</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="layui-nav-item">
                <a data-toggle="collapse" href="#statExamples">
                    <i class="material-icons">assessment</i>
                    <p>统计管理<b class="caret"></b></p>
                </a>
                <div class="collapse" id="statExamples">
                    <ul class="nav layui-nav-child">
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }pricing.jsp">浏览统计</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="layui-nav-item">
                <a data-toggle="collapse" href="#messageExamples">
                    <i class="material-icons">message</i>
                    <p>消息管理<b class="caret"></b></p>
                </a>
                <div class="collapse" id="messageExamples">
                    <ul class="nav layui-nav-child">
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }pricing.jsp">公告管理</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }timeline.jsp">留言板</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="layui-nav-item">
                <a data-toggle="collapse" href="#codeExamples">
                    <i class="material-icons">code</i>
                    <p>在线代码生成<b class="caret"></b></p>
                </a>
                <div class="collapse" id="codeExamples">
                    <ul class="nav layui-nav-child">
                        <li>
                            <a href="javascript:;" href-url="${ctx }/gen/genTableColumnStyle">表字段设计管理</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/viewPage/tool/sqlconvert">sql转换</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="layui-nav-item">
                <a target="_blank" href="http://md-pro-angular.creative-tim.com/documentation">
                    <i class="material-icons">description</i>
                    <p>文档</p>
                </a>
            </li>
            <li class="hide">
                <a data-toggle="collapse" href="#pagesExamples">
                    <i class="material-icons">image</i>
                    <p>页面
                        <b class="caret"></b>
                    </p>
                </a>
                <div class="collapse" id="pagesExamples">
                    <ul class="nav">
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }pricing.jsp">Pricing</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }timeline.jsp">Timeline</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }login.jsp">Login Page</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }register.jsp">Register Page</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }lock.jsp">Lock Screen Page</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }user.jsp">User Profile</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="layui-nav-item">
                <a data-toggle="collapse" href="#componentsExamples">
                    <i class="material-icons">apps</i>
                    <p>组件
                        <b class="caret"></b>
                    </p>
                </a>
                <div class="collapse" id="componentsExamples">
                    <ul class="nav layui-nav-child">
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }buttons.jsp">Buttons</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }grid.jsp">Grid System</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }panels.jsp">Panels</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }sweet-alert.jsp">Sweet Alert</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }notifications.jsp">Notifications</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }icons.jsp">Icons</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }typography.jsp">Typography</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="layui-nav-item">
                <a data-toggle="collapse" href="#formsExamples">
                    <i class="material-icons">content_paste</i>
                    <p>表单
                        <b class="caret"></b>
                    </p>
                </a>
                <div class="collapse" id="formsExamples">
                    <ul class="nav layui-nav-child">
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }regular.jsp">Regular Forms</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }extended.jsp">Extended Forms</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }validation.jsp">Validation Forms</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }wizard.jsp">Wizard</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="layui-nav-item">
                <a data-toggle="collapse" href="#tablesExamples">
                    <i class="material-icons">grid_on</i>
                    <p>表格
                        <b class="caret"></b>
                    </p>
                </a>
                <div class="collapse" id="tablesExamples">
                    <ul class="nav layui-nav-child">
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }regular-1.jsp">Regular Tables</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }extended-1.jsp">Extended Tables</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }datatables.net.jsp">DataTables.net</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="hide">
                <a data-toggle="collapse" href="#mapsExamples">
                    <i class="material-icons">place</i>
                    <p>地图
                        <b class="caret"></b>
                    </p>
                </a>
                <div class="collapse" id="mapsExamples">
                    <ul class="nav">
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }google.jsp">Google Maps</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }fullscreen.jsp">Full Screen Map</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctxStaticPage }vector.jsp">Vector Map</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;" href-url="${ctxStaticPage }widgets.jsp">
                    <i class="material-icons">widgets</i>
                    <p>小工具</p>
                </a>
            </li>
            <li class="hide">
                <a href="javascript:;" href-url="${ctxStaticPage }charts.jsp">
                    <i class="material-icons">timeline</i>
                    <p>图表</p>
                </a>
            </li>
            <li class="hide">
                <a href="javascript:;" href-url="${ctxStaticPage }calendar.jsp">
                    <i class="material-icons">date_range</i>
                    <p>日期</p>
                </a>
            </li>
        </ul>
    </div>
</div>
<!--sidebar-menu-->