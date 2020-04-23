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
    
    <title>Redeem Prize</title>
    
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
	
	<script src="js/jquery-1.4.2.min.js" type="text/javascript"></script>
	<script src="js/popup.js" type="text/javascript"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
  </head>
  
  <body>
  	<div class="container-fluid">
  		<div class="row-fluid span12">
 			<div style="float: right">
		  		<form  class="form-search" action="selectprize.action" method="post">
		  			<input class="input-medium search-query" type="text" name="keyword"/>
		  			<input class="btn" type="submit" value="搜索"/>
		  		</form>
		  	</div><br>
			<div class="span10" style="margin-left: -38px;margin-top: 40px;">
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
					    			<form action="redeem.action" method="post" name="redeemprize"> 
					    				<input type="hidden" name="prize_id" value="${prize.prizeId}">
					    				<input type="hidden" name="prize_score" value="${prize.prizeScore}">
					    				<input type="button" class="btn btn-primary redeemed" name="redeem_${prize.prizeId}" value="兑换">
					    		<!--  	<a href="redeem.action?prize_id=${prize.prizeId}&prize_score=${prize.prizeScore}" class="btn btn-primary">兑换</a>-->
					            	</form>
					            </td>
				            </tr>
				        </c:forEach>
				    </tbody>
				</table>
			</div>
			<!-- 右侧信息栏 -->
			<div class="span2"  style="margin-top: 5opx;">
				<div>
					<h4 style="color: #007FCC">用户名：${profile.username}</h4>
					<h4 style="color: #007FCC" >可用积分：<span id="scoreAvailable">${profile.scoreAvailable}</span></h4>
					<h4 style="color: #007FCC">我已拥有商品</h4>
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>商品名称</th>
								<th>积分</th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var="mylist" items="${myprizelist}" varStatus="status">
							<tr>
								<td>${status.index+1}</td>
								<td>${mylist.prizeName}</td>
								<td>${mylist.prizeScore}</td>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</div>
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
    <div class="pagination pagination-right" style="margin-right: 260px">
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
	<!--<script type="text/javascript">
    	$(".redeemed").click(function(){
			var elements = $(this).attr('name').split('_');
			var score = "score_" + elements[1];
			var prizeScore = document.getElementById(score).innerHTML;
			var ascore = '${profile.scoreAvailable}';
			var a = parseInt(prizeScore) ;
			var b = parseInt(ascore);
			if( a < b ){
				document.forms["redeemprize"].submit();
			}
			else{
				alert("积分不够，不能兑换！");
			}
		});
    </script>-->
    <script type="text/javascript" src="js/redeem.js"></script>
  </body>
</html>
