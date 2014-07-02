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
<link rel="stylesheet" type="text/css" href="../css/editor.css">


<link href="../ueditor/themes/default/css/umeditor.css" type="text/css"
	rel="stylesheet">
<script type="text/javascript" src="../ueditor/jquery.min.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../ueditor/umeditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="../ueditor/umeditor.js"></script>



<link
	href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css"
	rel="stylesheet">


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
			<!--start placeholder-->
			<div class="col-md-1"></div>
			<!--end placeholder-->
			<div class="col-md-7">

				<div class="jumbotron">
					标题 (必填)<input type="text" id="title" class="form-control">
					<br> 内容

					<!--------------------ueditor------------------------------------------------ -->
					<script  type="text/plain"  id="myEditor" ></script>
					<!--------------------end of ueditor------------------------------------------------ -->


					<br>
					<div class="row">
						<div class="col-md-1">
							<button type="button" class="btn btn-default btn-lg">取消</button>
						</div>
						<div class="col-md-9"></div>
						<div class="col-md-1">
							<button type="button" id="btn_post"
								onclick="javascript:post_article()"
								class="btn btn-success btn-lg">发布</button>
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
									<span class="glyphicon glyphicon-edit"></span> 文章（5）
								</h3>
							</td>
						</tr>
						<tr>
							<td>
								<h3>
									<span class="glyphicon glyphicon-bullhorn"></span> 发布信息
								</h3> <br>
								<h4>
									<a href="../StaticView/post_job_info.html">房屋信息</a>
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
			<!--start placeholder-->
			<div class="col-md-2"></div>
			<!--end placeholder-->
		</div>
	</div>

	<div id="fb-root"></div>
</body>

<script type="text/javascript">
    var um = UM.getEditor('myEditor');
</script>

</html>