<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="../css/common_body.css">

</head>
<title>工作信息发布</title>
</head>
<jsp:include page="/WEB-INF/view/header.jsp" />
 
<body id="common_body" >
	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-8">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3>发布工作信息</h3>
					</div>
					
					<form action="/those_people/job/postJobInfo.do" 
						onsubmit="return checkJobInfo()" method="post">
						
						<input type="hidden" id ="uid" name="uid" value="${userInfo.uid}" />
						
						<div class="panel-body">

							<div class="alert alert-danger" id="errorJobTitle"
								style="display: none"></div>
							<div class="input-group input-group-lg">
								<span class="input-group-addon">标题</span> <input type="text"
									id="jobInfoTitle" name="jobInfoTitle" class="form-control" placeholder="必填内容">
							</div>
							<br>
							
							
							<div class="alert alert-danger" id="errorCompany"
								style="display: none"></div>
							<div class="input-group input-group-lg">
								<span class="input-group-addon">公司</span> <input type="text"
									id="jobCompany" name="jobCompany" class="form-control" placeholder="必填内容">
							</div>
							<br>
							
							
							<div class="alert alert-danger" id="errorWorkPlace"
								style="display: none"></div>

							<div class="input-group input-group-lg">
								<span class="input-group-addon">工作地点</span> <input type="text"
									id="workplace" name = "workplace" class="form-control" placeholder="必填内容">
							</div>
							<br>

							<h3>
								<span class="label label-primary">工作内容描述（必填内容）</span>
							</h3>
							<div class="alert alert-danger" id="errorjobContent"
								style="display: none"></div>
							<textarea class="form-control" id="jobContent" name="jobContent" rows="10"></textarea>
							<br>
							<h3>
								<span class="label label-primary">应聘要求描述</span>
							</h3>
							<div class="alert alert-danger" id="errorjobRequire"
								style="display: none"></div>
							<textarea class="form-control" id="jobRequire" name="jobRequire" rows="5"></textarea>


							<br>

							<div class="alert alert-danger" id="errorWorkType"
								style="display: none"></div>

							<select class="form-control" name="jobType" id="workType" >
								<option value="0">工作性质</option>
								<option value="1">实习生</option>
								<option value="2">应届生</option>
								<option value="3">社会招聘</option>
							</select> <br>

							<div class="input-group input-group-lg">
								<h3>
									<span class="label label-primary">联系方式</span>
								</h3>
								<div class="input-group input-group-lg">

									<div class="alert alert-danger" id="errorContactEmail"
										style="display: none"></div>
									<div class="input-group input-group-lg">
										<span class="input-group-addon">邮箱</span> <input type="text"
											id="contactEmail" name= "contactEmail" class="form-control" placeholder="必填内容">
									</div>
									<br>
									<div class="alert alert-danger" id="errorContactTel"
											style="display: none"></div>
									<div class="input-group input-group-lg">
										<span class="input-group-addon">电话</span> <input type="text"
											id="contactTel" name= "contactTel" class="form-control">
									</div>
								</div>
							</div>
							<br>
							<div class="row">
								<div class="col-md-1"></div>
								<div class="col-md-8"></div>
								<div class="col-md-3">
									<button type="reset" class="btn btn-warning btn-lg">取消</button>
									&nbsp&nbsp
									<button type="submit" class="btn btn-success btn-lg">发布</button>
								</div>
							</div>
						</div>

					</form>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
</body>

<script src="http://cdn.bootcss.com/jquery/1.10.2/jquery.min.js"></script>
<script
	src="http://cdn.bootcss.com/twitter-bootstrap/3.0.3/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/job.js">
	
</script>
</html>