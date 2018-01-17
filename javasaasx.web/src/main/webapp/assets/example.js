  //初始化 下拉框值
http.ajaxAsyncJsonPost("/gen/genTableColumnStyle/getTableList", {}, function(selectBos){
    var opts = select.buildSelectOptsHtml(selectBos);
    $('#dbTableSelect').html(opts);
    $('#dbTableSelect').selectpicker('refresh');
});

$('#dbTableSelect').on('changed.bs.select', function (e, index) {
    var table = e.target.value;
    log(index);
});
