<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<%--     <%@ page import ="com.classes.Calculator" %> --%>

 
 <!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 	<%!  // declartion tag : allocate memory 1 time only
		int a=100;
		int cube(int n)
		{
			return n*n*n;
		}
	%> 
	
	<%  // Scriplet tag
		out.print(a);
		out.print("Cube is"+cube(5));
	%>
	<%=a %>
	<%="Cube is"+cube(5) %> --%>
	
	<!-- jsp tags: -->
	
<%-- 	<jsp:include page="Login.html"></jsp>
	
	<jsp:forward page="Table.jsp"></jsp> --%>
	
	<%-- <%
		 Calculator c1=new Calculator();
		out.print(c1.cube(9));
	%> --%>
	 
	 <jsp:useBean class="com.classes.Calculator" id="c1"></jsp:useBean> <!-- we can import function and methods using this tag -->
	<%
		out.print(c1.cube(10));
	%>
</body>
</html>