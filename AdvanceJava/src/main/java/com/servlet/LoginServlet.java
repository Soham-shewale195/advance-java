package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet
{
	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		System.out.println("service");
		PrintWriter out=res.getWriter();
		
		String user = req.getParameter("txtuser");
		String pass = req.getParameter("txtpass");
		
		if(user.equals(pass))
		{
			out.println("<h1> Login Succesfully</h1>");
		}
		else
		{
			out.println("Login fail");
		}

	}
//	@Override
//	public void destroy() 
//	{
//		System.out.println("destroy");
//
//	}
	

}
