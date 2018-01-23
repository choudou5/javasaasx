<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<footer class="footer">
    <div class="container-fluid">
       <%-- <nav class="pull-left">
            <ul>
                <li>
                    <a href="#">Home</a>
                </li>
                <li>
                    <a href="#">Company</a>
                </li>
                <li>
                    <a href="#">Portfolio</a>
                </li>
                <li>
                    <a href="#">Blog</a>
                </li>
            </ul>
        </nav>--%>
        <p class="copyright text-center">
            Copyright &copy; <script>document.write(new Date().getFullYear())</script>
            <a href="#">choudou5</a>
            All rights reserved
        </p>
    </div>
</footer>

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

<!-- 右键菜单 -->
<div class="my-dblclick-box hide">
    <table class="layui-tab dblclick-tab">
        <tbody><tr class="card-refresh">
            <td><i class="layui-icon">ဂ</i>刷新当前标签</td>
        </tr>
        <tr class="card-close">
            <td><i class="layui-icon">ဆ</i>关闭当前标签</td>
        </tr>
        <tr class="card-close-all">
            <td><i class="layui-icon">ဆ</i>关闭所有标签</td>
        </tr>
        <tr class="card-cancel-menu">
            <td><i class="layui-icon">ဆ</i>取消</td>
        </tr>
        </tbody></table>
</div>