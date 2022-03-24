<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ page import="maincontrol.*" %>
    
    <%
    	String item = (String) request.getParameter("itemToRemove");
    	RemoveItem remove = new RemoveItem(getServletContext());
    	
    	remove.remove(item);
    %>