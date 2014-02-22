/**
 * the js for the header
 */
function verifyEmailFormat(email) {
	var format = /^([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+@([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+.[a-za-z]{2,3}$/;
	if (format.test(email)) {
		return true;
	}
	return false;
}
function showWarnMessage(elementId, message) {
	document.getElementById(elementId).innerHTML = "<h6>" + message + "<h6/>";
	document.getElementById(elementId).style.display = "";
}

function hideWarnMessage(elementId) {
	document.getElementById(elementId).style.display = "none";
}
function verifyEmailCB(email) {
	if (email.length == 0) {
		return;
	} else {
		if (!verifyEmailFormat(email)) {
			showWarnMessage('errorEmail', "邮箱格式不正确，请您输入正确的邮箱地址!");
			return;
		} 
	}
	$
			.getJSON(
					"/those_people/register/verifyEmail.do",
					{
						email : email
					},
					function(data, textStatus) {
						if (data.result == false) {
							showWarnMessage('errorEmail', '该邮箱已经被注册!');
						}
					});
}
function ifPasswordAndRePasswordSame(password, rePassword) {
	if (password == rePassword) {
		return true;
	}
	return false;
}
function verifyRepeatPassword(rePassword) {
	var password = document.getElementById('password').value;
	if (ifPasswordAndRePasswordSame(password, rePassword)) {
		hideWarnMessage('errorRePassword');
	} else {
		showWarnMessage('errorRePassword', '两次密码不一致!');
	}
}

function checkRegister() {
	var realName = document.getElementById("realName").value;
	var nickName = document.getElementById("nickName").value;
	var email = document.getElementById("email").value;
	var password = document.getElementById('password').value;
	var rePassword = document.getElementById('rePassword').value;
	if (realName.length == 0 || nickName.length == 0 || email.length == 0
			|| password.length == 0 || rePassword.lenght == 0) {
		if (realName.length == 0) {
			showWarnMessage('errorRealName', '请填写您的真实姓名!');
		}
		if (nickName.length == 0) {
			showWarnMessage('errorNickName', '请填写您的昵称!');
		}
		if (email.length == 0) {
			showWarnMessage('errorEmail', '请您填写邮箱!');
		}
		if (password.length == 0) {
			showWarnMessage('errorPassword', '请您填写密码!');
		}
		if (rePassword.length == 0) {
			showWarnMessage('errorRePassword', '请您再次填写密码!');
		}
		return false;
	}
	if (!verifyEmailFormat(email)) {
		showWarnMessage('errorEmail', "邮箱格式不正确，请您输入正确的邮箱地址!");
		return false;
	}
	if (!ifPasswordAndRePasswordSame(password, rePassword)) {
		showWarnMessage('errorRePassword', '两次密码不一致!');
		return false;
	}
}
