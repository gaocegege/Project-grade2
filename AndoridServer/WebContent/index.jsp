<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<script src="js/jquery-1.8.3.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Test for get News</title>
</head>
<body>
	<div id="container">Hehe</div>
	<script type="text/javascript">
		setTimeout(function(){
			$.ajax({
				url : "test.action",
		        type : "get",
		        //data : "pageNum=" + pageNum,
		        dataType: "json",
		        success: function(data){
		        	document.getElementById("container").innerHTML = data.jsonContent;
		        }
		    });               
		},10000);
	</script>
</body>
</html>