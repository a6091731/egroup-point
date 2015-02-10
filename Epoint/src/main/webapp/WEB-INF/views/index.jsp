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
 	<meta name="description" content="首頁-創業e點通">  
	<title>首頁-創業e點通</title>

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
						<!-- 第二階段導覽列top-nav-left -->	 
						<div class="top-nav-left">
							<span class="menu"> </span> 
							<ul>
 								<li><a href="javascript:;">關於我們</a></li>
								<li><a href="#works" class="scroll">專業顧問</a></li>
								<li><a href="#Properties" class="scroll">成功案例</a></li>
								<li><a href="javascript:;" class="scroll">我想創業</a></li>
								<li><a href="#projects" class="scroll" >創業Q&A</a></li>
								<li><a href="#Community" class="scroll">聯絡我們</a></li>
							 </ul>
						</div> 
						
						<div class="top-nav-right">
						<c:choose>
							<c:when test="${loginMember!=null}">
								<p id="memberName">Hi~${loginMember.name }，歡迎您登入<p>
								<a href="logout" id="loginButton"><span>登出</span></a>
							</c:when>
							<c:otherwise>
								<a href="memberLogin" id="loginButton"><span>登入</span></a>
							</c:otherwise>
						</c:choose>
					</div><!-- top-nav -->
				</nav>
			</div><!-- grid_12 -->
		</div><!-- container -->
	</header>
	<div class="indexbanner">
		<div class="banner-info text-center">
			<h1>想要創業卻不知道如何跨出第一步嗎？<br>
				專業顧問.精闢分析.真心回饋<br>
				讓您事半功倍.實現夢想
			</h1>
			<div class="clearfix"> </div>
			<a href="venturePlanMap" class="indexButton"><span class="next">我想創業<i class="fa fa-paper-plane fa-lg fa-left"></i></span></a>
		</div>
	</div>
	<!--  
	<div>
		我該如何創業
	</div>
	<div>
		創業該注意什麼？
	</div>
	-->
	<footer class="footerwrap">
		<div class="container">
			<div class="grid_12">
				<span>©2015 創業e點通 </span>
			</div>
		</div>
	</footer>
	
	<!-- import jquery -->
	<script src="js/jquery-1.9.1.min.js"></script>
	<!-- import nav slideToggle RWD js -->	
	<script src="js/nav.js"></script>
		
	<script src="js/fixtop.js"></script>
</body>
</html>