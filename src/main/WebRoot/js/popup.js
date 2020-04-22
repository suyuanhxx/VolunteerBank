/***************************/
//@Author: Adrian "yEnS" Mato Gondelle
//@website: www.yensdesign.com
//@email: yensamg@gmail.com
//@license: Feel free to use it, but keep this credits please!					
/***************************/

//SETTING UP OUR POPUP
//0 means disabled; 1 means enabled;
var popupStatus = 0;

//loading popup with jQuery magic!
function loadPopup(){
	//loads popup only if it is disabled
	if(popupStatus==0){
		$("#backgroundPopup").css({
			"opacity": "0.7"
		});
		$("#backgroundPopup").fadeIn("slow");
		$("#popupContact").fadeIn("slow");
		
		popupStatus = 1;
	}
}

//disabling popup with jQuery magic!
function disablePopup(){
	//disables popup only if it is enabled
	if(popupStatus==1){
		$("#backgroundPopup").fadeOut("slow");
		$("#popupContact").fadeOut("slow");
		popupStatus = 0;
	}
}

//centering popup
function centerPopup(){
	//request data for centering
	var windowWidth = document.documentElement.clientWidth;
	var windowHeight = document.documentElement.clientHeight;
	var popupHeight = $("#popupContact").height();
	var popupWidth = $("#popupContact").width();
	//centering
	$("#popupContact").css({
		"position": "absolute",
		"top": document.documentElement.scrollTop+document.body.scrollTop+windowHeight/2-popupHeight*3/5,
		"left": windowWidth/2 - popupWidth/2
	});
	//only need force for IE6
	
	$("#backgroundPopup").css({
		"height": windowHeight
	});
	
}

//CONTROLLING EVENTS IN jQuery
$(document).ready(function(){
	//Click the button event!
	//LOADING POPUP
	/*$("#button").click(function(){
		//centering with css
		centerPopup();
		//load popup
		loadPopup();
	});*/
	$(".update_").click(function(){
		
		var elements = $(this).attr('name').split('_');
		var id = "id_"+elements[1];
		var name = "name_"+elements[1];
		var img = "pic_"+elements[1];
		var score = "score_"+elements[1];
		$('#prizeId_edit').val(document.getElementById(id).innerHTML);
		$('#prizeName_edit').val(document.getElementById(name).innerHTML);
		$('#prizeScore_edit').val(document.getElementById(score).innerHTML);
		document.getElementById("resetdiv").innerHTML='<img id="displayimage" width="140" height="140" class="img-rounded" src="image/no-image.jpg"/><input id="imagefile" type="file" name="imagefile" onchange="imgChange()"/>';
		if (id != "id_") {
			document.getElementById("displayimage").src = document.getElementById(img).src;
		}
		
		//centering with css
		centerPopup();
		//load popup
		loadPopup();
	});
				
	//CLOSING POPUP
	//Click the x event!
	$("#popupContactClose").click(function(){
		disablePopup();
	});
	//Click out event!
	$("#backgroundPopup").click(function(){
		disablePopup();
	});
	//Press Escape event!
	$(document).keypress(function(e){
		if(e.keyCode==27 && popupStatus==1){
			disablePopup();
		}
	});

});


function imgChange() {
	var pic = document.getElementById("displayimage");
    var file = document.getElementById("imagefile");
    if(window.FileReader){//chrome,firefox7+,opera,IE10,IE9，IE9也可以用滤镜来实现
        oFReader = new FileReader();
        oFReader.readAsDataURL(file.files[0]);
        oFReader.onload = function (oFREvent) {pic.src = oFREvent.target.result;};        
     }
     else if (document.all) {//IE8-
         file.select();
         var reallocalpath = document.selection.createRange().text//IE下获取实际的本地文件路径
         if (window.ie6) pic.src = reallocalpath; //IE6浏览器设置img的src为本地路径可以直接显示图片
         else { //非IE6版本的IE由于安全问题直接设置img的src无法显示本地图片，但是可以通过滤镜来实现，IE10浏览器不支持滤镜，需要用FileReader来实现，所以注意判断FileReader先
             pic.style.filter = "progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod='image',src=\"" + reallocalpath + "\")";
             pic.src = 'data:image/gif;base64,R0lGODlhAQABAIAAAP///wAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==';//设置img的src为base64编码的透明图片，要不会显示红xx
         }
     }
     else if (file.files) {//firefox6-
         if (file.files.item(0)) {
             url = file.files.item(0).getAsDataURL();
             pic.src = url;
         }
     }
}