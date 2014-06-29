<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="../css/common_body.css">



</head>
<title>主页</title>
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
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-body">
						<table class="table">
							<tbody>
								<tr>
									<td rowspan="5"><img src="../img/head-pic/head.png"
										alt="..." class="img-thumbnail"></td>
									<td><span class="glyphicon glyphicon-hand-right"></span></td>
									<td>原浩</td>
								</tr>
								<tr>
									<td><span class="glyphicon glyphicon-pencil"></span></td>
									<td>专注坑爹50年，从未被超越！</td>
								</tr>
								<tr>
									<td><span class="glyphicon glyphicon-map-marker"></span></td>
									<td>深圳</td>
								</tr>
								<tr>
									<td><span class="glyphicon glyphicon-book"></span></td>
									<td>南开大学 | 软件工程</td>
								</tr>
								<tr>
								<td><span class="glyphicon glyphicon-briefcase"></span></td>
								<td>百度</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="panel-footer">
						<div class="row">
							<div class="col-md-3">
								<h4>
									<span class="glyphicon glyphicon-home"></span>
								</h4>
							</div>
							<div class="col-md-3">
								<h4>文章（10）</h4>
							</div>
							<div class="col-md-3">
								<h4>信息（211）</h4>
							</div>
							<div class="col-md-3">
								<h4>被赞（21）</h4>
							</div>
						</div>

					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>文章</h4>
					</div>
					<div class="panel-body">
						<a href=""><h5>毕业后是否对校友这种特殊的资源有强力的情感需求和利益需求？</h5></a> <a href=""><h5>毕业后是否对校友这种特殊的资源有强力的情感需求和利益需求？</h5></a>
						<a href=""><h5>毕业后是否对校友这种特殊的资源有强力的情感需求和利益需求？</h5></a> <a href=""><h5>毕业后是否对校友这种特殊的资源有强力的情感需求和利益需求？</h5></a>
						<a href=""><h5>毕业后是否对校友这种特殊的资源有强力的情感需求和利益需求？</h5></a> <a href=""><h5>毕业后是否对校友这种特殊的资源有强力的情感需求和利益需求？</h5></a>
					</div>
				</div>
				<div class="panel panel-default">
					<div class="panel-heading">
						<h4>信息</h4>
					</div>
					<div class="panel-body">
						<a href=""><h5>毕业后是否对校友这种特殊的资源有强力的情感需求和利益需求？</h5></a> <a href=""><h5>毕业后是否对校友这种特殊的资源有强力的情感需求和利益需求？</h5></a>
						<a href=""><h5>毕业后是否对校友这种特殊的资源有强力的情感需求和利益需求？</h5></a> <a href=""><h5>毕业后是否对校友这种特殊的资源有强力的情感需求和利益需求？</h5></a>
						<a href=""><h5>毕业后是否对校友这种特殊的资源有强力的情感需求和利益需求？</h5></a> <a href=""><h5>毕业后是否对校友这种特殊的资源有强力的情感需求和利益需求？</h5></a>
					</div>
				</div>
			</div>

			<div class="col-md-3"></div>
		</div>
	</div>
</body>
</html>