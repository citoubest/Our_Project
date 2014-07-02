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

<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
<link
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="http://netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"
	rel="stylesheet">

<link rel="stylesheet" type="text/css"
	href="../css/summernote/summernote.css" />
<script src="../js/summernote/summernote.js"></script>
</head>


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



					<div id="summernote"></div>



					<br>
					<div class="row">
						<div class="col-md-1">
							<button type="button" class="btn btn-default btn-lg">取消</button>
						</div>
						<div class="col-md-9"></div>
						<div class="col-md-1">
							<button type="button" id="btn_post"
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

<script src="../js/post_article.js"></script>
</html>