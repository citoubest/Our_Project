<!DOCTYPE html>
<html lang="en">
<head>

 <script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
  <link href="http://netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css" rel="stylesheet">
  <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
  <link href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet">

  <!-- include summernote -->
  <link href="../css/summernote/summernote.css" rel="stylesheet">
  <script src="../js/summernote/summernote.js"></script>


</head>

<body>

<div id="summernote">
</div>
    
		
</body>
    <script>
          $(document).ready(function() {
            $('#summernote').summernote({
  minHeight: 300,                 // set editor height
  maxHeight: null,             // set maximum height of editor

});
          });
        </script>

</html>