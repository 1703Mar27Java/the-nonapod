$(document).ready(function(){
	
	
	$(".flex-item").click(function(){
		
		$("#f-layout").val($(this).find(".id").val());
		
		
		$("#levels").hide();
		if($(this).hasClass('selected')){  
			$(this).removeClass('selected');
			$("#build").hide();
			$("#view").hide();
			$("#share").hide();
			$("#destroy").hide();
			$("#new-rocket").fadeIn('slow');
		} else {
			$("#view").fadeIn('slow');
			$("#share").fadeIn('slow');
			$("#build").fadeIn('slow');
			$("#destroy").fadeIn('slow');
			$("#new-rocket").hide();
			$(this).addClass('selected').siblings().removeClass('selected');    
		}
	});
	
	$("#new-rocket").click(function(){
		$(".selected").removeClass('selected');
		$("#levels").fadeIn('slow');
		$("#destroy").hide();
		$("#build").hide();
		$("#view").hide();
		$("#share").hide();
	});
	
	
	$("#build").click(function(){
		$("#go").attr("action","rocket");
		$("#go").submit();

	});
	
	$("#easy").click(function(){
		$("#go").attr("action","newrocket");
		$("#f-layout").val(1);
		$("#go").submit();
	});
    
	$("#medium").click(function(){
		$("#go").attr("action","newrocket");
		$("#f-layout").val(2);
		$("#go").submit();
	});
	
	$("#hard").click(function(){
		$("#go").attr("action","newrocket");
		$("#f-layout").val(3);
		$("#go").submit();
	});
	
	
});
