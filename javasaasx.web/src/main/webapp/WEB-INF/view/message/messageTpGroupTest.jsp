<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-第三方消息群</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
    <style type="text/css">
    </style>
</head>

<body>
<div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-content">
                                <div class="row">
                                    <!-- left -->
                                    <div class="col-sm-2">
                                        <div class="card-content bd-grey pd-10">
                                            <h4 class="card-title">第三方消息群</h4>
                                            <div class="material-datatables">
                                                <input type="text" class="form-control clearable input-sm" id="filter" placeholder="搜索...">
                                                <div class="form-group scroll-y h-max-580 h-min-450">
                                                    <table id="leftDatatables" class="table table-bordered table-hover"  data-filter="#filter" data-page-size="100" cellspacing="0" width="100%" style="width:100%">
                                                        <tbody>
                                                        <c:forEach items="${leftDataList}" var="dataItem">
                                                            <tr>
                                                                <td onclick="FormUtil.setInputVal('#bizType', '${dataItem.value}')" title="${dataItem.text}"><a href="javascript:;">${dataItem.text}</a></td>
                                                            </tr>
                                                        </c:forEach>
                                                        </tbody>
                                                    </table>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- left end -->

                                    <!-- right -->
                                    <div class="col-sm-10">
                                        <h4 class="card-title">消息测试</h4>
                                        <form id="inputForm" class="form-horizontal" onsubmit="return false">
                                            <div class="form-group label-floating">
                                                <textarea id="message" rows="8" class="form-control clearable" placeholder="输入..." maxlength="10000"></textarea>
                                            </div>
                                            <div class="form-group label-floating is-empty">
                                                <input type="hidden" id="bizType" name="bizType" />
                                                <button id="submitBtn" class="btn btn-twitter mgt-f8" onclick="sendMsg()" >发送</button>
                                            </div>
                                        </form>
                                    </div>
                                    <!-- right end -->

                                </div>
                            </div>

                        </div>
                    </div>


                </div>
            </div>
</body>
<%@include file="/include/scriptLib.jsp" %>
<%@include file="/include/validScriptLib.jsp" %>
<script src="${ctxStatic }/jquery-plugs/footable.all.min.js"></script>
<script src="${ctxStatic }/js/biz/message/messageTpGroup.js"></script>
<script type="text/javascript">
    $(function () {
        $("#leftDatatables").footable();
        TableUtil.bingTrMenuActive("#leftDatatables");
    });

    function sendMsg(){
        var bizType = $("#bizType").val();
        if(CommUtil.isEmpty(bizType)){
            dialogTipError("请选择群");
            return;
        }
        var message = $("#message").val();
        if(CommUtil.isEmpty(message)){
            dialogTipError("请输入要发送的消息");
            return;
        }
        HttpUtil.ajaxAsyncJsonPost("/message/messageTpGroup/send", {bizType: bizType, message: message});
    }
</script>
</html>