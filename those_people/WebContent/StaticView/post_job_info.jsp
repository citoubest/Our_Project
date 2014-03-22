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
    <![endif]-> </head>
<title>工作信息发布</title>
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
   <h3>发布工作信息</h3>  
  </div>
  <div class="panel-body">
    <div class="input-group input-group-lg">
  <span class="input-group-addon">标题</span>
  <input type="text" class="form-control" placeholder="必填内容">
</div>
<br>
<div class="input-group input-group-lg">
  <span class="input-group-addon">工作地点</span>
  <input type="text" class="form-control" placeholder="必填内容">
</div>
<br>
<h3><span class="label label-primary">工作内容描述（必填内容）</span></h3>
<textarea class="form-control" rows="10"></textarea>
<br>
<h3><span class="label label-primary">应聘要求描述</span></h3>
<textarea class="form-control" rows="5"></textarea>
<br>
<select class="form-control">
  <option>工作性质</option>
  <option>实习生</option>
  <option>应届生</option>
  <option>社会招聘</option>
</select>
<br>
<div class="input-group input-group-lg">
  <span class="input-group-addon">联系方式</span>
  <input type="text" class="form-control" placeholder="必填内容">
</div>
<br>
<div class="row"> 
<div class="col-md-1"> </div>
<div class="col-md-8"> </div>
<div class="col-md-3">
  <button type="button" class="btn btn-warning btn-lg">取消</button>
  &nbsp&nbsp
<button type="button" class="btn btn-success btn-lg">发布</button>
 </div>
</div>
  </div>
</div>
      </div>
      <div class="col-md-3"> </div>
    </div>
  </div>
</body>
</html>