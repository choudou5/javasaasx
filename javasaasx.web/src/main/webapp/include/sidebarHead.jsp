<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<nav class="navbar navbar-transparent navbar-absolute" style="background-color: hsla(0,0%,100%,.96)">
    <div class="container-fluid">
        <div class="navbar-minimize">
            <button id="minimizeSidebar" class="btn btn-round btn-white btn-fill btn-just-icon">
                <i class="material-icons visible-on-sidebar-regular">more_vert</i>
                <i class="material-icons visible-on-sidebar-mini">view_list</i>
            </button>
        </div>
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

            <a class="navbar-brand" href="#">【控制台】 </a>
      <%--      <a class="navbar-brand" href="#">【会员】 </a>
            <a class="navbar-brand" href="#">【监控】 </a>
            --%>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right" lay-filter="side-top">
                <li>
                    <a href="#" class="dropdown-toggle" title="备忘录" data-toggle="modal" data-target="#nemoModal">
                        <i class="material-icons">local_offer</i>
                        <p class="hidden-lg hidden-md">备忘录</p>
                    </a>
                </li>
                <li>
                    <a href="#" id="locksystem" title="锁屏">
                        <i class="fa fa-lock fa-lg"></i>&nbsp;锁屏
                    </a>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="material-icons">notifications</i>
                        <span class="notification">5</span>
                        <p class="hidden-lg hidden-md">公告通知<b class="caret"></b></p>
                    </a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#">Mike John responded to your email</a>
                        </li>
                        <li>
                            <a href="#">You have 5 new tasks</a>
                        </li>
                        <li>
                            <a href="#">You're now friend with Andrew</a>
                        </li>
                        <li>
                            <a href="#">Another Notification</a>
                        </li>
                        <li>
                            <a href="#">Another One</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="material-icons">person</i>
                        <p class="hidden-lg hidden-md">快捷操作<b class="caret"></b></p>
                    </a>
                    <ul class="dropdown-menu head-r-menu layui-nav layui-nav-tree" lay-filter="side">
                        <li class="layui-nav-item">
                            <a href="javascript:;" href-url="${ctx }/viewPage/sys/userProfile"><i class="fa fa-question-circle fa-lg "></i>基本资料</a>
                        </li>
                        <li class="layui-nav-item">
                            <a href="javascript:;" href-url="${ctx }/viewPage/sys/sysUserUpdatePwd"><i class="fa fa-unlock-alt fa-lg "></i>修改密码</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-question-circle fa-lg "></i>帮助中心</a>
                        </li>
                        <li>
                            <a href="javascript:;" onclick="refreshCache()"><i class="fa fa-refresh fa-lg"></i>刷新缓存</a>
                        </li>
                        <li>
                            <a href="javascript:;" onclick="dialogConfirm('确认退出系统？','${ctx }/logout.do','提示', '确定退出', '不，我点错了！')"><i class="fa fa-sign-out fa-lg"></i>退出登录</a>
                        </li>
                    </ul>
                </li>
                <li class="separator hidden-lg hidden-md"></li>
            </ul>
            <%--<form class="navbar-form navbar-right" role="search">
                <div class="form-group form-search is-empty">
                    <input type="text" id="globalSearch" class="form-control clearable" placeholder="搜索">
                    <span class="material-input"></span>
                </div>
                <button type="submit" class="btn btn-white btn-round btn-just-icon">
                    <i class="material-icons">search</i>
                    <div class="ripple-container"></div>
                </button>
            </form>--%>
        </div>
    </div>
</nav>

<!-- 备忘录 -->
<div class="modal fade" id="nemoModal" tabindex="-1" role="dialog" aria-labelledby="nemoModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true"><i class="material-icons">clear</i></button>
                <h4 class="modal-title">备忘录</h4>
            </div>
            <div class="modal-body">
                <textarea rows="5" class="form-control" placeholder="记录待办事情，系统自动提示"></textarea>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-raised btn-round btn-info" data-dismiss="modal">保存</button>
                <button type="button" class="btn btn-danger btn-simple" data-dismiss="modal">我知道了</button>
            </div>
        </div>
    </div>
</div>

