<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="maincontrol.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To-Do</title>

<!-- Bootstrap links -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<!-- font links -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Poppins:wght@200&display=swap" rel="stylesheet">

<!-- custom css styles -->
<link rel="stylesheet" href="style.css">

<!-- icon cdn link -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
	
	<div class = "container-fluid ">
		
		<div class="row justify-content-md-center">
			<header class="d-flex justify-content-center">
				<h1>Your To-Do List</h1>
			</header>
			<form name="inputForm" class="d-flex justify-content-center">
				<input type="text" name="itemIn" class="todo-input">
				<button class="todo-button" type="submit"><i class="fas fa-plus-square"></i></button>
				
			</form>
		</div>
	
		
		<div class="todo-container">
			
			<ul class="todo-list">
			

				<jsp:include page="index_files/itemlits.jsp"></jsp:include>
				
				
			</ul>
			
		</div>
	
	</div>



	<!-- Bootstrap links -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	
	<!-- app scripts -->
	<script src="./app.js"></script>
</body>
</html>