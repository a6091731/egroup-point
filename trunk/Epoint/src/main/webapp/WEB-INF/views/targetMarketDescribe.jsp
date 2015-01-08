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
<meta name="description" content="創業業種-填寫創業業種、商業模式和在此行業的一技之長-創業e點通">
<title>創業業種-填寫創業業種、商業模式和在此行業的一技之長-創業e點通</title>

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
					<a href="index.html"><img src="./images/egroup.png"
						alt="創業e點通品牌標誌"></a>
				</div>
				<!-- logo -->
				<nav class="clearfix">
					<div class="top-nav">
						<div class="top-nav-right">
							<a href="javascript:;" id="loginButton"><span>創業地圖</span></a>
						</div>
					</div>
					<!-- top-nav -->
				</nav>
			</div>
			<!-- grid_12 -->
		</div>
		<!-- container -->
	</header>
	<div class="wrapper clearfix">
		<div class="container">
			<div class="grid_12">
				<div class="banner">
					<div class="imgHolder">
						<img src="images/banner-office.jpg" alt="banner圖片-辦公室">
					</div>
				</div>
				<div class="breadcrumbs">
					<p>
						<a href="index.html">首頁</a> &gt; <a href="#">創業地圖</a> &gt; <a
							href="#">創業前檢核表地圖</a> &gt;<span>創業前檢核表【創業業種】</span>
					</p>
				</div>
			</div>
			<div class="grid_3">
				<aside>
					<ul class="sideNav hideBlock">
						<li><a href="javascript:;"><i class="fa fa-child"></i>創業業種</a></li>
						<li><div class="mask"></div> <a href="javascript:;"><i
								class="fa fa-lock"></i>目標市場描述</a></li>
						<li><div class="mask"></div> <a href="javascript:;"><i
								class="fa fa-lock"></i>產品描述</a></li>
						<li><div class="mask"></div> <a href="javascript:;"><i
								class="fa fa-lock"></i>業務</a></li>
						<li><div class="mask"></div> <a href="javascript:;"><i
								class="fa fa-lock"></i>行銷</a></li>
						<li><div class="mask"></div> <a href="javascript:;"><i
								class="fa fa-lock"></i>產品定位</a></li>
						<li><div class="mask"></div> <a href="javascript:;"><i
								class="fa fa-lock"></i>人力資源規劃</a></li>
					</ul>
					<div class="memberRwdnav clearfix">
						<nav class="primary">
							<ul class="rightnav">
								<li><a href="javascript:;">創業業種</a></li>
								<li><a href="javascript:;">(鎖) 目標市場描述</a></li>
								<li><a href="javascript:;">(鎖) 產品描述</a></li>
								<li><a href="javascript:;">(鎖) 行銷</a></li>
								<li><a href="javascript:;">(鎖) 產品定位</a></li>
								<li><a href="javascript:;">(鎖) 人力資源規劃</a></li>
							</ul>
						</nav>
					</div>
				</aside>
			</div>
			<div class="grid_9">
				<section class="ventureTypesTitle hideBlock">
					<h2>
						<img alt="創業業種圖示" src="images/type.png">創業業種
					</h2>
				</section>
				<form id="sendForm" action="addVentureTypeCont" method="post">
					<div class="ventureTypesInput clearfix">
						<ul>
							<li>
								<h4>1.創業業種(內容)：</h4> 
								<a href="javascript:;" data-reveal-id=helpVentureType><span>
								<i class="fa fa-exclamation-circle"></i>我需要範例協助</span></a> 
								<textarea rows="8" name="content1" placeholder="近年來，由於經濟繁榮、國民所得提高、人們生活結構發生變化及單身比率年年升高..."></textarea>
							</li>
							<li>
								<h4>2.商業模式(生意賺錢的方法)：</h4> 
								<a href="javascript:;" data-reveal-id="helpBusinessModel"><span>
								<i class="fa fa-exclamation-circle"></i>我需要範例協助</span></a> 
								<textarea rows="8" name="content2" placeholder="商業模式(生意賺錢的方法)：範例"></textarea>
							</li>
							<li>
								<h4>3.自己在此行業的一技之長：</h4> 
								<a href="javascript:;" data-reveal-id="helpLink"><span>
								<i class="fa fa-exclamation-circle"></i>我需要範例協助</span></a> 
								<textarea rows="8" name="content3" placeholder="自己在此行業的一技之長：範例"></textarea>
							</li>
						</ul>
						<button type="submit" class="nextStepButton">
							<span class="next">下一步，填寫目標市場描述<i class="fa fa-arrow-right"></i></span>
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>




	<!-- import jquery -->
	<!-- <script src="js/jquery-1.9.1.min.js"></script>此版本jquery 無法顯示彈窗，看要不要改成1.7.1 -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

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
	<!-- BEGIN MODAL WINDOWS -->
	<!-- helpVentureType -->
	<div id="helpVentureType" class="reveal-modal">
		<header class="reveal-modal-header">範例協助  : 創業業種(內容)</header>
		<div class="cont clearfix">
			<p>近年來，由於經濟繁榮、國民所得提高、人們生活結構發生變化及單身比率年年升高...</p>
		</div>
	</div>	
	<!-- helpBusinessModel -->
	<div id="helpBusinessModel" class="reveal-modal">
		<header class="reveal-modal-header">範例協助  : 商業模式(生意賺錢的方法)</header>
		<div class="cont clearfix">
			<p></p>
		</div>
	</div>	
</body>
</html>