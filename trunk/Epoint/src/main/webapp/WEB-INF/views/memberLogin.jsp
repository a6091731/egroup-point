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
 	<meta name="description" content="會員登入-進入創業e點通-創業e點通">  
	<title>會員登入-進入創業e點通-創業e點通</title>

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
							<a href="javascript:;" id="loginButton"><span>登入</span></a>
						</div>
					</div><!-- top-nav -->
				</nav>
			</div><!-- grid_12 -->
		</div><!-- container -->
	</header>
	
	<div class="container">	
		<div class="prefix_4 grid_4 suffix_4">
			<form class="register_form clearfix" id="sendForm" method="post" action="checkLogin">
				<ul>
					<li class="register_title">
						<h2>會員登入</h2>
					</li>
					<li>
						<label for="account">帳號<span class="errorMsg">${errorMsg}</span></label>
						<input type="text" name="account" id="account" placeholder="請輸入Email" class="textbox" maxlength="55">
					</li>
					<li>
						<label for="password">密碼</label>
						<input type="password" name="password" id="password" placeholder="請輸入密碼" class="textbox" maxlength="20">
					</li>
					<li>
						<div class="register_chg">
							<button type="submit" class="nextStepButton register_btn"><span class="next">登入</span></button>
						</div>
					</li>
					<li>
						<a href="mailResend.html" class="fgpwd">忘記密碼</a>
						<span>/</span>
						<!-- <a href="mailResend.html" class="fgpwd">我沒有收到帳號驗證信</a> -->
						<a href="memberRegister.html" class="fgpwd">加入會員</a>
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
	<!-- validate -->
	<script src="js/jquery.validate.js"></script>
	<script src="js/messages_zh_TW.js"></script>
	<script src="js/additional-methods.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#sendForm").validate({
				rules:{
					account:"required",
					password:"required"
				},
				messages:{
					account:"請填寫帳號",
					password:"請填寫密碼"					
				}
			});
		});
	</script>
</body>
</html>