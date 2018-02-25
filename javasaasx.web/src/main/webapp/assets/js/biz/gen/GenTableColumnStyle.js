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
        FormUtil.tryLockSubmit();
        var paramArr = form.serialize();
        HttpUtil.ajaxAsyncJsonPost("/gen/genTableColumnStyle/save", paramArr, function(message){
            dialogTip(message);
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
            "emptyTable": "找不到记录！",
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
                    return '<input name="columnStyleList['+meta.row+'].id" class="form-control" type="hidden" value="' + CommUtil.toText(row.id) + '" />' +
                        '<input name="columnStyleList['+meta.row+'].table" class="form-control" type="hidden" value="' + row.table + '" />' +
                        '<input name="columnStyleList['+meta.row+'].fieldType" class="form-control" type="hidden" value="' + row.fieldType + '" />' +
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
                    return '<div class="checkbox"><label><input type="checkbox" name="columnStyleList['+meta.row+'].isInsert" '+BindUtil.bindCheckBoxStatus(row.isInsert)+'/><span class="checkbox-material"><span class="check"></span></span></label></div>';
                },"targets": 3
            },
            {
                "render": function(name, type, row, meta) {
                    return '<div class="checkbox"><label><input type="checkbox" name="columnStyleList['+meta.row+'].isEdit" '+BindUtil.bindCheckBoxStatus(row.isEdit)+'/><span class="checkbox-material"><span class="check"></span></span></label></div>';
                },"targets": 4
            },
            {
                "render": function(name, type, row, meta) {
                    return '<div class="checkbox"><label><input type="checkbox" name="columnStyleList['+meta.row+'].isList" '+BindUtil.bindCheckBoxStatus(row.isList)+'/><span class="checkbox-material"><span class="check"></span></span></label></div>';
                },"targets": 5
            },
            {
                "render": function(name, type, row, meta) {
                    return buildGenCodeShowTypeHtm(meta.row, row.showType);
                },"targets": 6
            },
            {
                "render": function(name, type, row, meta) {
                    return '<div class="checkbox"><label><input type="checkbox" name="columnStyleList['+meta.row+'].isQuery" '+BindUtil.bindCheckBoxStatus(row.isQuery)+'/><span class="checkbox-material"><span class="check"></span></span></label></div>';
                },"targets": 7
            },
            {
                "render": function(name, type, row, meta) {
                    return buildGenCodeQueryTypeHtm(meta.row, row.queryType);
                },"targets":  8
            },
            {
                "render": function(name, type, row, meta) {
                    return '<input name="columnStyleList['+meta.row+'].dicType" class="form-control" type="text" value="' + CommUtil.toText(row.dicType) + '" />';
                },"targets": 9
            }
        ]
    });
}


function buildGenCodeQueryTypeHtm(index, selectValue){
    selectValue = CommUtil.isEmpty(selectValue)?"":selectValue;
    var htm = new StringBuffer();
    htm.append('<select  name="columnStyleList['+index+'].queryType" class="form-control" title="查询方式">');
    // (selectValue=="eq"?"selected=\"selected\"":"")
    htm.append('<option value="eq" '+(selectValue=="eq"?"selected=\"selected\"":"")+'>等于</option>');
    htm.append('<option value="neq" '+(selectValue=="neq"?"selected=\"selected\"":"")+'>不等于</option>');
    htm.append('<option value="gt" '+(selectValue=="gt"?"selected=\"selected\"":"")+'>大于</option>');
    htm.append('<option value="lt" '+(selectValue=="lt"?"selected=\"selected\"":"")+'>小于</option>');
    htm.append('<option value="between" '+(selectValue=="between"?"selected=\"selected\"":"")+'>范围</option>');
    htm.append('<option value="like" '+(selectValue=="like"?"selected=\"selected\"":"")+'>模糊</option>');
    htm.append('</select>');
    return htm.toString();
}

function buildGenCodeShowTypeHtm(index, selectValue){
    selectValue = CommUtil.isEmpty(selectValue)?"":selectValue;
    var htm = new StringBuffer();
    htm.append('<select name="columnStyleList['+index+'].showType" class="form-control" title="生成类型">');
    // (selectValue=="eq"?"selected=\"selected\"":"")
    htm.append('<option value="input" '+(selectValue=="input"?"selected=\"selected\"":"")+'>input</option>');
    htm.append('<option value="textarea" '+(selectValue=="textarea"?"selected=\"selected\"":"")+'>textarea</option>');
    htm.append('<option value="select" '+(selectValue=="select"?"selected=\"selected\"":"")+'>select</option>');
    htm.append('<option value="checkbox" '+(selectValue=="checkbox"?"selected=\"selected\"":"")+'>checkbox</option>');
    htm.append('<option value="radio" '+(selectValue=="radio"?"selected=\"selected\"":"")+'>radio</option>');
    htm.append('<option value="dialog" '+(selectValue=="dialog"?"selected=\"selected\"":"")+'>dialog</option>');
    htm.append('</select>');
    return htm.toString();
}