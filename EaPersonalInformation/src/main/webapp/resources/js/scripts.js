//$(document).ready(function () {
//	alert('Il DOM è completo');
//});

$(document).ready(function () {
	$(".img-responsive").click(function(){
        alert("Ciao");
	});
});

//function onClickMethod(val){
//	ajaxLink('/userhome/getTags', {'tagName': val}, 'viewDiv');
//}

function onClickMethod(val,displayComponentId){
	$.post('/userhome/getTags', {'tagName': val}, function(data) {
	document.getElementById(displayComponentId).innerHTML = data + "test";
	});
}

function passwordGenCopy() {
    var x = document.getElementById("pwdGen").value;
    document.getElementById("demoP").innerHTML = "You selected: " + x;
}

//function ajaxLink(url, params, displayComponentId) {
//    $.post(url, params, function(data) {
//    	alert("url: ");
//    	document.getElementById(displayComponentId).value = data;
//    	
//    });
//}

