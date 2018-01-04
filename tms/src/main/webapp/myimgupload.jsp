<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false" %>
<!DOCTYPE html >
<html>
<head>
	<meta charset="utf-8" />
	<title></title>
	<script src="/js/jquery-1.8.3.js" type="text/javascript"></script>
</head>
<body>
<script>
    $(document).ready(function () {
        $("#inputs").change(function () {
            var fil = this.files;
            for (var i = 0; i < fil.length; i++) {
                reads(fil[i]);
            }
        });
    });
    function reads(fil){
        var reader = new FileReader();
        reader.readAsDataURL(fil);
        reader.onload = function()
        {
            document.getElementById("dd").innerHTML += "<img src='"+reader.result+"'>";
        };
    }
</script>
</body>
  <form method="post" action="/user/add"  enctype="multipart/form-data" >
	  <input type="file"  name="image_url" id="inputs"/>文件上传
	  <div id='dd'></div>
	  <input type="submit">
  </form>
<html>