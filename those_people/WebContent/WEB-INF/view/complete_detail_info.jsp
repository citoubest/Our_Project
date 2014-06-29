<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" type="text/css" href="../css/common_body.css">
<link rel="stylesheet" type="text/css" href="../css/imgSelector/imgareaselect-default.css">


</head>
<title>title</title>
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
				<div class="panel panel-success">
					<div class="panel-heading">
						<h4>恭喜您已经成功注册！完善一下您的信息吧！以便我们更快的帮您找到组织。</h4>
					</div>
					<div class="panel-body">
						<table class="table">
							<tbody id="user_info_detail">
								<tr>
									<td colspan="4"
										style="padding-top: 50px; padding-bottom: 40px;">${realName}</td>
								</tr>
								<tr>
									<td>头像 </td>
									<td><img id="headerpic" src="../img/head-pic/headpic_default.jpg"
										alt="..." class="img-thumbnail" style="width:120px;height:120px"></td>
									<td>
										<div style="position: relative;">
										<form action="/those_people/register/handle_head_pic.do" id="headpictoupload" target="iframupload" method="post" enctype="multipart/form-data">
											<a class='btn btn-primary' href='javascript:;'> 选择头像 <input
												type="file" id="headpicfile"
												style='position: absolute; z-index: 2; top: 0; left: 0; filter: alpha(opacity = 0); -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)"; opacity: 0; background-color: transparent; color: transparent;'
												name="file_source" onchange="preview(this)" size="40">
											</a>
											<br>
											支持 JPG、PNG、GIF 格式，不要超过 2M 。
											<input type="hidden" name="x" id="picx">
											<input type="hidden" name="y" id="picy">
											<input type="hidden" name="width" id="picwid">
											<input type="hidden" name="height" id="pichei">
										</form>
										<iframe name="iframupload" style="display: none"></iframe>
										</div>
									</td>
									<td></td>
								</tr>
								<form action="/those_people/register/completeDetailInfo.do">
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">性別(必填)</td>
									<td style="padding-top: 50px; padding-bottom: 40px;">
									<input name="gender"type="radio" value="0">男
									</td>
									<td style="padding-top: 50px; padding-bottom: 40px;">
									<input name="gender" value="1"type="radio">女
									</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">教育经历</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										type="text" name="school" class="form-control" placeholder="学校">（必填）</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										type="text" name="major" class="form-control" placeholder="专业"></td>
									<td style="padding-top: 50px; padding-bottom: 40px;"></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">入学时间（必填）</td>
									<td style="padding-top: 50px; padding-bottom: 40px;">
									<select name="enrollmentDate">
											<option value="2014">2014</option>
											<option value="2013">2013</option>
											<option value="2012">2012</option>
											<option value="2011">2011</option>
											<option value="2010">2010</option>
											<option value="2009">2009</option>
											<option value="2008">2008</option>
											<option value="2007">2007</option>
											<option value="2006">2006</option>
											<option value="2005">2005</option>
											<option value="2004">2004</option>
											<option value="2003">2003</option>
											<option value="2002">2002</option>
											<option value="2001">2001</option>
											<option value="2000">2000</option>
											<option value="1999">1999</option>
											<option value="1998">1998</option>
											<option value="1997">1997</option>
											<option value="1996">1996</option>
											<option value="1995">1995</option>
											<option value="1994">1994</option>
											<option value="1993">1993</option>
											<option value="1992">1992</option>
											<option value="1991">1991</option>
											<option value="1990">1990</option>
											<option value="1989">1989</option>
											<option value="1988">1988</option>
											<option value="1987">1987</option>
											<option value="1986">1986</option>
											<option value="1985">1985</option>
											<option value="1984">1984</option>
											<option value="1983">1983</option>
											<option value="1982">1982</option>
											<option value="1981">1981</option>
											<option value="1980">1980</option>
											<option value="1979">1979</option>
											<option value="1978">1978</option>
											<option value="1977">1977</option>
											<option value="1976">1976</option>
											<option value="1975">1975</option>
											<option value="1974">1974</option>
											<option value="1973">1973</option>
											<option value="1972">1972</option>
											<option value="1971">1971</option>
											<option value="1970">1970</option>
									</select> 年
									</td>
									<td colspan="2"
										style="padding-top: 50px; padding-bottom: 40px;"></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">职业经历</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										type="text" name="company" class="form-control" placeholder="公司或组织"></td>
									<td colspan="2"
										style="padding-top: 50px; padding-bottom: 40px;"></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">居住地（必填）</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										type="text" name="city" class="form-control" placeholder="目前居住地"></td>
									<td colspan="2"
										style="padding-top: 50px; padding-bottom: 40px;"></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">写一句性感的签名呗</td>
									<td colspan="2"
										style="padding-top: 50px; padding-bottom: 40px;"><textarea
										 name="signature"	class="form-control" rows="5" cols="20"></textarea></td>
									<td style="padding-top: 50px; padding-bottom: 40px;"></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;">实名或匿名显示（必填）</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
										name="showType" value="0" type="radio">匿名</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"><input
									name="showType" value="1" type="radio">实名</td>
									<td colspan="2"></td>
								</tr>
								<tr>
									<td style="padding-top: 50px; padding-bottom: 40px;"></td>
									<td style="padding-top: 50px; padding-bottom: 40px;">
										<button type="submit" class="btn btn-primary btn-lg">保存设置</button>
									</td>
									<td style="padding-top: 50px; padding-bottom: 40px;"></td>
									<td style="padding-top: 50px; padding-bottom: 40px;"></td>
								</tr>
								</form>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	<div class="modal fade" id="uploadHeadPicModal" data-backdrop="static">
		<div class="modal-dialog" style="heigth: 400px; width: 350px">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">编辑头像</h4>
				</div>
				<div id="preview" class="modal-body"></div>
				<div class="modal-footer">
					<button type="button"  onclick="checkUploadAndSubmit()" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript"
	src="../js/imgSelector/jquery.imgareaselect.pack.js"></script>
	<script type="text/javascript" src="../js/uploadheadpic.js"></script>
</html>