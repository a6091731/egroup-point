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
					<a href="index"><img src="./images/egroup.png"
						alt="創業e點通品牌標誌"></a>
				</div>
				<!-- logo -->
				<nav class="clearfix">
					<div class="top-nav">
						<div class="top-nav-right">
							<a href="ventureChecklistMap" id="loginButton"><span>創業地圖</span></a>
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
						<a href="index">首頁</a> &gt; <a href="venturePlanMap">創業地圖</a> &gt; <a
							href="ventureChecklistMap">創業前檢核表地圖</a> &gt;<span>創業前檢核表【目標市場描述】</span>
					</p>
				</div>
			</div>
			<div class="grid_3">
				<aside>
					<ul class="sideNav hideBlock">
						<c:forEach items="${getVentureCheckMenuList}" var="menu">
							<c:choose>
								<c:when test="${menu.classID <= getVentureCheckMenuListNow+1}">
									<li><a href="${menu.url}"><i class="${menu.css}"></i>${menu.name }</a></li>
								</c:when>
								<c:otherwise>
									<li><div class="mask"></div> <a href="${menu.url}"><i class="fa fa-lock"></i>${menu.name }</a></li>
								</c:otherwise>
							</c:choose>							
						</c:forEach>						
					</ul>
					<div class="memberRwdnav clearfix">
						<nav class="primary">
							<ul class="rightnav">
								<c:forEach items="${getVentureCheckMenuList}" var="menu">
									<c:choose>
										<c:when test="${menu.classID <= getVentureCheckMenuListNow+1}">
											<li><a href="${menu.url}">${menu.name}</a></li>
										</c:when>
										<c:otherwise>
											<li><a href="${menu.url}">(鎖) ${menu.name}</a></li>
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</ul>
						</nav>
					</div>
				</aside>
			</div>
			<div class="grid_9">
				<section class="ventureTypesTitle hideBlock">
					<h2>
						<img alt="創業業種圖示" src="images/type.png">目標市場描述
					</h2>
				</section>
				<form id="sendForm" action="addTargetMarketDescribeCont" method="post">
					<div class="ventureTypesInput clearfix">
						<ul>
						<c:forEach items="${getVentureCheckListByMember}" var="ventureCehckList">
							<li>
								<input type="hidden" name="mapClassID" id="${ventureCehckList.classID}">
								<input type="hidden" name="mapSubClassID" id="${ventureCehckList.subclassID}">
								<h4>${ventureCehckList.name}</h4> 
								<a href="javascript:;" data-reveal-id="help${ventureCehckList.subclassID}"><span>
								<i class="fa fa-exclamation-circle"></i>我需要範例協助</span></a> 
							<c:choose>
								<c:when test="${!empty ventureCehckList.content}">
									<textarea rows="8" id="content${ventureCehckList.subclassID}" name="content${ventureCehckList.subclassID}" placeholder="近年來，由於經濟繁榮、國民所得提高、人們生活結構發生變化及單身比率年年升高...">${ventureCehckList.content }</textarea>
								</c:when>
								<c:otherwise>
									<textarea rows="8" id="content${ventureCehckList.subclassID}" name="content${ventureCehckList.subclassID}" placeholder="近年來，由於經濟繁榮、國民所得提高、人們生活結構發生變化及單身比率年年升高..."></textarea>
								</c:otherwise>
							</c:choose>	
							</li>	
						</c:forEach>								
						</ul>
						<button type="submit" class="nextStepButton">
							<span class="next">下一步，填寫產品描述<i class="fa fa-arrow-right"></i></span>
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
	<script src="js/jquery.validate.js"></script>
	<script type="text/javascript">
		$(function() {
			$('nav.primary .rightnav').mobileMenu();

			$("#sendForm").validate({
            	rules:{
            		content121:{
            			required:true,
            			maxlength:150
            		},			
					content122:{
		    			required:true,
		    			maxlength:150
		    		},
            		content123:{
		    			required:true,
		    			maxlength:150
		    		} 
            	},
            	messages:{
            		content121:{
            			required:"此欄位不能空白",
            			maxlength:"長度不能超過{0}"
            		},
            		content122:{
            			required:"此欄位不能空白",
            			maxlength:"長度不能超過{0}"
            		},
            		content123:{
            			required:"此欄位不能空白",
            			maxlength:"長度不能超過{0}"
            		}
            	}
            });	 
			
			$("#content121").attr("placeholder","性別、年齡、職業");
			$("#content122").attr("placeholder","餐飲業 : 提供食物外，另提供 內用、外帶、外送等服務，內有冷氣冷氣");
			$("#content123").attr("placeholder","餐飲業 : 本店都使用有機米，手工麵條早上現做，搭配無農藥自種韭菜，保證吃了健康");
		});
	</script>
	<!-- BEGIN MODAL WINDOWS -->
	<!-- targetCustomers -->
	<div id="help121" class="reveal-modal">
		<header class="reveal-modal-header">範例協助  : 目標客戶是誰?(誰會買我的東西)</header>
		<div class="cont clearfix">
			<p>性別</p>
			<p>年齡</p>
			<p>職業</p>
		</div>
	</div>	
	<!-- valueProvided -->
	<div id="help122" class="reveal-modal">
		<header class="reveal-modal-header">範例協助  : 能提供給顧客什麼價值?(能提供給顧客什麼服務)</header>
		<div class="cont clearfix">
			<p>餐飲業 : 提供食物外，另提供 內用、外帶、外送等服務，內有冷氣冷氣</p>
		</div>
	</div>	
	<!-- customersBenefits -->
	<div id="help123" class="reveal-modal">
		<header class="reveal-modal-header">範例協助  : 顧客能從中得到什麼好處?(買我東西有什麼附加價值)</header>
		<div class="cont clearfix">
			<p>餐飲業 : 本店都使用有機米，手工麵條早上現做，搭配無農藥自種韭菜，保證吃了健康</p>
		</div>
	</div>	
</body>
</html>