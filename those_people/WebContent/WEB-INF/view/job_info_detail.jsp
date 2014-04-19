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
<!-[if IE]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]->
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
									id="head-pic-detail"> <label style="padding-left: 15px;">${jobDetailInfo.nickName}</label>
							</div>
							<div class="col-md-10">
								<div class="col-md-8">
								<input type="hidden" id="infoId" value="${jobDetailInfo.id}">
								<B>${loveInfo.title}</B>
								</div>
								<div class="col-md-4">
									发布时间： ${jobDetailInfo.postDate} <br> <br> 浏览次数：${jobDetailInfo.visitCnt}
								</div>
							</div>
						</div>
						<hr class="featurette-divider">
						
						<p>公司名称：</p>
						<p>
						${jobDetailInfo.company}
                        </p>

						<br>
						
						
						<p>工作地点：</p>
						<p>
						${jobDetailInfo.workPlace}
                        </p>

						<br>
						<p>职位类别：</p>
						<p>
						${jobDetailInfo.jobtype}
                        </p>

						<br>
						
						<p>工作描述：</p>
						<p>
						${jobDetailInfo.content}
                        </p>

						<br>
						<p>职位要求：</p>
						<p>
						${jobDetailInfo.requires}
                        </p>
                        <br><br>
                        <p>联系方式：</p>
                        <p>Email:${jobDetailInfo.email}</p>
                       	
						 <p>Tel:${jobDetailInfo.tel}</p>
						 
	
						<hr class="featurette-divider">
						<button type="button" class="btn btn-info" id="collectBtn">收藏</button>
					</div>
				</div>
				<div class="panel panel-default">
					<div id="commentBody"  class="panel-body">
						<span class="glyphicon glyphicon-comment"></span> 说两句 <br>
						<textarea id="commentConten" class="form-control" rows="5"></textarea>
						<div class="row">
							<button type="button" onclick="postCommnet(2,0,${userInfo.uid})" class="btn btn-info" id="commentBtn">评论</button>
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
</html>