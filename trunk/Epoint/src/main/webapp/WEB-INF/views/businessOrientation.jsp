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
	<title>產業定位-填寫在產業供應鏈中的位置.誰是競爭對手等等-創業e點通</title>
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
					<a href="index"><img src="./images/egroup.png" alt="創業e點通品牌標誌"></a>
				</div><!-- logo -->
				<nav class="clearfix">
					<div class="top-nav">
						<div class="top-nav-right">
							<a href="ventureChecklistMap" id="loginButton"><span>創業地圖</span></a>
						</div>
					</div><!-- top-nav -->
				</nav>
			</div><!-- grid_12 -->
		</div><!-- container -->
	</header>
	<div class="wrapper clearfix">
		<div class="container">
			<div class="grid_12">
				<div class="banner">
					<div class="imgHolder"><img src="images/banner-office.jpg" alt="banner圖片-辦公室"></div>
				</div>
				<div class="breadcrumbs">
            		<p><a href="index">首頁</a> &gt; <a href="venturePlanMap">創業地圖</a> &gt; <a
							href="ventureChecklistMap">創業前檢核表地圖</a> &gt;<span>創業前檢核表【產業定位】</span></p>
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
					<h2><i class="fa fa-paper-plane fa-color"></i>產業定位</h2>
				</section>
				<form id="sendForm" action="addBusinessOrientationCont" method="post">
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
									<textarea rows="8" id="content${ventureCehckList.subclassID}" name="content${ventureCehckList.subclassID}">${ventureCehckList.content }</textarea>
								</c:when>
								<c:otherwise>
									<textarea rows="8"id="content${ventureCehckList.subclassID}" name="content${ventureCehckList.subclassID}"></textarea>
								</c:otherwise>
							</c:choose>	
							</li>	
						</c:forEach>				
					</ul>
						<button type="submit" class="nextStepButton">
							<span class="next">下一步，填寫人力資源規劃<i class="fa fa-arrow-right"></i></span>
						</button>
					
				</div>
				</form>
			</div>
		</div>			
	</div>


	<!-- BEGIN MODAL WINDOWS -->
	<div id="help161" class="reveal-modal">
		<header class="reveal-modal-header">範例協助  : 在產業供應鏈中的位置</header>
		<div class="cont clearfix">
			<p>從上游拿甚麼原料做產品，賣給誰?</p>	
			<p>跟誰買什麼貨?</p>	
			<p>用什麼方法?</p>	
			<p>賣給誰?</p>			
		</div>
	</div>	
	<div id="help162" class="reveal-modal">
		<header class="reveal-modal-header">範例協助  : 誰是競爭對手?(誰跟我賣一樣的東西)</header>
		<div class="cont clearfix">
			<p>7-11 V.S 全家</p>
			<p>燒仙草   V.S 黑丸</p>	
			<p>麥當勞   V.S 肯德基</p>	
		</div>
	</div>
	<div id="help163" class="reveal-modal">
		<header class="reveal-modal-header">範例協助  : 品質跟競爭者的對應關係為何?</header>
		<div class="cont clearfix">
			<p>我的產品品質比起競爭對手，哪裡比較好? 哪裡比較差? 要如何改善?</p>	
		</div>
	</div>
	<div id="help164" class="reveal-modal">
		<header class="reveal-modal-header">範例協助  : 價格跟競爭者的對應關係為何?</header>
		<div class="cont clearfix">
			<p>我的產品價格比起競爭對手，是比較貴? 還是比較便宜? 為什麼?</p>	
		</div>
	</div>
	<div id="help165" class="reveal-modal">
		<header class="reveal-modal-header">範例協助  : 服務跟競爭者的對應關係為何?</header>
		<div class="cont clearfix">
			<p>我的服務比起競爭對手，哪裡比較好? 哪裡比較差? 要如何改善?</p>			
		</div>
	</div>
	<div id="help166" class="reveal-modal">
		<header class="reveal-modal-header">範例協助  : 如何發展策略聯盟?</header>
		<div class="cont clearfix">
			<p>有沒有跟其他人合作一起開發產品或是推廣市場的機會?</p>			
		</div>
	</div>
	
	<!-- import jquery -->
	<!-- <script src="js/jquery-1.9.1.min.js"></script>此版本jquery 無法顯示彈窗，看要不要改成1.7.1 -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	
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

	        	$("#content161").attr("placeholder","從上游拿甚麼原料做產品，賣給誰? 跟誰買什麼貨? 用什麼方法? 賣給誰?");
				$("#content162").attr("placeholder","7-11 V.S 全家 ； 燒仙草   V.S 黑丸 ； 麥當勞   V.S 肯德基");
				$("#content163").attr("placeholder","我的產品品質比起競爭對手，哪裡比較好? 哪裡比較差? 要如何改善?");
				$("#content164").attr("placeholder","我的產品價格比起競爭對手，是比較貴? 還是比較便宜? 為什麼?");
				$("#content165").attr("placeholder","我的服務比起競爭對手，哪裡比較好? 哪裡比較差? 要如何改善?");
				$("#content166").attr("placeholder","有沒有跟其他人合作一起開發產品或是推廣市場的機會?");
	            
	            $("#sendForm").validate({
	            	rules:{
	            		content161:{
	            			required:true,
	            			maxlength:150
	            		},			
						content162:{
			    			required:true,
			    			maxlength:150
			    		},
	            		content163:{
			    			required:true,
			    			maxlength:150
			    		},
	            		content164:{
			    			required:true,
			    			maxlength:150
			    		},
	            		content165:{
			    			required:true,
			    			maxlength:150
			    		},
	            		content166:{
			    			required:true,
			    			maxlength:150
			    		}
	            	},
	            	messages:{
	            		content161:{
	            			required:"此欄位不能空白",
	            			maxlength:"長度不能超過{0}"
	            		},
	            		content162:{
	            			required:"此欄位不能空白",
	            			maxlength:"長度不能超過{0}"
	            		},
	            		content163:{
	            			required:"此欄位不能空白",
	            			maxlength:"長度不能超過{0}"
	            		},
	            		content164:{
	            			required:"此欄位不能空白",
	            			maxlength:"長度不能超過{0}"
	            		},
	            		content165:{
	            			required:"此欄位不能空白",
	            			maxlength:"長度不能超過{0}"
	            		},
	            		content166:{
	            			required:"此欄位不能空白",
	            			maxlength:"長度不能超過{0}"
	            		}
	            	}
	            });	 
	        });
	    </script>
</body>
</html>