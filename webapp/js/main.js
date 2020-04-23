
$(document).ready(function(){
	$("#cpwd").focus(function(){
		document.getElementById("tips").style.display="none";
	});
	$("#npwd").focus(function(){
		document.getElementById("retips").style.display="none";
	});
	$("#repwd").focus(function(){
		document.getElementById("retips").style.display="none";
	});
});

$('.dropdown-toggle').dropdown();

$(".comment").click(function(){
	var elements = $(this).attr('name').split('_');
	var id = "taskId_"+elements[1];
	var comment = "comment_" + elements[1];
	var taskId = document.getElementById(id).innerHTML;
	var commentd = document.getElementById(comment).value;
	if(commentd==""){
		display.style.display="none";
	}
	else
	{
		display.style.display="";
		document.getElementById("commented").innerHTML=commentd;
	}
	document.getElementById("taskId").innerHTML=taskId;
	document.getElementById("commented").innerHTML=commentd;
//	document.getElementById("taskId_hidden").innerHTML=text;
	$('#taskId_hidden').val(taskId);
});

