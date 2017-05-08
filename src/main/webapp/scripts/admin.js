
$(document).ready(function(){
	
	$(".flex-item").click(function(){
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
	
	
});
