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
 	<meta name="description" content="創業-支出結構-規畫你的創業第一年支出-創業e點通">  
	<title>產品描述-填寫每項產品的規格、說明、定價、銷售價格、直接成本-創業e點通</title>

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
            		<p><a href="index.html">首頁</a> &gt; <a href="#">創業地圖</a> &gt; <a href="#">創業前檢核表地圖</a> &gt;<span>創業前檢核表【產品描述】</span></p>
	            </div>
			</div>
			<div class="grid_3">
				<aside>
					<ul class="sideNav hideBlock">
						<li><a href="javascript:;"><i class="fa fa-child"></i>創業業種</a></li>
						<li><a href="javascript:;"><i class="fa fa-lock"></i>目標市場描述</a></li>
						<li><a href="javascript:;"><i class="fa fa-lock"></i>產品描述</a></li>
						<li><div class="mask"></div><a href="javascript:;"><i class="fa fa-lock"></i>業務</a></li>
						<li><div class="mask"></div><a href="javascript:;"><i class="fa fa-lock"></i>行銷</a></li>
						<li><div class="mask"></div><a href="javascript:;"><i class="fa fa-lock"></i>產品定位</a></li>
						<li><div class="mask"></div><a href="javascript:;"><i class="fa fa-lock"></i>人力資源規劃</a></li>
					</ul>	
	                <div class="memberRwdnav clearfix">
	                    <nav class="primary">
	                        <ul class="rightnav">
	                            <li>
	                                <a href="javascript:;">公司成立</a>
	                            </li>	                        
	                            <li>
	                                <a href="javascript:;">(鎖) 營業場所完工</a>
	                            </li>
	                            <li>
	                                <a href="javascript:;">(鎖) 人員到位</a>
	                            </li>
	                            <li>
	                                <a href="javascript:;">(鎖) 生產設備建置</a>
	                            </li>
	                            <li>
	                                <a href="javascript:;">(鎖) 試產</a>
	                            </li>
	                            <li>
	                                <a href="javascript:;">(鎖) 原料採購</a>
	                            </li>
	                            <li>
	                                <a href="javascript:;">(鎖) 試營運</a>
	                            </li>
	                            <li>
	                                <a href="javascript:;">(鎖) 通路開發</a>
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
					<h2><i class="fa fa-file-text-o fa-color"></i>產品描述</h2>
				</section>


				<form class="formset2 clearfix">					
					<fieldset>
					  	<a class="addProduct" data-reveal-id ="addProduct"><i class="fa fa-plus"></i> 新增一項產品</a>
					  	<table class="productTable responsive">
								<thead>
									<tr>
										<th>產品名稱</th>
										<th>終端消費者定價</th>
										<th>實質銷售價格</th>
										<th>直接成本</th>
										<th>編輯</th>
										<th>刪除</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td>好吃的旺旺仙貝</td>
										<td>200</td>
										<td>180</td>
										<td>100</td>
										<td><a href="javascript:;" class="fa-color"><i class="fa fa-pencil-square-o fa-lg"></i></a></td>
										<td><a href="javascript:;" class="fa-color"><i class="fa fa-times-circle fa-lg"></i></a></td>
									</tr>
									<tr>
										<td>好吃的旺旺仙貝</td>
										<td>200</td>
										<td>180</td>
										<td>100</td>
										<td><a href="javascript:;" class="fa-color"><i class="fa fa-pencil-square-o fa-lg"></i></a></td>
										<td><a href="javascript:;" class="fa-color"><i class="fa fa-times-circle fa-lg"></i></a></td>
									</tr>
									<tr>
										<td>好吃的旺旺仙貝</td>
										<td>200</td>
										<td>180</td>
										<td>100</td>
										<td><a href="javascript:;" class="fa-color"><i class="fa fa-pencil-square-o fa-lg"></i></a></td>
										<td><a href="javascript:;" class="fa-color"><i class="fa fa-times-circle fa-lg"></i></a></td>
									</tr>
									<tr>
										<td>好吃的旺旺仙貝</td>
										<td>200</td>
										<td>180</td>
										<td>100</td>
										<td><a href="javascript:;" class="fa-color"><i class="fa fa-pencil-square-o fa-lg"></i></a></td>
										<td><a href="javascript:;" class="fa-color"><i class="fa fa-times-circle fa-lg"></i></a></td>
									</tr>
								</tbody>
							</table>
							<div class="text-center">
								<ul class="pagination">
		                            <li class="prev disabled"><a href="#">←</a></li>
		                            <li class="active"><a href="#">1</a></li>
		                            <li><a href="javascript:;">2</a></li>
		                            <li><a href="javascript:;">3</a></li>
		                            <li class="next"><a href="#">→</a></li>
		                        </ul>
	                        </div>
					</fieldset>	
					<div class="mt50px">
						<a href="javascript:;" class="nextStepButton"><span class="next">下一步，填寫營業場所完工<i class="fa fa-arrow-right"></i></span></a>
					</div>
				  </form>
			</div>
		</div>			
	</div>

	<!-- BEGIN MODAL WINDOWS -->
	<div id="addProduct" class="reveal-modal">
		<header class="reveal-modal-header">
			新增產品 : 產品描述
		</header>
		<form id="sendForm" action="addProduct" method="post">
			<div class="cont clearfix">
				產品名稱 : <input type="text" name="name"><br>
				產品規格 : <input type="text" name="specification"><br>
				產品包裝 : <input type="text" name="pack"><br>
				終端消費者定價 : <input type="text" name="endPrice"><br>
				實質銷售價格 : <input type="text" name="salesPrice"><br>
				直接成本 : <input type="text" name="cost"><br>
			</div>
			<button type="submit" class="nextStepButton">
				<span class="next">新增產品<i class="fa fa-arrow-right"></i></span>
			</button>
		</form>
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
</body>
</html>