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
        <ul class="nav layui-nav layui-nav-tree" lay-filter="side">
            <%--<li class="layui-this layui-nav-item">
                <a href="javascript:;" href-url="${ctx }/index">
                    <i class="layui-icon">&#xe629;</i>
                    <p>控制台</p>
                </a>
            </li>--%>
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
                            <a href="javascript:;" href-url="${ctx }/sys/sysSetting">系统设置</a>
                        </li>
                       <%-- <li>
                            <a href="javascript:;" href-url="${ctx }/sys/sysUser">用户管理</a>
                        </li>--%>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/sys/sysRole">角色管理</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/sys/sysOffice">通讯录</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/message/messageTpGroup">第三方群组</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="layui-nav-item">
                <a data-toggle="collapse" href="#safeExamples">
                    <i class="material-icons">verified_user</i>
                    <p>站点维护<b class="caret"></b></p>
                </a>
                <div class="collapse" id="safeExamples">
                    <ul class="nav layui-nav-child">
                        <li>
                            <a href="javascript:;" href-url="${ctx }/dic/dicSensitiveWord">敏感词管理</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/log/logOperation">广告管理</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/log/logOperation">留言反馈</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/log/logOperation">友情链接</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/log/logOperation">APP版本管理</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="layui-nav-item">
                <a data-toggle="collapse" href="#logExamples">
                    <i class="fa fa-history"></i>
                    <p>安全与日志<b class="caret"></b></p>
                </a>
                <div class="collapse" id="logExamples">
                    <ul class="nav layui-nav-child">
                        <li>
                            <a href="javascript:;" href-url="${ctx }/log/logOperation">系统防火墙记录</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/log/logOperation">限制黑名单</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/log/logOperation">操作日志</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/log/logUserLogin">登录日志</a>
                        </li>
                       <%-- <li>
                            <a href="javascript:;" href-url="${ctx }/log/sysException">异常日志</a>
                        </li>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/log/sysRemoteException">远程日志</a>
                        </li>--%>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/viewPage/log/logAdminList">日志监管</a>
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
                    <%--    <li>
                            <a href="javascript:dialogTipError('待完善');" href-url="">字典管理</a>
                        </li>
                        <li>
                            <a href="javascript:dialogTipError('待完善');" href-url="">分类管理</a>
                        </li>--%>
                        <li>
                            <a href="javascript:;" href-url="${ctx }/dic/dicArea">地区管理</a>
                        </li>
                       <%-- <li>
                            <a href="javascript:dialogTipError('待完善');" href-url="">OSS配置</a>
                        </li>--%>
                    </ul>
                </div>
            </li>
            <li class="layui-nav-item hide">
                <a data-toggle="collapse" href="#statExamples">
                    <i class="material-icons">assessment</i>
                    <p>统计管理<b class="caret"></b></p>
                </a>
                <div class="collapse" id="statExamples">
                    <ul class="nav layui-nav-child">
                        <li>
                            <a href="javascript:dialogTipError('待完善');" href-url="">浏览统计</a>
                        </li>
                        <li>
                            <a href="javascript:dialogTipError('待完善');" href-url="">搜索统计</a>
                        </li>
                    </ul>
                </div>
            </li>
            <li class="layui-nav-item hide">
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
                            <a href="javascript:;" href-url="${ctxStaticPage }pricing.jsp">验证码记录</a>
                        </li>
                    </ul>
                </div>
            </li>

            <li class="layui-nav-item">
                <a href="javascript:;" href-url="${ctx }/gen/genTableColumnStyle">
                    <i class="fa fa-code"></i>
                    <p>在线代码生成</p>
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
            <li class="layui-nav-item">
                <a target="_blank" href="http://md-pro-angular.creative-tim.com/documentation">
                    <i class="material-icons">description</i>
                    <p>文档</p>
                </a>
            </li>
        </ul>
    </div>
</div>
<!--sidebar-menu-->