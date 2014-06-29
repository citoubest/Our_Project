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
					<div class="btn-toolbar" data-role="editor-toolbar"
						data-target="#editor">
						<div class="btn-group">
							<a class="btn btn-default" data-edit="bold" title="加粗"> <i
								class="icon-bold"></i>
							</a> <a class="btn btn-default" data-edit="italic" title="斜体"> <i
								class="icon-italic"></i>
							</a> <a class="btn btn-default" data-edit="strikethrough" title="删除线">
								<i class="icon-strikethrough"></i>
							</a> <a class="btn btn-default" data-edit="underline" title="下划线"><i
								class="icon-underline"></i></a>
						</div>
						<div class="btn-group">
							<a class="btn btn-default" data-edit="insertunorderedlist"
								title="无序列表"><i class="icon-list-ul"></i></a> <a
								class="btn btn-default" data-edit="insertorderedlist"
								title="有序列表"><i class="icon-list-ol"></i></a>
						</div>
						<div class="btn-group">
							<a class="btn btn-default" data-edit="justifyleft" title="左对齐"><i
								class="icon-align-left"></i></a> <a class="btn btn-default"
								data-edit="justifycenter" title="居中"><i
								class="icon-align-center"></i></a> <a class="btn btn-default"
								data-edit="justifyright" title="右对齐"><i
								class="icon-align-right"></i></a>
						</div>
						<div class="btn-group">
							<a class="btn btn-default" data-toggle="dropdown" title="超链接"><i
								class="icon-link"></i></a>
							<div class="dropdown-menu input-append ">
								<input class="span2" placeholder="URL" type="text"
									data-edit="createLink" />
								<button class="btn btn-default" type="button">增加</button>
							</div>
						</div>
						<div class="btn-group">

							<a  href="#myModal" class="btn btn-default" title="图片（可直接拖拽）" id="pictureBtn" target="btn" data-toggle="modal"><i class="icon-picture"></i></a> 
				
							<div id="myModal" class="modal">  
								<span style="white-space:pre"></span>
								<div class="modal-header">  
								    <span style="white-space:pre">  </span><span class="btn btn-success fileinput-button"> <i class="icon-plus"></i> <span>Add files...</span>  
								        <span style="white-space:pre">  </span>
								        <input id="fileupload"  type="file" name="fileupload" onchange="ajaxFileUpload()" />  
								    <span style="white-space:pre">  </span></span>  
								</div>  
							</div>  
						
						</div>
						<div class="btn-group">
							<a class="btn btn-default" data-edit="undo" title="撤销"><i
								class="icon-undo"></i></a> <a class="btn btn-default"
								data-edit="redo" title="恢复"><i class="icon-repeat"></i></a>
						</div>
					</div>


					<div id="editor">
					
					</div>

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
	<script>
		$(function() {
			function initToolbarBootstrapBindings() {
				$('a[title]').tooltip({
					container : 'body'
				});
				$('.dropdown-menu input').click(function() {
					return false;
				}).change(
						function() {
							$(this).parent('.dropdown-menu').siblings(
									'.dropdown-toggle').dropdown('toggle');
						}).keydown('esc', function() {
					this.value = '';
					$(this).change();
				});

				$('[data-role=magic-overlay]').each(
						//picture
						function() {
							var overlay = $(this), target = $(overlay
									.data('target'));
							overlay.css('opacity', 0).css('position',
									'absolute').offset(target.offset()).width(
									target.outerWidth()).height(
									target.outerHeight());
						});
				if ("onwebkitspeechchange" in document.createElement("input")) {
					var editorOffset = $('#editor').offset();
					$('#voiceBtn').css('position', 'absolute').offset(
							{
								top : editorOffset.top,
								left : editorOffset.left
										+ $('#editor').innerWidth() - 35
							});
				} else {
					$('#voiceBtn').hide();
				}
			}
			;
			function showErrorAlert(reason, detail) {
				var msg = '';
				if (reason === 'unsupported-file-type') {
					msg = "Unsupported format " + detail;
				} else {
					console.log("error uploading file", reason, detail);
				}
				$(
						'<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>'
								+ '<strong>File upload error</strong> '
								+ msg
								+ ' </div>').prependTo('#alerts');
			}
			;
			initToolbarBootstrapBindings();
			$('#editor').wysiwyg({
				fileUploadError : showErrorAlert
			});
			window.prettyPrint && prettyPrint();
		});
	</script>
	<div id="fb-root"></div>
</body>
<script src="../js/editor/bootstrap-wysiwyg.js"></script>
<script src="../js/editor/jquery.hotkeys.js"></script>
<script src="../js/ajaxfileupload.js"></script>
<script src="../js/post_article.js"></script>
</html>