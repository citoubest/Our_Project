
$(document).ready(function()
		{
	$('#summernote').summernote({
		lang: 'zh-CN',
		codemirror: { // codemirror options  
		    theme: 'monokai'  
		  },  
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
		success: function(imgurl) {
			
			imgurl='/those_people'+imgurl;
			editor.insertImage(welEditable, imgurl);
		}
	});
}

function post_article()
{
	var v_title = document.getElementById("title").value;

	
	var v_content =$('#summernote').code();

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
