<%@ include file="includes/head"%>
<body>

	<script type="text/javascript" src="scripts/build.js"></script>

	<%@ include file="includes/navbar"%>


	<div class="container">

				<div class="instructions">
			<h2>Instructions</h2><br>
			<p>1) Drag shapes into the grid to build a rocket</p><br>
			<p>2) Click placed shapes to rotate them</p><br>
			<p>3) Hold control and click a placed shape to create a duplicate</p><br>
			<p>4) Have fun!</p>
		
		</div>
	
	<div class="build">



		<div class="build-view">
	
			
			
			<div id="grid">
			
			</div>
	
			<div id="palet">
				<img id="drag1" class="palet-item north" src="imgs/square.jpg" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag1" class="palet-item north" src="imgs/square.jpg" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag1" class="palet-item north" src="imgs/square.jpg" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag1" class="palet-item north" src="imgs/square.jpg" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag1" class="palet-item north" src="imgs/square.jpg" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag1" class="palet-item north" src="imgs/square.jpg" draggable="true" ondragstart="drag(event)" width="30" height="30"> 
				<img id="drag2" class="palet-item north" src="imgs/triangle.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag2" class="palet-item north" src="imgs/triangle.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag2" class="palet-item north" src="imgs/triangle.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag2" class="palet-item north" src="imgs/triangle.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag2" class="palet-item north" src="imgs/triangle.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag2" class="palet-item north" src="imgs/triangle.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
			</div>
			
	
		</div>

	</div>


	 <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content" style="background-color:rgba(232, 44, 44, .9)">

        <div class="modal-body">
        	
        	
        <form>
          	<div class="form-group">
							<label class="control-label" for="name">Name your rocket:</label>
							<input id="name" type="text" maxlength="50" class="form-control">
			</div>
			
		<div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">submit</button>
        </div>
		</form>
		
        </div>
      </div>
      
    </div>
  </div>

				
	<div class="button-panel" style="margin-top: 110px;">
		<button id="save" style="margin-top:220px;" class="btn btn-lg btn-primary option">Back to<br>Garage</button><br>
		<button id="back" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary option">Save</button>			
	</div>

	</div>



</body>
</html>