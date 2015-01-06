$(function() {
	$("span.menu").click(function(){
		$(".top-nav-left ul").slideToggle(500, function(){
		});
	});
	$(".scroll").click(function(event){		
		event.preventDefault();
		$('html,body').animate({scrollTop:$(this.hash).offset().top},1000);
	});
});