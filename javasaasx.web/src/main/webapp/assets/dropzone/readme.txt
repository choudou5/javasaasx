中文文档：http://wxb.github.io/dropzonejs.com.zh-CN/dropzonezh-CN/

中文文档（常用）：https://www.renfei.org/blog/dropzone-js-introduction.html

<link rel="stylesheet" href="/dropzone/dropzone.css " type="text/css">
<script type="text/javascript" src="/dropzone/dropzone.js"></script>

// 上传插件(haowen@lianj.com改动过源码，更新版本请注意)

new Dropzone("#dropz", {
	url: ctx+"/upload/image?fileType=9",
	addRemoveLinks: true,	//删除按钮
	hideInputId: "#attachmentUrl",  //隐藏输入框
	hideInputSeparator: ",",	//多值 分割值
	maxFiles: 2,	//上传文件数
	maxFilesize: 8, //MB 单文件最大体积
	acceptedFiles: ".jpg,.png",	//支持类型
	init: function() {
		this.on("success", function(file, responseText, e) {
			var result = eval("("+responseText+")");
			if(result.message != null){
				showTip(result.message);
				return;
			}
			this.bindHiddenInput(file, result.imageBo.ossUrl);
		});
		this.initDefImage();
	}
});


<input id="attachmentUrl" name="attachmentUrl" type="hidden" value=""  />
<div id="dropz" class="dropzone" style="width: 500px;"></div>