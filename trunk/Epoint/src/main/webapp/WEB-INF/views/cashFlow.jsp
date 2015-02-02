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
						<canvas id="canvas" height="150" width="600"></canvas>
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
											<td><a href="javascript:;" class="fa-color" data-reveal-id="sub${item.subClassID }"><i class="fa fa-file-text-o fa-lg"></i></a></td>
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
	<c:forEach items="${totalMoneyBySubClass}" var="subClass" varStatus="loop">
        <div id="sub${subClass.subClassID}" class="reveal-modal">
                <div class="cont clearfix">
                        <form class="formset clearfix">
                        	<c:forEach items="${payItems}" var="item" varStatus="loop2">
                        	<c:out value="${loop2.index}"></c:out>
							  	<fieldset class="fieldset">
							  		<legend>1.1 固定成本[設立費用]：</legend>
								  	<div class="field">
								  		<label>日期：
								  			<input type="month" class="form-control" name="fixcostdate">
								  		</label>
								  	</div>
								  	<div class="field">
								  		<label><span>金額：</span>
								  			<input type="text" class="form-control" name="fixcost" >
								  		</label>
								  	</div>
								</fieldset>
							</c:forEach>
								<fieldset  class="fieldset">
								  	<legend>1.2 固定成本[設計及申請商標]</legend>
								  	<div class="field">
								  		<label>日期：
								  			<input type="month" class="form-control" name="fixcostdateLogo">
								  		</label>
								  	</div>
								  	<div class="field">
								  		<label>金額：
								  			<input type="text" class="form-control" name="fixcostLogo">
								  		</label>
								  	</div>
								</fieldset>
								<fieldset  class="fieldset">
								  	<legend>2 印製名片</legend>
								  	<button class="addbutton"><i class="fa fa-plus"></i> 新增一筆費用</button>
								  	<div>
									  	<div class="field">
									  		<label>日期：
									  			<input type="month" class="form-control" name="cardDate">
									  		</label>
									  	</div>
									  	<div class="field">
									  		<label>金額：
									  			<input type="text" class="form-control" name="cardCost">
									  		</label>
									  	</div>
									  	<div class="field">
									  		<button class="deletebutton" ><i class="fa fa-times"></i> 刪除</button>
									  	</div>					  		
								  	</div>
								</fieldset>					
								<fieldset  class="fieldset">
								  	<legend>3 律師費用</legend>
								  	<button class="addbutton" ><i class="fa fa-plus"></i> 新增一筆費用</button>
								  	<div>
									  	<div class="field">
									  		<label>日期：
									  			<input type="month" class="form-control" name="date3">
									  		</label>
									  	</div>
									  	<div class="field">
									  		<label>金額：
									  			<input type="text" class="form-control" name="money3">
									  		</label>
									  	</div>
									  	<div class="field">
									  		<button class="deletebutton" ><i class="fa fa-times"></i> 刪除</button>
									  	</div>					  		
								  	</div>
								  	<div>
									  	<div class="field">
									  		<label>日期：
									  			<input type="month" class="form-control" name="date3">
									  		</label>
									  	</div>
									  	<div class="field">
									  		<label>金額：
									  			<input type="text" class="form-control" name="money3">
									  		</label>
									  	</div>
									  	<div class="field">
									  		<button class="deletebutton" ><i class="fa fa-times"></i> 刪除</button>
									  	</div>					  		
								  	</div>
								</fieldset>	
								<fieldset  class="fieldset">
								  	<legend>4 會計師費用</legend>
								  	<button class="addbutton" ><i class="fa fa-plus"></i> 新增一筆費用</button>
								  	<div>
									  	<div class="field">
									  		<label>日期：
									  			<input type="month" class="form-control" name="date3">
									  		</label>
									  	</div>
									  	<div class="field">
									  		<label>金額：
									  			<input type="text" class="form-control" name="money3">
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
	</c:forEach>



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

		<script>
			var randomScalingFactor = function(){
				return Math.round(Math.random()*100);
			};
			var expendData = [0,0,0,0,0,0,0,0,0,0,0,0];
			<c:forEach items='${monthTotalMoney}' var='total' varStatus='loop'>
				expendData[${loop.index}] = ${total };
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
			}
		</script> 
</body>
</html>