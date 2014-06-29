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
<title>交友信息发布</title>
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
					<div class="panel-heading">
						<h3>发布交友信息</h3>
					</div>
					<div class="panel-body">
					<form action="/those_people/post_love_info/post.do" onsubmit="return checkPostLoveInfo()" method="post">
						<div class="input-group input-group-lg">
							<span class="input-group-addon">标题</span> <input type="text"
							name="infoTitle"	 id="infoTitle" class="form-control" placeholder="必填内容" maxlength="30">
						</div>
						<br> 
						<h3>
							<span class="label label-primary">自我描述（必填内容）</span>
						</h3>
						<textarea name="selfDescribe" id="selfDescribe" class="form-control" rows="10"></textarea>
						<br>
						<h3>
							<span class="label label-primary">期望对方（必填内容）</span>
						</h3>
						<textarea name="expectOther" id="expectOther" class="form-control" rows="10"></textarea>
						<br>
						<h3>
							<span class="label label-danger">无图无真相(可选)</span>
						</h3>
						<input type="file"> <br>
						<div class="input-group input-group-lg">
							<span class="input-group-addon">联系方式</span> <input type="text"
							name="contactWay"	id="contactWay" class="form-control" placeholder="必填内容">
						</div>
						<br>
						<div class="alert alert-danger" id="errorInfo"
							style="display: none"></div>
						<br>
						<div class="row">
							<div class="col-md-1"></div>
							<div class="col-md-8"></div>
							<div class="col-md-3">
								<button type="button" class="btn btn-warning btn-lg">取消</button>
								&nbsp&nbsp
								<button type="submit" class="btn btn-success btn-lg">发布</button>
							</div>
						</div>
						</form>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../js/love_info.js"></script>
</html>