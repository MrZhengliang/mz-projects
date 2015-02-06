//校验登陆输入是否为空
var sub=function(){
	var ou = document.logForm.username;
	var op = document.logForm.password;
	var oc = document.logForm.code;
	if(ou.value ==''||op.value == ''||oc.value == ''){
		alert('用户名或者密码或者验证码为空!');
		return;
	}else{
		document.logForm.submit();
	}
}

