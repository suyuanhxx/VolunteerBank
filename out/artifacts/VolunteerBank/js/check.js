userillegal = 0;
pwdillegal = 0;
rpwdillegal = 0;
identical = 0;

function check() {
	checkusername();
	checkpassword();
	checkrepassword();
}

function checkusername() {
	var username = document.getElementById("username").value;
	var checkusernameinfo = $("#checkusernameinfo");
	checkusernameinfo.html("");
	
	if (trim(username) == "") { 
		checkusernameinfo.html("用户名不能为空");
		userillegal = 1;
	}
	else if (trim(username).length > 10) {
		checkusernameinfo.html("用户名不能超过五个汉字或十个字符");
		userillegal = 1;
	}
	else if(userillegal == 0)
	{
		verifyusername();
	}
	else
		userillegal = 0;
	
	available_submit();
}

function checkpassword() {
	var password = document.getElementById("password").value;
	var checkpasswordinfo = $("#checkpasswordinfo");
	checkpasswordinfo.html("");
	
	if (trim(password) == "") {
		checkpasswordinfo.html("密码不能为空");
		pwdillegal = 1;
	}
	else if (trim(password).length > 20) {
		checkpasswordinfo.html("密码不能超过20个字符");
		pwdillegal = 1;
	}
	else 
		pwdillegal = 0;
	
	if (identical)
		checkrepassword();
	
	available_submit();
}

function checkrepassword() {
	var repassword = document.getElementById("repassword").value;
	var checkrepasswordinfo = $("#checkrepasswordinfo");
	checkrepasswordinfo.html("");
	
	if(repassword != trim(document.getElementById("password").value))
	{
		checkrepasswordinfo.html("两次输入的密码不一致");
		rpwdillegal = 1;
	}
	else
		rpwdillegal = 0;
	
	identical = 1;
	available_submit();
}

function verifyusername() {
    var jqueryObj = $("#username");
    var username = jqueryObj.val();

    $.ajax({
    	type : "post",
    	url : "checkusername.action",
    	data : {username:username},
    	contentType : "application/x-www-form-urlencoded",
    	success : function(data)
    	{
			if(date.result == "exist")
			{
				$("#checkusernameinfo").html("用户名已存在");
				userillegal = 1;
			} else {
				$("#checkusernameinfo").html("可以使用此用户名");
				userillegal = 0;
			}
		}
    });	
}

function cleanusernameerror() {
	$("#checkusernameinfo").html("");
	$("#username").select();
	userillegal = 0;
}

function cleanpassworderror(){
	$("#checkpasswordinfo").html("");
	$("#password").select();
	pwdillegal = 0;
}

function cleanrepassworderror() {
	$("#checkrepasswordinfo").html("");
	$("#repassword").select();
	rpwdillegal = 0;
}


function trim(str) {
	return str.replace(/(^\s*)|(\s*$)/g, "");
}

function available_submit() {
	if (!userillegal && !pwdillegal && !rpwdillegal) {
		document.getElementById("submit").disabled = false;
	}
	else
		document.getElementById("submit").disabled = true;
}