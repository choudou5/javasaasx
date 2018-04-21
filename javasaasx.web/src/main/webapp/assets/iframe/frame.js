var openMenus = [];
layui.use(['layer', 'element'], function () {

    var element = layui.element(), layer = layui.layer, $ = layui.jquery; //导航的hover效果、二级菜单等功能，需要依赖element模块
    var body = $('.my-body');

    // http://demo.vip-admin.com/
    // http://fslayuiplugin.fallsea.com/
    // 监听导航(side)点击切换页面
    element.on('nav(side)', function (elem) {
        log("side");
        // 添加tab方法
        addTab(element,elem);
    });

    // 监听顶部导航
    element.on('nav(side-top)', function (elem) {
        log("side-top");
        // 添加tab方法
        addTab(element,elem);
    });

    // 监听顶部左侧导航
    element.on('nav(side-right)', function (elem) {
        log("side-right");
        // 添加tab方法
        addTab(element,elem);
    });

    openMenus = getSessionOpenMenus();
    // 添加TAB选项卡
    function addTab(element, elem){
        var card    = 'card';                                   // 选项卡对象
        var title   = elem.children('a').text();                // 导航栏text
        var src     = elem.children('a').attr('href-url');      // 导航栏跳转URL
        var id = hex_md5(title);                                // ID
        //var id      = new Date().getTime();                     // ID
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
                //绑定关闭事件
                $('.my-body .layui-tab-card > .layui-tab-title li[lay-id='+id+'] i.layui-tab-close').bind('click', function () {
                    var cardLayId = $(this).closest("li").attr('lay-id');
                    delSessionMenu(cardLayId);
                });
                // 关闭弹窗
                layer.closeAll();
            }
            setSessionOpenMenus(id, title, src);
        }
        SessionUtil.set("curMenu", id); //当前的窗口
        // 切换相应的ID tab
        element.tabChange(card, id);
        // 提示信息
        dialogLoading();
    }

	// 删除选项卡
    window.delTab = function (layId) {
        // 删除
        element.tabDelete('card', layId);
        delSessionMenu(layId);
    };


    //添加 tab到框架
    window.addTabToFrame = function(title, src){
        var card    = 'card';                                   // 选项卡对象
        var id = hex_md5(title);                                // ID
        //var id      = new Date().getTime();                     // ID
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
                //绑定关闭事件
                $('.my-body .layui-tab-card > .layui-tab-title li[lay-id='+id+'] i.layui-tab-close').bind('click', function () {
                    var cardLayId = $(this).closest("li").attr('lay-id');
                    delSessionMenu(id);
                });
                // 关闭弹窗
                layer.closeAll();
            }
            setSessionOpenMenus(id, title, src);
        }
        SessionUtil.set("curMenu", id); //当前的窗口
        // 切换相应的ID tab
        element.tabChange(card, id);
        // 提示信息
        dialogLoading();
    }



    // 删除所有选项卡
    window.delAllTab = function () {
        // 选项卡对象
        layui.each($('.my-body .layui-tab-title > li'), function (k, v) {
            var layId = $(v).attr('lay-id');
            if (layId > 1) {
                // 删除
                element.tabDelete('card', layId);
                delSessionMenu(layId);
            }
        });
    };

    // 删除其他选项卡
    window.delOhterlTab = function () {
        // 选项卡对象
        layui.each($('.my-body .layui-tab-title > li'), function (k, v) {
            var layId = $(v).attr('lay-id');
            if (layId > 1 && layId != cardLayId) {
                // 删除
                element.tabDelete('card', layId);
                delSessionMenu(layId);
            }
        });
    };

    // 单击 相应选项卡
    $(document).on('click', '.my-body .layui-tab-card > .layui-tab-title li', function () {
        var cardIdx = $(this).index();
        var cardLayId = $(this).attr('lay-id');
        // 窗体对象
        var ifr = $(document).find('.my-body .layui-tab-content .layui-tab-item iframe').eq(cardIdx);
        // 刷新当前页
        ifr.attr('src', ifr.attr('src'));
        // 切换到当前选项卡
        element.tabChange('card', cardLayId);
        SessionUtil.set("curMenu", cardLayId);
    });


    // 双击 刷新相应选项卡
    $(document).on('dblclick', '.my-body .layui-tab-card > .layui-tab-title li', function () {
        var cardIdx = $(this).index();
        var cardLayId = $(this).attr('lay-id');
        // 窗体对象
        var ifr = $(document).find('.my-body .layui-tab-content .layui-tab-item iframe').eq(cardIdx);
        // 刷新当前页
        ifr.attr('src', ifr.attr('src'));
        // 切换到当前选项卡
        element.tabChange('card', cardLayId);
    });

    //手机端 双击事件
    var mobileClickCount = 0;
    $(document).on('click', '.my-body .layui-tab-card > .layui-tab-title li', function () {
        mobileClickCount++;
        setTimeout(function () {
            mobileClickCount = 0;
        }, 500);
        if (mobileClickCount > 1) {
            var cardIdx = $(this).index();
            var cardLayId = $(this).attr('lay-id');
            // 窗体对象
            var ifr = $(document).find('.my-body .layui-tab-content .layui-tab-item iframe').eq(cardIdx);
            // 刷新当前页
            ifr.attr('src', ifr.attr('src'));
            // 刷新当前选项卡
            element.tabChange('card', cardLayId);
            mobileClickCount = 0;
        }
    });


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

    window.initShowTabTip = function () {
        var tabTipStr = __isMobileModel?"双击刷新":"双击刷新，右键关闭更多";
        var home = $(document).find('body .my-body .layui-tab-card > .layui-tab-title li:eq(0)');
        layer.tips(tabTipStr, home, {
            tips: [2, '#3595CC'],
            time: 4000
        });
    };

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
    // 右键提示框菜单操作-关闭其他页面
    $(document).on('click', '.card-close-other', function () {
        window.delOhterlTab();
    });
    // 右键提示框菜单操作-关闭所有页面
    $(document).on('click', '.card-close-all', function () {
        // 删除
        window.delAllTab();
    });
    // 右键提示框菜单操作-打开新页面
    $(document).on('click', '.card-open-new', function () {
        // 窗体对象
        var ifr = $(document).find('.my-body .layui-tab-content .layui-tab-item iframe').eq(cardIdx);
        // 刷新当前页
        var url = ifr.attr('src');
        top.window.open(url);
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

    /******************************** start 锁屏 *****************************************/
    function lockPage() {
        layer.open({
            title: false,
            type: 1,
            content: '  <div class="admin-header-lock" id="lock-box">' +
            '<div class="admin-header-lock-img text-center"><img src="/assets/img/avatar.jpg"/></div>' +
            '<div class="admin-header-lock-name" id="lockUserName">请叫我臭哥</div>' +
            '<div class="input_btn">' +
            '<input type="password" class="admin-header-lock-input input-sm" autocomplete="off" placeholder="请输入密码解锁.." name="lockPwd" id="lockPwd" />&nbsp;' +
            '<button class="btn btn-success btn-sm" id="unlock"><i class="fa fa-unlock"></i>解锁</button>' +
            '</div>' +
            '<p class="text-danger">请输入“123456”，否则不会解锁哦！！！</p>' +
            '</div>',
            closeBtn: 0,
            shade: 0.9
        })
        $(".admin-header-lock-input").focus();
    }
    $("#locksystem").on("click", function() {
        SessionUtil.set("locksystem", true);
        lockPage();
    })
    // 判断是否显示锁屏
    if (SessionUtil.get("locksystem") == "true") {
        lockPage();
    }
    // 解锁
    $("body").on("click", "#unlock", function() {
        if ($(this).siblings(".admin-header-lock-input").val() == '') {
            layer.msg("请输入解锁密码！");
            $(this).siblings(".admin-header-lock-input").focus();
        } else {
            if ($(this).siblings(".admin-header-lock-input").val() == "123456") {
                SessionUtil.set("locksystem", false);
                $(this).siblings(".admin-header-lock-input").val('');
                layer.closeAll("page");
            } else {
                layer.msg("密码错误，请重新输入！");
                $(this).siblings(".admin-header-lock-input").val('').focus();
            }
        }
    });
    $(document).on('keydown', function() {
        if (event.keyCode == 13) {
            $("#unlock").click();
        }
    });
    /******************************** end 锁屏 *****************************************/



    /******************************** end 缓存菜单 *****************************************/
    //退出 待完善
    $(".signOut").click(function() {
        SessionUtil.remove("openMenus");
        openMenus = [];
        SessionUtil.remove("curMenu");
    })

    //刷新后还原打开的窗口
    if (SessionUtil.has("openMenus")) {
        openMenus = getSessionOpenMenus();
        var curMenu = SessionUtil.get("curMenu");
        var openMenu = null;
        for (var i = 0; i < openMenus.length; i++) {
            openMenu = openMenus[i];
            addTabToFrame(openMenu['title'], openMenu['src']);
        }
        //定位到刷新前的窗口
        if (CommUtil.isNotEmpty(curMenu))
            element.tabChange("bodyTab", curMenu);
    }

    function getSessionOpenMenus(){
        var str = SessionUtil.get("openMenus");
        if(CommUtil.isEmpty(str))
            return [];
        return JSON.parse(str);
    }

    function setSessionOpenMenus(id, title, src){
        var item = CommUtil.getJsonArrayItemById(openMenus, id);
        if(item == null){
            var currMenuStr = {"id":id, "title": title, "src": src};
            openMenus.push(currMenuStr);
            //log(JSON.stringify(openMenus));
            SessionUtil.set("openMenus", JSON.stringify(openMenus)); //打开的窗口
        }
    }

    function delSessionMenu(id){
        //log("delMenu:"+id);
        openMenus = CommUtil.delJsonArrayById(openMenus, id);
        SessionUtil.set("openMenus", JSON.stringify(openMenus)); //打开的窗口
        //log(JSON.stringify(openMenus));
    }
    /******************************** end 缓存菜单 *****************************************/

});

//frameLoading();

function frameLoading(){
    var htm = new StringBuffer();
    htm.append('<div class="frame-loading">');
    htm.append('<div><div></div></div>');
    htm.append('<div><div></div></div>');
    htm.append('<div><div></div></div>');
    htm.append('<div><div></div></div>');
    htm.append('</div>');
    $("body").prepend(htm.toString());
    setTimeout(function(){
        $(".frame-loading").remove();
        $("#frame").css("opacity", "1");
        initShowTabTip();
    }, 1500);
}

