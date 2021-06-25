<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<style>
button {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #45a049;
}
</style>
</head>
<body>
	<div class = "container">
		<div class="float-right">
			<a href="${pageContext.request.contextPath}/logout.jsp">Logout</a>
		</div>
		<h1>Freelancer Directory</h1>
		<hr/>
		
		<div class = "border border-success"  style="width:500px;  margin: 0 auto; margin-top: 50vh; transform: translateY(-50%); border-radius:8px;">
			<div class = "">
				<form action = "${pageContext.request.contextPath}/FreelancerController" method="POST">
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "nom" placeholder = "Entrer le nom" value = "${freelancer.nom}"/>
					</div>
				
					<div class = "form-group">
						<input type = "text" class = "form-control" name = "prenom" placeholder = "Entrer le prenom" value = "${freelancer.prenom}"/>
					</div>
				
					<div class="form-group">
					  	<input type = "text" class = "form-control" name = "email" placeholder = "Entrer email" value = "${freelancer.email}"/>
					</div>
					
					<div class="form-group">
					  	<input type = "text" class = "form-control" name = "nb_annees_exp" placeholder = "Entrer nombre annees experiences" value = "${freelancer.nb_annees_exp}"/>
					</div>
					
					<div class="form-group">
					  	<input type = "text" class = "form-control" name = "competences" placeholder = "Entrer competences" value = "${freelancer.competences}"/>
					</div>
					
				
					<input type = "hidden" name = "id" value = "${freelancer.id}"/>
				
					<button type = "submit" class = "">Save</button>
				</form>
			</div>
		</div>
		<a href = "${pageContext.request.contextPath}/FreelancerController?action=LIST">Back to List</a>
	</div>
	

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>