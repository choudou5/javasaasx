<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统操作日志[列表]</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="card">
            <div class="card-content">
                <div class="toolbar"></div>
                <div class="material-datatables">
                    <table id="datatables" class="table table-striped table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%">
                        <thead>
                        <tr>
                            <th>说明</th>
                            <th>ip地址</th>
                            <th>请求uri</th>
                            <th>方法</th>
                            <th>创建者</th>
                            <th>创建时间</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${pageResult.result}" var="item">
                            <tr>
                                <td>${item.desc}</td>
                                <td>${item.ip}</td>
                                <td>${item.requestUri}</td>
                                <td>${item.method}</td>
                                <td>${item.createBy}</td>
                                <td>${fns:formatDateTime(item.createTime)}</td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!-- end content-->
        </div>
        <!--  end card  -->
    </div>
</div>
</body>
<%@include file="/include/scriptLib.jsp" %>
<script type="text/javascript">
    $(function () {
        var datatables = $('#datatables').DataTable({
            "pagingType": "full_numbers",
            "lengthMenu": [
                [10, 25, 50, -1],
                [10, 25, 50, "All"]
            ],
            responsive: true,
            language: {
                search: "_INPUT_",
                searchPlaceholder: "Search",
            }
        });

        // Delete a record
        datatables.on('click', '.remove', function(e) {
            var href = $(this).data("href");
            tr = $(this).closest('tr');
            dialogConfirmAjaxDel(href, datatables, tr);
            e.preventDefault();
        });
    });
</script>
</html>