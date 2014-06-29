<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">  
    <link rel="stylesheet" type="text/css" href="../css/common_body.css">  


<title>title</title>
<link rel="stylesheet"
	href="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="../css/login_header.css">
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
				<ul  class="nav navbar-nav navbar-right">
					<li><a href="/those_people/user/userInfo.do"> <img src="${userInfo.headPicPath}"
							style="height: 30px; width: 30px;" alt="..." class="img-rounded"></a>
					</li>
					<li style="margin-top: 15px">
						<div class="btn-group">
							<button class="btn btn-default btn-sm dropdown-toggle"
								type="button" data-toggle="dropdown">
								${userInfo.nickName} <span class="caret"></span>
							</button>
							<ul class="dropdown-menu">
								<li><a href="#">好友</a></li>
								<li class="divider"></li>
								<li><a href="#">文章</a></li>
								<li class="divider"></li>
								<li><a href="#">已发布信息</a></li>
								<li class="divider"></li>
								<li><a href="#">发布工作信息</a></li>
								<li class="divider"></li>
								<li><a href="#">发布交友信息</a></li>
								<li class="divider"></li>
								<li><a href="#">发布活动信息</a></li>
								<li class="divider"></li>
								<li><a href="#">发布活动信息</a></li>
								<li class="divider"></li>
								<li><a href="#">退出</a></li>
							</ul>
						</div>
					</li>
					<li><a href="" id="envelopicon"> <img
							src="../img/tool-icon/envelop.jpg"
							style="height: 23px; width: 28px;" alt="..." class="img-rounded"></a>
					</li>
					<li><a href="" id="envelopicon" style="font-size: 23px;">
							<span id="usersetting" class="glyphicon glyphicon-cog"></span>
					</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>
</body>
<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
</html>