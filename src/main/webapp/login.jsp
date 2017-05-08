<%@ include file="includes/head"%>


<body>
 
 <script type="text/javascript" src="scripts/login.js"></script>
 <div class = "container">
            <div class="wrapper">
            	<div class ="form-header" >
	                <h3 class="form-signin-heading text-center" style="color:white; font-size:30pt;" >
	                <img src="imgs/logo.png" style="width:120px;height:120px;" alt=""/>                	
	                    <img id ="rocket" src="imgs/example.png" style="position:absolute;width:60px;height:60px;" alt=""/>
	                </h3>
	                  <h3 class="form-signin-heading text-center" style="color:white; font-size:30pt;" >
	                	Rocket Garage
	                </h3>
	                <hr class="spartan" style="width:80%;">
                </div>
                
                 <div id="login-div">
                <form action="" method="post" class="form-signin">  
                
	                    <div class="input-group">
	                        <span class="input-group-addon" >
	                            <i class="glyphicon glyphicon-user"></i>
	                        </span>
	                       <input type="text" class="form-control" style="height:45px;" name="username" placeholder="Username" required="" />
	                    </div>
	                    <div class="input-group">
	                        <span class="input-group-addon">
	                            <i class="glyphicon glyphicon-lock"></i>
	                        </span>
	                       <input type="password" class="form-control" style="height:47px;" name="password" placeholder="Password" required=""/>         	  
	                    </div>
	                    <button class="btn asd btn-lg btn-primary btn-block"  value="login" name="login" type="Submit">Login</button>
	                    
	                    <button class="btn btn-primary btn-block" style="margin-top:20px" name="register" type="button"  value="register">Register</button>
	                                      			
            	</form>
            </div> 
            
            <div id="register-div">
            <form method="post" action="#" class="form-signin" style="margin-top:0;">
						
						<div class="form-group">
							<label class="control-label" for="signupName">Username</label><span style="color:red;">&nbsp;&nbsp;&nbsp; Error</span>
							<input id="signupName" type="text" maxlength="50" class="form-control">
						</div>
						<div class="form-group">
							<label class="control-label" for="signupEmail">Email</label><span style="color:red;">&nbsp;&nbsp;&nbsp; Error</span>
							<input id="signupEmail" type="email" maxlength="50" class="form-control">
						</div>
						<div class="form-group">
							<label class="control-label" for="signupPassword">Password</label><span style="color:red;">&nbsp;&nbsp;&nbsp; Error</span>
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