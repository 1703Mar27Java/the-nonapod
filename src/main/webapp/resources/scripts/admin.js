

$(document).ready(function(){
	
	$(".flex-item").click(function(){
		
		$("#f-layout").val($(this).find(".flaggedId").val());
		
		if($(this).hasClass('selected')){  
			$(this).removeClass('selected');
			$("#delete").fadeOut('slow');
			$("#unflag").fadeOut('slow');
		} else {
			$("#delete").fadeIn('slow');
			$("#unflag").fadeIn('slow');
			$(this).addClass('selected').siblings().removeClass('selected');    
		}
	});
	
	
	$("#deleteFlagged").click(function(){
		
		remove = $(".selected");
		
		$.ajax({
            type: 'post',
            url: 'removeRocket',
            data: { 
              'id' : $("#f-layout").val()
            },
            success: function (response) {
            	
			remove.remove();
			$("#delete").hide();
			$("#unflag").hide();
      	
            },
            error: function (response) {

            	console.log("nay");
            	
            }
            
            
         }); 
			
	});
	
	
	$("#removeFlag").click(function(){
		
		remove = $(".selected");
		
		$.ajax({
            type: 'post',
            url: 'removeFlag',
            data: { 
              'id' : $("#f-layout").val()
            },
            success: function (response) {
            	
			remove.remove();
			$("#delete").hide();
			$("#unflag").hide();
      	
            },
            error: function (response) {

            	console.log("neigh");
            	
            }       
         }); 		
	});
	
	
	$('button[name="deleteButton"]').click(function(){
		
		$.ajax({
			type: 'post',
			url: 'deleteUser',
			data: {
				'userDeleteId' : $(this).prev().val()
			},
			success: function(response){
				
				$(this).closest("tr").remove();
			},
			
			error: function(response){
				
				console.log("nein");
			}
		});
		
	});
	
	
	
});
