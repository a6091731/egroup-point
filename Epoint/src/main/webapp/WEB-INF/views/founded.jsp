<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="zh-tw">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 	<meta name="description" content="創業-支出結構-規畫你的創業第一年支出-創業e點通">  
	<title>支出結構-規畫你的創業第一年支出-創業e點通</title>

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
            		<p><a href="index.html">首頁</a> &gt; <a href="#">創業地圖</a> &gt; <a href="#">創業第一年營運排程地圖</a> &gt; <span>支出結構</span></p>
	            </div>
			</div>
			<div class="grid_3">
				<aside>
					<ul class="sideNav hideBlock">
						<li><a href="javascript:;"><i class="fa fa-child"></i>公司成立</a></li>
						<li><div class="mask"></div><a href="javascript:;"><i class="fa fa-lock"></i>營業場所完工</a></li>
						<li><div class="mask"></div><a href="javascript:;"><i class="fa fa-lock"></i>人員到位</a></li>
						<li><div class="mask"></div><a href="javascript:;"><i class="fa fa-lock"></i>生產設備建置</a></li>
						<li><div class="mask"></div><a href="javascript:;"><i class="fa fa-lock"></i>試產</a></li>
						<li><div class="mask"></div><a href="javascript:;"><i class="fa fa-lock"></i>原料採購</a></li>
						<li><div class="mask"></div><a href="javascript:;"><i class="fa fa-lock"></i>試營運</a></li>
						<li><div class="mask"></div><a href="javascript:;"><i class="fa fa-lock"></i>通路開發</a></li>
						<li><div class="mask"></div><a href="javascript:;"><i class="fa fa-lock"></i>行銷推廣</a></li>
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
					<h2><img alt="創業業種圖示" src="images/type.png">公司成立</h2>
				</section>


				<form class="formset clearfix" method="post" action="modiExpenditure">
				  	<fieldset class="fieldset">
				  		<legend>1.1 固定成本[設立費用]：</legend>
					  	<div class="field">
					  		<label>日期：
					  			<input type="month" class="form-control" name="fixcostdate">
					  		</label>
					  	</div>
					  	<div class="field">
					  		<label><span>金額：</span>
					  			<input type="text" class="form-control" name="money" >
					  		</label>
					  	</div>
					</fieldset>
					<fieldset  class="fieldset">
					  	<legend>1.2 固定成本[設計及申請商標]</legend>
					  	<div class="field">
					  		<label>日期：
					  			<input type="month" class="form-control" name="fixcostdateLogo">
					  		</label>
					  	</div>
					  	<div class="field">
					  		<label>金額：
					  			<input type="text" class="form-control" name="money">
					  		</label>
					  	</div>
					</fieldset>
					<fieldset id="BusinessCard" class="fieldset">
					  	<legend>2 印製名片</legend>
					  	<button type="button" class="addbutton" data-id="card"><i class="fa fa-plus"></i> 新增一筆費用</button>
					  	<div id="card1">
						  	<div class="field">
						  		<label>日期：
						  			<input type="month" class="form-control" name="cardDate">
						  		</label>
						  	</div>
						  	<div class="field">
						  		<label>金額：
						  			<input type="text" class="form-control" name="cardCost">
						  		</label>
						  	</div>
						  	<div class="field">
						  		<button type="button" class="deletebutton delCardBtn" data-id="1"><i class="fa fa-times"></i> 刪除</button>
						  	</div>					  		
					  	</div>
					</fieldset>					
					<fieldset id="Lawyer" class="fieldset">
					  	<legend>3 律師費用</legend>
					  	<button type="button" class="addbutton" data-id="lawyer"><i class="fa fa-plus"></i> 新增一筆費用</button>
					  	<div id="lawyer1">
						  	<div class="field">
						  		<label>日期：
						  			<input type="month" class="form-control" name="date3">
						  		</label>
						  	</div>
						  	<div class="field">
						  		<label>金額：
						  			<input type="text" class="form-control" name="money3">
						  		</label>
						  	</div>
						  	<div class="field">
						  		<button type="button" class="deletebutton delLawyerBtn" data-id="1"><i class="fa fa-times"></i> 刪除</button>
						  	</div>					  		
					  	</div>
					</fieldset>	
					<fieldset id="Accountants" class="fieldset">
					  	<legend>4 會計師費用</legend>
					  	<button type="button" class="addbutton" data-id="accountant"><i class="fa fa-plus"></i> 新增一筆費用</button>
					  	<div id="accountant1">
						  	<div class="field">
						  		<label>日期：
						  			<input type="month" class="form-control" name="date3">
						  		</label>
						  	</div>
						  	<div class="field">
						  		<label>金額：
						  			<input type="text" class="form-control" name="money3">
						  		</label>
						  	</div>
						  	<div class="field">
						  		<button type="button" class="deletebutton delAccountBtn" data-id="1"><i class="fa fa-times"></i> 刪除</button>
						  	</div>					  		
					  	</div>
					</fieldset>		
					<div class="mt50px">
						<button type="submit" class="nextStepButton"><span class="next">下一步，填寫營業場所完工<i class="fa fa-arrow-right"></i></span></button>
						<!-- <a href="javascript:;" class="nextStepButton"><span class="next">下一步，填寫營業場所完工<i class="fa fa-arrow-right"></i></span></a> -->
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
		var cardCount = 1;
		var lawyerCount = 1;
		var accountCount = 1;
	        $(function() {
	            $('nav.primary .rightnav').mobileMenu();
	            
	            
	            
	            $('.addbutton').click(function(){
	            	var type = $(this).data('id');
	            	if(type == 'card'){
	            		cardCount++;
	            		var cardText = 
	            		'<div id="card'+cardCount+'">'+
	            			'<div class="field">'+
						  		'<label>日期：'+
						  			'<input type="month" class="form-control" name="cardDate">'+
						  		'</label>'+
						  	'</div>'+
						  	'<div class="field">'+
						  		'<label>金額：'+
						  			'<input type="text" class="form-control" name="cardCost">'+
						  		'</label>'+
						  	'</div>'+
						  	'<div class="field">'+
						  		'<button type="button" class="deletebutton delCardBtn" data-id="'+cardCount+'"><i class="fa fa-times"></i> 刪除</button>'+
						  	'</div></div>';
	            		$('#BusinessCard').append(cardText);
	            	}else if(type == 'lawyer'){
	            		lawyerCount++;
	            		var lawyerText = 
	            		'<div id="lawyer'+lawyerCount+'">'+
	            			'<div class="field">'+
						  		'<label>日期：'+
						  			'<input type="month" class="form-control" name="date3">'+
						  		'</label>'+
						  	'</div>'+
						  	'<div class="field">'+
						  		'<label>金額：'+
						  			'<input type="text" class="form-control" name="money3">'+
						  		'</label>'+
						  	'</div>'+
						  	'<div class="field">'+
						  		'<button type="button" class="deletebutton delLawyerBtn" data-id="'+lawyerCount+'"><i class="fa fa-times"></i> 刪除</button>'+
						  	'</div></div>';
	            		$('#Lawyer').append(lawyerText);
	            	}else if(type == 'accountant'){
	            		accountCount++;
	            		var accountText = 
	            			'<div id="accountant'+accountCount+'">'+
						  	'<div class="field">'+
						  		'<label>日期：'+
						  			'<input type="month" class="form-control" name="date3">'+
						  		'</label>'+
						  	'</div>'+
						  	'<div class="field">'+
						  		'<label>金額：'+
						  			'<input type="text" class="form-control" name="money3">'+
						  		'</label>'+
						  	'</div>'+
						  	'<div class="field">'+
						  		'<button type="button" class="deletebutton delAccountBtn" data-id="'+accountCount+'"><i class="fa fa-times"></i> 刪除</button>'+
						  	'</div></div>';
	            		$('#Accountants').append(accountText);
	            	}
	            	$('.delCardBtn').click(function(){
		            	var id = $(this).data('id');
		            	$('#card'+id).remove();
		            });
	            	$('.delLawyerBtn').click(function(){
		            	var id = $(this).data('id');
		            	$('#lawyer'+id).remove();
		            });
	            	$('.delAccountBtn').click(function(){
		            	var id = $(this).data('id');
		            	$('#accountant'+id).remove();
		            });
	            });
	        });
	    </script>
</body>
</html>