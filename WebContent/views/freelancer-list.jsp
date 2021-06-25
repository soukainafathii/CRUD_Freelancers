<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Freelancer Directory</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs4/dt-1.10.20/datatables.min.css"/>
</head>
<body>
	<%
        String email=(String)session.getAttribute("email");
        
        //redirect user to login page if not logged in
        if(email==null){
        	response.sendRedirect("index.jsp");
        }
    %>
	<div class = "container">
		<div class="float-right">
			<a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
		</div>
		<h1>Freelancer Directory</h1>
		<hr/>
		
		<p>${NOTIFICATION}</p>
		
		<p>
			<button class = "btn btn-primary" onclick="window.location.href = 'views/freelancer-form.jsp'">Add Freelancer</button>
		
		</p>
	
		<table class = "table table-Primary table-bordered" id="datatable">
			<thead>
				<tr class = "thead-dark">
					<th>Nom</th>
					<th>Prenom</th>
					<th>Email</th>
					<th>nombre annees experience</th>
					<th>competences</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="freelancer">
					<tr>
						<td>${freelancer.nom}</td>
						<td>${freelancer.prenom}</td>
						<td>${freelancer.email}</td>
						<td>${freelancer.nb_annees_exp}</td>
						<td>${freelancer.competences}</td>
						<td> 
							<a href = "${pageContext.request.contextPath}/FreelancerController?action=EDIT&id=${freelancer.id}">Edit</a> 
							| 
							<a href = "${pageContext.request.contextPath}/FreelancerController?action=DELETE&id=${freelancer.id}">Delete</a> 
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>