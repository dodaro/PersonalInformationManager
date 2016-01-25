//$(document).ready(function () {
//	$(".img-responsive").click(function(){
//        alert("Ciao");
//	});
//});

$(document).ready(function () {
	$("#pwdGen").change(function(){          
	    var value = $("#pwdGen option:selected").val();
	    if ((value === '0') || (value === '1') || (value === '2') || (value === '3')){
	    	$("#word1").prop('disabled', true);
	    	$("#word2").prop('disabled', true);
	    	return;
	    }
	    if (value === '4') {
	    	$("#word1").prop('disabled', false);
	    	$("#word2").prop('disabled', false);
	    }
	});
});



