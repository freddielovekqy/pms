$(function(){
	$(".nav-handler").mouseover(function(){
		$(this).find("a").css("color", "#03a9f4");
	});

	$(".nav-handler").mouseleave(function(){
		$(this).find("a").css("color", "#383838");
	});
})