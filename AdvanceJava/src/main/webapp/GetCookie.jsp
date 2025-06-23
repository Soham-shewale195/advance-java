<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import ="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% // Scriplet tag
	Cookie c[]=request.getCookies();
	for (Cookie c1 : c)
	{
		out.print("Cookie Name : "+c1.getName());
		out.print("<br>Cookie value : "+c1.getValue());
	}
	%>

</body>
</html>