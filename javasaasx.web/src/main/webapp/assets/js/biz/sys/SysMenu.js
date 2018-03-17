/**
 * @Name：菜单表 业务JS
 * @Author：xuhaowen
 * @Date：2018-01-18
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */

/**
 * 编辑
 */
function edit(){

}


/**
 * 异步 右侧表格数据
 * @param table
 */
__table = null;
function ajaxRightDataTable(menuId){
    //eg: http://www.gbtags.com/gb/rtwidget-replayerpreview/928.htm
    if(__table != null)
        __table.destroy();
    $("#submitBtn").prop("disabled", false);
    $("#menuId").val(menuId);

    __table = $('#datatables').DataTable({
        scrollY: "400px",
        responsive: true,   //响应式
        paging: false,
        pagingType: "full_numbers",
        ordering: false,
        searching: false,
        retrieve: true,
        ajax: {
            "url": ctx+'/sys/sysMenu/ajaxButtomList?pid='+menuId,
            "type": "POST"
        },
        bInfo: false,//不显示信息
        language: {
            "emptyTable": "找不到记录",
            "loadingRecords": "请等待，数据正在加载中......",
        },
        columns: [
            {"data": "name"},
            {"data": "permission"},
            {"data": "remarks"},
            {"data": "isMobileShow"},
            {"data": "isSysData"},
            {"data": ""}
        ],
        "columnDefs": [
            {
                "render": function(name, type, row, meta) {
                    return row.name;
                },"targets": 0
            },
            {
                "render": function(name, type, row, meta) {
                    return row.permission;
                },"targets": 1
            },
            {
                "render": function(name, type, row, meta) {
                    return CommUtil.toText(row.remarks);
                },"targets": 2
            },
            {
                "render": function(name, type, row, meta) {
                    var htm = '<div class="togglebutton"><label><input type="checkbox" data-id="'+row.id+'" data-field="isMobileShow" value="1" '+BindUtil.bindCheckBoxStatus(row.isMobileShow)+' /></label></div>';
                    return htm
                },"targets": 3
            },
            {
                "render": function(name, type, row, meta) {
                    var htm = '<div class="togglebutton"><label><input type="checkbox" data-id="'+row.id+'" data-field="isSysData" value="1" '+BindUtil.bindCheckBoxStatus(row.isSysData)+' /></label></div>';
                    return htm;
                },"targets": 4
            },
            {
                "render": function(name, type, row, meta) {
                    var htm = '<div class="togglebutton"><label><input type="checkbox" data-id="'+row.id+'" data-field="status" value="1" '+BindUtil.bindCheckBoxStatus(row.status)+' /></label></div>';
                    return htm;
                },"targets": 5
            }
        ]
    });

    setTimeout(function(){
        $.material.init();
        $("input[type=checkbox]").on("change", function(){
            var id = $(this).data("id");
            var field = $(this).data("field");
            var checked = $(this).is(":checked");
            var url = "/sys/sysMenu/ajaxUpdate";
            HttpUtil.ajaxAsyncJsonPost(url, {id: id, field: field, flag: checked}, function(data){
                dialogTip("更新成功");
            });
        });
    }, 500);

}
