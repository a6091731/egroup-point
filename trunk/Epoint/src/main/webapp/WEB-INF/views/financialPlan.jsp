<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 	<meta name="description" content="資金規劃地圖-算出你的創業資金需求並規劃-創業e點通">  
	<title>資金規劃地圖-算出你的創業資金需求並規劃-創業e點通</title>
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
	<!-- responsive-table -->
	<link rel="stylesheet" href="css/responsive-tables.css"  media="screen">

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
	<div class="wrapper clearfix">
		<div class="container">
			<div class="grid_12">
				<div class="breadcrumbs">
            		<p><a href="index">首頁</a> &gt; 
            		<a href="venturePlanMap">創業地圖</a> &gt; <span>資金規劃地圖</span></p>
	            </div>
			</div>
	        <div class="grid_6 prefix_3 suffix_3">
				<section class="ventureChecklistTitle">
					<img alt="資金規劃地圖圖示" src="images/ventureCheck.png">
					<h2>資金規劃地圖</h2>
				</section><!-- 
				<section class="financialTypesTitle">
					<h2><i class="fa fa-usd fa-color"></i>計算第一年創業資金</h2>
					<ul>
						<li>恭喜您完成了創業檢核表與創業第一年營運排程，接下來做資金規劃</li>
						<li>首先，參考您創業第一年營運排程中的收支報表後，計算出您的每月平均費用為:1222元</li>
						<li>月平均費用 = 1234 元</li>
						<li>目前您累積的資金缺口(不足的資金) = <input type="text" class="input-control" name="input1">元</li>
						<li><h4>第一年創業資金需求 = 每月平均費用*3 + 目前您累積的資金缺口(不足的資金)</h4></li>
						<li>算出第一年創業資金需求為21222元後，開始第二步驟， 進行資金規劃。</li>
					</ul>

				</section> -->
				<section class="ventureTypesTitle">
					<h2><i class="fa fa-usd fa-color"></i>算出第一年創業資金需求</h2>
				</section>				
			</div>
			<div class="grid_3 prefix_3">
				<div class="financialBox">您的月平均費用:<br/> ${avgCost}元<br/>(參考創業第一年營運排程中的收支報表)</div>
			</div>
			<form id="addForm" method="POST" action="addFinancialPlan">
			<div class="grid_3 suffix_3">
				<div class="financialBox">目前您累積的資金缺口<br/>
				<input type="text" class="input-control" id="lackMoney" name="lackMoney" value="${fundLack}" style="ime-mode:disabled">元
				<p></p>(填寫您不足的資金)</div>
			</div>
			<div class="grid_6 prefix_3 suffix_3">
				<div class="financialBox" id="requestMoney">
				月平均費用*3 + 資金缺口 = 第一年創業資金需求<br/>
				10*3+7=37<br/>
				<h3>您的第一年創業資金需求=37元</h3>
				</div>
			</div>
			<div class="grid_6 prefix_3 suffix_3">
				<section class="ventureTypesTitle">
					<h2><i class="fa fa-usd fa-color"></i>規劃資金</h2>
				</section>
			</div>
			<div class="grid_6 prefix_3 suffix_3">
				<div class="ventureTypesInput clearfix">
					<ul>
						<li>
							<h4 class="productTitle" id="title1">資金用途總額 = 資金需求 37</h4>
								<table class="productTable ">
								<thead>
									<tr>
										<th>資金用途</th>
										<th colspan="2">金額</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td colspan="3"><button type="button" class="addbutton" id="addUseBtn"><i class="fa fa-plus"></i> 新增一筆用途</button> </td>
									</tr>
								<c:set value="0" var="index"/>
								<c:choose>
									<c:when test="${fn:length(usesPlans) gt 0}">
									<c:forEach items="${usesPlans}" var="use" varStatus="i">
										<tr id="usesPlans_${index}">
											<td>
												<input type="hidden" name="usesPlans[${i.index }].record" value="${use.record }">
												<input type="text" class="input-control required" name="usesPlans[${i.index }].name" value="${use.name }">
												<p></p>
											</td>
											<td><input type="text" class="input-control moneyValidate useMoney" name="usesPlans[${i.index }].money" value="${use.money }"> 元<p></p></td>
											<td><button type="button" class="deletebutton" onClick="delDetail(${index},${use.record},1)"><i class="fa fa-times"></i></button></td>
										</tr>
						  			<c:set var="index" value="${index+1}" />
									</c:forEach>
									</c:when>
									<c:when test="${fn:length(usesPlans) eq 0}">
										<tr id="usesPlans_${index}">
											<td>
												<input type="hidden" name="dynamicPlans[${index}].property" value="1">
												<input type="text" class="input-control required" name="dynamicPlans[${index }].name">
												<p></p>
											</td>
											<td><input type="text" class="input-control moneyValidate useMoney" name="dynamicPlans[${index }].money"> 元<p></p></td>
											<td><button type="button" class="deletebutton" onClick="del(1,${index})"><i class="fa fa-times"></i></button></td>
										</tr>
						  			<c:set var="index" value="${index+1}" />
									</c:when>
								</c:choose>
									<tr id="useTotal">
										<td>用途總額</td>
										<td colspan="2" id="useMoney"></td>
									</tr>
									<tr>
										<td id="useMsg"></td>
										<td colspan="2" id="useGap"></td>
									</tr>
								</tbody>
							</table>
						</li>
					</ul>
				</div>
			</div>
			<div class="grid_6 prefix_3 suffix_3">
				<div class="ventureTypesInput clearfix">
					<ul>
						<li>
							<h4 class="productTitle" id="title2">資金來源總額 = 資金需求 37</h4>
								<table class="productTable ">
								<thead>
									<tr>
										<th>資金來源</th>
										<th colspan="2">金額</th>
									</tr>
								</thead>
								<tbody>
										<tr>
										<td colspan="3"><button type="button" class="addbutton" id="addSrcBtn"><i class="fa fa-plus"></i> 新增一筆用途</button> </td>
									</tr>
								<c:choose>
									<c:when test="${fn:length(sourcePlans) gt 0}">
									<c:forEach items="${sourcePlans}" var="src" varStatus="i">
										<tr id="sourcePlans_${index}">
											<td>
												<input type="hidden" name="sourcePlans[${i.index }].record" value="${src.record }">
												<input type="text" class="input-control required" name="sourcePlans[${i.index }].name" value="${src.name }">
												<p></p>
											</td>
											<td><input type="text" class="input-control moneyValidate srcMoney" name="sourcePlans[${i.index }].money" value="${src.money }"> 元<p></p></td>
											<td><button type="button" class="deletebutton" onClick="delDetail(${index},${src.record},0)"><i class="fa fa-times"></i></button></td>
										</tr>
							  		<c:set var="index" value="${index+1}" />
									</c:forEach>
									</c:when>
									<c:when test="${fn:length(sourcePlans) eq 0}">
										<tr id="sourcePlans_${index}">
											<td>
												<input type="hidden" name="dynamicPlans[${index }].property" value="0">
												<input type="text" class="input-control required" name="dynamicPlans[${index }].name">
												<p></p>
											</td>
											<td><input type="text" class="input-control moneyValidate srcMoney" name="dynamicPlans[${index }].money"> 元<p></p></td>
											<td><button type="button" class="deletebutton" onClick="del(0,${index})"><i class="fa fa-times"></i></button></td>
										</tr>
							  		<c:set var="index" value="${index+1}" />
									</c:when>
								</c:choose>
									<tr id="srcTotal">
										<td>來源總額</td>
										<td colspan="2" id="srcMoney"></td>
									</tr>
									<tr>
										<td id="srcMsg"></td>
										<td colspan="2" id="srcGap"></td>
									</tr>
								</tbody>
							</table>
						</li>
					</ul>
					<button type="submit" id="submitBtn" class="nextStepButton"><span class="next">完成資金規劃 <i class="fa fa-arrow-right"></i></span></button>
				</div>
			</div>	
		</form>		
		</div>			
	</div>
	<!-- import jquery -->
	<!-- <script src="js/jquery-1.9.1.min.js"></script>此版本jquery 無法顯示彈窗，看要不要改成1.7.1 -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	
	<!-- import nav slideToggle RWD js -->	
		<script src="js/nav.js"></script>
	<!-- import progressbar -->
		<script type="text/javascript" src="js/progressbar.js"></script>
		<script>
			progressBar(20, $('#progressBar'));
		</script>
	<!-- import progresscircle -->	
		<script src="js/jquery.circliful.js"></script>
		
		<script src="js/jquery.validate.js"></script>
		<script src="js/messages_zh_TW.js"></script>
		<script src="js/additional-methods.js"></script>
		<script type="text/javascript">
		$( document ).ready(function() {
			$('.progress').circliful();
		});
		var avgCost = ${avgCost};
		var result =  parseInt(avgCost) * 3;
		var index = '${index}';
		var count = '${fn:length(usesPlans)}' + '${fn:length(sourcePlans)}';
		var delIndex = 0;
		var total = 0;
		$( document ).ready(function() {
			calculateNeedMoney();
			calculateMoney('useMoney');
			calculateMoney('srcMoney');
			
			$("#addForm").validate({
				rules:{
					lackMoney : {
						required: true,
	            		digits: true,
	            		min: 1,
	            		maxlength: 9
					}
				},
				messages:{
					lackMoney:{
			    		maxlength:'請輸入小於10位數的金額'
			    	}
			    },
				errorPlacement: function (error, element) {
					element.next().append(error);
	    	    }
			});
			$.validator.addMethod("cMaxlength", $.validator.methods.maxlength, "請輸入小於10位數的金額");
			jQuery.validator.addClassRules({
            	moneyValidate: {
            		required: true,
            		digits: true,
            		min: 1,
            		cMaxlength: 9,
            		sum: result
            	}
            });
			jQuery.validator.addMethod(
			    "sum",
			    function (value, element, params) {
			        var sumOfVals = 0;
			        var className = element.name.match("^use")?'.useMoney':'.srcMoney';
			        var parent = $(className);
			        $(parent).each(function () {
			            sumOfVals = sumOfVals + parseInt($(this).val(), 10);
			        });
			        if (sumOfVals == params) return true;
			        return false;
			    },
			    jQuery.format("總合必須等於 {0}")
			);
			$('#lackMoney').change(function(){
				calculateNeedMoney();
			});
			$('.useMoney').change(function(){
				calculateMoney('useMoney');
			});
			$('.srcMoney').change(function(){
				calculateMoney('srcMoney');
			});
			$('#addUseBtn').click(function(){
				var content = '<tr id="usesPlans_'+count+'">'+
					'<td>'+
					'<input type="hidden" name="dynamicPlans['+index+'].property" value="1">'+
					'<input type="text" class="input-control required" name="dynamicPlans['+index+'].name"><p></p></td>'+
					'<td><input type="text" class="input-control moneyValidate useMoney" name="dynamicPlans['+index+'].money"> 元<p></p></td>'+
					'<td><button type="button" class="deletebutton" onClick="del(1,'+count+')"><i class="fa fa-times"></i></button></td>'+
				'</tr>';
           		$('#useTotal').before(content);
           		index++;
           		count++;
    			$('.useMoney').change(function(){
    				calculateMoney('useMoney');
    			});
            });
			$('#addSrcBtn').click(function(){
				var content = '<tr id="sourcePlans_'+count+'">'+
					'<td>'+
					'<input type="hidden" name="dynamicPlans['+index+'].property" value="0">'+
					'<input type="text" class="input-control required" name="dynamicPlans['+index+'].name"><p></p></td>'+
					'<td><input type="text" class="input-control moneyValidate srcMoney" name="dynamicPlans['+index+'].money"> 元<p></p></td>'+
					'<td><button type="button" class="deletebutton" onClick="del(0,'+count+')"><i class="fa fa-times"></i></button></td>'+
				'</tr>';
	       		$('#srcTotal').before(content);
	       		index++;
	       		count++;
    			$('.srcMoney').change(function(){
    				calculateMoney('srcMoney');
    			});
	        });
		});
		
		function del(property,id){
			var trName = property == 1 ? 'usesPlans' : 'sourcePlans';
			$('#'+trName+'_'+id).remove();
			var className = property == 1 ? 'useMoney' : 'srcMoney';
			calculateMoney(className);
		}
		
		function delDetail(id,record,property){
			$('#addForm').append('<input type="hidden" name="deletedPlans['+delIndex+'].record" value="'+record+'">');
			$('#addForm').append('<input type="hidden" name="deletedPlans['+delIndex+'].property" value="'+property+'">');
			del(property,id);
			delIndex++;
		}
		
	    function calculateNeedMoney(){
	    	var lackMoney = $('#lackMoney').val() != '' ? parseInt($('#lackMoney').val()) : 0;
			result = parseInt(avgCost) * 3 + parseInt(lackMoney);
			$('#requestMoney').empty();
			$('#requestMoney').append('月平均費用*3 + 資金缺口 = 第一年創業資金需求<br/>'+
					avgCost+'*3+'+lackMoney+'='+result+'<br/><h3>您的第一年創業資金需求='+
					result+'元</h3>');
			$('#title1').empty();
			$('#title1').append('資金用途總額 = 資金需求 = '+result);
			$('#title2').empty();
			$('#title2').append('資金用途總額 = 資金需求 = '+result);
	    }
	    
	    function calculateMoney(type){
	    	total = 0;
	    	if($('.'+type).length == 0){
	    		$('#'+type).empty();
	    	}
			$('.'+type).each(function(index) {
				var useMoney = $(this).val() != '' ? parseInt($(this).val()) : 0;
				total += parseInt(useMoney);
				$('#'+type).empty();
				$('#'+type).append(total+'元');
			});
			if(type == 'useMoney'){
				$('#useMsg').empty();
				$('#useGap').empty();
				if(result == total){
					$('#useMsg').append('驗證通過');
					$('#useGap').append('差0元');
					$('#useMsg').parent().attr('class', 'greenText');
				}else{
					$('#useMsg').append('驗證不合');
					$('#useMsg').parent().attr('class', 'redText');
					if(result > total){
						$('#useGap').append('差'+(result-total)+'元');
					}else{
						$('#useGap').append('多'+(total-result)+'元');
					}
				}
			}else{
				$('#srcMsg').empty();
				$('#srcGap').empty();
				if(result == total){
					$('#srcMsg').append('驗證通過');
					$('#srcGap').append('差0元');
					$('#srcMsg').parent().attr('class', 'greenText');
				}else{
					$('#srcMsg').append('驗證不合');
					$('#srcMsg').parent().attr('class', 'redText');
					if(result > total){
						$('#srcGap').append('差'+(result-total)+'元');
					}else{
						$('#srcGap').append('多'+(total-result)+'元');
					}
				}
			}
	    }
		</script>

	<!-- responsive-table -->  
	    <script src="js/responsive-tables.js"></script>
</body>
</html>