<html>
    <head>
        <title>Login System</title>
        
    <style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}


input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}
</style>
    
    
    
    </head>
 	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <body>
        <%
        String email=(String)session.getAttribute("email");
        
        //redirect user to home page if already logged in
        if(email!=null){
            response.sendRedirect("FreelancerController?action=LIST");
        }
 
        String status=request.getParameter("status");
        
        if(status!=null){
        	if(status.equals("false")){
        		   out.print("Incorrect login details!");	           		
        	}
        	else{
        		out.print("Some errors occurred!");
        	}
        }
        %>
    
        <div  class="border border-success" style="width:500px;  margin: 0 auto; margin-top: 50vh; transform: translateY(-50%); border-radius:8px;">
        	<form action="loginprocess" method="post"> 
       		<div class="card">
	        	<div class="">
	        		Login
	        	</div>
	        	<div class="">
	        		 
	                    <div class="form-group">
	                    	<input type="text" name="email" required class="" placeholder="Entrer email"/>
	                    </div>
	                	<div class="form-group">
	                		<input type="password" name="password" required class="" placeholder="Entrer password"/>
	                	</div>
	        		
	        	</div>
	        	<div class="">
	        		<input type="submit" value="Login" class=""/>
	        	</div>
       		</div>
        	</form>
        </div>
    </body>
</html>