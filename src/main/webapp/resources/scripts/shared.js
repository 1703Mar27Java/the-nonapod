$(document).ready(function(){
	
	
	$(".flex-item").click(function(){
		if($(this).hasClass('selected')){  
			$(this).removeClass('selected');
			$("#view-s").fadeOut('slow');
			$("#send").fadeOut('slow');
		} else {
			$("#view-s").fadeIn('slow');
			$("#send").fadeIn('slow');
			$(this).addClass('selected').siblings().removeClass('selected');    
		}
	});
	
    
	
	
});