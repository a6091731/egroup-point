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
 	<meta name="description" content="會員註冊-加入創業e點通-創業e點通">  
	<title>會員註冊-加入創業e點通-創業e點通</title>
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
			<form id="sendForm" action="addMember" method="post" class="register_form clearfix">
				<ul>
					<li class="register_title">
						<h2>會員註冊</h2>
					</li>
					<li>
						<label for="account">帳號</label>
						<input type="text" name="account" id="account" placeholder="請輸入帳號" class="textbox" >
					</li>
					<li>
						<label for="password">密碼</label>
						<input type="password" name="password" id="password" placeholder="請輸入密碼" class="textbox" maxlength="20">
					</li>
					<li>
						<label for="password2">確認密碼</label>
						<input type="password" name="password2" id="password2" placeholder="請確認密碼" class="textbox" maxlength="20">
					</li>
					<li>
						<label for="name">姓名</label>
						<input type="text" name="name" id="name" placeholder="請輸入姓名" class="textbox" maxlength="10">
					</li>
					<li>
						<label for="email">Email</label>
						<input type="text" name="email" id="email" placeholder="請輸入Email" class="textbox" maxlength="55">
					</li>
					<li>
						<div class="register_chg">
							<Button type="submit" class="nextStepButton register_btn"><span class="next">註冊</span></Button>
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
	<!-- validate -->
	<script src="js/jquery.validate.js"></script>
	<script src="js/messages_zh_TW.js"></script>
	<script src="js/additional-methods.js"></script>
	<script type="text/javascript">
		$(function(){
			$("#sendForm").validate({				
				rules:{
        			account:{
        				minlength:6,
        				maxlength:20,
        				required:true,
    					remote:{
    						url:"checkAccount",
    						type:"post",
    						cache:false,
    						data:{
    							account:function(){
    					        	return $("#account").val();
    							}
    						}
    					}
        			},
        			name:{
        				required:true,
        				maxlength:10
        			},
        			password:{
        				required:true,
        				minlength:6,
        				maxlength:30
        			},
        			password2:{
        				required:true,
        				minlength:6,
        				maxlength:30,
        				equalTo:$("#password")
        			},
        			email:{
        				required:true,
        				email: true,
        				maxlength:55
        			},
        			//agree:"required"*/
	    		},	        				
	    		messages:{	    			
	    			account:{
	    				minlength:"帳號長度不能小於{0}",
	    				maxlength:"帳號長度不能大於{0}",
	    				required:"請輸入帳號",
	    				email:"信箱格式不正確",
	    				remote:"帳號已被註冊"
	    			},
	    			name:{
	    				require:"請輸入名字",
	    				maxlength:"名字長度不能大於{0}"
	    			},	    			
	    			password:{
	    				required:"請輸入密碼",
	    				minlength:"長度不得小於{0}",
	    				maxlength:"長度不得大於{0}"
	    			},
	        		password2:{
	        			required:"請確認密碼",
	        			minlength:"長度不得小於{0}",
	        			maxlength:"長度不得大於{0}",
	        			equalTo:"密碼輸入不同"
	        		},
	        		email:{
        				required:"請輸入email",
        				email: "mail 格式不符。EX: name@gmail.com",
        				maxlength:"email長度不能大於{0}"
        			}
	    			//agree:"請勾選同意"*/
	    		},
	    		errorPlacement: function (error, element) {
	    	    	if(element.attr('name') == "agree"){
	    	    		element.closest("label").append(error);
	    	    	}
	    	    	else
	    	    		error.insertAfter(element);
	    	    	$("#send").attr("disabled", false);
	    	    }
	    	});
		});
	</script>
	
</body>
</html>