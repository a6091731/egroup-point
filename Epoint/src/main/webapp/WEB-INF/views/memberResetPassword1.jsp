<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 	<meta name="description" content="重設密碼-設定新密碼-創業e點通">  
	<title>重設密碼-設定新密碼-創業e點通</title>
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
<body class="bg-login">
	<header class="topheader clearfix">
		<div class="container">
			<div class="prefix_4  grid_4 suffix_4 center">
				<div class="logo">
					<a href="index"><img src="./images/egroup-white.png" alt="創業e點通品牌標誌"></a>
					<p><a href="index"><i class="fa fa-home"></i> 回首頁</a></p>
				</div>
			</div><!-- grid_12 -->
		</div><!-- container -->
	</header>
	
	<div class="container">	
		<div class="prefix_4 grid_4 suffix_4">
			<form id="sendForm" action="resetPassword" method="post" class="register_form clearfix">
				<ul>
					<li class="register_title">
						<input type="hidden" name="aid" value="${aid}">
						<h2>重設密碼</h2>
					</li>					
					<li>
						<label for="password">新密碼</label>
						<input type="password" name="newPassword1" id="newPassword1" placeholder="請輸入新密碼" class="textbox key">
					</li>
					<li>
						<label for="password">確認新密碼</label>
						<input type="password" name="newPassword2" id="newPassword2" placeholder="請確認新密碼" class="textbox key">
					</li>
					<li>
						<div class="register_chg">
							<button type="submit" class="nextStepButton register_btn">
								<span class="next">修改密碼</span>
							</button>
						</div>
						<div class="">
							<button type="button" onclick="back();" class="linkR"><span class="next">取消</span></button>							
						</div>
					</li>
				</ul>
				<!-- <label class="law"><input type="checkbox" name="agree"><a href="javascript:;" title="閱讀條款內容">同意本網站條款</a></label> -->
			</form>
		</div>
	</div>


	<!-- import jquery -->
	<script src="js/jquery-1.9.1.min.js"></script>
	<!-- import nav slideToggle RWD js -->	
	<script src="js/nav.js"></script>
	<script src="js/jquery.validate.js"></script>
	<script type="text/javascript">
		$("#sendForm").validate({				
			rules:{ 
				newPassword1:{
					required:true,
					minlength:6,
					maxlength:30
				},
				newPassword2:{
					required:true,
					minlength:6,
					maxlength:30,
					equalTo:$("#newPassword1")
				}   			
				
    			//agree:"required"*/
    		},	        				
    		messages:{
    			newPassword1:{
    				required:"請輸入密碼",
    				minlength:"長度不得小於{0}",
    				maxlength:"長度不得大於{0}"
    			},
    			newPassword2:{
        			required:"請確認密碼",
        			minlength:"長度不得小於{0}",
        			maxlength:"長度不得大於{0}",
        			equalTo:"密碼輸入不同"
        		}
    		}
    	});
		
		function back(){			
			history.back();
		}
	</script>
</body>
</html>