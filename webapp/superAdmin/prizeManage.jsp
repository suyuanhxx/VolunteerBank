<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'prizeManager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/general.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
	
	<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
	<script src="js/popup.js" type="text/javascript"></script>
	<script src="https://code.jquery.com/jquery.js"></script>
	<script src="assets/bootstrap/js/bootstrap.js"></script>
  </head>
  
  <body>
  	<!-- 头部 -->
	<div class="row-fluid span12 publishtop">
		<div class="container-fluid">
			<div style="margin-top: 2px;"><a href="return.action"><i class="icon-home icon-white"></i> Home</a></div>
			<div class="dropdown" style="float:right; margin-top: -19px;">
  				<a class="dropdown-toggle" data-toggle="dropdown" data-target="#" href="#">
					<i class="icon-user icon-white"></i> ${user.username} <i class="icon-hand-down icon-white"></i>
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="profilemanage.action?username=${user.username}"><i class="icon-user"></i> 我的简历</a></li>
					<li><a href="mytasklist.action"><i class="icon-tasks"></i> 我的任务</a></li>
					<li class="divider"></li>
					<li><a href="loginout.action"><i class="icon-key"></i> 退出</a></li>
				</ul>
			</div>
		</div>
	</div>
  	<div class="container-fluid">
  		<div class="row-fluid">
			<div class="span12">
			  	<div style="float: right">
			  		<form  class="form-search" action="selectprize.action" method="post">
			  			<input class="input-medium search-query" type="text" name="keyword"/>
			  			<input class="btn" type="submit" value="搜索"/>
			  		</form>
			  	</div><br>
   				<table class="table table-bordered table-hover">
			    	<thead>
						<tr>
				    		<th width="15%">商品编号</th>
				    		<th width="15%">商品名称</th>
				    		<th width="45%">商品图像</th>
				    		<th width="15%">商品积分</th>
				    		<th width="10%" colspan="2">操作</th>
				    	</tr>
				    </thead>
				    <tbody>
				    	<c:forEach var="prize" items="${pagination.objList}">
				    		<tr class="info">
					    		<td id="id_${prize.prizeId}">${prize.prizeId}</td>
					    		<td id="name_${prize.prizeId}">${prize.prizeName}</td>
					    		<td id="img_${prize.prizeId}"><img id="pic_${prize.prizeId}" src="getimage.action?prizeId=${prize.prizeId}" width="140" height="140"
                                onerror="javascript:this.src='image/no-image.jpg'" class="img-rounded" /></td>
					    		<td id="score_${prize.prizeId}">${prize.prizeScore}</td>
					    		<td>
					                <div>
					                	<input name="update_${prize.prizeId}"
					                		class="btn btn-small btn-primary update_" type="button" value="修改" style="float:left"/>
					                	<form action="deleteprize.action?prizeId=${prize.prizeId}" method="post" style="float:left">
					                		<input class="btn btn-small btn-danger" type="submit" value="删除" onclick='return confirm("确定要删除吗?")'/>
					                	</form>
					                </div>
					            </td>
				            </tr>
				        </c:forEach>
				        <tr class="warning">
				    		<td id="id_"></td>
				    		<td id="name_"></td>
				    		<td id="img_"></td>
				    		<td id="score_"></td>
				    		<td>
				                <div>
				                	<input name="update_"
				                		class="btn btn-small btn-info update_" type="button" value="添加" style="float:left"/>&nbsp;
				                </div>
				            </td>        
				        </tr>
				    </tbody>
				</table>
			</div>
		</div>
	</div>	
    
    <div id="popupContact">
		<div class="modal-header">
			<a id="popupContactClose">x</a>
			<h3 id="myModalLabel">
				请输入商品信息
			</h3>
		</div>
		<form id="contactArea" action="updateprize.action" method="post" enctype="multipart/form-data">
			<div class="modal-body">
				<input type="hidden" id="prizeId_edit" name="prizeId"/>
				商品名称：<br>
				<input type="text" id="prizeName_edit" name="prizeName"/>
				<br/><br/>
				商品图像：<br>
				<input type="hidden" id="prizeImg_edit" name="prizeImg"/>
				<div id="resetdiv">
					<img id="displayimage" width="140" height="140" class="img-rounded" src="image/no-image.jpg"/>
					<input id="imagefile" type="file" name="imagefile" onchange="imgChange()"/>
				</div>
				<br/><br/>
				商品积分：<br>
				<input type="text" id="prizeScore_edit" name="prizeScore"/>
				<br/><br/>
				<input class="btn btn-primary" type="submit" value="确认" style="float:right"/>
			</div>
		</form>
	</div>
	<div id="backgroundPopup"></div>
	
	<script>  
	/*** 翻页*/
	function doPage(page){  
	    var form=document.forms[0];
	    if('${pagination.currentPage}'===page){
	        return;
	    }else if("next"===page){
	        if('${pagination.currentPage}'=='${pagination.totalPage}')return;
	        form.action='<s:url />?pagination.currentPage='+(new Number('${pagination.currentPage}')+1);
	    }else if("pre"===page){
	        if('${pagination.currentPage}'==1)return;
	        form.action='<s:url />?pagination.currentPage='+(new Number('${pagination.currentPage}')-1);  
	    }else {
	        form.action='<s:url />?pagination.currentPage='+page;
	    }
	    form.submit();
	}
	</script>

	<s:if test="#request.pagination.totalPage>0">
    <div class="pagination pagination-right">
		<ul>
	        <!-- 总记录数   
	        <span>${pagination.totalRow}</span>-->  
	        <!-- 当前页/总页数   
	        <span>${pagination.currentPage}/${pagination.totalPage}</span>-->  
	        <!-- 当前页不是第一页时生成首页和上一页 -->  
	        <c:if test="${pagination.currentPage>1}">
	            <li onclick="doPage('1')">
					<a>首页</a>
	            </li>
	             <li onclick="doPage('pre')">
					<a>上一页</a>
	            </li>
	        </c:if>
	        <!-- 计算要分几次显示页码，每次显示10页 -->
	        <c:choose>
	            <c:when test="${pagination.totalPage %10 > 0}">
	                <c:set var="count" value="${pagination.totalPage/pagination.pageSize+1}" />
	            </c:when>
	            <c:otherwise>
	                <c:set var="count" value="${pagination.totalPage/pagination.pageSize}" />
	            </c:otherwise>
	        </c:choose>
	        <!-- count > 1 -->
	        <c:choose>
	            <c:when test="${count - 1 > 1}">
	                <!-- 1~10页先生成 -->
	                <label id="p_1" class="cruLabel">
		                <c:forEach var="p" begin="1" end="10">
		                    <li onclick="doPage('${p}')" <c:if test="${p==pagination.currentPage}">class='selected'</c:if>>
		                    	<a>${p}</a>
		                    </li>  
		                </c:forEach>
	                	<li onclick="doPageLabel('p_2')"><a> »</a></li>
	                </label>
	                <c:forEach var="index" begin="2" end="${count}">
		                <label id="p_${index}" class="hideLabel">
		                    <li onclick="doPageLabel('p_${index-1}')"><a>« </a></li>
		                    <c:forEach items="${pagination.pages}" var="page" begin="${(index-1)*pagination.pageSize}" end="${index*pagination.pageSize-1}">  
		                        <c:if test="${page>10}">
		                            <li onclick="doPage('${page}')" <c:if test="${page==pagination.currentPage}">class='selected'</c:if>>
		                            	<a>${page}</a>
		                            </li>  
		                        </c:if>
		                    </c:forEach>
		                    <c:if test="${count - index > 1}">
		                        <li onclick="doPageLabel('p_${index+1}')"><a> »</a></li>
		                    </c:if>
		                </label>
	                </c:forEach>
	            </c:when>
	            <c:otherwise>
	                <c:forEach items="${pagination.pages}" var="page">
	                    <li onclick="doPage('${page}')" <c:if test="${page==pagination.currentPage}">class='selected'</c:if>>
	                    	<a>${page}</a>
	                    </li>  
	                </c:forEach>
	            </c:otherwise>
	        </c:choose>
	        <!-- 当前页不是最后页时生成下一页 末页 -->
	        <c:if test="${pagination.currentPage!=pagination.totalPage}">
	            <li onclick="doPage('next')">
	            	<a>下一页</a>
	            </li>
	        	<li onclick="doPage('${pagination.totalPage}')">
	        		<a>末页</a>
	        	</li>
	        </c:if>
        </ul>
        <%--
        <span>转到</span>
        <select id="to_p">
            <c:forEach items="${pagination.pages}" var="tp">
                <option value="${tp}"
                    <c:if test="${tp eq pagination.currentPage}">  
                    selected="selected"  
                    </c:if>
                >${tp}</option>
            </c:forEach>  
        </select>
        <span>页</span>
        <span onclick="doPage(document.getElementById('to_p').value)">确定</span> --%>
    </div>
    </s:if>
  </body>
</html>
