$(document).ready(function(){
	$(".one").click(function(){
		$(this).addClass("active");
		$(".two").removeClass("active");
		$(".three").removeClass("active");
	});
});

$(document).ready(function(){
	$(".two").click(function(){
		$(this).addClass("active");
		$(".one").removeClass("active");
		$(".three").removeClass("active");
	});
});

$(document).ready(function(){
	$(".three").click(function(){
		$(this).addClass("active");
		$(".one").removeClass("active");
		$(".two").removeClass("active");
	});
});