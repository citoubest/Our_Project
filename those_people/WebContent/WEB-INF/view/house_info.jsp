<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="../css/common_body.css">
<link rel="stylesheet" type="text/css" href="../css/house_info.css">
<!-[if IE]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]->
</head>
<title>房屋信息</title>
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
	<input type="hidden" id="uid" value="${sessionScope.userInfo.uid}" />
	<input type="hidden" id="currentPage" value="${currentPage}" />
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-7">
				<div class="panel panel-default">
					<div class="panel-body">
					  <div id="infoBody" class="panel-body">
						<c:forEach items="${HouseInfo}" var="houseInfo">
						  <div class="row">
							<div class="col-md-2">
								<img src="${houseInfo.headPicPath}" class="img-rounded"
										id="head-pic-detail"> <label style="padding-left: 15px;">${houseInfo.nickName }</label>
							</div>
							<div class="col-md-10">
								<div class="row" id="houseinfotitle">
									${userInfo.nickName}发布了：<a href="javascript:void(0)" onclick="showHouseDetail(${houseInfo.id})"> ${houseInfo.title}</a>
									 <span class="label label-info"	style="font-size: 15px;">
									 ${houseInfo.infoType}
									 </span>
									 &nbsp&nbsp&nbsp&nbsp 发布时间 &nbsp ${houseInfo.postTime}
								</div>
								<div class="row" id="houseinfohead">
								 房屋类型： ${houseInfo.houseType}
								</div>			
							</div>
						</div>
							<hr class="featurette-divider">
						</c:forEach>
					</div>
                    </div>
					<div id="noMoreInfo"></div>
					<div class="panel-footer" style="text-align: center">
						<a href="javascript:void(0)" onclick = "showMore()">更多 </a>
					</div>

				</div>
				<div class="col-md-2"></div>
				<div class="col-md-2"></div>
			</div>
		</div>
	</div>

</body>

<script type="text/javascript" src="../js/house_info.js"></script>

<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>

<script
	src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
</html>