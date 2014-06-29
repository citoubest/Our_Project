function post_article()
{
	var v_title = document.getElementById("title").value;
	var v_content = $('#editor').html();

	$.post("/those_people/article/postArticle.do", {
		"title":v_title,
		"content":v_content
		},
		function(datas)
		{
			alert("发布成功！");
		}
	);	
}

function ajaxFileUpload()  
{  	  
	    $.ajaxFileUpload  
	    ({  
	         url:'/those_people/article/upload.do',  
	         secureuri:false,  
	         fileElementId:'fileupload',
	         dataType: 'json', 
	         success: function (data, status)  
	         {  
	        	 var  image=$("<image src="+'/those_people'+data+" />");
	         	$("#editor").append(image);
	         },  
	         error: function (data, status, e)  
	         {  
	             alert(data.status);  
	             alert(data.message+" error:  "+e);  
	         }       
	      }  
	    );
	    return false;  
}