<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="../css/common_body.css">
<link rel="stylesheet" type="text/css" href="../css/home.css">

</head>
<title>那些人</title>
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
				<div class="row">
					<div class="panel panel-default">
						<div class="panel-body">
							<div class="row">
								<div class="col-md-3">
									<img src="../img/tool-icon/photo.png">
								</div>
								<div class="col-md-3">
									<img src="../img/tool-icon/paper-plane.png">
								</div>
								<div class="col-md-3">
									<img src="../img/tool-icon/glasses.png">
								</div>
								<div class="col-md-3">
									<img src="../img/tool-icon/www.png">
								</div>
							</div>
						</div>
					</div>
				</div>
				<br>
				<div class="row" id="content">
					<div class="row">
						<div class="col-md-2" id="head-pic">
							<img src="../img/head-pic/head.jpg" class="img-rounded"
								id="head-pic-detail">
						</div>
						<div class="col-md-10" id="msg-detail">
							<div class="panel panel-default">
								<div class="panel-body">
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
								</div>

								<div class="panel-footer">
									<div class="row">
										<div class="col-md-9"></div>
										<div class="col-md-1">
											<h4>
												<span class="glyphicon glyphicon-heart"></span>
											</h4>
										</div>
										<div class="col-md-1">
											<h4>
												<span class="glyphicon glyphicon-retweet">
											</h4>
										</div>
										<div class="col-md-1">
											<h4>
												<span class="glyphicon glyphicon-comment">
											</h4>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2" id="head-pic">
							<img src="../img/head-pic/head.jpg" class="img-rounded"
								id="head-pic-detail">
						</div>
						<div class="col-md-10" id="msg-detail">
							<div class="panel panel-default">
								<div class="panel-body">
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas
								</div>

								<div class="panel-footer">
									<div class="row">
										<div class="col-md-9"></div>
										<div class="col-md-1">
											<h4>
												<span class="glyphicon glyphicon-heart"></span>
											</h4>
										</div>
										<div class="col-md-1">
											<h4>
												<span class="glyphicon glyphicon-retweet">
											</h4>
										</div>
										<div class="col-md-1">
											<h4>
												<span class="glyphicon glyphicon-comment">
											</h4>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-2" id="head-pic">
							<img src="../img/head-pic/head.jpg" class="img-rounded"
								id="head-pic-detail">
						</div>
						<div class="col-md-10" id="msg-detail">
							<div class="panel panel-default">
								<div class="panel-body">
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas <br>
									fdsafadfasfas <br> fdsafadfasfas <br> fdsafadfasfas
								</div>

								<div class="panel-footer">
									<div class="row">
										<div class="col-md-9"></div>
										<div class="col-md-1">
											<h4>
												<span class="glyphicon glyphicon-heart"></span>
											</h4>
										</div>
										<div class="col-md-1">
											<h4>
												<span class="glyphicon glyphicon-retweet">
											</h4>
										</div>
										<div class="col-md-1">
											<h4>
												<span class="glyphicon glyphicon-comment">
											</h4>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-2">
				<table class="table">
					<tbody id="right-tool-bar">
						<tr>
							<td>
								<h3>
									<span class="glyphicon glyphicon-eye-open"></span> 关注（5）
								</h3>
							</td>
						</tr>
						<tr>
							<td>
								<h3>
									<span class="glyphicon glyphicon-heart"></span> 赞（5）
								</h3>
							</td>
						</tr>
						<tr>
							<td>
								<h3>
									<a href="../StaticView/text_editor.jsp"><span class="glyphicon glyphicon-edit"></span> 文章（5）</a>
								</h3>
							</td>
						</tr>
						<tr>
							<td>
								<h3>
									<span class="glyphicon glyphicon-bullhorn"></span> 发布信息
								</h3> <br>
								<h4>
									<a href="../StaticView/post_house_info.jsp">房屋信息</a>
								</h4> <br>
								<h4>
									<a href="../StaticView/post_love_info.jsp">交友信息</a>
								</h4> <br>
								<h4>
									<a href="../StaticView/post_job_info.jsp">工作信息</a>
								</h4> <br>
								<h4>
									<a href="">活动信息</a>
								</h4>
							</td>
						</tr>
						<tr>
							<td>
								<h3>
									<span class="glyphicon glyphicon-plus"></span> 加关注
								</h3>
							</td>
						</tr>
						<tr>
							<td>可能感兴趣的人</td>
						<tr>
							<td>热门话题</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-md-2"></div>
		</div>
	</div>
</body>
</html>