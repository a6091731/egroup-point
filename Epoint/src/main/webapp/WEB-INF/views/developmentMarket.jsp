<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="zh-tw">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 	<meta name="description" content="創業-支出結構-規畫你的創業第一年支出-創業e點通">  
	<title>支出結構-規畫你的創業第一年支出-創業e點通</title>

	<!-- reset.css -->
	<link rel="stylesheet" href="css/reset.css" media="screen">
	<!-- font-awesome.min.css -->
	<link rel="stylesheet" href="css/font-awesome.min.css" media="screen">
	<!-- grid1200 -->
	<link rel="stylesheet" href="css/skeleton.css">
	<!-- style -->
	<link rel="stylesheet" href="css/style.css">
	<!-- layout -->
	<link rel="stylesheet" href="css/layout.css">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn’t work if you view the page via file:// -->
    
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<header class="topheader clearfix">
		<div class="container">
			<div class="grid_12">
				<div class="logo">
					<a href="index.html"><img src="./images/egroup.png" alt="創業e點通品牌標誌"></a>
				</div><!-- logo -->
				<nav class="clearfix">
					<div class="top-nav">
						<div class="top-nav-right">
							<a href="javascript:;" id="loginButton"><span>創業地圖</span></a>
						</div>
					</div><!-- top-nav -->
				</nav>
			</div><!-- grid_12 -->
		</div><!-- container -->
	</header>
	<div class="wrapper">
		<div class="container">
			<div class="grid_12">
				<div class="banner">
					<div class="imgHolder"><img src="images/banner-office.jpg" alt="banner圖片-辦公室"></div>
				</div>
				<div class="breadcrumbs">
            		<p><a href="index.html">首頁</a> &gt; <a href="#">創業地圖</a> &gt; <a href="#">創業第一年營運排程地圖</a> &gt; <span>支出結構</span></p>
	            </div>
			</div>
			<div class="grid_3">
				<aside>
					<ul class="sideNav hideBlock">
						<li><a href="javascript:;"><i class="fa fa-child"></i>公司成立</a></li>
						<li><a href="javascript:;"><i class="fa fa-child"></i>營業場所完工</a></li>
						<li><a href="javascript:;"><i class="fa fa-child"></i>人員到位</a></li>
						<li><a href="javascript:;"><i class="fa fa-child"></i>生產設備建置</a></li>
						<li><a href="javascript:;"><i class="fa fa-child"></i>試產</a></li>
						<li><a href="javascript:;"><i class="fa fa-child"></i>原料採購</a></li>
						<li><a href="javascript:;"><i class="fa fa-child"></i>試營運</a></li>
						<li><a href="javascript:;"><i class="fa fa-child"></i>通路開發</a></li>
						<li><div class="mask"></div><a href="javascript:;"><i class="fa fa-lock"></i>行銷推廣</a></li>
					</ul>	
	                <div class="memberRwdnav clearfix">
	                    <nav class="primary">
	                        <ul class="rightnav">
	                            <li>
	                                <a href="javascript:;">公司成立</a>
	                            </li>	                        
	                            <li>
	                                <a href="javascript:;">營業場所完工</a>
	                            </li>
	                            <li>
	                                <a href="javascript:;">人員到位</a>
	                            </li>
	                            <li>
	                                <a href="javascript:;">生產設備建置</a>
	                            </li>
	                            <li>
	                                <a href="javascript:;">試產</a>
	                            </li>
	                            <li>
	                                <a href="javascript:;">原料採購</a>
	                            </li>
	                            <li>
	                                <a href="javascript:;">試營運</a>
	                            </li>
	                            <li>
	                                <a href="javascript:;">通路開發</a>
	                            </li>
	                            <li>
	                                <a href="javascript:;">(鎖) 行銷推廣</a>
	                            </li>	                              
	                        </ul>
	                    </nav>
	                </div>          	
	            </aside>
	        </div>
	        <div class="grid_9">
				<section class="ventureTypesTitle hideBlock">
					<h2><img alt="創業業種圖示" src="images/type.png">通路開發</h2>
				</section>

				<form class="formset clearfix" id="sendForm" method="POST" action="addExpenditure">
					<input type="hidden" name="subClass" value="218">
					<input type="hidden" name="dynamicTypeCount" id="cardCount" value="${dynamicTypeCount[0] }">
					<input type="hidden" name="dynamicTypeCount" id="lawyerCount" value="${dynamicTypeCount[1] }">
					<fieldset id="BusinessCard" class="fieldset">
					  	<legend>1 差旅費用</legend>
					  	<button type="button" class="addbutton" data-id="card"><i class="fa fa-plus"></i> 新增一筆費用</button>
					  	<c:set value="0" var="index"/>
					  	<c:if test="${dynamicTypeCount[0] > 0}">
					  	<c:forEach items="${dynamicPayMoney}" begin="${index}" end="${index + dynamicTypeCount[0] -1}" var="card">
					  	<div id="paymoney_${index}">
					  	<input type="hidden" name="dynamicPayMoney[${index}].ID" value="2181">
					  	<input type="hidden" name="dynamicPayMoney[${index}].record" value="${card.record}">
						  	<div class="field">
						  		<label>日期：
						  			<input type="month" class="form-control required" name="dynamicPayMoney[${index}].date_string" value="${fn:substring(card.date,0,7) }">
						  		</label>
						  	</div>
						  	<div class="field">
						  		<label>金額：
						  			<input type="text" class="form-control required digits" name="dynamicPayMoney[${index}].money" value="${card.money }">
						  		</label>
						  	</div>
						  	<div class="field">
						  		<button type="button" class="deletebutton delCardBtn" data-id="${index}" data-record="${card.record }" data-item="2181"><i class="fa fa-times"></i> 刪除</button>
						  	</div>					  		
					  	</div>
					  	<c:set var="index" value="${index+1}" />
					  	</c:forEach>
					  	</c:if>
					</fieldset>					
					<fieldset id="Lawyer" class="fieldset">
					  	<legend>2 交際費</legend>
					  	<button type="button" class="addbutton" data-id="lawyer"><i class="fa fa-plus"></i> 新增一筆費用</button>
					  	<c:if test="${dynamicTypeCount[1] > 0}">
					  	<c:forEach items="${dynamicPayMoney}" begin="${index}" end="${index + dynamicTypeCount[1] -1}" var="lawyer">
					  	<div id="paymoney_${index}">
					  	<input type="hidden" name="dynamicPayMoney[${index}].ID" value="2182">
					  	<input type="hidden" name="dynamicPayMoney[${index}].record" value="${lawyer.record}">
						  	<div class="field">
						  		<label>日期：
						  			<input type="month" class="form-control required" name="dynamicPayMoney[${index}].date_string" value="${fn:substring(lawyer.date,0,7) }">
						  		</label>
						  	</div>
						  	<div class="field">
						  		<label>金額：
						  			<input type="text" class="form-control required digits" name="dynamicPayMoney[${index}].money" value="${lawyer.money }">
						  		</label>
						  	</div>
						  	<div class="field">
						  		<button type="button" class="deletebutton delLawyerBtn" data-id="${index}" data-record="${lawyer.record }" data-item="2182"><i class="fa fa-times"></i> 刪除</button>
						  	</div>					  		
					  	</div>
					  	<c:set var="index" value="${index+1}" />
					  	</c:forEach>
					  	</c:if>
					</fieldset>	
					<div class="mt50px">
						<button type="submit" class="nextStepButton"><span class="next">下一步，填寫行銷推廣<i class="fa fa-arrow-right"></i></span></button>
					</div>
				  </form>
			</div>
		</div>			
	</div>

	<!-- BEGIN MODAL WINDOWS -->
	<div id="helpLink" class="reveal-modal">
		<header class="reveal-modal-header">
			我需要範例協助
		</header>
		<div class="cont clearfix">
			<p>
				近年來，由於經濟繁榮、國民所得提高、人們生活結構發生變化及單身比率年年升高...
			</p>
		</div>
	</div>



	<!-- import jquery -->
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<!-- import nav slideToggle RWD js -->	
		<script src="js/nav.js"></script>
	<!-- Reveal Modal -->
		<script src="js/jquery.reveal.js"></script>
	<!-- jquery.mobilemenu.js -->
		<script src="js/jquery.mobilemenu.js"></script>
		
	<script src="js/jquery.validate.js"></script>
	<script src="js/messages_zh_TW.js"></script>
	<script src="js/additional-methods.js"></script>
		<script type="text/javascript">
		var cardCount = 1;
		var lawyerCount = 1;
		var index = 0;
		var deletedIndex = 0;
	        $(function() {
	            $('nav.primary .rightnav').mobileMenu();
	            cardCount = $('#cardCount').val();
	            lawyerCount = $('#lawyerCount').val();
	            index = parseInt(cardCount) + parseInt(lawyerCount);
	            
	            $("#sendForm").validate();
	            
	            $('.addbutton').click(function(){
	            	var type = $(this).data('id');
	            	if(type == 'card'){
	            		cardCount++;
	            		$('#cardCount').val(cardCount);
	            		var cardText = 
	            		'<div id="paymoney_'+index+'">'+
	            		'<input type="hidden" name="dynamicPayMoney['+index+'].ID" value="2181">'+
	            			'<div class="field">'+
						  		'<label>日期：'+
						  			'<input type="month" class="form-control required" name="dynamicPayMoney['+index+'].date_string">'+
						  		'</label>'+
						  	'</div>'+
						  	'<div class="field">'+
						  		'<label>金額：'+
						  			'<input type="text" class="form-control required digits" name="dynamicPayMoney['+index+'].money">'+
						  		'</label>'+
						  	'</div>'+
						  	'<div class="field">'+
						  		'<button type="button" class="deletebutton delCardBtn" data-id="'+index+'"><i class="fa fa-times"></i> 刪除</button>'+
						  	'</div></div>';
	            		$('#BusinessCard').append(cardText);
	            	}else if(type == 'lawyer'){
	            		lawyerCount++;
	            		$('#lawyerCount').val(lawyerCount);
	            		var lawyerText = 
	            		'<div id="paymoney_'+index+'">'+
	            		'<input type="hidden" name="dynamicPayMoney['+index+'].ID" value="2182">'+
	            			'<div class="field">'+
						  		'<label>日期：'+
						  			'<input type="month" class="form-control required" name="dynamicPayMoney['+index+'].date_string">'+
						  		'</label>'+
						  	'</div>'+
						  	'<div class="field">'+
						  		'<label>金額：'+
						  			'<input type="text" class="form-control required digits" name="dynamicPayMoney['+index+'].money">'+
						  		'</label>'+
						  	'</div>'+
						  	'<div class="field">'+
						  		'<button type="button" class="deletebutton delLawyerBtn" data-id="'+index+'"><i class="fa fa-times"></i> 刪除</button>'+
						  	'</div></div>';
	            		$('#Lawyer').append(lawyerText);
	            	}
	            	index++;
	            	$('.delCardBtn').click(function(){
	            		var id = $(this).data('id');
		            	removeValidate(id);
		            	$('#paymoney_'+id).remove();
		            	if(cardCount > 1){
			            	cardCount--;
			            	$('#cardCount').val(cardCount);
		            	}
		            });
	            	$('.delLawyerBtn').click(function(){
		            	var id = $(this).data('id');
		            	removeValidate(id);
		            	$('#paymoney_'+id).remove();
		            	if(lawyerCount > 1){
		            	lawyerCount--;
		            	$('#lawyerCount').val(lawyerCount);
		            	}
		            });
	            });
	            initialDelBtn();
	        });
	        
	    	function removeValidate(id){
	    		$('#paymoney_'+id+' input[name="dynamicPayMoney['+id+'].date_string"]').rules("remove");
	    		$('#paymoney_'+id+' input[name="dynamicPayMoney['+id+'].money"]').rules("remove");
	    	}
	    	
	    	function initialDelBtn(){
            	$('.delCardBtn').click(function(){
	            	var id = $(this).data('id');
	            	var record = $(this).data('record');
	            	var itemID = $(this).data('item');
            		$('#sendForm').append('<input type="hidden" name="deletedPayMoney['+id+'].record" value="'+record+'">');
            		$('#sendForm').append('<input type="hidden" name="deletedPayMoney['+id+'].ID" value="'+itemID+'">');
	            	removeValidate(id);
	            	$('#paymoney_'+id).remove();
	            	deletedIndex++;
	            	if(cardCount > 1){
		            	cardCount--;
		            	$('#cardCount').val(cardCount);
	            	}
	            });
            	$('.delLawyerBtn').click(function(){
	            	var id = $(this).data('id');
	            	var record = $(this).data('record');
	            	var itemID = $(this).data('item');
            		$('#sendForm').append('<input type="hidden" name="deletedPayMoney['+id+'].record" value="'+record+'">');
            		$('#sendForm').append('<input type="hidden" name="deletedPayMoney['+id+'].ID" value="'+itemID+'">');
	            	removeValidate(id);
	            	$('#paymoney_'+id).remove();
	            	deletedIndex++;
	            	if(lawyerCount > 1){
	            	lawyerCount--;
	            	$('#lawyerCount').val(lawyerCount);
	            	}
	            });
	    	}
	    </script>
</body>
</html>