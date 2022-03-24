<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="maincontrol.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

			
<link rel="stylesheet" href="../style.css">				
				
				
				
				
				<%
				PrintItems print = new PrintItems(getServletContext());
				print.printlist(request, response);
				%>
					
				
			