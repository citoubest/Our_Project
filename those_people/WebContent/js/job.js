/*
 *  this file is for job module:check format
	author:xuyingjie
 *
 */


function verifyEmailFormat(email) {
	var format = /^([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+@([a-za-z0-9]+[_|_|.]?)*[a-za-z0-9]+.[a-za-z]{2,3}$/;
	if (format.test(email)) {
		return true;
	}
	return false;
}

function verifyTelFormat(tel)
{
	var format = /(^[0-9]{3,4}\-[0-9]{7,8}$)|(^[0-9]{3,4}\)[0-9]{3,8}$)|(^0{0,1}13[0-9]{9}$)|(13\d{d}$)|(15[0135-9]\d{8}$)|(18[267]\d{8}$)/;
	if(format.test(tel))
	{
		return true;
	}
	return false;
}


function checkJobInfo()
{
		
		var jobtitle = document.getElementById("jobInfoTitle").value;
		
		var jobcompany = document.getElementById("jobCompany").value;
		var workplace = document.getElementById("workplace").value;
		
		var jobContent = document.getElementById("jobContent").value;
		var jobRequire = document.getElementById('jobRequire').value;
		var workType = document.getElementById('workType').selectedIndex;
		var email = document.getElementById('contactEmail').value;
		var tel = document.getElementById('contactTel').value;
		
		
		if (jobtitle.length == 0||jobcompany.length==0 || workplace.length == 0 || jobContent.length == 0
				|| jobRequire.length == 0 || email.lenght == 0) {
			if (jobtitle.length == 0) {
				showWarnMessage('errorJobTitle', '请填写发布信息的标题!');
			}
			
			if(jobcompany.length==0)
			{
				showWarnMessage('errorCompany', '请填写您所在公司名称!');
			}
			if (workplace.length == 0) {
				showWarnMessage('errorWorkPlace', '请填写工作地点!');
			}
			if (jobContent.length == 0) {
				showWarnMessage('errorjobContent', '请填写对工作岗位的描述!');
			}
			if (jobRequire.length == 0) {
				showWarnMessage('errorjobRequire', '请填写对求职人员的要求!');
			}
			if (email.length == 0) {
				showWarnMessage('errorContactEmail', '请您的联系方式!');
			}
			return false;
		}
		
		//check work type
		if(workType==0)
		{
			showWarnMessage('errorWorkType', '请选择工作性质!');
			return  false;
		}
		//check email format
		
		if (!verifyEmailFormat(email)) {
			showWarnMessage('errorContactEmail', "邮箱格式不正确，请您输入正确的邮箱地址!");
			return false;
		}
		//check tel format
		if(tel.length!=0 && !verifyTelFormat(tel) )
		{
			showWarnMessage('errorContactTel', "电话格式有误，请您输入正确的电话（手机或固话）!");
		
			return false;
		}

		return true;
}


function showJobDetail(jid)
{	
	var uri = "/those_people/job/showJobDetail.do?j_id="+jid;
	window.location.href=uri;
}

