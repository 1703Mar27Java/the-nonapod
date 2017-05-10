<%@ include file="includes/head"%>
<body>

	<script type="text/javascript" src="scripts/build.js"></script>
	<script type="text/javascript" src="scripts/html2canvas.js"></script>
	<script type="text/javascript" src="scripts/FileSaver.min.js"></script>

	<%@ include file="includes/navbar"%>


	<div class="container">

				<div class="instructions">
			<h2>Instructions</h2><br>
			<p>1) Drag shapes into the grid to build a rocket</p><br>
			<p>2) Click placed shapes to rotate them</p><br>
			<p>3) Drag a placed shape to create a duplicate</p><br>
			<p>4) Hold Ctrl and drag a placed shape to move it</p><br>
			<p>5) Click a tile and press the Delete key to delete a shape
			<p>6) Have fun!</p>
		
		</div>
	
	<div class="build">



		<div class="build-view">
	
			
			
			<div id="grid">
			
			</div>
	
			<div id="palet">
				<img id="drag1" class="palet-item north" src="imgs/shapes/blackSquare.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag3" class="palet-item north" src="imgs/shapes/blueSquare.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag5" class="palet-item north" src="imgs/shapes/graySquare.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag7" class="palet-item north" src="imgs/shapes/greenSquare.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag9" class="palet-item north" src="imgs/shapes/magentaSquare.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag11" class="palet-item north" src="imgs/shapes/orangeSquare.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag13" class="palet-item north" src="imgs/shapes/pinkSquare.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag15" class="palet-item north" src="imgs/shapes/redSquare.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag17" class="palet-item north" src="imgs/shapes/white.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag19" class="palet-item north" src="imgs/shapes/yellowSquare.png" draggable="true" ondragstart="drag(event)" width="30" height="30"><br>
				<img id="drag2" class="palet-item north" src="imgs/shapes/blackTri.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag4" class="palet-item north" src="imgs/shapes/blueTri.png" draggable="true" ondragstart="drag(event)" width="30" height="30">			
				<img id="drag6" class="palet-item north" src="imgs/shapes/grayTri.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag8" class="palet-item north" src="imgs/shapes/greenTri.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag10" class="palet-item north" src="imgs/shapes/mengentaTri.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag12" class="palet-item north" src="imgs/shapes/orangeTri.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag14" class="palet-item north" src="imgs/shapes/pinkTri.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag16" class="palet-item north" src="imgs/shapes/redTri.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag18" class="palet-item north" src="imgs/shapes/whiteTri.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				<img id="drag20" class="palet-item north" src="imgs/shapes/yellowTri.png" draggable="true" ondragstart="drag(event)" width="30" height="30">
				
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
          <button type="button" id="saveSub" class="btn btn-default" data-dismiss="modal">submit</button>
        </div>
		</form>
		
        </div>
      </div>
      
    </div>
  </div>

				
	<div class="button-panel" style="float:right;margin-top: 110px;">
		<button id="back" style="margin-top:220px;" class="btn btn-lg btn-primary option">Back to<br>Garage</button><br>
		<button id="save" data-toggle="modal" data-target="#myModal" class="btn btn-lg btn-primary option">Save</button>			
	</div>

	</div>



</body>
</html>