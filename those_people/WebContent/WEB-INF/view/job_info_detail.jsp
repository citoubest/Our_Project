<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="../css/common_body.css">
<link rel="stylesheet" type="text/css"
	href="../css/love_info_detail.css">

</head>
<title>工作详细信息</title>
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
					<div class="panel-heading">
						<h4>工作信息详情</h4>
					</div>
					<div class="panel-body">
						<div class="row">
							<div class="col-md-2">
								<img src="${jobDetailInfo.headPicPath}" class="img-rounded"
									id="head-pic-detail"> <label style="padding-left: 15px;"><c:out
										value="${jobDetailInfo.nickName}" /></label>
							</div>
							<div class="col-md-10">
								<div class="col-md-8">
									<input type="hidden" id="infoId" value="${jobDetailInfo.id}">
									<B><c:out value="${jobDetailInfo.title}" /></B>
								</div>
								<div class="col-md-4">
									发布时间：
									<c:out value="${jobDetailInfo.postDate}" />


								</div>
							</div>
						</div>
						<hr class="featurette-divider">

						<p>公司名称：</p>
						<p>
							<c:out value="${jobDetailInfo.company}" />
						</p>
						<br>

						<p>工作地点：</p>
						<p>
							<c:out value="${jobDetailInfo.workPlace}" />
						</p>

						<br>
						<p>职位类别：</p>
						<p>
							<c:out value="${jobDetailInfo.jobtype}" />
						</p>

						<br>

						<p>工作描述：</p>
						<p>
							<c:out value="${jobDetailInfo.content}" />
						</p>

						<br>
						<p>职位要求：</p>
						<p>
							<c:out value="${jobDetailInfo.requires}" />
						</p>
						<br> <br>
						<p>联系方式：</p>
						<p>
							Email:
							<c:out value="${jobDetailInfo.email}" />
						</p>

						<p>
							Tel:
							<c:out value="${jobDetailInfo.tel}" />
						</p>


						<hr class="featurette-divider">


						<div id="statics_info">
						<c:choose>
						<c:when test="${jobDetailInfo.isCollected eq true}">
							<a href="javascript:void(0)"  onclick="praiseBox(${jobDetailInfo.id},2,2)">取消收藏 (<c:out	value="${jobDetailInfo.collects}" />)</a> 
						</c:when>
						<c:otherwise>
						<a href="javascript:void(0)" onclick="praiseBox(${jobDetailInfo.id},2,2)">收藏 (<c:out	value="${jobDetailInfo.collects}" />)</a> 
						</c:otherwise>
						</c:choose>
						<c:choose>
						<c:when test="${jobDetailInfo.isLiked eq true}">
							<a href="javascript:void(0)" onclick="praiseBox(${jobDetailInfo.id},2,1)"> 
								<span id="like_type">取消赞</span> (<span id="like_total"><c:out	value="${jobDetailInfo.likes}" /></span>)</a>
						</c:when>
						<c:otherwise>
							<a href="javascript:void(0)" onclick="praiseBox(${jobDetailInfo.id},2,1)"> 
								<span id="like_type">赞</span> (<span id="like_total"><c:out	value="${jobDetailInfo.likes}" /></span>)</a>
						</c:otherwise>
						</c:choose>
							 <a href="javascript:void(0)"> 点击 (<c:out value="${jobDetailInfo.visits}" />)</a>
						</div>

					</div>
				</div>
				<div class="panel panel-default">
					<div id="commentBody" class="panel-body">
						<span class="glyphicon glyphicon-comment"></span> 说两句 <br>
						<textarea id="commentConten" class="form-control" rows="5"></textarea>
						<div class="row">
							<button type="button" onclick="postCommnet(2,0,${userInfo.uid})"
								class="btn btn-info" id="commentBtn">评论</button>
						</div>
						<h4>评论</h4>
						<br>

					</div>
				</div>
				<div class="col-md-2"></div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript" src="../js/post_comment.js"></script>
<script type="text/javascript" src="../js/statistics.js"></script>
</html>
