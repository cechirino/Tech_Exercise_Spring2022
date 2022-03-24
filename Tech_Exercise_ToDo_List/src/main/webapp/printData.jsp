<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page import="maincontrol.*" %>
    
   <%
			PrintItems print = new PrintItems(getServletContext());
			print.printlist(request, response);
				
	%>