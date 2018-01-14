/**
 * 询问框
 * @param content
 * @param href 链接地址或函数
 * @param title
 * @param okBtnText 确认按钮文本，选填
 * @param noBtnText 取消按钮文本，选填
 * @returns {Boolean}
 */
function dialogConfirm(content, href, title, okBtnText, noBtnText){
	title = title==undefined?'提示':title;
	okBtnText = okBtnText==undefined?'确定':okBtnText;
	noBtnText = noBtnText==undefined?'取消':noBtnText;
	
	layer.confirm(content, {title: title, icon: 3, btn: [okBtnText, noBtnText]}, function(index){
		layer.close(index);
		if(typeof href == 'function'){
			return href();
		}else{
			window.location.href = href;
		}
	}, function(){
		  console.log("click no btn");
	});
	return false;
}

/**
 * 弹出框
 * @param title
 * @param type 类型：success/error/warning/md5/bad/nice
 */
function dialogAlert(title, type){
	type = type==undefined?"warning":type;
	layer.alert(title, {icon: layerGetIcon(type), btn:["知道了"]});
}

/**
 * 提示框
 * @param title
 * @param type 类型：success/error/warning/md5/bad/nice
 * @param autoCloseTime 自动关闭时间（毫秒）
 * @param algin t/r/b/l/lt/lb/rt/rb  默认：auto
 */
function dialogTip(title, type, autoCloseTime, align){
	type = type==undefined?"success":type;
	autoCloseTime = autoCloseTime==undefined?3000:autoCloseTime;
	align = align==undefined?"auto":align;
	layer.msg(title, {icon: layerGetIcon(type), time: autoCloseTime, offset: '20px'});
}


/**
 * prompt层
 * @param title
 * @param callBack 回调函数
 * @param inputType 输入类型 0=text, 1=password, 2=textarea 默认 0
 */
function dialogPrompt(title, callBack, inputType){
	inputType = inputType==undefined?0:inputType;
	layer.prompt({title: title, formType: inputType}, function(content, index){
	  layer.close(index);
	  if(typeof callBack == 'function'){
		  callBack(content);
	  }
	});
}


var __loadingIndex = 9999999999;
/**
 * 加载提示框
 * @param text
 * @param autoCloseTime
 */
function dialogLoading(text, autoCloseTime){
	__loadingIndex = layer.load();
	autoCloseTime = autoCloseTime==undefined?1000:autoCloseTime;
	setTimeout(function(){
		layer.close(__loadingIndex); 
	},autoCloseTime );
}

/**
 * 关闭加载提示框
 */
function dialogCloseLoading(){
	layer.close(__loadingIndex); 
}

/**
 * 弹出 新页面
 * @param title
 * @param url
 * @param width
 * @param height
 * @param okCall
 * @param cancelCall
 * @param initCall
 */
function dialogOpenPage(title, url, width, height, okCall, cancelCall, initCall){
	//layer.closeAll();
	width = width==undefined?'450px':width+'px';
	height = height==undefined?'350px':height+'px';
	
	//单窗口模式，层叠置顶
	layer.open({
	  type: 2 //此处以iframe举例
	  ,title: title
	  ,area: [width, height]
	  ,closeBtn: 0
	  ,shadeClose: true
	  ,maxmin: true
	  ,content: url
	  ,btn: ['确定', '取消']
	  ,yes: function(index){
		  if(typeof okCall == 'function'){
			  okCall(index);
		  }
	  }
	  ,btn2: function(){
		  if(typeof cancelCall == 'function'){
			  cancelCall();
		  }
	  }
	  ,zIndex: layer.zIndex //重点1
	  ,success: function(layero){
		  if(typeof initCall == 'function'){
			  initCall();
		  }
	  }
	});
}

/**
 * @param type success/error/warning/md5/bad/nice
 * @returns {0=感叹号, 1=成功, 2=错误, 3=疑问, 4=加密, 5=坏脸, 6=笑脸}
 */
function layerGetIcon(type){
	log(type);
	if("success" == type){
		return 1;
	}else if("error" == type){
		return 2;
	}else if("warning" == type){
		return 3;
	}else if("md5" == type){
		return 4;
	}else if("bad" == type){
		return 5;
	}else if("nice" == type){
		return 6;
	}else{
		return 0;
	}
}

/**
 * 复选框选中事件
 * @param attId
 * @param checkedCall
 * @param unCheckedCall
 */
//function checkboxEvent(attId, checkedCall, unCheckedCall){
//	$("#"+attId).click(function(){
//		if($(this).is(":checked")){
//			checkedCall();
//			if(typeof checkedCall == 'function'){
//				checkedCall();
//			}
//		}else{
//			if(typeof unCheckedCall == 'function'){
//				unCheckedCall();
//			}
//		}
//	});
//}

