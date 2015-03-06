<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zh-tw">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 	<meta name="description" content="編輯個人資料-編輯會員資料-創業e點通">  
	<title>編輯個人資料-編輯會員資料-創業e點通</title>
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
				</div><!-- logo -->
<!-- 				<nav class="clearfix">
					<div class="top-nav">
						<div class="top-nav-right">
							<a href="memberLogin.html" id="loginButton"><span>登入</span></a>
						</div>
					</div>
				</nav> -->
			</div><!-- grid_12 -->
		</div><!-- container -->
	</header>
	
	
	<div class="container">	
		<div class="prefix_4 grid_4 suffix_4">
			<form id="sendForm" action="modiMember" method="post" class="register_form clearfix">
				<ul>
					<li class="register_title">
						<h2>編輯會員資料</h2>
					</li>
					<li>
						<p>帳號 : ${getMember.account}
					</li>
					<li>
						<label for="name">姓名</label>
						<input type="text" name="name" id="name" value="${getMember.name}" class="textbox" maxlength="10">
					</li>
					<!-- 
						<li>
							<label for="name">性別
							<input  type="radio" name="sex" value="male" checked>男
							<input  type="radio" name="sex" value="female">女</label>
						</li>	
					 -->
					<li>
						<label for="phone">電話</label>
						<input type="text" name="phone" id="phone" value="${getMember.phone }" placeholder="請輸入電話" class="textbox" maxlength="55">
					</li>
					<li>
						<label for="email">Email</label>
						<input type="text" name="email" id="email" value="${getMember.email }" class="textbox" maxlength="55">
					</li>
					<li>
						<label for="password">密碼 : <a href="memberModiPassword1" ><span class="next">修改密碼</span></a></label>
						
					</li>
					<li>
						<div class="register_chg">
							<Button type="submit" class="nextStepButton register_btn">
							<span class="next">修改</span>					
							</Button>
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
		<script src="js/jquery.validate.js"></script>
		<script src="js/nav.js"></script>
		<script type="text/javascript">
		$("#sendForm").validate({				
			rules:{    			
				name:{
    				required:true,
    				maxlength:10
    			},
    			phone:{
    				required:true,
    				number:true,
    				maxlength:10
    			},
    			email:{
    				required:true,
    				email: true,
    				maxlength:55
    			},
    			//agree:"required"*/
    		},	        				
    		messages:{
    			name:{
    				required:"請輸入名字",
    				maxlength:"名字長度不能大於{0}"
    			},	   
    			phone:{
    				required:"請輸入電話",
    				number:"請輸入數字",
    				maxlength:"長度不得大於{0}"
    			},
        		email:{
    				required:"請輸入email",
    				email: "mail 格式不符。EX: name@gmail.com",
    				maxlength:"email長度不能大於{0}"
    			}
    			//agree:"請勾選同意"*/
    		}
    	});
			
		function back(){
			var slice1 = document.referrer.slice(-11);
			var slice2 = document.referrer.slice(-19);
			if(slice1=="memberModi2" || slice1=="" || slice1==null || slice2=="memberModiPassword2"){
				window.open('index', '_self');
			}
			else
				history.back();
		}
	</script>

</body>
</html>