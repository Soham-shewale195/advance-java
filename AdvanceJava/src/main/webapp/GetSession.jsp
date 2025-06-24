<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String user=(String) session.getAttribute("user");
		out.println("Hello user"+user);
		 out.print("<br> session id : "+session.getId());
	%>
	<form action="SetSession.jsp">
		<input type="submit" value="Logout.jsp">
	</form>
</body>
</html>