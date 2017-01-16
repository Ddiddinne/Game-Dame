<%@ page import="org.isen.dame.webapp.ShowServlet" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css"/>
	<script type="text/javascript" src="jquery.1.8.3.min.js"></script>
</head>
<body>

<h1>Play</h1>
<div id="board"></div>
</body>

<script type="text/javascript">
	$(document).ready(function(e) {
	for(var i=1; i<=10;i++){

		var str="<div>";
		for(var y=1; y<=10; y++){
		    if((y+i)%2==0){
		    str+="<div class='case brown'></div>";
		    }else{
		    str+="<div class='case white'></div>";
		    }

		}
		str+="</div>"
		$("#board").append(str);
		str="";
    }

		
	});
</script>
</html>