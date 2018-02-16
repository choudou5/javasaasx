
layui.use(['layer', 'element'], function () {
    var element = layui.element(), layer = layui.layer, $ = layui.jquery; //导航的hover效果、二级菜单等功能，需要依赖element模块
    var body = $('.my-body');

    // 监听导航(side)点击切换页面
    element.on('nav(side)', function (elem) {
        // 添加tab方法
        addTab(element,elem);
    });

    // 监听顶部导航
    element.on('nav(side-top)', function (elem) {
        log($(this));
        // 添加tab方法
        addTab(element,elem);
    });

    // 监听顶部左侧导航
    element.on('nav(side-right)', function (elem) {
        log("right");
        // 添加tab方法
        addTab(element,elem);
    });


    // 添加TAB选项卡
    function addTab(element, elem){
        var card    = 'card';                                   // 选项卡对象
        var title   = elem.children('a').text();                // 导航栏text
        var src     = elem.children('a').attr('href-url');      // 导航栏跳转URL
        var id      = new Date().getTime();                     // ID
        var flag    = getTitleId(card, title);                  // 是否有该选项卡存在
        // 大于0就是有该选项卡了
        if(flag > 0){
            id = flag;
        }else{
            if(src){
                //新增
                element.tabAdd(card, {
                    title: '<span>'+title+'</span>'
                    ,content: '<iframe src="' + src + '" frameborder="0"></iframe>'
                    ,id: id
                });
                // 关闭弹窗
                layer.closeAll();
            }
        }
        // 切换相应的ID tab
        element.tabChange(card, id);
        // 提示信息
        dialogLoading();
    }

	// 删除选项卡
    window.delTab = function (layId) {
        // 删除
        element.tabDelete('card', layId);
    };

    // 删除所有选项卡
    window.delAllTab = function () {
        // 选项卡对象
        layui.each($('.my-body .layui-tab-title > li'), function (k, v) {
            var layId = $(v).attr('lay-id');
            if (layId > 1) {
                // 删除
                element.tabDelete('card', layId);
            }
        });
    };

    // 获取当前选中选项卡lay-id
    window.getThisTabID = function () {
        // 当前选中的选项卡id
        return $(document).find('body .my-body .layui-tab-card > .layui-tab-title .layui-this').attr('lay-id');
    };


    // 选项卡右键事件阻止
    $(document).on("contextmenu", '.my-body .layui-tab-card > .layui-tab-title li', function () {
        return false;
    });

    // 选项卡右键事件
    $(document).on("mousedown", '.my-body .layui-tab-card > .layui-tab-title li', function (e) {
        // 判断是右键点击事件并且不是欢迎页面选项卡
        if (3 == e.which && $(this).index() > 0) {
            // 赋值
            cardIdx = $(this).index();
            cardLayId = $(this).attr('lay-id');
            console.log('lay-id:' + cardLayId);
            // 选择框
            layer.tips($('.my-dblclick-box').html(), $(this), {
                skin: 'dblclick-tips-box',
                tips: 3,
                time: false
            });
        }
    });

    // 点击body关闭tips
    $(document).on('click', 'html', function () {
        layer.closeAll('tips');
    });


    // 右键提示框菜单操作-刷新页面
    $(document).on('click', '.card-refresh', function () {
        // 窗体对象
        var ifr = $(document).find('.my-body .layui-tab-content .layui-tab-item iframe').eq(cardIdx);
        // 刷新当前页
        ifr.attr('src', ifr.attr('src'));
        // 切换到当前选项卡
        element.tabChange('card', cardLayId);
    });

    // 右键提示框菜单操作-关闭页面
    $(document).on('click', '.card-close', function () {
        // 删除
        window.delTab(cardLayId);
    });

	

    // 右键提示框菜单操作-关闭所有页面
    $(document).on('click', '.card-close-all', function () {
        // 删除
        window.delAllTab();
    });

	//取消菜单
	$(document).on('click', '.card-cancel-menu', function () {
       layer.closeAll('tips');
    });

    // 根据导航栏text获取lay-id
    function getTitleId(card,title){
        var id = -1;
        $(document).find(".layui-tab[lay-filter=" + card + "] ul li").each(function(){
            if(title === $(this).find('span').html()){
                id = $(this).attr('lay-id');
            }
        });
        return id;
    }

    // 监听控制content高度
    function init(){
        // 选项卡高度
        cardTitleHeight = $(document).find(".layui-tab[lay-filter='card'] ul.layui-tab-title").height();
        // 需要减去的高度
        height = $(window).height() - $('.layui-header').height() - cardTitleHeight - $('.layui-footer').height();
        // 设置高度
        $(document).find(".layui-tab[lay-filter='card'] div.layui-tab-content").height( height - 2 );
    }

    // 初始化
    init();



});