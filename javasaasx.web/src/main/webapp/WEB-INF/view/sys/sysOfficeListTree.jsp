<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-系统机构</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
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
                            <div class="card-content pd-10">
                                <h4 class="card-title ">成员</h4>
                                <p><a href="" class="text-black"><i class="fa fa-user"></i>&nbsp;所有成员</a></p>
                                <p><a href="" class="text-black"><i class="fa fa-user"></i>&nbsp;停用的成员</a></p>
                                <h4 class="card-title">机构</h4>
                                <a href="javascript:;" onclick="FormUtil.bindFormAddBtn('添加成员')" data-href="${ctx}/sys/sysUser/form"><i class="fa fa-plus"></i>&nbsp;创建部门</a>
                                <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                                    <div class="panel panel-default">
                                        <div class="panel-heading" role="tab" id="headingOne">
                                            <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                                <h4 class="panel-title">
                                                    Collapsible  #1
                                                    <i class="material-icons">keyboard_arrow_down</i>
                                                </h4>
                                            </a>
                                        </div>
                                        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                            <div class="panel-body">
                                                Anim pariatur cliche reprehenderit, en nem aesthetn't heard of them accusamus labore sustainable VHS.
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel panel-default">
                                        <div class="panel-heading" role="tab" id="headingTwo">
                                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                                <h4 class="panel-title">
                                                    Collapsib=Item #2
                                                    <i class="material-icons">keyboard_arrow_down</i>
                                                </h4>
                                            </a>
                                        </div>
                                        <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
                                            <div class="panel-body">
                                                 occaecat craft beer farm-to-table, raw denim aestheem accusamus labore sustainable VHS.
                                            </div>
                                        </div>
                                    </div>
                                    <div class="panel panel-default">
                                        <div class="panel-heading" role="tab" id="headingThree">
                                            <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                                                <h4 class="panel-title">
                                                    Collapsibl= #3
                                                    <i class="material-icons">keyboard_arrow_down</i>
                                                </h4>
                                            </a>
                                        </div>
                                        <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
                                            <div class="panel-body">
                                             em accusamus labore sustainable VHS.
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <%--
                                <div class="material-datatables">
                                    <input type="text" class="form-control clearable input-sm" id="filter" placeholder="搜索...">
                                    <div class="form-group scroll-y h-max-580 h-min-450">
                                        <table id="leftDatatables" class="table table-bordered table-hover"  data-filter="#filter" data-page-size="100" cellspacing="0" width="100%" style="width:100%">
                                            <tbody>
                                            <c:forEach items="${leftDataList}" var="dataItem">
                                                <tr>
                                                    <td onclick="ajaxRightDataTable('${dataItem.value}')" title="${dataItem.text}"><a href="javascript:;">${dataItem.value}</a></td>
                                                </tr>
                                            </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                                --%>
                            </div>
                        </div>
                        <!-- left end -->

                        <!-- right -->
                        <div class="col-sm-10">
                            <div class="row col-sm-12 card-title">
                                <div class="col-sm-3">
                                    xxx . 成员 10
                                </div>
                                <div class="col-sm-3">
                                    <a href="javascript:;" class="text-link" onclick="FormUtil.bindFormAddBtn('添加成员')" data-href="${ctx}/sys/sysUser/form"><i class="fa fa-plus"></i>&nbsp;添加成员</a>
                                </div>
                            </div>
                            <div class="row col-sm-12">
                                <form id="inputForm" class="form-horizontal" onsubmit="return ajaxSubmitForm()">
                                    <div class="material-datatables table-responsive">
                                        <table id="datatables" class="table table-no-bordered table-hover" cellspacing="0" width="100%" style="width:100%; max-height: 600px;">
                                            <thead>
                                            <tr>
                                                <th>名称<small class="red">*</small></th>
                                                <th>上级id</th>
                                                <th>父路径</th>
                                                <th>层级深度</th>
                                                <th>排序</th>
                                                <th>区域编码</th>
                                                <th>机构类型: company=公司、dept=部门<small class="red">*</small></th>
                                                <th>联系地址</th>
                                                <th>负责人</th>
                                                <th>电话</th>
                                                <th>备注信息</th>
                                                <th>code标识</th>
                                                <th>状态: 0=禁用，1=正常</th>
                                                <th>是否系统数据: 0=否，1=是</th>
                                            </tr>
                                            </thead>
                                            <tbody></tbody>
                                        </table>
                                    </div>
                                    <div class="row bg-grey">
                                        <label class="col-sm-4 label-on-left"></label>
                                        <div class="col-sm-8 pull-right">
                                            <div class="col-md-2">
                                                <div class="form-group label-floating is-empty">
                                                    <button id="submitBtn" class="btn btn-twitter mgt-f8" disabled >保存</button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>

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
<script src="${ctxStatic }/js/biz/sys/sysOffice.js"></script>
<script type="text/javascript">
    $(function () {
        $('.card .material-datatables label').addClass('form-group');
        $("#leftDatatables").footable();
        tbl.bingdTrMenuActive("#leftDatatables");
    });
</script>
</html>