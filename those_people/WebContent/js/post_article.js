
$(document).ready(function()
		{
	$('#summernote').summernote({    
		height:300,
		toolbar: [
		          ['style', ['bold', 'italic', 'underline','strikethrough']],
		          ['para', ['ul', 'ol']],
		          ['picture',['picture']],
		          ['link',['link']],
		          ['hr',['hr']],
		          ['codeview',['codeview']],
		          ['fullscreen',['fullscreen']],
		          ],
		          onImageUpload: function(files, editor, $editable) {
		        	  sendFile(files[0],editor,$editable);

		          }
	});
		});




function sendFile(file,editor,welEditable) {

	var data = new FormData();
	data.append("file",file);
	$.ajax({
		data:data,
		dataType:'text',
		type: "POST",
		url: "/those_people/article/upload.do",
		cache: false,
		processData: false,
	    contentType: false,
		success: function(url) {
			editor.insertImage(welEditable, url);
		}
	});
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
