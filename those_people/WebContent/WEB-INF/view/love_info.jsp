<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="../css/common_body.css">
<link rel="stylesheet" type="text/css" href="../css/love_info.css">

</head>
<title>鹊桥信息</title>
</head>
<c:choose>
	<c:when test="${!empty sessionScope.userInfo}">
		<jsp:include page="/WEB-INF/view/login_header.jsp" />
	</c:when>
	<c:otherwise>
		<jsp:include page="/WEB-INF/view/header.jsp" />
	</c:otherwise>
</c:choose>
<body id="common_body">
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-7">
				<div class="panel panel-default">
					<div class="panel-body">
						<div class="row">
							<div class="col-md-2">
								<img src="../img/head-pic/head.jpg" class="img-rounded"
									id="head-pic-detail"> <label style="padding-left: 15px;">忒各色</label>
							</div>
							<div class="col-md-10">
								<div id="infoposttime">
									<h6>2014-03-16 10:23:31</h6>
								</div>
							</div>
						</div>
						&nbsp
						<div id="infocontent" class="row">
							<a href="">
								<h4>想找一个懂自己的人，恋爱、结婚、生子，携手走下去！</h4>
							</a> <img src="../img/love_info_pic/meitu.jpg" alt="..."
								style="height: 150px; width: 120px;" class="img-thumbnail">
						</div>
						&nbsp
						<div class="row">
							<div id="infocommentstatus">
								<span class="glyphicon glyphicon-eye-open">(29)</span> 
								&nbsp 
								<a onclick="javascript:likeThisInfo(); return false;" href="#"> 
								<span class="glyphicon glyphicon-thumbs-up">(32)</span>
								</a> 
								&nbsp 
								<span class="glyphicon glyphicon-comment">(18)</span>
							</div>
						</div>
						<hr class="featurette-divider">
						<div class="row">
							<div class="col-md-2">
								<img src="../img/head-pic/head.jpg" class="img-rounded"
									id="head-pic-detail"> <label style="padding-left: 15px;">忒各色</label>
							</div>
							<div class="col-md-10">
								<div id="infoposttime">
									<h6>2014-03-16 10:23:31</h6>
								</div>
							</div>
						</div>
						&nbsp
						<div id="infocontent" class="row">
							<a href="">
								<h4>想找一个懂自己的人，恋爱、结婚、生子，携手走下去！</h4>
							</a>
						</div>
						&nbsp
						<div class="row">
							<div id="infocommentstatus">
								<span class="glyphicon glyphicon-eye-open">(29)</span> &nbsp <span
									class="glyphicon glyphicon-thumbs-up">(32)</span> &nbsp <span
									class="glyphicon glyphicon-comment">(18)</span>
							</div>
						</div>
						<hr class="featurette-divider">
						<div class="row">
							<div class="col-md-2">
								<img src="../img/head-pic/head.jpg" class="img-rounded"
									id="head-pic-detail"> <label style="padding-left: 15px;">忒各色</label>
							</div>
							<div class="col-md-10">
								<div id="infoposttime">
									<h6>2014-03-16 10:23:31</h6>
								</div>
							</div>
						</div>
						&nbsp
						<div id="infocontent" class="row">
							<a href="">
								<h4>想找一个懂自己的人，恋爱、结婚、生子，携手走下去！</h4>
							</a>
						</div>
						&nbsp
						<div class="row">
							<div id="infocommentstatus">
								<span class="glyphicon glyphicon-eye-open">(29)</span> &nbsp <span
									class="glyphicon glyphicon-thumbs-up">(32)</span> &nbsp <span
									class="glyphicon glyphicon-comment">(18)</span>
							</div>
						</div>
						<hr class="featurette-divider">
						<div class="row">
							<div class="col-md-2">
								<img src="../img/head-pic/head.jpg" class="img-rounded"
									id="head-pic-detail"> <label style="padding-left: 15px;">忒各色</label>
							</div>
							<div class="col-md-10">
								<div id="infoposttime">
									<h6>2014-03-16 10:23:31</h6>
								</div>
							</div>
						</div>
						&nbsp
						<div id="infocontent" class="row">
							<a href="">
								<h4>想找一个懂自己的人，恋爱、结婚、生子，携手走下去！</h4>
							</a>
						</div>
						&nbsp
						<div class="row">
							<div id="infocommentstatus">
								<span class="glyphicon glyphicon-eye-open">(29)</span> &nbsp <span
									class="glyphicon glyphicon-thumbs-up">(32)</span> &nbsp <span
									class="glyphicon glyphicon-comment">(18)</span>
							</div>
						</div>
						<hr class="featurette-divider">
						<div class="row">
							<div class="col-md-2">
								<img src="../img/head-pic/head.jpg" class="img-rounded"
									id="head-pic-detail"> <label style="padding-left: 15px;">忒各色</label>
							</div>
							<div class="col-md-10">
								<div id="infoposttime">
									<h6>2014-03-16 10:23:31</h6>
								</div>
							</div>
						</div>
						&nbsp
						<div id="infocontent" class="row">
							<a href="">
								<h4>想找一个懂自己的人，恋爱、结婚、生子，携手走下去！</h4>
							</a>
						</div>
						&nbsp
						<div class="row">
							<div id="infocommentstatus">
								<span class="glyphicon glyphicon-eye-open">(29)</span> &nbsp <span
									class="glyphicon glyphicon-thumbs-up">(32)</span> &nbsp <span
									class="glyphicon glyphicon-comment">(18)</span>
							</div>
						</div>
					</div>
					<a href="">
						<div class="panel-footer" style="text-align: center">更多</div>
					</a>
				</div>
			</div>
			<div class="col-md-2"></div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>