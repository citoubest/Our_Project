<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="../css/common_body.css">
<!-[if IE]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]->
<title>title</title>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">
</head>
<body>
	<div class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="/those_people/index/home.do?uid=${userInfo.uid}">那些人</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="#">鹊桥</a></li>
					<li><a href="#about">房屋</a></li>
					<li><a href="/those_people/job/jobInfo.do">工作</a></li>
					<li><a href="#activity">活动</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#">
							<button class="btn btn-info btn-sm" data-toggle="modal"
								data-target="#registModal">
								<b>注册</b>
							</button>
					</a></li>
					<li><a href="#
              ">
							<button class="btn btn-info btn-sm" data-toggle="modal"
								data-target="#loginModal">
								<b>登录</b>
							</button>
					</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
	<!-- The Modal dialog of regist-->
	<div class="modal fade" id="registModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">注册</h4>
				</div>
				<form action="/those_people/register/registUser.do"
					onsubmit="return checkRegister()" method="post">
					<div class="modal-body">
						<div class="alert alert-danger" id="errorRealName"
							style="display: none"></div>
						<div class="input-group input-group-lg">
							<input type="text" name="realName" id="realName"
								class="form-control" placeholder="真实姓名"
								onfocus="hideWarnMessage('errorRealName')"> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-user"></span>
							</span>
						</div>
						<br>
						<div class="alert alert-danger" id="errorNickName"
							style="display: none"></div>
						<div class="input-group input-group-lg">
							<input type="text" name="nickName" id="nickName"
								class="form-control" placeholder="昵称"
								onfocus="hideWarnMessage('errorNickName')"> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-user"></span>
							</span>
						</div>
						<br>
						<div class="alert alert-danger" id="errorEmail"
							style="display: none"></div>
						<div class="input-group input-group-lg">
							<input type="text" name="email" id="email" class="form-control"
								placeholder="邮箱" onfocus="hideWarnMessage('errorEmail')"
								onblur="verifyEmailCB(this.value)"> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-envelope"></span>
							</span>
						</div>
						<br>
						<div class="alert alert-danger" id="errorPassword"
							style="display: none"></div>
						<div class="input-group input-group-lg">
							<input type="password" name="passWord" id="password"
								class="form-control" placeholder="密码(6-10位字符)" maxlength="10"
								onfocus="hideWarnMessage('errorPassword')"> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-lock"></span>
							</span>
						</div>
						<br>
						<div class="alert alert-danger" id="errorRePassword"
							style="display: none"></div>
						<div class="input-group input-group-lg">
							<input type="password" name="rePassword" id="rePassword"
								onblur="verifyRepeatPassword(this.value)" id="rePassWord"
								class="form-control" placeholder="确认密码" maxlength="10"
								onfocus="hideWarnMessage('errorRePassword')"> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-lock"></span>
							</span>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">注册</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!--The end of regist model dialog -->

	<!--The Model dialog of Login-->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">登录</h4>
				</div>
				<form action="/those_people/login/loginAccount.do"
					onsubmit="return checkLogin()" method="post">
					<div class="modal-body">
						<div class="input-group input-group-lg">
							<input type="text" class="form-control" id="loginEmail"
								name="loginEmail" placeholder="邮箱"> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-envelope"></span>
							</span>
						</div>
						<br>
						<div class="input-group input-group-lg">
							<input type="password" class="form-control" id="loginPassword"
								name="loginPassword" placeholder="密码"> <span
								class="input-group-addon"> <span
								class="glyphicon glyphicon-lock"></span>
							</span>
						</div>
						<br>
						<div class="alert alert-danger" id="errorLogin"
							style="display: none"></div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">登录</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!--The end of regist model dialog -->
</body>
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script
	src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/header.js">
	
</script>
</html>