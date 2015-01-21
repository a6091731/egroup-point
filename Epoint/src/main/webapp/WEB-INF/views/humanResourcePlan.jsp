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
	<title>人力資源規劃-填寫創業後自我能力精進計畫、期待補強的不同專長能力等等-創業e點通</title>

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
				<div class="banner">
					<div class="imgHolder"><img src="images/banner-office.jpg" alt="banner圖片-辦公室"></div>
				</div>
				<div class="breadcrumbs">
            		<p><a href="index.html">首頁</a> &gt; <a href="#">創業地圖</a> &gt; <a href="#">創業前檢核表地圖</a> &gt;<span>創業前檢核表【人力資源規劃】</span></p>
	            </div>
			</div>
			<div class="grid_3">
				<aside>
					<ul class="sideNav hideBlock">
						<c:forEach items="${getVentureCheckMenuList}" var="menu">
							<c:choose>
								<c:when test="${menu.classID <= getVentureCheckMenuListNow }">
									<li><a href="${menu.url}"><i class="fa fa-child"></i>${menu.name }</a></li>
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
										<c:when test="${menu.classID <= getVentureCheckMenuListNow}">
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
					<h2><i class="fa fa-users fa-color"></i>人力資源規劃</h2>
				</section>
				<form id="sendForm" action="addHumanResourcePlan" method="post">
					<div class="ventureTypesInput clearfix">
						<ul>
							<li>
								<h4>1.人力規劃</h4>
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
												<textarea rows="8" name="content${ventureCehckList.subclassID}" placeholder="近年來，由於經濟繁榮、國民所得提高、人們生活結構發生變化及單身比率年年升高...">${ventureCehckList.content }</textarea>
											</c:when>
											<c:otherwise>
												<textarea rows="8" name="content${ventureCehckList.subclassID}" placeholder="近年來，由於經濟繁榮、國民所得提高、人們生活結構發生變化及單身比率年年升高..."></textarea>
											</c:otherwise>
										</c:choose>	
										</li>	
									</c:forEach>	
								</ul>
							</li>	
							<li>
								<h4 class="productTitle">2.組織規模及人力養成圖表</h4>
									<table class="productTable responsive">
									<thead>
										<tr>
											<th></th>
											<th>建置期</th>
											<th>Q1</th>
											<th>Q2</th>
											<th>Q3</th>
											<th>Q4</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>管理人員</td>
											<td><input type="text" class="input-control0" name="MQ0" id="MQ0" value="${getHumanResourceContentByMember.MQ0}" ></td>
											<td><input type="text" class="input-control1" name="MQ1" id="MQ1" value="${getHumanResourceContentByMember.MQ1}" ></td>
											<td><input type="text" class="input-control2" name="MQ2" id="MQ2" value="${getHumanResourceContentByMember.MQ2}" ></td>
											<td><input type="text" class="input-control3" name="MQ3" id="MQ3" value="${getHumanResourceContentByMember.MQ3}" ></td>
											<td><input type="text" class="input-control4" name="MQ4" id="MQ4" value="${getHumanResourceContentByMember.MQ4}" ></td>
										</tr>
										<tr>
											<td>研發生產</td>
											<td><input type="text" class="input-control0" name="RQ0" id="RQ0" value="${getHumanResourceContentByMember.RQ0}" ></td>
											<td><input type="text" class="input-control1" name="RQ1" id="RQ1" value="${getHumanResourceContentByMember.RQ1}" ></td>
											<td><input type="text" class="input-control2" name="RQ2" id="RQ2" value="${getHumanResourceContentByMember.RQ2}" ></td>
											<td><input type="text" class="input-control3" name="RQ3" id="RQ3" value="${getHumanResourceContentByMember.RQ3}" ></td>
											<td><input type="text" class="input-control4" name="RQ4" id="RQ4" value="${getHumanResourceContentByMember.RQ4}" ></td>
										</tr>
										<tr>
											<td>行銷業務</td>
											<td><input type="text" class="input-control0" name="SQ0" id="SQ0" value="${getHumanResourceContentByMember.SQ0}" ></td>
											<td><input type="text" class="input-control1" name="SQ1" id="SQ1" value="${getHumanResourceContentByMember.SQ1}" ></td>
											<td><input type="text" class="input-control2" name="SQ2" id="SQ2" value="${getHumanResourceContentByMember.SQ2}" ></td>
											<td><input type="text" class="input-control3" name="SQ3" id="SQ3" value="${getHumanResourceContentByMember.SQ3}" ></td>
											<td><input type="text" class="input-control4" name="SQ4" id="SQ4" value="${getHumanResourceContentByMember.SQ4}" ></td>
										</tr>
										<tr>
											<td>其他</td>
											<td><input type="text" class="input-control0" name="OQ0" id="OQ0" value="${getHumanResourceContentByMember.OQ0}" ></td>
											<td><input type="text" class="input-control1" name="OQ1" id="OQ1" value="${getHumanResourceContentByMember.OQ1}" ></td>
											<td><input type="text" class="input-control2" name="OQ2" id="OQ2" value="${getHumanResourceContentByMember.OQ2}" ></td>
											<td><input type="text" class="input-control3" name="OQ3" id="OQ3" value="${getHumanResourceContentByMember.OQ3}" ></td>
											<td><input type="text" class="input-control4" name="OQ4" id="OQ4" value="${getHumanResourceContentByMember.OQ4}" ></td>
										</tr>
										<tr>
											<td>合計</td>
											<td><p id="setTotalQ0">${getHumanResourceContentByMember.totalQ0}</p><input type="hidden" name="totalQ0" id="totalQ0" ></td>
											<td><p id="setTotalQ1">${getHumanResourceContentByMember.totalQ1}</p><input type="hidden" name="totalQ1" id="totalQ1" ></td>
											<td><p id="setTotalQ2">${getHumanResourceContentByMember.totalQ2}</p><input type="hidden" name="totalQ2" id="totalQ2" ></td>
											<td><p id="setTotalQ3">${getHumanResourceContentByMember.totalQ3}</p><input type="hidden" name="totalQ3" id="totalQ3" ></td>
											<td><p id="setTotalQ4">${getHumanResourceContentByMember.totalQ4}</p><input type="hidden" name="totalQ4" id="totalQ4" ></td>
										</tr>
									</tbody>
								</table>
							</li>
						</ul>						
						<button type="submit" class="nextStepButton">
							<span class="next">恭喜您完成創業檢核表 !<i class="fa fa-arrow-right"></i></span>
						</button>
					</div>
				</form>
			</div>
		</div>			
	</div>


	<!-- BEGIN MODAL WINDOWS -->
	<div id="helpLink" class="reveal-modal">
		<header class="reveal-modal-header">
			我需要範例協助
		</header>
		<div class="cont clearfix">
			<p>
				近年來，由於經濟繁榮、國民所得提高、人們生活結構發生變化及單身比率年年升高...
			</p>
		</div>
		<a class="close-reveal-modal">&#215;</a>
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
		<script type="text/javascript">
	        $(function() {
	            $('nav.primary .rightnav').mobileMenu();
	            $('.input-control0').keyup(function(){
	            	//alert($('#MQ0').val());
		            $('#setTotalQ0').text(Number($('#MQ0').val())+Number($('#RQ0').val())+Number($('#SQ0').val())+Number($('#OQ0').val()));
		            $('#totalQ0').val(parseInt($('#setTotalQ0').text()));
	            });
	            
	            $('.input-control1').keyup(function(){
	            	//alert($('#MQ0').val());
	            	 $('#setTotalQ1').text(Number($('#MQ1').val())+Number($('#RQ1').val())+Number($('#SQ1').val())+Number($('#OQ1').val()));
	            	 $('#totalQ1').val(parseInt($('#setTotalQ1').text()));
		        });
	            
	            $('.input-control2').keyup(function(){
	            	//alert($('#MQ0').val());
	            	 $('#setTotalQ2').text(Number($('#MQ2').val())+Number($('#RQ2').val())+Number($('#SQ2').val())+Number($('#OQ2').val()));
	            	 $('#totalQ2').val(parseInt($('#setTotalQ2').text()));
		        });
	            
	            $('.input-control3').keyup(function(){
	            	//alert($('#MQ0').val());
	            	 $('#setTotalQ3').text(Number($('#MQ3').val())+Number($('#RQ3').val())+Number($('#SQ3').val())+Number($('#OQ3').val()));
	            	 $('#totalQ3').val(parseInt($('#setTotalQ3').text()));
		        });	
	            
	            $('.input-control4').keyup(function(){
	            	//alert($('#MQ0').val());
	            	 $('#setTotalQ4').text(Number($('#MQ4').val())+Number($('#RQ4').val())+Number($('#SQ4').val())+Number($('#OQ4').val()));
	            	 $('#totalQ4').val(parseInt($('#setTotalQ4').text()));
		        });
	        });
	    </script>
	 <!-- responsive-table -->  
	    <script src="js/responsive-tables.js"></script>
</body>
</html>