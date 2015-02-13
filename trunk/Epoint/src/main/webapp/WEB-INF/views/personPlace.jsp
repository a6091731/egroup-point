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
	<!-- favicon -->
	<link rel="shortcut icon" type="image/x-icon" href="images/favicon.ico">
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
            		<p><a href="index">首頁</a> &gt; <a href="venturePlanMap">創業地圖</a> &gt; 
            		<a href="ventureCapitalPlanMap">創業第一年營運排程地圖</a> &gt; <span>支出結構</span></p>
	            </div>
			</div>
			<div class="grid_3">
				<aside>
					<ul class="sideNav hideBlock">
						<li><a href="founded"><i class="fa fa-child"></i>公司成立</a></li>
						<li><a href="placeComplete"><i class="fa fa-certificate"></i>營業場所完工</a></li>
						<li class="current"><a href="personPlace"><i class="fa fa-users"></i>人員到位</a></li>
						<li><a href="equipmentBuild"><i class="fa fa-building-o"></i>生產設備建置</a></li>
						<li><a href="trialProduction"><i class="fa fa-cubes"></i>試產</a></li>
						<li><a href="procureMaterial"><i class="fa fa-shopping-cart"></i>原料採購</a></li>
						<li><a href="trialOperation"><i class="fa fa-thumbs-up"></i>試營運</a></li>
						<li><a href="developmentMarket"><i class="fa fa-bullseye"></i>通路開發</a></li>
						<li><a href="marketing"><i class="fa fa-truck"></i>行銷推廣</a></li>
					</ul>	
	                <div class="memberRwdnav clearfix">
	                    <nav class="primary">
	                        <ul class="rightnav">
	                            <li>
	                                <a href="founded">公司成立</a>
	                            </li>	                        
	                            <li>
	                                <a href="placeComplete">營業場所完工</a>
	                            </li>
	                            <li>
	                                <a href="personPlace">人員到位</a>
	                            </li>
	                            <li>
	                                <a href="equipmentBuild">生產設備建置</a>
	                            </li>
	                            <li>
	                                <a href="trialProduction">試產</a>
	                            </li>
	                            <li>
	                                <a href="procureMaterial">原料採購</a>
	                            </li>
	                            <li>
	                                <a href="trialOperation">試營運</a>
	                            </li>
	                            <li>
	                                <a href="developmentMarket">通路開發</a>
	                            </li>
	                            <li>
	                                <a href="marketing">行銷推廣</a>
	                            </li>
	                        </ul>
	                    </nav>
	                </div>          	
	            </aside>
	        </div>
	        <div class="grid_9">
				<section class="ventureTypesTitle hideBlock">
					<h2><img alt="創業業種圖示" src="images/type.png">人員到位</h2>
				</section>

				<form class="formset clearfix" id="sendForm" method="POST" action="addExpenditure">
					<input type="hidden" name="subClass" value="213">
					<input type="hidden" name="dynamicTypeCount" id="cardCount" value="${dynamicTypeCount[0] }">
					<input type="hidden" name="dynamicTypeCount" id="lawyerCount" value="${dynamicTypeCount[1] }">
				  	<fieldset class="fieldset">
				  	<input type="hidden" name="fixedPayMoney[0].ID" value="2131">
				  	<input type="hidden" name="fixedPayMoney[0].record" value="${fixedPayMoney[0].record == 0? 1:fixedPayMoney[0].record}">
				  		<legend>1.1 固定成本[薪資(含勞/健保費及退休金提撥)]：</legend>
					  	<div class="field">
					  		<label>日期：
					  			<input type="month" class="form-control dateValidate" name="fixedPayMoney[0].date_string" value="${fn:substring(fixedPayMoney[0].date,0,7)}">
					  		</label>
					  	</div>
					  	<div class="field">
					  		<label><span>金額：</span>
					  			<input type="text" class="form-control moneyValidate" name="fixedPayMoney[0].money" value="${fixedPayMoney[0].money}">
					  		</label>
					  	</div>
					</fieldset>
					<fieldset class="fieldset">
				  	<input type="hidden" name="fixedPayMoney[1].ID" value="2132">
				  	<input type="hidden" name="fixedPayMoney[1].record" value="${fixedPayMoney[1].record == 0? 1:fixedPayMoney[1].record}">
				  		<legend>1.1.2 固定成本[薪資增減]：</legend>
					  	<div class="field">
					  		<label>日期：
					  			<input type="month" class="form-control dateValidate" name="fixedPayMoney[1].date_string" value="${fn:substring(fixedPayMoney[1].date,0,7)}">
					  		</label>
					  	</div>
					  	<div class="field">
					  		<label><span>金額：</span>
					  			<input type="text" class="form-control moneyValidate" name="fixedPayMoney[1].money" value="${fixedPayMoney[1].money}">
					  		</label>
					  	</div>
					</fieldset>
					<fieldset id="BusinessCard" class="fieldset">
					  	<legend>2 辦公用品及文具書報費</legend>
					  	<button type="button" class="addbutton" data-id="card"><i class="fa fa-plus"></i> 新增一筆費用</button>
					  	<c:set value="0" var="index"/>
					  	<c:if test="${dynamicTypeCount[0] > 0}">
					  	<c:forEach items="${dynamicPayMoney}" begin="${index}" end="${index + dynamicTypeCount[0] -1}" var="card">
					  	<div id="paymoney_${index}">
					  	<input type="hidden" name="dynamicPayMoney[${index}].ID" value="2133">
					  	<input type="hidden" name="dynamicPayMoney[${index}].record" value="${card.record}">
						  	<div class="field">
						  		<label>日期：
						  			<input type="month" class="form-control dateValidate" name="dynamicPayMoney[${index}].date_string" value="${fn:substring(card.date,0,7) }">
						  		</label>
						  	</div>
						  	<div class="field">
						  		<label>金額：
						  			<input type="text" class="form-control moneyValidate" name="dynamicPayMoney[${index}].money" value="${card.money }">
						  		</label>
						  	</div>
						  	<div class="field">
						  		<button type="button" class="deletebutton delCardBtn" data-id="${index}" data-record="${card.record }" data-item="2133"><i class="fa fa-times"></i> 刪除</button>
						  	</div>					  		
					  	</div>
					  	<c:set var="index" value="${index+1}" />
					  	</c:forEach>
					  	</c:if>
					</fieldset>					
					<fieldset id="Lawyer" class="fieldset">
					  	<legend>3 訓練費用</legend>
					  	<button type="button" class="addbutton" data-id="lawyer"><i class="fa fa-plus"></i> 新增一筆費用</button>
					  	<c:if test="${dynamicTypeCount[1] > 0}">
					  	<c:forEach items="${dynamicPayMoney}" begin="${index}" end="${index + dynamicTypeCount[1] -1}" var="lawyer">
					  	<div id="paymoney_${index}">
					  	<input type="hidden" name="dynamicPayMoney[${index}].ID" value="2134">
					  	<input type="hidden" name="dynamicPayMoney[${index}].record" value="${lawyer.record}">
						  	<div class="field">
						  		<label>日期：
						  			<input type="month" class="form-control dateValidate" name="dynamicPayMoney[${index}].date_string" value="${fn:substring(lawyer.date,0,7) }">
						  		</label>
						  	</div>
						  	<div class="field">
						  		<label>金額：
						  			<input type="text" class="form-control moneyValidate" name="dynamicPayMoney[${index}].money" value="${lawyer.money }">
						  		</label>
						  	</div>
						  	<div class="field">
						  		<button type="button" class="deletebutton delLawyerBtn" data-id="${index}" data-record="${lawyer.record }" data-item="2134"><i class="fa fa-times"></i> 刪除</button>
						  	</div>					  		
					  	</div>
					  	<c:set var="index" value="${index+1}" />
					  	</c:forEach>
					  	</c:if>
					</fieldset>	
					<div class="mt50px">
						<button type="submit" class="nextStepButton"><span class="next">下一步，填寫生產設備建置<i class="fa fa-arrow-right"></i></span></button>
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
	            $.validator.addMethod("cMaxlength", $.validator.methods.maxlength, "請輸入小於10位數的金額");
	            $.validator.addMethod("dateMin", $.validator.methods.min, "時間不得小於您的創業第一年時間 : {0} 開始");
	            $.validator.addMethod("dateMax", $.validator.methods.max, "時間不得大於您的創業第一年時間 : {0} 結束");
	            jQuery.validator.addClassRules({
	            	dateValidate: {
	            		required: true,
	            		dateMin: '${fn:substring(getMember.capitalDate,0,7)}',
	            		dateMax: calculateEndDate('${fn:substring(getMember.capitalDate,0,7)}')
	            	},
	            	moneyValidate: {
	            		required: true,
	            		digits: true,
	            		min: 1,
	            		cMaxlength: 9
	            	}
	            });
	            
	            $('.addbutton').click(function(){
	            	var type = $(this).data('id');
	            	if(type == 'card'){
	            		cardCount++;
	            		$('#cardCount').val(cardCount);
	            		var cardText = 
	            		'<div id="paymoney_'+index+'">'+
	            		'<input type="hidden" name="dynamicPayMoney['+index+'].ID" value="2133">'+
	            			'<div class="field">'+
						  		'<label>日期：'+
						  			'<input type="month" class="form-control dateValidate" name="dynamicPayMoney['+index+'].date_string">'+
						  		'</label>'+
						  	'</div>'+
						  	'<div class="field">'+
						  		'<label>金額：'+
						  			'<input type="text" class="form-control moneyValidate" name="dynamicPayMoney['+index+'].money">'+
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
	            		'<input type="hidden" name="dynamicPayMoney['+index+'].ID" value="2134">'+
	            			'<div class="field">'+
						  		'<label>日期：'+
						  			'<input type="month" class="form-control dateValidate" name="dynamicPayMoney['+index+'].date_string">'+
						  		'</label>'+
						  	'</div>'+
						  	'<div class="field">'+
						  		'<label>金額：'+
						  			'<input type="text" class="form-control moneyValidate" name="dynamicPayMoney['+index+'].money">'+
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
		            	if(cardCount > 1){
			            	$('#paymoney_'+id).remove();
			            	cardCount--;
			            	$('#cardCount').val(cardCount);
		            	}
		            });
	            	$('.delLawyerBtn').click(function(){
		            	var id = $(this).data('id');
		            	if(lawyerCount > 1){
			            	$('#paymoney_'+id).remove();
			            	lawyerCount--;
			            	$('#lawyerCount').val(lawyerCount);
		            	}
		            });
	            });
	            initialDelBtn();
	        });
	        
	    	function initialDelBtn(){
            	$('.delCardBtn').click(function(){
	            	var id = $(this).data('id');
	            	if(cardCount > 1){
		            	var record = $(this).data('record');
		            	var itemID = $(this).data('item');
	            		$('#sendForm').append('<input type="hidden" name="deletedPayMoney['+id+'].record" value="'+record+'">');
	            		$('#sendForm').append('<input type="hidden" name="deletedPayMoney['+id+'].ID" value="'+itemID+'">');
		            	$('#paymoney_'+id).remove();
		            	deletedIndex++;
		            	cardCount--;
		            	$('#cardCount').val(cardCount);
	            	}
	            });
            	$('.delLawyerBtn').click(function(){
	            	var id = $(this).data('id');
	            	if(lawyerCount > 1){
		            	var record = $(this).data('record');
		            	var itemID = $(this).data('item');
	            		$('#sendForm').append('<input type="hidden" name="deletedPayMoney['+id+'].record" value="'+record+'">');
	            		$('#sendForm').append('<input type="hidden" name="deletedPayMoney['+id+'].ID" value="'+itemID+'">');
		            	$('#paymoney_'+id).remove();
		            	deletedIndex++;
		            	lawyerCount--;
		            	$('#lawyerCount').val(lawyerCount);
	            	}
	            });
	    	}
	    	
	    	function calculateEndDate(startDate){
				var endDate;
				var endYear = parseInt(startDate.substring(0,4));
				var endMon = parseInt(startDate.substring(5,7))-1;
				if(endMon == 0){
					endDate = endYear+'-12';
				}else{
					endYear++;
					endMon = '0'+endMon;
					endDate = endYear+'-'+endMon.substring(endMon.length-2,endMon.length);
				}
				return endDate;
			}
	    </script>
</body>
</html>