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
 	<meta name="description" content="月現金流-查看每月收入與支出明細-創業e點通">  
	<title>月現金流-查看每月收入與支出明細-創業e點通</title>
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
					<a href="index"><img src="./images/egroup.png" alt="創業e點通品牌標誌"></a>
				</div><!-- logo -->
				<nav class="clearfix">
					<div class="top-nav">
						<div class="top-nav-right">
							<a href="ventureCapitalPlanMap" id="loginButton"><span>創業第一年資金規劃</span></a>
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
            		<p><a href="index.html">首頁</a> &gt; <a href="venturePlanMap">創業地圖</a> &gt; 
            		<a href="ventureCapitalPlanMap">創業第一年營運排程地圖</a> &gt; <span>月現金流</span></p>
	            </div>
			</div>
			<div class="grid_3">
				<aside>
					<ul class="sideNav hideBlock">
						<li ${selectedMonth eq 1 ? "class='current'": ""}><a href="cashFlow?mon=1">1月</a></li>
						<li ${selectedMonth eq 2 ? "class='current'": ""}><a href="cashFlow?mon=2">2月</a></li>
						<li ${selectedMonth eq 3 ? "class='current'": ""}><a href="cashFlow?mon=3">3月</a></li>
						<li ${selectedMonth eq 4 ? "class='current'": ""}><a href="cashFlow?mon=4">4月</a></li>
						<li ${selectedMonth eq 5 ? "class='current'": ""}><a href="cashFlow?mon=5">5月</a></li>
						<li ${selectedMonth eq 6 ? "class='current'": ""}><a href="cashFlow?mon=6">6月</a></li>
						<li ${selectedMonth eq 7 ? "class='current'": ""}><a href="cashFlow?mon=7">7月</a></li>
						<li ${selectedMonth eq 8 ? "class='current'": ""}><a href="cashFlow?mon=8">8月</a></li>
						<li ${selectedMonth eq 9 ? "class='current'": ""}><a href="cashFlow?mon=9">9月</a></li>
						<li ${selectedMonth eq 10 ? "class='current'": ""}><a href="cashFlow?mon=10">10月</a></li>
						<li ${selectedMonth eq 11 ? "class='current'": ""}><a href="cashFlow?mon=11">11月</a></li>
						<li ${selectedMonth eq 12 ? "class='current'": ""}><a href="cashFlow?mon=12">12月</a></li>
					</ul>	
	                <div class="memberRwdnav clearfix">
	                    <nav class="primary">
	                        <ul class="rightnav">
	                            <li>
	                                <a href="javascript:;">1月</a>
	                            </li>	 
	                            <li>
	                                <a href="javascript:;">2月</a>
	                            </li>	
	                            <li>
	                                <a href="javascript:;">3月</a>
	                            </li>	
	                            <li>
	                                <a href="javascript:;">4月</a>
	                            </li>	
	                            <li>
	                                <a href="javascript:;">5月</a>
	                            </li>	
	                            <li>
	                                <a href="javascript:;">6月</a>
	                            </li>	
	                            <li>
	                                <a href="javascript:;">7月</a>
	                            </li>	
	                            <li>
	                                <a href="javascript:;">8月</a>
	                            </li>	
	                            <li>
	                                <a href="javascript:;">9月</a>
	                            </li>	
	                            <li>
	                                <a href="javascript:;">10月</a>
	                            </li>	
	                            <li>
	                                <a href="javascript:;">11月</a>
	                            </li>	
	                            <li>
	                                <a href="javascript:;">12月</a>
	                            </li>	                   
	                        </ul>
	                    </nav>
	                </div>          	
	            </aside>
	        </div>
	        <div class="grid_9">
				<section class="ventureTypesTitle hideBlock">
					<h2><i class="fa fa-area-chart fa-color"></i>月現金流</h2>
				</section>
				<div>
					<div>
						<canvas id="canvas" height="400" width="1250"></canvas>
					</div>
				</div>
				<section class="ventureTypesTitle pt20">
					<h2><i class="fa fa-file-text-o fa-color"></i>${selectedMonth}月收入明細
					<a class="addProduct" data-reveal-id ="addProduct" data-closeonbackgroundclick="false"><i class="fa fa-plus"></i> 新增產品</a></h2>
				</section>
				<div class="ventureTypesInput clearfix">
						<ul>
							<li>
								<table class="productTable responsive">
									<thead>
										<tr>
											<th>產品名稱</th>
											<th>產品總利潤</th>
											<th>產品明細</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${totalIncomeByMemberDate1}" var="product" varStatus="i">		
									<tr>
										<td>${product.name }</td>
										<td>${product.monthIncome }</td>
										<td><a onclick="newProductSales(${i.index});" class="fa-color" 
										    data-reveal-id ="addProductSales" data-closeonbackgroundclick="false">
												<i class="fa fa-file-text-o fa-lg"></i></a>
										</td>
									</tr>			
									</c:forEach>									
								</tbody>
							</table>
							</li>
						</ul><!-- 
						<div class="text-center">
							<ul class="pagination">
	                            <li class="prev disabled"><a href="#">←</a></li>
	                            <li class="active"><a href="#">1</a></li>
	                            <li><a href="javascript:;">2</a></li>
	                            <li><a href="javascript:;">3</a></li>
	                            <li class="next"><a href="#">→</a></li>
	                        </ul>
                        </div> -->
					</div>
					<section class="ventureTypesTitle pt20">
						<h2><i class="fa fa-file-text-o fa-color"></i>${selectedMonth}月支出明細</h2>
					</section>
					<div class="ventureTypesInput clearfix">
						<ul>
							<li>
								<table class="productTable responsive">
									<thead>
										<tr>
											<th>支出品項</th>
											<th>支出總費用</th>
											<th>銷售明細</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${totalExpenditureBySubClass}" var="item">
										<tr>
											<td>${item.subClassName }</td>
											<td>${item.monthTotal }</td>
											<td><a onClick="editPayMoney(${item.subClassID })" class="fa-color" data-reveal-id="editExpenditure"><i class="fa fa-file-text-o fa-lg"></i></a></td>
										</tr>
									</c:forEach>
									</tbody>
							</table>
							</li>
						</ul>
					</div>
			</div>
		</div>			
	</div>

	<!-- addProduct BEGIN MODAL WINDOWS -->
	<div id="addProduct" class="reveal-modal">
		<div class="cont clearfix">
			<form id="sendForm1" action="addProductCashFlow" method="post" class="formset clearfix">
			<input type="hidden" value="${param.mon}" name="mon" id="mon"> 
				<fieldset class="fieldset2">
					<legend>1 產品名稱</legend>
					<div class="field">
						<label><span>產品名稱：</span> 
						<input type="text" class="form-control" name="name"> </label>
					</div>
				</fieldset>
				<fieldset class="fieldset2">
					<legend>2產品規格</legend>
					<textarea rows="8" name="specification"
						placeholder="產品內容物數量、產品長寬高、重量"></textarea>
				</fieldset>
				<fieldset class="fieldset2">
					<legend>3包裝說明</legend>
					<textarea rows="8" name="pack"
						placeholder="紙袋裝、紙盒裝、塑膠袋裝、真空包裝	"></textarea>
				</fieldset>
				<fieldset class="fieldset2">
					<legend>4終端消費者定價</legend>
					<div>
						<div class="field">
							<label>金額： <input type="text" name="endPrice" class="form-control">
							</label>
						</div>
					</div>
				</fieldset>
				<fieldset class="fieldset2">
					<legend>5實質銷售價格</legend>
					<div>
						<div class="field">
							<label>金額： <input type="text" name="salesPrice"	class="form-control">
							</label>
						</div>
					</div>
				</fieldset>
				<fieldset class="fieldset2">
					<legend>6直接成本</legend>
					<div>
						<div class="field">
							<label>金額： <input type="text" name="cost" class="form-control">
							</label>
						</div>
					</div>
				</fieldset>
				<fieldset id="addSalesQuantityA" class="fieldset2">  
				 <input type="hidden" id="delCountA" value="0">                                	
					<legend>產品銷售數量 : </legend>								  			  	
					<button type="button" class="addbutton" onclick="addbuttonA();"><i class="fa fa-plus"></i> 新增數量</button>
					<div id="newMoney0" >
						<div class="deleteblock">
											  		
						</div>
					</div>								  	
				</fieldset>
				<button type="submit" class="finishButton" id="addProductSubmit">
					<span class="next">新增產品</span>
				</button>
				<button type="button" class="cancelButton">
					<span class="next">取消</span>
				</button>
			</form>
		</div>
		<a class="close-reveal-modal">&#215;</a>
	</div>
	
	<!-- BEGIN MODAL WINDOWS -->
        <div id="addProductSales" class="reveal-modal">
                <div class="cont clearfix">
                        <form class="formset clearfix" id="sendForm2" action="addProductSalseCashFlow" method="post">
                        		<input type="hidden" id="productID" name="productID">   
                        		<input type="hidden" value="${param.mon}" name="mon" id="mon">                     		
	                            <fieldset class="fieldset2">
	                                    <p id="productName"></p>
	                            </fieldset>
	                            <input type="hidden" id="delCount" value="1">
                                <fieldset id="addSalesQuantity" class="fieldset2">                                  	
								  	<legend>產品銷售數量 : </legend>								  			  	
								  	<button type="button" class="addbutton" onclick="addbutton();"><i class="fa fa-plus"></i> 新增數量</button>
									<div id="newMoney0" >
									  	<div class="deleteblock">
										  	<div class="field">
										  		<label>日期：
										  			<input type="month" class="form-control salsDate" id="salsDate0" name="salsDate" >
										  		</label>
										  	</div>
										  	<div class="field">
										  		<label>數量：
										  			<input type="text" class="form-control salsQuantity" id="salsQuantity0" name="salsQuantity" >
										  		</label>
										  	</div>
										  	<div class="field">
										  		<button type="button" class="deletebutton" onclick="deletebutton(0);"><i class="fa fa-times"></i> 刪除</button>
										  	</div>					  		
									  	</div>
									</div>								  	
								</fieldset>
                                <button type="submit" class="finishButton" id="addProductSalesSubmit">
								<span class="next">確認修改</span>
								</button>
								<button type="button" class="cancelButton" >
									<span class="next">取消</span>
								</button>
                          </form>
                </div>
                <a class="close-reveal-modal">&#215;</a>
        </div>

	<!-- BEGIN MODAL WINDOWS -->
        <div id="editExpenditure" class="reveal-modal">
                <div class="cont clearfix">
                	<form class="formset clearfix" id="sendForm" method="POST" action="addCashFlow">
                    	
                	</form>
                </div>
                <a class="close-reveal-modal">&#215;</a>
        </div>



	<!-- import jquery -->
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<!-- import nav slideToggle RWD js -->	
		<script src="js/nav.js"></script>
	<!-- Reveal Modal -->
		<script src="js/jquery.reveal.js"></script>
	<!-- jquery.mobilemenu.js -->
		<script src="js/jquery.mobilemenu.js"></script>
		<script type="text/javascript">
	        $(function() {
	            $('nav.primary .rightnav').mobileMenu();
	            
	            $('#sendForm').validate();
	            $.validator.addMethod("cMaxlength", $.validator.methods.maxlength, "請輸入小於10位數的金額");
				jQuery.validator.addClassRules({
	            	dateValidate: {
	            		required: true,
	            		min: '${fn:substring(getMember.capitalDate,0,7)}',
	            		max: calculateEndDate('${fn:substring(getMember.capitalDate,0,7)}')
	            	},
	            	moneyValidate: {
	            		required: true,
	            		digits: true,
	            		min: 1,
	            		cMaxlength: 9
	            	}
	            });
	        });
	    </script>
	<!-- responsive-table -->  
	    <script src="js/responsive-tables.js"></script>
	<!-- Chart -->  
	    <script src="js/Chart.js"></script>
	    
		<script src="js/jquery.validate.js"></script>
		<script src="js/messages_zh_TW.js"></script>
		<script src="js/additional-methods.js"></script>

		<script>			
			//列出每月支出
			var expendData = [0,0,0,0,0,0,0,0,0,0,0,0];
			<c:forEach items='${monthTotalExpenditure}' var='total' varStatus='i'>
				expendData['${i.index}'] = ${total};
			</c:forEach>
			//列出每月收入
			var incomeData = [0,0,0,0,0,0,0,0,0,0,0,0];
			<c:forEach items='${monthTotalIncome}' var='total' varStatus='i'>
				incomeData['${i.index}'] = ${total};
			</c:forEach>
			var chartData = {
				labels : ["1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"],
				datasets : [
					{
						label: "收入",
						fillColor : "rgba(126, 195, 117,0.2)",
						strokeColor : "rgba(126, 195, 117,1)",
						highlightFill: "rgba(126, 195, 117,1)",
			            highlightStroke: "rgba(126, 195, 117,1)",
			            //scaleGridLineColor : "rgba(0,0,0,.05)",			            
						data : incomeData
					},
					{
						label: "支出",
						fillColor : "rgba(226, 84, 84,0.2)",
						strokeColor : "rgba(226, 84, 84,1)",
						highlightFill: "rgba(226, 84, 84,1)",
			            highlightStroke: "rgba(226, 84, 84,1)",
						data : expendData
					}
				]
			};
			window.onload = function(){
				var ctx = document.getElementById("canvas").getContext("2d");
				//折線圖
				//var myLineChart = new Chart(ctx).Line(chartData,{reponsive:true});
				var myBarChart = new Chart(ctx).Bar(chartData,{reponsive:true,multiTooltipTemplate: "\<\%\=datasetLabel%> : \<\%\=value%>"});
				canvas.onclick = function(evt){
				    var activeBars = myBarChart.getBarsAtEvent(evt);
				    //var mon = activeBars[0].label.toString();
				    //lert(mon.subString(0,1));
				    window.open('cashFlow?mon='+activeBars[0].label[0], '_self');
				   /* alert(activeBars[0].label);
				    alert(activeBars[0].x);
				    alert(activeBars[0].y);
				    alert(activeBars[0].value);*/
				    // => activeBars is an array of bars on the canvas that are at the same position as the click event.
				};
			}

			//支出結構----------------------------------------------------------
			var fixedIndex = 0;
			var dynamicIndex = 0;
			var dynamicNum = 2;
			var fixedIndex, dynamicIndex, dynamicNum;
			function editPayMoney(subClassID){
				fixedIndex = 0;
				dynamicIndex = 0;
				dynamicNum = 2;
				$.ajax({
					url:"getPayMoneyDetailBySubClassID",
					data:{
						subClassID : subClassID
					},
					success:function(result){
						$('#sendForm').empty();
						var mon = '${selectedMonth}';
						$('#sendForm').append('<input type="hidden" value="'+mon+'" name="mon">');
						$('#sendForm').append('<input type="hidden" value="'+subClassID+'" name="subClass">');
						$.each(result.payItemList, function(index, value){
							var obj = result.payItemList[index];
							var tempList;
							switch(index){
								case 0:
									tempList = result.list1;
									break;
								case 1:
									tempList = result.list2;
									break;
								case 2:
									tempList = result.list3;
									break;
								case 3:
									tempList = result.list4;
									break;
								case 4:
									tempList = result.list5;
									break;
								case 5:
									tempList = result.list6;
									break;
								case 6:
									tempList = result.list7;
									break;
							}
							
							if(obj.status == 1){
								if(tempList.length > 0){
									$('#sendForm').append('<fieldset class="fieldset" id="field'+obj.itemID+'">'+
											'<input type="hidden" name="fixedPayMoney['+fixedIndex+'].ID" value="'+obj.itemID+'">'+
											'<input type="hidden" name="fixedPayMoney['+fixedIndex+'].record" value="'+tempList[0].record+'">'+
									  		'<legend>1.'+(fixedIndex+1)+' '+obj.name+'：</legend>'+
									  		'<div class="field">'+
										  		'<label>日期：'+
										  			'<input type="month" class="form-control dateValidate" name="fixedPayMoney['+fixedIndex+'].date_string" value="'+tempList[0].date.substring(0,7)+'">'+
										  		'</label>'+
										  	'</div>'+
										  	'<div class="field">'+
										  		'<label><span>金額：</span>'+
										  			'<input type="text" class="form-control moneyValidate" name="fixedPayMoney['+fixedIndex+'].money" value="'+tempList[0].money+'">'+
										  		'</label>'+
										  	'</div>'+
										'</fieldset>');
								}else{
									$('#sendForm').append('<fieldset class="fieldset" id="field'+obj.itemID+'">'+
											'<input type="hidden" name="fixedPayMoney['+fixedIndex+'].ID" value="'+obj.itemID+'">'+
									  		'<legend>1.'+(fixedIndex+1)+' '+obj.name+'：</legend>'+
									  		'<div class="field">'+
										  		'<label>日期：'+
										  			'<input type="month" class="form-control dateValidate" name="fixedPayMoney['+fixedIndex+'].date_string">'+
										  		'</label>'+
										  	'</div>'+
										  	'<div class="field">'+
										  		'<label><span>金額：</span>'+
										  			'<input type="text" class="form-control moneyValidate" name="fixedPayMoney['+fixedIndex+'].money">'+
										  		'</label>'+
										  	'</div>'+
										'</fieldset>');
								}
								fixedIndex++;
							}else if(obj.status == 2){
								var appendText = '<fieldset class="fieldset" id="field'+obj.itemID+'">'+
								'<button type="button" class="addbutton" onClick="addPayMoney('+obj.itemID+')"><i class="fa fa-plus"></i> 新增一筆費用</button>'+
						  		'<legend>'+dynamicNum+' '+obj.name+'：</legend>';
								if(tempList.length > 0){
									for(var i = 0;i < tempList.length;i++){
										var data = tempList[i];
										appendText += 
											'<div id="paymoney_'+dynamicIndex+'">'+
											'<input type="hidden" name="dynamicPayMoney['+dynamicIndex+'].ID" value="'+obj.itemID+'">'+
											'<input type="hidden" name="dynamicPayMoney['+dynamicIndex+'].record" value="'+data.record+'">'+
											  	'<div class="field">'+
											  		'<label>日期：'+
											  			'<input type="month" class="form-control dateValidate" name="dynamicPayMoney['+dynamicIndex+'].date_string" value="'+data.date.substring(0,7)+'">'+
											  		'</label>'+
											  	'</div>'+
											  	'<div class="field">'+
											  		'<label>金額：'+
											  			'<input type="text" class="form-control moneyValidate" name="dynamicPayMoney['+dynamicIndex+'].money" value="'+data.money+'">'+
											  		'</label>'+
											  	'</div>'+
											  	'<div class="field">'+
											  		'<button type="button" class="deletebutton" onClick="delExistPayMoney('+obj.itemID+','+dynamicIndex+','+data.record+')"><i class="fa fa-times"></i> 刪除</button>'+
											  	'</div>'+
										  	'</div>';
										dynamicIndex++;
									}
									appendText += '</fieldset>';
								}else{
									appendText += '<div id="paymoney_'+dynamicIndex+'">'+
											  	'<div class="field">'+
											  		'<label>日期：'+
											  			'<input type="month" class="form-control dateValidate" name="dynamicPayMoney['+dynamicIndex+'].date_string">'+
											  		'</label>'+
											  	'</div>'+
											  	'<div class="field">'+
											  		'<label>金額：'+
											  			'<input type="text" class="form-control moneyValidate" name="dynamicPayMoney['+dynamicIndex+'].money">'+
											  		'</label>'+
											  	'</div>'+
											  	'<div class="field">'+
											  		'<button class="deletebutton" ><i class="fa fa-times"></i> 刪除</button>'+
											  	'</div>'+
										  	'</div></fieldset>';
									dynamicIndex++;
								}
								$('#sendForm').append(appendText);
								dynamicNum++;
							}else if(obj.status == 3){
								if(tempList.length > 0){
									$('#sendForm').append('<fieldset class="fieldset" id="field'+obj.itemID+'">'+
											'<input type="hidden" name="fixedPayMoney['+fixedIndex+'].ID" value="'+obj.itemID+'">'+
											'<input type="hidden" name="fixedPayMoney['+fixedIndex+'].record" value="'+tempList[0].record+'">'+
									  		'<legend>1.'+(fixedIndex+1)+' '+obj.name+'：</legend>'+
										  	'<div class="field">'+
										  		'<label>日期：'+
										  			'<input type="month" class="form-control dateValidate" name="fixedPayMoney['+fixedIndex+'].date_string" value="'+tempList[0].date.substring(0,7)+'">'+
										  		'</label>'+
										  	'</div>'+
										  	'<div class="field">'+
										  		'<label><span>金額：</span>'+
										  			'<input type="text" class="form-control moneyValidate" name="fixedPayMoney['+fixedIndex+'].money" value="'+tempList[0].money+'">'+
										  		'</label>'+
										  	'</div>'+
										'</fieldset>');
								}else{
									$('#sendForm').append('<fieldset class="fieldset" id="field'+obj.itemID+'">'+
											'<input type="hidden" name="fixedPayMoney['+fixedIndex+'].ID" value="'+obj.itemID+'">'+
									  		'<legend>1.'+(fixedIndex+1)+' '+obj.name+'：</legend>'+
										  	'<div class="field">'+
										  		'<label>日期：'+
										  			'<input type="month" class="form-control dateValidate" name="fixedPayMoney['+fixedIndex+'].date_string">'+
										  		'</label>'+
										  	'</div>'+
										  	'<div class="field">'+
										  		'<label><span>金額：</span>'+
										  			'<input type="text" class="form-control moneyValidate" name="fixedPayMoney['+fixedIndex+'].money">'+
										  		'</label>'+
										  	'</div>'+
										'</fieldset>');
								}
								fixedIndex++;
							}
						});
						$('#sendForm').append(
								'<button type="submit" class="finishButton"><span class="next">儲存變更</span></button>'+
		                    	'<button type="button" class="cancelButton"><span class="next">取消</span></button>');
						$(".cancelButton").click(function(){
							$(".close-reveal-modal").trigger("click");
						});
					}
				});
			}
			
			
			
			//收入結構----------------------------------------------------------
			var addSalesQuantityCount = 1;
			var index = 1;
			var count = 1;
			var deletedIndex = 0;
			
			var addSalesQuantityCountA = 1;
			var indexA = 0;
			var countA = 1;
			var deletedIndexA = 0;
			
			 $(function(){
		            $(".cancelButton").click(function(){
						$(".close-reveal-modal").trigger("click");
					});
		            //sendForm1----------------------------------------------------------		           	 
		            $("#sendForm1").validate({
		            	rules:{
		            		name:{
		            			required:true,
		            			maxlength:10
		            		},			
		            		specification:{
				    			required:true,
				    			maxlength:150
				    		},			
				    		pack:{
				    			required:true,
				    			maxlength:150
				    		},			
				    		endPrice:{
				    			required:true,
				    			number: true,
				    			maxlength:9,
				    			min:1,
				    			digits:true 
				    			
				    		},			
				    		salesPrice:{
				    			required:true,
				    			number: true,
				    			maxlength:9,
				    			min:1,
				    			digits:true 
				    		},			
				    		cost:{
				    			required:true,
				    			number: true,
				    			maxlength:9,
				    			min:1,
				    			digits:true 
				    			
				    		}
		            	},
		            	messages:{
		            		name:{
		            			required:"此欄位不能空白",
		            			maxlength:"長度不能超過{0}"
		            		},
		            		specification:{
		            			required:"此欄位不能空白",
		            			maxlength:"長度不能超過{0}"
		            		},
		            		pack:{
		            			required:"此欄位不能空白",
		            			maxlength:"長度不能超過{0}"
		            		},
		            		endPrice:{
		            			required:"此欄位不能空白",
		            			number: "請輸入數字",
		            			maxlength:"長度不能超過{0}",
		            			min:"請輸入大於0的金額",
		            			digits:"請輸入整數" 
		            		},
		            		salesPrice:{
		            			required:"此欄位不能空白",
		            			number: "請輸入數字",
		            			maxlength:"長度不能超過{0}",
		            			min:"請輸入大於0的金額",
		            			digits:"請輸入整數" 
		            		},
		            		cost:{
		            			required:"此欄位不能空白",
		            			number: "請輸入數字",
		            			maxlength:"長度不能超過{0}",
		            			min:"請輸入大於0的金額",
		            			digits:"請輸入整數" 
		            		}
		            	},
	    	        	submitHandler:function(form){
	    					$(".salsDateA").attr("name","salsDateA");
	    					form.submit();
	    					$(".salsQuantityA").attr("name","salsQuantityA");
	    					form.submit();
	    				}
		            });	
		            /*$("#addProductSubmit").click(function(){
		            	var salsClassCount = $('.salsDateA').length
		            	if(salsClassCount>1){
		            		$("#salsDateA0").rules("add",{
		    	        		required:true,
		    	            	messages:{
		    	            		required:"請輸入日期",	            		
		    	            	}
		    	        	});	        	

		    	        	$("#salsQuantityA0").rules("add",{
		    	        		required:true,
		    	            	number: true,
		    	            	min:1,
		    	            	maxlength:9,
		            			digits: true,
		    	            	messages:{
		    	            		required:"請輸入數量",
		    	            		num:"請輸入數字",
		    	            		min:"請輸入大於0的數量",
		    	            		maxlength:"請輸入小於10位數的數量",
			            			digits:"請輸入整數" 
		    	            	}
		    	        	});        		    	        	
		            	}else{	            		
		            		if($('.salsDateA').val()!="" || $('.salsQuantityA').val()!=""){
		            			$("#salsDateA0").rules("add",{
			    	        		required:true,
			    	            	messages:{
			    	            		required:"請輸入日期",	            		
			    	            	}
			    	        	});	        	

			    	        	$("#salsQuantityA0").rules("add",{
			    	        		required:true,
			    	            	number: true,
			    	            	min:1,
			    	            	maxlength:9,
			            			digits: true,
			    	            	messages:{
			    	            		required:"請輸入數量",
			    	            		num:"請輸入數字",
			    	            		min:"請輸入大於0的數量",
			    	            		maxlength:"請輸入小於10位數的數量",
				            			digits:"請輸入整數" 
			    	            	}
			    	        	});        	
			    	        	
		            		}else{
		            			//alert("請注意，因為您沒有輸入任何資料，此產品的銷售數量為0。");
		            			$(".close-reveal-modal").trigger("click");
		            		}        
		            	}
					});	*/   
		            
		         	//sendForm2----------------------------------------------------------
		            $("#sendForm2").validate({
		            	rules:{},
		            	messages:{},
	    	        	submitHandler:function(form){
	    					$(".salsDate").attr("name","salsDate");
	    					form.submit();
	    					$(".salsQuantity").attr("name","salsQuantity");
	    					form.submit();
	    				}
		            });	 
		           $("#addProductSalesSubmit").click(function(){
		            	var salsClassCount = $('.salsDate').length
		            	if(salsClassCount>1){
		            		$("#salsDate0").rules("add",{
		    	        		required:true,
		    	            	messages:{
		    	            		required:"請輸入日期",	            		
		    	            	}
		    	        	});	        	

		    	        	$("#salsQuantity0").rules("add",{
		    	        		required:true,
		    	            	number: true,
		    	            	min:1,
		    	            	maxlength:9,
		            			digits: true,
		    	            	messages:{
		    	            		required:"請輸入數量",
		    	            		num:"請輸入數字",
		    	            		min:"請輸入大於0的數量",
		    	            		maxlength:"請輸入小於10位數的數量",
			            			digits:"請輸入整數" 
		    	            	}
		    	        	});        		    	        	
		            	}else{	            		
		            		if($('.salsDate').val()!="" || $('.salsQuantity').val()!=""){
		            			$("#salsDate0").rules("add",{
			    	        		required:true,
			    	            	messages:{
			    	            		required:"請輸入日期",	            		
			    	            	}
			    	        	});	        	

			    	        	$("#salsQuantity0").rules("add",{
			    	        		required:true,
			    	            	number: true,
			    	            	min:1,
			    	            	maxlength:9,
			            			digits: true,
			    	            	messages:{
			    	            		required:"請輸入數量",
			    	            		num:"請輸入數字",
			    	            		min:"請輸入大於0的數量",
			    	            		maxlength:"請輸入小於10位數的數量",
				            			digits:"請輸入整數" 
			    	            	}
			    	        	});        	
			    	        	
		            		}else{
		            			//alert("請注意，因為您沒有輸入任何資料，此產品的銷售數量為0。");
		            			$(".close-reveal-modal").trigger("click");
		            		}        
		            	}
					});	   
		     	});
		        
		        /*function deleteProduct(){
		        	$.ajax({
						url:"getProductSalesListByMemberID",
						data:{
							productID : list[i].id
						},
						dataType:"json",
		        	})
		        }*/
		        
		      	//支出sendForm function----------------------------------------------------------
		        function addPayMoney(itemID){
					alert('itemID='+itemID);
					alert('dynamicIndex='+dynamicIndex);
					var addpayMoneyText =
						'<div id="paymoney_'+123+'">'+
						'<input type="hidden" name="dynamicPayMoney['+dynamicIndex+'].ID" value="'+itemID+'">'+
						'<div class="field">'+
					  	'<label>日期：'+
					  	'<input type="month" class="form-control dateValidate" name="dynamicPayMoney['+dynamicIndex+'].date_string">'+
					  	'</label>'+
					  	'</div>'+
					  	'<div class="field">'+
					  	'<label>金額：'+
					  	'<input type="text" class="form-control moneyValidate" name="dynamicPayMoney['+dynamicIndex+'].money">'+
					  	'</label>'+
					  	'</div>'+
					  	'<div class="field">'+
					  	'<button type="button" class="deletebutton" onClick="delPayMoney('+itemID+','+dynamicIndex+')"><i class="fa fa-times"></i> 刪除</button>'+
					  	'</div>'+
				  		'</div>';          		
					$('#field'+itemID).append(addpayMoneyText);
					dynamicIndex++;
				}
				
				function delPayMoney(itemID,index){
					if($('#field'+itemID+' div[id^="paymoney"]').length > 1){
						$('#paymoney_'+index).remove();
					}
				}
				
				function delExistPayMoney(itemID,index,record){
					if($('#field'+itemID+' div[id^="paymoney"]').length > 1){
						$('#sendForm').append('<input type="hidden" name="deletedPayMoney['+index+'].record" value="'+record+'">');
	            		$('#sendForm').append('<input type="hidden" name="deletedPayMoney['+index+'].ID" value="'+itemID+'">');
						$('#paymoney_'+index).remove();
					}
				}
		        
		        
		      	//收入sendForm1 function----------------------------------------------------------
		        function addValidateA(getIndex){
		        	$("#salsDateA"+getIndex).rules("add",{
		        		required:true,
		            	messages:{
		            		required:"請輸入日期",	            		
		            	}
		        	});	        	

		        	$("#salsQuantityA"+getIndex).rules("add",{
		        		required:true,
		            	number: true,
		            	min:1,
		            	maxlength:9,
            			digits: true,
		            	messages:{
		            		required:"請輸入數量",
		            		num:"請輸入數字",
		            		min:"請輸入大於0的數量",
		            		maxlength:"請輸入小於10位數的數量",
	            			digits:"請輸入整數" 
		            	}
		        	});
		        }		
		        
		        function addbuttonA(){
		        	var addSalesQuantityText =
					  	'<div class="deleteblock" id="newMoneyA'+indexA+'">'+
						'<div class="field">'+  	
						'<label>日期：'+		
						'<input type="month" class="form-control salsDateA" id="salsDateA'+indexA+'" name="salsDateA'+indexA+'">'+  			
						'</label>'+  		
						'</div>'+  	
						'<div class="field">'+  	
						'<label>數量：'+ 		
						'<input type="text" class="form-control salsQuantityA"  id="salsQuantityA'+indexA+'" name="salsQuantityA'+indexA+'">'+ 			
						'</label>'+  		
						'</div>'+  	
						'<div class="field">'+  	
						'<button type="button" class="deletebutton" onclick="deletebuttonA('+indexA+');"><i class="fa fa-times"></i> 刪除</button>'+  		
						'</div>'+  				  		
					  	'</div>';	            		
		            	$('#addSalesQuantityA').append(addSalesQuantityText);
		            	var delCountA = $('#delCountA').val();
		            	delCountA++;	            	
		            	$('#delCountA').val(delCountA);
		            	addValidateA(indexA);
		            	indexA++;
		        }
		        
		        function deletebuttonA(indexA){
		        	var delCountA = $('#delCountA').val();
		        	if(delCountA>0){
	            		$("#newMoneyA"+indexA).remove();  
	            		delCountA--;
	            		$('#delCountA').val(delCountA);
		        	}
	           	}
		      	//收入sendForm2 function----------------------------------------------------------
		        function addValidate(getIndex){
		        	$("#salsDate"+getIndex).rules("add",{
		        		required:true,
		            	messages:{
		            		required:"請輸入日期",	            		
		            	}
		        	});	        	

		        	$("#salsQuantity"+getIndex).rules("add",{
		        		required:true,
		            	number: true,
		            	min:1,
		            	maxlength:9,
            			digits: true,
		            	messages:{
		            		required:"請輸入數量",
		            		num:"請輸入數字",
		            		min:"請輸入大於0的數量",
		            		maxlength:"請輸入小於10位數的數量",
	            			digits:"請輸入整數" 
		            	}
		        	});
		        }		        		        
		        
		        function addbutton(){
		        	var addSalesQuantityText =
					  	'<div class="deleteblock" id="newMoney'+index+'">'+
						'<div class="field">'+  	
						'<label>日期：'+		
						'<input type="month" class="form-control salsDate" id="salsDate'+index+'" name="salsDate'+index+'">'+  			
						'</label>'+  		
						'</div>'+  	
						'<div class="field">'+  	
						'<label>數量：'+ 		
						'<input type="text" class="form-control salsQuantity"  id="salsQuantity'+index+'" name="salsQuantity'+index+'">'+ 			
						'</label>'+  		
						'</div>'+  	
						'<div class="field">'+  	
						'<button type="button" class="deletebutton" onclick="deletebutton('+index+');"><i class="fa fa-times"></i> 刪除</button>'+  		
						'</div>'+  				  		
					  	'</div>';	            		
		            	$('#addSalesQuantity').append(addSalesQuantityText);
		            	var delCount = $('#delCount').val();
		            	delCount++;	            	
		            	$('#delCount').val(delCount);
		            	addValidate(index);
		            	index++;
		        }
		        
		        function deletebutton(index){
		        	var delCount = $('#delCount').val();
		        	if(delCount>1){
	            		$("#newMoney"+index).remove();  
	            		delCount--;
	            		$('#delCount').val(delCount);
		        	}else{
		        		$("#salsDate"+index).val("");  
		        		$("#salsQuantity"+index).val(""); 
		        	}
	           	}
		        
				function newProductSales(i){
					var list = $.parseJSON('${totalIncomeByMemberDate2}');
					$('#productID').val(list[i].id);
					$('#productName').text(list[i].name);
					$('#delCount').val(1);
					var delCount = $('#delCount').val();
					$.ajax({
						url:"getProductSalesListByMemberID",
						data:{
							productID : list[i].id
						},
						dataType:"json",
						success:function(result){
							$('#addSalesQuantity').html("");
							var addSalesQuantityText = 
								'<legend>產品銷售數量 : </legend>'+							  			  	
							  	'<button type="button" class="addbutton" onclick="addbutton();"><i class="fa fa-plus"></i> 新增數量</button>'+
								'<div id="newMoney0" >'+
								'<div class="deleteblock">'+
								'<div class="field">'+
								'<label>日期：'+
								'<input type="month" class="form-control salsDate" id="salsDate0" name="salsDate">'+
								'</label>'+
								'</div>'+
								'<div class="field">'+
								'<label>數量：'+
								'<input type="text" class="form-control salsQuantity" id="salsQuantity0" name="salsQuantity">'+
								'</label>'+
								'</div>'+
								'<div class="field">'+
								'<button type="button" class="deletebutton" onclick="deletebutton(0);"><i class="fa fa-times"></i> 刪除</button>'+
								'</div>'+		  		
								'</div>'+
								'</div>';
							$('#addSalesQuantity').append(addSalesQuantityText);
							$("#salsDate0").val("");
							$("#salsQuantity0").val("");
							if(result.length>0){
								$("#salsDate0").val(result[0].date_string);
								$("#salsQuantity0").val(result[0].quantity);							
								for(var i=1; i<result.length; i++){
					            	$('#delCount').val($('#delCount').val()+1)
									addSalesQuantityText = 
									  	'<div class="deleteblock" id="newMoney'+index+'">'+
										'<div class="field">'+  	
										'<label>日期：'+		
										'<input type="month" class="form-control salsDate" id="salsDate'+index+'" name="salsDate'+index+'" value="'+result[i].date_string+'">'+  			
										'</label>'+  		
										'</div>'+  	
										'<div class="field">'+  	
										'<label>數量：'+ 		
										'<input type="text" class="form-control salsQuantity" id="salsQuantity'+index+'" name="salsQuantity'+index+'" value="'+result[i].quantity+'">'+ 			
										'</label>'+  		
										'</div>'+  	
										'<div class="field">'+  	
										'<button type="button" class="deletebutton" onclick="deletebutton('+index+');"><i class="fa fa-times"></i> 刪除</button>'+  		
										'</div>'+  				  		
									  	'</div>';
					            	$('#addSalesQuantity').append(addSalesQuantityText);	
					            	delCount++;
					            	$('#delCount').val(delCount);
					            	addValidate(index);
					            	index++;
								}
							}
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