$(document).ready(function(){
	
	
	$(".flex-item").click(function(){
		$("#levels").hide();
		if($(this).hasClass('selected')){  
			$(this).removeClass('selected');
			$("#build").fadeOut('slow');
			$("#view").fadeOut('slow');
			$("#share").fadeOut('slow');
		} else {
			$("#view").fadeIn('slow');
			$("#share").fadeIn('slow');
			$("#build").fadeIn('slow');
			$(this).addClass('selected').siblings().removeClass('selected');    
		}
	});
	
	$("#new-rocket").click(function(){
		$(".selected").removeClass('selected');
		$("#levels").fadeIn('slow');
		$("#build").hide();
		$("#view").hide();
		$("#share").hide();
	});
	
	
    
	
	
});
