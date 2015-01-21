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
 	<meta name="description" content="資金規劃地圖-算出你的創業資金需求並規劃-創業e點通">  
	<title>資金規劃地圖-算出你的創業資金需求並規劃-創業e點通</title>

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
            		<p><a href="index.html">首頁</a> &gt; <a href="#">創業地圖</a> &gt; <span>資金規劃地圖</span></p>
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
				<div class="financialBox">您的月平均費用:<br/> 10 元<br/>(參考創業第一年營運排程中的收支報表)</div>
			</div>
			<div class="grid_3 suffix_3">
				<div class="financialBox">目前您累積的資金缺口<br/> <input type="text" class="input-control" name="input1">元<br/>(填寫您不足的資金)</div>
			</div>
			<div class="grid_6 prefix_3 suffix_3">
				<div class="financialBox">月平均費用*3 + 資金缺口 = 第一年創業資金需求<br/>10*3+7=37<br/><h3>您的第一年創業資金需求=37元</h3></div><!-- 
				<section class="ventureTypesTitle">
					<h2><i class="fa fa-usd fa-color"></i>計算第一年創業資金</h2>

				<h4>第一年創業資金需求 = 每月平均費用*3 + 目前您累積的資金缺口(不足的資金)</h4>
				<div class="financialBox">目前您累積的資金缺口<br/> <input type="text" class="input-control" name="input1">元<br/>(不足的資金)</div>
				</section> -->
			</div>
			<div class="grid_6 prefix_3 suffix_3">
				<section class="ventureTypesTitle">
					<h2><i class="fa fa-usd fa-color"></i>規劃資金</h2>
				</section>
			</div>
			<div class="grid_6 prefix_3 suffix_3">
				<form>
					<div class="ventureTypesInput clearfix">
						<ul>
							<li>
								<h4 class="productTitle">
								資金用途總額 = 資金需求 37</h4>
									
								
									<table class="productTable ">
									<thead>
										<tr>
											<th>資金用途</th>
											<th colspan="2">金額</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td colspan="3"><button class="addbutton"><i class="fa fa-plus"></i> 新增一筆用途</button> </td>
										</tr>
										<tr>
											<td><input type="text" class="input-control" name="input1"></td>
											<td><input type="text" class="input-control" name="input1"> 元</td>
											<td><button class="deletebutton"><i class="fa fa-times"></i></button></td>
										</tr>

										<tr>
											<td>用途總額</td>
											<td colspan="2">20元</td>
										</tr>
										<tr class="redText">
											<td>驗證不合</td>
											<td colspan="2">差17元</td>
										</tr>
									</tbody>
								</table>
							</li>
						</ul>
					</div>
				</form>
			</div>
			<div class="grid_6 prefix_3 suffix_3">
				<form>
					<div class="ventureTypesInput clearfix">
						<ul>
							<li>
								<h4 class="productTitle">
								資金來源總額 = 資金需求 37</h4>
									
								
									<table class="productTable ">
									<thead>
										<tr>
											<th>資金來源</th>
											<th colspan="2">金額</th>
										</tr>
									</thead>
									<tbody>

										<tr>
											<td colspan="3"><button class="addbutton"><i class="fa fa-plus"></i> 新增一筆用途</button> </td>
										</tr>
										<tr>
											<td><input type="text" class="input-control" name="input1"></td>
											<td><input type="text" class="input-control" name="input1"> 元</td>
											<td><button class="deletebutton"><i class="fa fa-times"></i></button></td>
										</tr>
										<tr>
											<td>來源總額</td>
											<td colspan="2">46789 元</td>
										</tr>

										<tr class="greenText">
											<td>驗證通過</td>
											<td colspan="2">差0元</td>
										</tr>
									</tbody>
								</table>
							</li>
						</ul>
						<a href="javascript:;" class="nextStepButton"><span class="next">完成資金規劃 <i class="fa fa-arrow-right"></i></span></a>
					</div>
				</form>
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
		$( document ).ready(function() {
		        $('.progress').circliful();
		    });
		</script>

	<!-- responsive-table -->  
	    <script src="js/responsive-tables.js"></script>
</body>
</html>