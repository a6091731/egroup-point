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
	<title>創業規劃地圖-展開您的創業之旅，接下來我們將協助您規劃，幫助您實現夢想-創業e點通</title>
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
	
	<link rel="stylesheet" href="css/progress.css">
	

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
            		<p><a href="index.html">首頁</a> &gt; <a href="#">創業地圖</a></p>
	            </div>
			</div>
	        <div class="grid_6 prefix_3 suffix_3">
				<section class="ventureChecklistTitle">
					<h2>創業地圖</h2>
					<p>展開您的創業之旅，接下來我們將協助您規劃，幫助您實現夢想</p>
				</section>
			</div>
			
			
			<div class="grid_4" id="step1">
				<div class="step" id="step11">
					<div class="stepDescribe">
						<img alt="創業前檢核表圖示" src="images/ventureCheck.png">
						<h2>1.創業前檢核表</h2>
						<p>首先，請依順序完成您的創業前檢核表</p>
					</div>					
					<div id="step1Progress">
					  <div class="bar">
					    <div class="progress"></div>
					  </div>
					</div>		
					<a href="ventureChecklistMap" class="startButton" id="step1Url"><span class="next" id="step1Name">開始填寫<i class="fa fa-play-circle fa-lg fa-left"></i></span></a>					
				</div>
			</div>			
			<div class="grid_4" id="step2">
				<div class="stepLocked" id="step21">
					<div class="stepDescribe">
						<img alt="創業第一年資金規劃圖示" src="images/ventureCapitalLock.png">
						<h2>2.創業第一年資金規劃</h2>
						<p>完成創業前檢核表後，接下來請依順序完成您的創業第一年資金規劃</p>
					</div>
					<i class="fa fa-lock fa-4x fa-top"></i>
				</div>
			</div>
			<div class="grid_4" id="step3">
				<div class="stepLocked" id="step31">
					<div class="stepDescribe">
						<img alt="資金規劃地圖圖示" src="images/financialPlanLock.png">
						<h2>3.資金規劃地圖</h2>
						<p>恭喜您完成了創業檢核表與創業第一年營運排程，接下來做資金規劃</p>
					</div>
					<i class="fa fa-lock fa-4x fa-top"></i>
				</div>
			</div>
			
			<!-- 
			<div class="grid_4">
				<div class="step">
					<div class="stepDescribe">
						<img alt="創業前檢核表圖示" src="images/ventureCheck.png">
						<h2>1.創業前檢核表</h2>
						<p>首先，請依順序完成您的創業前檢核表</p>
					</div>					
					<a href="ventureChecklistMap" class="startButton"><span class="next">開始填寫<i class="fa fa-play-circle fa-lg fa-left"></i></span></a>
				</div>
			</div>
			<div class="grid_4">
				<div class="stepLocked">
					<div class="stepDescribe">
						<img alt="創業第一年資金規劃圖示" src="images/ventureCapitalLock.png">
						<h2>2.創業第一年資金規劃</h2>
						<p>完成創業前檢核表後，接下來請依順序完成您的創業第一年資金規劃</p>
					</div>
					<i class="fa fa-lock fa-4x fa-top"></i>
				</div>
			</div>
			<div class="grid_4">
				<div class="stepLocked">
					<div class="stepDescribe">
						<img alt="資金規劃地圖圖示" src="images/financialPlanLock.png">
						<h2>3.資金規劃地圖</h2>
						<p>恭喜您完成了創業檢核表與創業第一年營運排程，接下來做資金規劃</p>
					</div>
					<i class="fa fa-lock fa-4x fa-top"></i>
				</div>
			</div>
			 -->
			<!-- 
			<div class="grid_4">
				<div class="step">
					<div class="stepDescribe">
						<img alt="創業前檢核表圖示" src="images/ventureCheck.png">
						<h2>1.創業前檢核表</h2>
						<p>首先，請依順序完成您的創業前檢核表</p>
					</div>					
					<a href="ventureChecklistMap" class="startButton"><span class="next">開始填寫<i class="fa fa-play-circle fa-lg fa-left"></i></span></a>
				</div>
			</div>
			<div class="grid_4">
				<div class="stepLocked">
					<div class="stepDescribe">
						<img alt="創業第一年資金規劃圖示" src="images/ventureCapitalLock.png">
						<h2>2.創業第一年資金規劃</h2>
						<p>完成創業前檢核表後，接下來請依順序完成您的創業第一年資金規劃</p>
					</div>
					<i class="fa fa-lock fa-4x fa-top"></i>
				</div>
			</div>
			<div class="grid_4">
				<div class="stepLocked">
					<div class="stepDescribe">
						<img alt="資金規劃地圖圖示" src="images/financialPlanLock.png">
						<h2>3.資金規劃地圖</h2>
						<p>恭喜您完成了創業檢核表與創業第一年營運排程，接下來做資金規劃</p>
					</div>
					<i class="fa fa-lock fa-4x fa-top"></i>
				</div>
			</div>
			 -->
			
		</div>			
	</div>
	<!-- import jquery -->
	<!-- <script src="js/jquery-1.9.1.min.js"></script>此版本jquery 無法顯示彈窗，看要不要改成1.7.1 -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	
	<!-- import nav slideToggle RWD js -->	
		<script src="js/nav.js"></script>
	<!-- import progressbar -->
		<script type="text/javascript" src="js/progress.js"></script>
		<script type="text/javascript">
		$(function() {
			//alert('${checkListPercent}');
			if('${checkListPercent}'>0){
				if('${checkListPercent}'==100){
					/*$('#step1Progress').progress({
						//percent: '${checkListPercent}'		
						//測試用
						percent: 100	
					});
					$('#step1Progress').attr('class','ui progress success');	*/
					$('#step1Url').attr('class','downloadButton');
					$('#step1Url').attr('href','exportWord');
					$('#step1Name').text("下載創業前檢核表");
					$('#step1Name').append("<i class='fa fa-download fa-lg fa-left'>");
					$('#step11').append("<a href='ventureChecklistMap' class='modifyButton'><span class='next'>修改創業前檢核表<i class='fa fa-repeat fa-lg fa-left'></i></span></a>");
					
					//若創業前檢核表填完，開啟第一年營運規劃填寫
					$('#step21').remove();
					var step2Content ='<div class="step" id="step21">'+
					'<div class="stepDescribe">'+
					'<img alt="創業第一年資金規劃圖示" src="images/ventureCapital.png">'+
					'<h2>2.創業第一年資金規劃</h2>'+
					'<p>完成創業前檢核表後，接下來請依順序完成您的創業第一年資金規劃</p>'+
					'</div>'+
					'<div id="step1Progress">'+
				  	'<div class="bar">'+
				    '<div class="progress"></div>'+
				  	'</div>'+
					'</div>'+				
					'<a href="ventureCapitalPlanMap" class="startButton" id="step2Url"><span class="next" id="step2Name">開始填寫<i class="fa fa-play-circle fa-lg fa-left"></i></span></a>'+					
					'</div>';
					$('#step2').append(step2Content);
					
					//若創業前檢核表填完，開啟資金規劃地圖圖示
					$('#step31').remove();
					var step3Content;
					if('${FinancialPlanFlag==ture}'){
						step3Content ='<div class="step" id="step31">'+
						'<div class="stepDescribe">'+
						'<img alt="資金規劃地圖圖示" src="images/financialPlan.png">'+
						'<h2>3.資金規劃地圖</h2>'+
						'<p>恭喜您完成了創業檢核表與創業第一年營運排程，接下來做資金規劃</p>'+
						'</div>'+
						'<div id="step3Progress">'+
					  	'<div class="bar">'+
					    '<div class="progress"></div>'+
					  	'</div>'+
						'</div>'+
						'<a href="exportFinancialPlan" class="downloadButton" id="step3Url"><span class="next">下載創業前檢核表<i class="fa fa-download fa-lg fa-left"></i></span></a>'+
						'<a href="financialPlan" class="modifyButton" ><span class="next" id="step3Name">修改創資金規劃地圖<i class="fa fa-repeat fa-lg fa-left"></i></span></a>'+		
						'</div>';						
						$('#step3').append(step3Content);
					}else{
						step3Content ='<div class="step" id="step31">'+
						'<div class="stepDescribe">'+
						'<img alt="資金規劃地圖圖示" src="images/financialPlan.png">'+
						'<h2>3.資金規劃地圖</h2>'+
						'<p>恭喜您完成了創業檢核表與創業第一年營運排程，接下來做資金規劃</p>'+
						'</div>'+
						'<div id="step3Progress">'+
					  	'<div class="bar">'+
					    '<div class="progress"></div>'+
					  	'</div>'+
						'</div>'+				
						'<a href="financialPlan" class="startButton" id="step3Url"><span class="next" id="step3Name">開始填寫<i class="fa fa-play-circle fa-lg fa-left"></i></span></a>'+					
						'</div>';
						$('#step3').append(step3Content);
					}					
					
					
				}else{
					$('#step1Progress').progress({
						percent: '${checkListPercent}'			
					});
					$('#step1Progress').attr('class','ui yellow progress');
					$('#step1Url').attr('class','continueButton')
					$('#step1Name').text("繼續填寫");
					$('#step1Name').append("<i class='fa fa-angle-double-right fa-lg fa-left'>");
				}
			}else{
				$('#progress1').remove();	
			}
		});
		
	//創業前檢核表Percent	
	$('#progress1').progress({
		percent: '${checkListPercent}'			
	});
			
	/*$('#progress3').progress({
		percent: 100
	});*/
	</script>
</body>
</html>