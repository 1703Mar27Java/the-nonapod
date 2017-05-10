<%@ include file="includes/head"%>
<body>

	<script type="text/javascript" src="scripts/garage.js"></script>

	<%@ include file="includes/navbar"%>



	<div class="container">

		<div class="header">
			<h1>My Garage</h1>
		</div>

		<div class="flex-container">
			<div class="flex-item">
				<img class="flex-nail" src="imgs/sample.png">
				<div class="flex-name">My little rocket</div>
			</div>
			<div class="flex-item">
				<img class="flex-nail"
					src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQF0UU93Ob5dOiXO8xYzp-a7ptuXHvXdSN68K-BUTxZUZJqsMafKQ">
				<div class="flex-name">My little rocket</div>
			</div>
			<div class="flex-item">
				<img class="flex-nail"
					src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQF0UU93Ob5dOiXO8xYzp-a7ptuXHvXdSN68K-BUTxZUZJqsMafKQ">
				<div class="flex-name">My little rocket</div>
			</div>
			<div class="flex-item">
				<img class="flex-nail"
					src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQF0UU93Ob5dOiXO8xYzp-a7ptuXHvXdSN68K-BUTxZUZJqsMafKQ">
				<div class="flex-name">My little rocket</div>
			</div>
			<div class="flex-item">
				<img class="flex-nail"
					src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQF0UU93Ob5dOiXO8xYzp-a7ptuXHvXdSN68K-BUTxZUZJqsMafKQ">
				<div class="flex-name">My little rocket</div>
			</div>



		</div>

		<div class="button-panel">
			<button id="new-rocket" class="btn btn-lg btn-primary option">
				New<br>Rocket
			</button>
			<br>
			<button id="destroy"  style="font-size:10pt;" class="btn btn-lg btn-primary option">Destroy</button>
			<br>
			<button id="view" class="btn btn-lg btn-primary option">View</button>
			<br>
			<button id="build" class="btn btn-lg btn-primary option">Build</button>
			<br>
			<button id="share" class="btn btn-lg btn-primary option">Share</button>
			<span id="shared"></span><br>
		</div>
		<div id="levels">
			<button style="float: left; font-size: 10pt;" id="easy"
				class="btn btn-lg btn-primary option">Beginner</button>
			<br>
			<button style="float: left; font-size: 8pt;" id="medium"
				class="btn btn-lg btn-primary option">Intermediate</button>
			<br>
			<button style="float: left; font-size: 10pt;" id="hard"
				class="btn btn-lg btn-primary option">Advanced</button>
			<br>
		</div>



		<div class="modal fade" id="deleteSure" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content"
					style="background-color: rgba(232, 44, 44, .9)">

					<div class="modal-body">


						<form>
							Are you sure that you want to delete?

							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Yes</button>
								<button type="button" class="btn btn-default"
									data-dismiss="modal">No</button>
							</div>
						</form>

					</div>
				</div>

			</div>
		</div>

	</div>



</body>
</html>