<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Rocket Garage</title>
</head>
<body>
 
 <script type="text/javascript" src="scripts/login.js"></script>
 <div class = "container">
            <div class="wrapper">
            	<div class ="form-header">
	                <h3 class="form-signin-heading text-center" >
	                    <img src="imgs/example.ico" style="margin:30px; width:60px;height:60px;" alt=""/>
	                </h3>
	                <hr class="spartan" style="width:80%;">
                </div>
                
                 <div id="login-div">
                <form action="" method="post" class="form-signin">  
                
	                    <div class="input-group">
	                        <span class="input-group-addon" >
	                            <i class="glyphicon glyphicon-user"></i>
	                        </span>
	                       <input type="text" class="form-control" style="height:45px;" name="username" placeholder="Username" required="" autofocus="" />
	                    </div>
	                    <div class="input-group">
	                        <span class="input-group-addon">
	                            <i class="glyphicon glyphicon-lock"></i>
	                        </span>
	                       <input type="password" class="form-control" style="height:45px;" name="password" placeholder="Password" required=""/>         	  
	                    </div>
	                    <button class="btn btn-lg btn-primary btn-block"  value="login" name="login" type="Submit">Login</button>
	                    
	                    <button class="btn btn-primary btn-block" style="margin-top:20px" name="register" type="button"  value="register">Register</button>                  			
            	</form>
            </div> 
            
            <div id="register-div">
            <form method="post" action="#" class="form-signin" style="margin-top:0;">
						
						<div class="form-group">
							<label class="control-label" for="signupName">Username</label>
							<input id="signupName" type="text" maxlength="50" class="form-control">
						</div>
						<div class="form-group">
							<label class="control-label" for="signupEmail">Email</label>
							<input id="signupEmail" type="email" maxlength="50" class="form-control">
						</div>
						<div class="form-group">
							<label class="control-label" for="signupPassword">Password</label>
							<input id="signupPassword" type="password" maxlength="25" class="form-control"  length="40">
						</div>
						<div class="form-group">
							<label class="control-label" for="signupPasswordagain">Password again</label>
							<input id="signupPasswordagain" type="password" maxlength="25" class="form-control">
						</div>
						<div class="form-group">
							<button id="signupSubmit" type="submit" class="btn btn-lg btn-primary btn-block">Sign up</button>
						</div>
					<button name="cancel-register" type="button" class="btn btn-primary btn-block">Cancel</button>
					</form>
				</div>	
                
            </div>
            
</div>


</body>
</html>