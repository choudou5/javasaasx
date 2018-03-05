<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/include/tagLib.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>${siteName}-敏感词库[测试]</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <%@include file="/include/cssLib.jsp" %>
</head>

<body>
<div class="container-fluid">
    <div class="row">
        <div class="card">
            <div class="card-content">
                <div class="row">
                    <div class="col-md-12">
                        <textarea id="wordIn" rows="4" class="form-control clearable" placeholder=" 原始文本"></textarea>
                    </div>
                    <div class="col-md-2">
                        <button onclick="setRdWord()" class="btn btn-default btn-sm">随机文本</button>
                        <button onclick="testWord()" class="btn btn-info btn-sm">解析</button>
                    </div>
                    <div class="col-md-12">
                        <textarea id="wordOut" rows="4" class="form-control text-danger" placeholder=" 敏感词"></textarea>
                    </div>
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
    var rdWord = ["真性感，又射了，射了好多精液到你的照片上",
        "约炮，姐姐阿姨和少妇满意 ，不影响家庭，做得私聊谈，喜欢被亲吻，被口活的姐姐加我，本人。可长期相处，也可就一次高兴。单身寂寞的，经常空虚的，老公无法满足你的，就想让男人跪下给你舔，泄压满足心理的等等，只要你愿意都可以私聊我。",
        "你好美女！请问一下每晚上做爱两次，每次40分钟以上，但都达不到高潮，是什么情况啊",
        "你真是个王八蛋，fuck！！！",
        "我们是独藏分子，大家一起来反革命！",
        "去你妈的，真是日了狗了"];
    var dex = 0;
    function setRdWord(){
        if(dex == rdWord.length)
            dex = 0;
        var word = rdWord[dex];
        $("#wordIn").val(word);
        dex++;
    }

    function testWord(){
        var text = $("#wordIn").val();
        if(CommUtil.isEmpty(text)){
            return;
        }
        HttpUtil.ajaxAsyncJsonPost("/dic/dicSensitiveWord/test", {text: text}, function(data){
            var text = $("#wordOut").text(data);
        });
    }
</script>
</html>