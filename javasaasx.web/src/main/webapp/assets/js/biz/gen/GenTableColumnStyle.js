/**
 * @Name：生成表字段样式 业务JS
 * @Author：xuhaowen
 * @Date：2018-01-17
 * @Site：http://solrhome.com
 * @License：MIT
 * @Copyright：xuhaowende@sina.cn (@Copyright 2018-2020)
 */


/**
 * 异步 提交表单
 * @returns {boolean}
 */
function ajaxSubmitForm(){
    var form = $("#inputForm");
    if(form.valid()){
        var paramArr = form.serialize();
        http.ajaxAsyncJsonPost("/gen/genTableColumnStyle/save", paramArr, function(message){
            notify.show(message);
            setTimeout(function() {
                window.location.href = window.location.href;
            }, 800);
        });
    }
    return false;
}


/**
 * 异步 右侧表格数据
 * @param table
 */
__table = null;
function ajaxRightDataTable(table){
    //eg: http://www.gbtags.com/gb/rtwidget-replayerpreview/928.htm
    if(__table != null)
        __table.destroy();
    setFormValidation('#inputForm');
    $("#submitBtn").prop("disabled", false);
    $("#table").val(table);
    __table = $('#datatables').DataTable({
        scrollY: "530px",
        responsive: true,   //响应式
        paging: false,
        ordering: false,
        searching: false,
        retrieve: true,
        ajax: {
            "url": ctx+'/gen/genTableColumnStyle/edit?table='+table,
            "type": "POST"
        },
        bInfo: false,//不显示信息
        language: {
            "emptyTable": "暂无表字段数据，不科学！",
            "loadingRecords": "请等待，数据正在加载中......",
        },
        columns: [
            {"data": "column"},
            {"data": "desc"},
            {"data": "isInsert"},
            {"data": "isEdit"},
            {"data": "isList"},
            {"data": "isQuery"},
            {"data": "queryType"},
            {"data": "showType"},
            {"data": "dicType"},
            {"data": "sort"}
        ],
        "columnDefs": [
            {
                "render": function(name, type, row, meta) {
                    return '<input name="columnStyleList['+meta.row+'].id" class="form-control" type="hidden" value="' + comm.toText(row.id) + '" />' +
                        '<input name="columnStyleList['+meta.row+'].table" class="form-control" type="hidden" value="' + row.table + '" />' +
                        '<input name="columnStyleList['+meta.row+'].column" class="form-control" readonly type="text" value="' + row.column + '" />';
                },"targets": 0 //指定列
            },
            {
                "render": function(name, type, row, meta) {
                    return '<div class="form-group label-floating"><label class="control-label"></label>' +
                        '<input name="columnStyleList['+meta.row+'].desc" required="true"  class="form-control" type="text" value="' + row.desc + '" /></div>';
                },"targets": 1 //指定列
            },
            {
                "render": function(name, type, row, meta) {
                    return '<div class="form-group label-floating"><label class="control-label"></label>' +
                        '<input name="columnStyleList['+meta.row+'].fieldName" required="true" class="form-control" type="text" value="' + row.fieldName + '" /></div>';
                },"targets": 2
            },
            {
                "render": function(name, type, row, meta) {
                    return '<div class="checkbox"><label><input type="checkbox" name="columnStyleList['+meta.row+'].isInsert" '+constants.bindCheckBoxStatus(row.isInsert)+'/><span class="checkbox-material"><span class="check"></span></span></label></div>';
                },"targets": 3
            },
            {
                "render": function(name, type, row, meta) {
                    return '<div class="checkbox"><label><input type="checkbox" name="columnStyleList['+meta.row+'].isEdit" '+constants.bindCheckBoxStatus(row.isEdit)+'/><span class="checkbox-material"><span class="check"></span></span></label></div>';
                },"targets": 4
            },
            {
                "render": function(name, type, row, meta) {
                    return '<div class="checkbox"><label><input type="checkbox" name="columnStyleList['+meta.row+'].isList" '+constants.bindCheckBoxStatus(row.isList)+'/><span class="checkbox-material"><span class="check"></span></span></label></div>';
                },"targets": 5
            },
            {
                "render": function(name, type, row, meta) {
                    return constants.buildGenCodeShowTypeHtm(meta.row, row.showType);
                },"targets": 6
            },
            {
                "render": function(name, type, row, meta) {
                    return '<div class="checkbox"><label><input type="checkbox" name="columnStyleList['+meta.row+'].isQuery" '+constants.bindCheckBoxStatus(row.isQuery)+'/><span class="checkbox-material"><span class="check"></span></span></label></div>';
                },"targets": 7
            },
            {
                "render": function(name, type, row, meta) {
                    return constants.buildGenCodeQueryTypeHtm(meta.row, row.queryType);
                },"targets":  8
            },
            {
                "render": function(name, type, row, meta) {
                    return '<input name="columnStyleList['+meta.row+'].dicType" class="form-control" type="text" value="' + row.dicType + '" />';
                },"targets": 9
            }
        ]
    });
}
