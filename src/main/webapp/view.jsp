<%@ include file="includes/head"%>
<body>

	<script type="text/javascript" src="scripts/view.js"></script>

	<%@ include file="includes/navbar"%>



	<div class="container">

		<div class="rocket-header">
			<h2>Robert: My little rocket</h2>
		</div>

			<div class="rocket-view">
			<span style="float:right; margin-top:10px; font-size:15pt; color:#f9171d;" class="glyphicon glyphicon-thumbs-down">&nbsp;30&nbsp;</span> 				
			<span style="float:right; margin-top:10px; font-size:15pt; color:#15ce12; " class="glyphicon glyphicon-thumbs-up">&nbsp;50&nbsp;</span>
			<img style="width:700px;height:500px;margin:25px;margin-left:50px;">
			
			
			<div class="rocket-comments">
							<div class="comment">
								<div class="comment-body">
								DESU<br>
								DESU<br>
								DESU<br>
								DESU<br><br>
								DESU<br>
								DESU<br><br>
								DESU<br>
								DESU
								DESU
								</div>
								<div class ="comment-header">
								username @ timestamp
								</div>
							</div>

						
						<div class ="new-comment">
							<textarea style="resize: none;font-size:18pt; margin-left: 5px; margin-top: 5px; background-color:rgba(2, 1, 58, .7);" rows="4" cols="62">At w3schools.com you will learn how to make a website. We offer free tutorials in all web development technologies. 
						</textarea>
						<button style="width:120px; margin:10px;float:right;" class="btn btn-primary">Submit</button>
						</div>			
			</div> 					
			</div>
			
						
			<div style="width:10px;" class="button-panel">
				<button id="like" class="btn btn-lg btn-primary option"><span class="glyphicon glyphicon-thumbs-up"></span></button><br>
				<button id="dislike" class="btn btn-lg btn-primary option"><span class="glyphicon glyphicon-thumbs-down"></span></button><br>
				<button id="flag" class="btn btn-lg btn-primary option"><span class="glyphicon glyphicon-flag"></span></button><br>
			</div>
					
	</div>



</body>
</html>