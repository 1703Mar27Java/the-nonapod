<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Rocket Garage</title>
</head>
<body>
 
 <div class = "container">
            <div class="wrapper">
                <form action="" method="post" class="form-signin"> 
                     <div class="row text-center bol"></div>
                    <h3 class="form-signin-heading text-center">
                        <img src="imgs/example.ico" style="margin:30px; width:60px;height:60px;" alt=""/>
                    </h3>
                    <hr class="spartan">
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
                    <button class="btn btn-lg btn-primary btn-block"  value="login" type="Submit">Login</button>
                    <button class="btn btn-lg btn-primary btn-block" style="margin-top:20px"  value="register" type="Submit">Register</button>   			
                </form>			
            </div>
</div>


</body>
</html>