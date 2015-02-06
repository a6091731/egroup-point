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
 	<meta name="description" content="創業前檢核表地圖-請依順序完成您的創業前檢核表-創業e點通">  
	<title>創業前檢核表地圖-請依順序完成您的創業前檢核表-創業e點通</title>

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
							<a href="venturePlanMap.html" id="loginButton"><span>創業地圖</span></a>
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
            		<p><a href="index.html">首頁</a> &gt; <a href="#">創業地圖</a> &gt; <span>創業前檢核表地圖</span></p>
	            </div>
			</div>
	        <div class="grid_6 prefix_3 suffix_3">
				<section class="ventureChecklistTitle">
					<img alt="創業前檢核表圖示" src="images/ventureCheck.png">
					<h2>創業前檢核表</h2>
					<ul>
						<li>1.請依照順序完成您的創業前檢核表</li>
						<li>2.最後您可以按下"儲存創業檢核表" 儲存您的創業檢核表至您的電腦</li>
						<li>3.若在填表過程中您不清楚方向，可按下"我需要協助"來幫助自己完成填表</li>
					</ul>
				</section>
			</div>
		</div>			
	</div>
	<div class="ventureChecklist clearfix">
		<div class="container">
			<div class="grid_6 prefix_3 suffix_3">
				<ul>
					<li>
						<div class="ventureBox clearfix">
							<div class="progressCircle" data-dimension="80" data-text="${getPercent.percent11}%" data-fontsize="16" 
							data-percent="${getPercent.percent11}" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" 
							data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>創業業種</h3>
								<p>填寫創業業種、商業模式和在此行業的一技之長</p>
							</div>
							<i class="fa fa-angle-right fa-5x"></i>
							<a href="ventureTypes" target="_self"></a>
						</div>
 					</li>
					<li>
						<div class="${getPercent.percent11>0? 'ventureBox clearfix':'ventureBoxLocked clearfix'}">
							<div class="progressCircle" data-dimension="80" data-text="${getPercent.percent12}%" data-fontsize="16" 
							data-percent="${getPercent.percent12}" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" 
							data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>目標市場描述</h3>
								<p>填寫目標客戶、提供給顧客什麼價值、顧客從中能得到什麼好處</p>
							</div>
							<i class="${getPercent.percent11>0? 'fa fa-angle-right fa-5x:'fa fa-lock fa-4x fa-top'}"></i>
							<a href="${getPercent.percent12>0? 'targetMarketDescribe':'javascript:;'}" target="_self"></a>
						</div>
 					</li>
 					<li>
						<div class="${getPercent.productCount>0? 'ventureBox clearfix':'ventureBoxLocked clearfix'}">
							<div class="progressCircle" data-dimension="80" data-text="${getPercent.productCount>0? 100:0}%" data-fontsize="16" 
							data-percent="${getPercent.productCount>0? 100:0}" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" 
							data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>產品描述</h3>
								<p>填寫產品相關資訊，目前有${getPercent.productCount }項產品資訊</p>
							</div>
							<i class="fa fa-lock fa-4x fa-top"></i>
							<a href="${getPercent.percent13>0? 'showAllProductDescribe':'javascript:;'}" target="_self"></a>
						</div>
 					</li>
 					<li>
						<div class="${getPercent.percent14>0? 'ventureBox clearfix':'ventureBoxLocked clearfix'}">
							<div class="progressCircle" data-dimension="80" data-text="${getPercent.percent14}%" data-fontsize="16" 
							data-percent="${getPercent.percent14}" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" 
							data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>業務</h3>
								<p>填寫業務銷售通路、業務銷售末端消費者</p>
							</div>
							<i class="fa fa-lock fa-4x fa-top"></i>
							<a href="${getPercent.percent14>0? 'businessSales':'javascript:;'}" target="_self"></a>
						</div>
 					</li>
 					<li>
						<div class="${getPercent.percent15>0? 'ventureBox clearfix':'ventureBoxLocked clearfix'}">
							<div class="progressCircle" data-dimension="80" data-text="${getPercent.percent15}%" data-fontsize="16" 
							data-percent="${getPercent.percent15}" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" 
							data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>行銷</h3>
								<p>填寫行銷策略、付費行銷、免費行銷</p>
							</div>
							<i class="fa fa-lock fa-4x fa-top"></i>
							<a href="${getPercent.percent15>0? 'businessMarket':'javascript:;'}" target="_self"></a>
						</div>
 					</li>
 					<li>
						<div class="${getPercent.percent16>0? 'ventureBox clearfix':'ventureBoxLocked clearfix'}">
							<div class="progressCircle" data-dimension="80" data-text="${getPercent.percent16}%" data-fontsize="16" 
							data-percent="${getPercent.percent16}" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" 
							data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>產業定位</h3>
								<p>填寫在產業供應練中的位置</p>
							</div>
							<i class="fa fa-lock fa-4x fa-top"></i>
							<a href="${getPercent.percent16>0? 'businessOrientation':'javascript:;'}" target="_self"></a>
						</div>
 					</li>
 					<li>
						<div class="${getPercent.percent17>0? 'ventureBox clearfix':'ventureBoxLocked clearfix'}">
							<div class="progressCircle" data-dimension="80" data-text="${getPercent.percent17}%" data-fontsize="16"
							 data-percent="${getPercent.percent17}" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" 
							 data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>人力資源規劃</h3>
								<p>填寫人力規劃、組織規模及人力養成圖表</p>
							</div>
							<i class="fa fa-lock fa-4x fa-top"></i>
							<a href="${getPercent.percent17>0? 'humanResourcePlan':'javascript:;'}" target="_self"></a>
						</div>
 					</li>
 					
				</ul>		
			
			
			</div>
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
		<script>
		$(function() {
			$('.progressCircle').circliful();
		});
		</script>
</body>
</html>