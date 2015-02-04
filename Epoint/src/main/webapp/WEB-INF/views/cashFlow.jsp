<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 	<meta name="description" content="月現金流-查看每月收入與支出明細-創業e點通">  
	<title>月現金流-查看每月收入與支出明細-創業e點通</title>

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
	<div class="wrapper">
		<div class="container">
			<div class="grid_12">
				<div class="banner">
					<div class="imgHolder"><img src="images/banner-office.jpg" alt="banner圖片-辦公室"></div>
				</div>
				<div class="breadcrumbs">
            		<p><a href="index.html">首頁</a> &gt; <a href="#">創業地圖</a> &gt; <a href="#">創業第一年營運排程地圖</a> &gt; <span>月現金流</span></p>
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
					<h2><i class="fa fa-file-text-o fa-color"></i>${selectedMonth}月收入明細</h2>
				</section>
				<div class="ventureTypesInput clearfix">
						<ul>
							<li>
								<table class="productTable responsive">
									<thead>
										<tr>
											<th>產品名稱</th>
											<th>產品總利潤</th>
											<th>支出明細</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${getProductList1}" var="product" varStatus="i">		
										<tr>
											<td>${product.name }</td>
											<td>${product.totalProfit }</td>
																		
											<td>${product.totalProfit }</td>
											<td>
												<a onclick="setEditProduct(${i.index});" 
												class="fa-color" data-reveal-id="editProduct" data-closeonbackgroundclick="false">
												<i class="fa fa-pencil-square-o fa-lg"></i></a>
											</td>
											<td>
												<a onclick="" class="fa-color">
												<i class="fa fa-times-circle fa-lg"></i></a>
											</td>
										</tr>						
									</c:forEach>
									<tr>
										<td>好吃的旺旺仙貝</td>
										<td>0</td>
										<td><a href="javascript:;" class="fa-color" data-reveal-id ="productDetailExpenditure"><i class="fa  fa-file-text-o fa-lg"></i></a></td>
									</tr>
									<tr>
										<td>好吃的乖乖</td>
										<td>0</td>
										<td><a href="javascript:;" class="fa-color" data-reveal-id ="productDetailExpenditure"><i class="fa  fa-file-text-o fa-lg"></i></a></td>
									</tr>
									<tr>
										<td>好吃的洋芋片</td>
										<td>10000</td>
										<td><a href="javascript:;" class="fa-color" data-reveal-id ="productDetailExpenditure"><i class="fa  fa-file-text-o fa-lg"></i></a></td>
									</tr>
									<tr>
										<td>好吃的旺旺仙貝</td>
										<td>10000</td>
										<td><a href="javascript:;" class="fa-color" data-reveal-id ="productDetailExpenditure"><i class="fa  fa-file-text-o fa-lg"></i></a></td>
									</tr>
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
											<th>收入明細</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${totalMoneyBySubClass}" var="item">
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

	<!-- BEGIN MODAL WINDOWS -->
        <div id="productDetailExpenditure" class="reveal-modal">
             <div class="cont clearfix">
                     <form class="formset clearfix">
                         <fieldset class="fieldset2">
                                    <legend>產品名稱 : 好吃的旺旺仙貝</legend>
                            </fieldset>
                            <fieldset  class="fieldset2">
							  	<legend>產品銷售數量 : </legend>
							  	<button class="addbutton"><i class="fa fa-plus"></i> 新增一筆費用</button>
							  	<div class="deleteblock">
								  	<div class="field">
								  		<label>日期：
								  			<input type="month" class="form-control" name="cardDate">
								  		</label>
								  	</div>
								  	<div class="field">
								  		<label>數量：
								  			<input type="text" class="form-control" name="cardCost">
								  		</label>
								  	</div>
								  	<div class="field">
								  		<button class="deletebutton" ><i class="fa fa-times"></i> 刪除</button>
								  	</div>					  		
							  	</div>
							  	<div class="deleteblock">
								  	<div class="field">
								  		<label>日期：
								  			<input type="month" class="form-control" name="cardDate">
								  		</label>
								  	</div>
								  	<div class="field">
								  		<label>數量：
								  			<input type="text" class="form-control" name="cardCost">
								  		</label>
								  	</div>
								  	<div class="field">
								  		<button class="deletebutton" ><i class="fa fa-times"></i> 刪除</button>
								  	</div>					  		
							  	</div>
							</fieldset>
                             <a href="javascript:;" class="finishButton"><span class="next">儲存變更</span></a>          
                             <a href="javascript:;" class="cancelButton"><span class="next">取消</span></a>
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
			var randomScalingFactor = function(){
				return Math.round(Math.random()*100);
			};
			var expendData = [0,0,0,0,0,0,0,0,0,0,0,0];
			<c:forEach items='${monthTotalMoney}' var='total' varStatus='i'>
				expendData['${i.index}'] = ${total};
			</c:forEach>
			var lineChartData = {
				labels : ["1月","2月","3月","4月","5月","6月","7月","8月","9月","10月","11月","12月"],
				datasets : [
					{
						label: "My First dataset",
						fillColor : "rgba(220,220,220,0.2)",
						strokeColor : "rgba(220,220,220,1)",
						pointColor : "rgba(220,220,220,1)",
						pointStrokeColor : "#fff",
						pointHighlightFill : "#fff",
						pointHighlightStroke : "rgba(220,220,220,1)",
						data : [randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor(),randomScalingFactor()]
					},
					{
						label: "My Second dataset",
						fillColor : "rgba(151,187,205,0.2)",
						strokeColor : "rgba(151,187,205,1)",
						pointColor : "rgba(151,187,205,1)",
						pointStrokeColor : "#fff",
						pointHighlightFill : "#fff",
						pointHighlightStroke : "rgba(151,187,205,1)",
						data : expendData
					}
				]
			};
			window.onload = function(){
				var ctx = document.getElementById("canvas").getContext("2d");
				var myLineChart = new Chart(ctx).Line(lineChartData,{reponsive:true});
				$('#sendForm').validate();
			}

			var fixedIndex = 0;
			var dynamicIndex = 0;
			var dynamicNum = 2;
			function editPayMoney(subClassID){
				$.ajax({
					url:"getPayMoneyDetailBySubClassID",
					data:{
						subClassID : subClassID
					},
					//dataType:"json",
					success:function(result){
						$('#sendForm').empty();
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
								$('#sendForm').append('<fieldset class="fieldset" id="field'+obj.itemID+'">'+
										'<input type="hidden" name="fixedPayMoney['+fixedIndex+'].ID" value="'+obj.itemID+'">'+
										'<input type="hidden" name="fixedPayMoney['+fixedIndex+'].record" value="'+tempList[0].record+'">'+
								  		'<legend>1.'+(fixedIndex+1)+' 固定成本['+obj.name+']：</legend>'+
								  		'<div class="field">'+
									  		'<label>日期：'+
									  			'<input type="month" class="form-control required" name="fixedPayMoney['+fixedIndex+'].date_string" value="'+tempList[0].date.substring(0,7)+'">'+
									  		'</label>'+
									  	'</div>'+
									  	'<div class="field">'+
									  		'<label><span>金額：</span>'+
									  			'<input type="text" class="form-control required digits" name="fixedPayMoney['+fixedIndex+'].money" value="'+tempList[0].money+'">'+
									  		'</label>'+
									  	'</div>'+
									'</fieldset>');
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
											  			'<input type="month" class="form-control required" name="dynamicPayMoney['+dynamicIndex+'].date_string" value="'+data.date.substring(0,7)+'">'+
											  		'</label>'+
											  	'</div>'+
											  	'<div class="field">'+
											  		'<label>金額：'+
											  			'<input type="text" class="form-control required digits" name="dynamicPayMoney['+dynamicIndex+'].money" value="'+data.money+'">'+
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
											  			'<input type="month" class="form-control required" name="dynamicPayMoney['+dynamicIndex+'].date_string">'+
											  		'</label>'+
											  	'</div>'+
											  	'<div class="field">'+
											  		'<label>金額：'+
											  			'<input type="text" class="form-control required digits" name="dynamicPayMoney['+dynamicIndex+'].money">'+
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
								$('#sendForm').append('<fieldset class="fieldset" id="field'+obj.itemID+'">'+
										'<input type="hidden" name="fixedPayMoney['+fixedIndex+'].ID" value="'+obj.itemID+'">'+
										'<input type="hidden" name="fixedPayMoney['+fixedIndex+'].record" value="'+tempList[0].record+'">'+
								  		'<legend>1.'+(fixedIndex+1)+' 固定成本['+obj.name+']：</legend>'+
									  	'<div class="field">'+
									  		'<label>日期：'+
									  			'<input type="month" class="form-control required" name="fixedPayMoney['+fixedIndex+'].date_string" value="'+tempList[0].date.substring(0,7)+'">'+
									  		'</label>'+
									  	'</div>'+
									  	'<div class="field">'+
									  		'<label><span>金額：</span>'+
									  			'<input type="text" class="form-control required digits" name="fixedPayMoney['+fixedIndex+'].money" value="'+tempList[0].money+'">'+
									  		'</label>'+
									  	'</div>'+
									'</fieldset>');
								fixedIndex++;
							}
						});
						$('#sendForm').append(
								'<button type="submit" class="finishButton"><span class="next">儲存變更</span></button>'+
		                    	'<a href="javascript:;" class="cancelButton"><span class="next">取消</span></a>');
					}
				});
			}
			
			function addPayMoney(itemID){
				$('#field'+itemID).append(
					'<div id="paymoney_'+dynamicIndex+'">'+
					'<input type="hidden" name="dynamicPayMoney['+dynamicIndex+'].ID" value="'+itemID+'">'+
					  	'<div class="field">'+
				  		'<label>日期：'+
				  			'<input type="month" class="form-control required" name="dynamicPayMoney['+dynamicIndex+'].date_string">'+
				  		'</label>'+
				  	'</div>'+
				  	'<div class="field">'+
				  		'<label>金額：'+
				  			'<input type="text" class="form-control required digits" name="dynamicPayMoney['+dynamicIndex+'].money">'+
				  		'</label>'+
				  	'</div>'+
				  	'<div class="field">'+
				  		'<button type="button" class="deletebutton" onClick="delPayMoney('+itemID+','+dynamicIndex+')"><i class="fa fa-times"></i> 刪除</button>'+
				  	'</div>'+
			  	'</div>');
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
		
		</script> 
</body>
</html>