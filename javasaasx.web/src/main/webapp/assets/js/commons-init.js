//var __width = top.window.innerWidth;
var __winOutWidth = top.window.outerWidth;
//移动端
var __isMobileModel = __winOutWidth < 768;

var layer;
layui.use(['layer', 'laydate'], function () {
    layer = layui.layer;
});


//屏蔽浏览器原始右键
window.document.body.oncontextmenu = function(event){
    return false;
}

$(function(){

    //输入框 x
    $('.clearable').clearSearch({ callback: function() { console.log("cleared"); } } );

    //复选框
    $(".bootstrap-switch").each(function() {
        $this = $(this), data_on_label = $this.data("on-label") || "", data_off_label = $this.data("off-label") || "";
        $this.bootstrapSwitch({
            onText: data_on_label,
            offText: data_off_label,
            onSwitchChange: function(){
                log(11111);
                var url = $(this).data("switch-url");
                if(CommUtil.isEmpty(url)){
                    return;
                }
                var flag = $(this).is(":checked");
                HttpUtil.ajaxAsyncJsonPost(url, {flag: flag}, function(message){
                    dialogTip(message);
                });

            }
        });
    });

});