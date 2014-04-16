<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="../css/common_body.css">
<!-[if IE]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
<![endif]->
</head>
<title>房屋信息发布</title>
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
      <div class="col-md-1"> </div>
      <div class="col-md-8">
		   <div class="panel panel-default">
		     <div class="panel-heading">
              <h3>发布房屋信息</h3>  
             </div>
			    <div class="panel-body">
			    <form action="/those_people/house/houseInfo.do" onsubmit="return checkPostHouseInfo()" method ="post">
				    <div class="input-group input-group-lg">
					    <span class="input-group-addon">标题</span>
					    <input type="text"  name="title" id="title" class="form-control" placeholder="必填内容">
				    </div>
				    <br>
					<select name="infoType"  id="infoType">
						 <option value = ''>信息类别</option>
						 <option value = '1'>出租</option>
						 <option value = '2'>求租</option>
					</select>
					<select name="houseType" id="houseType">
						 <option value = ''>房屋类型</option>
						 <option value = '1'>不限</option>
						 <option value = '2'>普通住房</option>
						 <option value = '3'>商住两用</option>
						 <option value = '4'>公寓</option>
						 <option value = '5'>别墅</option>
						 <option value = '6'>其他</option>
					 </select>
					<br>
					<h3><span class="label label-primary">信息描述（必填内容）</span></h3>
					<textarea  name = "infoDescribe"  id = "infoDescribe" class="form-control" rows="10"></textarea>
					<br>
					 
					<h3><span class="label label-danger">无图无真相(可选)</span></h3>
					 <input type="file"  name="picturePath"> 
					<br>
					
					<div class="input-group input-group-lg">
					  <span class="input-group-addon">联系方式</span>
					  <input type="text"  name="contactWay" id="contactWay"  class="form-control" placeholder="必填内容">
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
<script type="text/javascript" src="../js/house_info.js"></script>
</html>