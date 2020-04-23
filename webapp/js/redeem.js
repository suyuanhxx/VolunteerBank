$(document).ready(function(){
	$(".redeemed").click(function(){
		var elements = $(this).attr('name').split('_');
		var score = "score_" + elements[1];
		var prizeScore = document.getElementById(score).innerHTML;
		var ascore = document.getElementById("scoreAvailable").innerHTML;
		// alert(ascore);
		var a = parseInt(prizeScore) ;
		var b = parseInt(ascore);
		if( a <= b ){
			document.forms["redeemprize"].submit();
		}
		else{
			alert("积分不够，不能兑换！");
		}
	});
});
