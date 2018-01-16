<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<footer class="footer" style="display: none;">
    <div class="container-fluid">
        <nav class="pull-left">
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
        </nav>
        <p class="copyright pull-right">
            &copy;
            <script>
                document.write(new Date().getFullYear())
            </script>
            <a href="#">Creative Tim</a>, made with love for a better web
        </p>
    </div>
</footer>

<!-- Classic Modal -->
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