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
	<title>創業第一年資金規劃地圖-請依順序完成您的創業第一年資金規劃-創業e點通</title>

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
					<a href="index"><img src="./images/egroup.png" alt="創業e點通品牌標誌"></a>
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
            		<p><a href="index.html">首頁</a> &gt; <a href="#">創業地圖</a> &gt; <span>創業第一年資金規劃地圖</span></p>
	            </div>
			</div>
	        <div class="grid_6 prefix_3 suffix_3">
	        	<form>
					<section class="ventureChecklistTitle">
						<img alt="創業第一年資金規劃圖示" src="images/ventureCapital.png">
						<h2>創業第一年資金規劃</h2>
						<ul>
							<li>請填寫您的創業時間，我們將以您設定的時間為基準往後一年作為您的營運排程。</li>
							<li>您創業第一年的時間：</li>
							<li><input type="month" class="form-control2" name="cardDate">至
								<input type="month" class="form-control2" name="cardDate"></li>
							<li>設定好您的創業時間後，可以開始進行您的營運試算，營運試算分為下列兩個部分：1.支出結構 2.收入結構</li>
						</ul>
					</section>
				</form>
			</div>
		</div>			
	</div>
	<div class="ventureChecklist clearfix">
		<div class="container">
			<div class="grid_6 prefix_3 suffix_3">
				<ul>
					<li>
						<div class="ventureBox clearfix">
							<div class="progressCircle" data-dimension="80" data-text="${getMember.getPercent}%" data-fontsize="16" data-percent="${getMember.getPercent}" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>支出結構</h3>
								<p>第一年總支出 : ${getMember.expenditure}</p>
							</div>
							<i class="fa fa-angle-right fa-5x"></i>
							<a href="founded" target="_self"></a>
						</div>
 					</li>
					<li>
						<div class="ventureBox clearfix">
							<div class="progressCircle" data-dimension="80" data-text="0%" data-fontsize="16" data-percent="0" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>收入結構</h3>
								<p>第一年總收入 : ${getMember.income}</p>
							</div>
							<i class="fa fa-angle-right fa-5x"></i>
							<a href="revenueStructure" target="_self"></a>
						</div>
 					</li> 
					<!-- lock style
					<li>
						<div class="ventureBoxLocked clearfix">
							<div class="progress" data-dimension="80" data-text="0%" data-fontsize="16" data-percent="0" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>收入結構</h3>
								<p>填寫目標客戶、提供給顧客什麼價值、顧客從中能得到什麼好處</p>
							</div>
							<i class="fa fa-lock fa-4x fa-top"></i>
							<a href="javascript:;" target="_self"></a>
						</div>
 					</li> 
 					-->
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