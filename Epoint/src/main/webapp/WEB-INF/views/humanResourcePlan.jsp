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
							href="ventureChecklistMap">創業前檢核表地圖</a> &gt;<span>創業前檢核表【人力資源規劃】</span></p>
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
											<h4>${ventureCehckList.name}</h4> 
											<a href="javascript:;" data-reveal-id="help${ventureCehckList.subclassID}"><span>
											<i class="fa fa-exclamation-circle"></i>我需要範例協助</span></a> 
										<c:choose>
											<c:when test="${!empty ventureCehckList.content}">
												<textarea rows="8" id="content${ventureCehckList.subclassID}" name="content${ventureCehckList.subclassID}" >${ventureCehckList.content }</textarea>
											</c:when>
											<c:otherwise>
												<textarea rows="8" id="content${ventureCehckList.subclassID}" name="content${ventureCehckList.subclassID}"></textarea>
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
											<th>上半年</th>
											<th>建置期</th>
											<th>1月</th>
											<th>2月</th>
											<th>3月</th>
											<th>4月</th>
											<th>5月</th>
											<th>6月</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>管理人員</td>
											<td><input type="text" class="input-control0 input-control" name="M0" id="M0" value="${getHumanResourceContentByMember.m0}" ></td>
											<td><input type="text" class="input-control1 input-control" name="M1" id="M1" value="${getHumanResourceContentByMember.m1}" ></td>
											<td><input type="text" class="input-control2 input-control" name="M2" id="M2" value="${getHumanResourceContentByMember.m2}" ></td>
											<td><input type="text" class="input-control3 input-control" name="M3" id="M3" value="${getHumanResourceContentByMember.m3}" ></td>
											<td><input type="text" class="input-control4 input-control" name="M4" id="M4" value="${getHumanResourceContentByMember.m4}" ></td>
											<td><input type="text" class="input-control5 input-control" name="M5" id="M5" value="${getHumanResourceContentByMember.m5}" ></td>
											<td><input type="text" class="input-control6 input-control" name="M6" id="M6" value="${getHumanResourceContentByMember.m6}" ></td>
										</tr>
										<tr>
											<td>研發生產</td>
											<td><input type="text" class="input-control0 input-control" name="R0" id="R0" value="${getHumanResourceContentByMember.r0}" ></td>
											<td><input type="text" class="input-control1 input-control" name="R1" id="R1" value="${getHumanResourceContentByMember.r1}" ></td>
											<td><input type="text" class="input-control2 input-control" name="R2" id="R2" value="${getHumanResourceContentByMember.r2}" ></td>
											<td><input type="text" class="input-control3 input-control" name="R3" id="R3" value="${getHumanResourceContentByMember.r3}" ></td>
											<td><input type="text" class="input-control4 input-control" name="R4" id="R4" value="${getHumanResourceContentByMember.r4}" ></td>
											<td><input type="text" class="input-control5 input-control" name="R5" id="R5" value="${getHumanResourceContentByMember.r5}" ></td>
											<td><input type="text" class="input-control6 input-control" name="R6" id="R6" value="${getHumanResourceContentByMember.r6}" ></td>
											
										</tr>
										<tr>
											<td>行銷業務</td>
											<td><input type="text" class="input-control0 input-control" name="S0" id="S0" value="${getHumanResourceContentByMember.s0}" ></td>
											<td><input type="text" class="input-control1 input-control" name="S1" id="S1" value="${getHumanResourceContentByMember.s1}" ></td>
											<td><input type="text" class="input-control2 input-control" name="S2" id="S2" value="${getHumanResourceContentByMember.s2}" ></td>
											<td><input type="text" class="input-control3 input-control" name="S3" id="S3" value="${getHumanResourceContentByMember.s3}" ></td>
											<td><input type="text" class="input-control4 input-control" name="S4" id="S4" value="${getHumanResourceContentByMember.s4}" ></td>
											<td><input type="text" class="input-control5 input-control" name="S5" id="S5" value="${getHumanResourceContentByMember.s5}" ></td>
											<td><input type="text" class="input-control6 input-control" name="S6" id="S6" value="${getHumanResourceContentByMember.s6}" ></td>
										</tr>
										<tr>
											<td>其他</td>
											<td><input type="text" class="input-control0 input-control" name="O0" id="O0" value="${getHumanResourceContentByMember.o0}" ></td>
											<td><input type="text" class="input-control1 input-control" name="O1" id="O1" value="${getHumanResourceContentByMember.o1}" ></td>
											<td><input type="text" class="input-control2 input-control" name="O2" id="O2" value="${getHumanResourceContentByMember.o2}" ></td>
											<td><input type="text" class="input-control3 input-control" name="O3" id="O3" value="${getHumanResourceContentByMember.o3}" ></td>
											<td><input type="text" class="input-control4 input-control" name="O4" id="O4" value="${getHumanResourceContentByMember.o4}" ></td>
											<td><input type="text" class="input-control5 input-control" name="O5" id="O5" value="${getHumanResourceContentByMember.o5}" ></td>
											<td><input type="text" class="input-control6 input-control" name="O6" id="O6" value="${getHumanResourceContentByMember.o6}" ></td>
										</tr>
										<tr>
											<td>合計</td>
											<td><p id="setTotal0">${getHumanResourceContentByMember.total0}</p><input type="hidden" name="total0" id="total0" ></td>
											<td><p id="setTotal1">${getHumanResourceContentByMember.total1}</p><input type="hidden" name="total1" id="total1" ></td>
											<td><p id="setTotal2">${getHumanResourceContentByMember.total2}</p><input type="hidden" name="total2" id="total2" ></td>
											<td><p id="setTotal3">${getHumanResourceContentByMember.total3}</p><input type="hidden" name="total3" id="total3" ></td>
											<td><p id="setTotal4">${getHumanResourceContentByMember.total4}</p><input type="hidden" name="total4" id="total4" ></td>
											<td><p id="setTotal5">${getHumanResourceContentByMember.total5}</p><input type="hidden" name="total5" id="total5" ></td>
											<td><p id="setTotal6">${getHumanResourceContentByMember.total6}</p><input type="hidden" name="total6" id="total6" ></td>
										</tr>
									</tbody>
								</table>
								
								
							</li>
							<li>
									<table class="productTable responsive">
									<thead>
										<tr>
											<th>下半年</th>
											<th>7月</th>
											<th>8月</th>
											<th>9月</th>
											<th>10月</th>
											<th>11月</th>
											<th>12月</th>
										</tr>
									</thead>
									<tbody>
										<tr>
											<td>管理人員</td>
											
											<td><input type="text" class="input-control7 input-control" name="M7" id="M7" value="${getHumanResourceContentByMember.m7}" ></td>
											<td><input type="text" class="input-control8 input-control" name="M8" id="M8" value="${getHumanResourceContentByMember.m8}" ></td>
											<td><input type="text" class="input-control9 input-control" name="M9" id="M9" value="${getHumanResourceContentByMember.m9}" ></td>
											<td><input type="text" class="input-control10 input-control" name="M10" id="M10" value="${getHumanResourceContentByMember.m10}" ></td>
											<td><input type="text" class="input-control11 input-control" name="M11" id="M11" value="${getHumanResourceContentByMember.m11}" ></td>
											<td><input type="text" class="input-control12 input-control" name="M12" id="M12" value="${getHumanResourceContentByMember.m12}" ></td>
										</tr>
										<tr>
											<td>研發生產</td>
											
											<td><input type="text" class="input-control7 input-control" name="R7" id="R7" value="${getHumanResourceContentByMember.r7}" ></td>
											<td><input type="text" class="input-control8 input-control" name="R8" id="R8" value="${getHumanResourceContentByMember.r8}" ></td>
											<td><input type="text" class="input-control9 input-control" name="R9" id="R9" value="${getHumanResourceContentByMember.r9}" ></td>
											<td><input type="text" class="input-control10 input-control" name="R10" id="R10" value="${getHumanResourceContentByMember.r10}" ></td>
											<td><input type="text" class="input-control11 input-control" name="R11" id="R11" value="${getHumanResourceContentByMember.r11}" ></td>
											<td><input type="text" class="input-control12 input-control" name="R12" id="R12" value="${getHumanResourceContentByMember.r12}" ></td>
											
										</tr>
										<tr>
											<td>行銷業務</td>
											
											<td><input type="text" class="input-control7 input-control" name="S7" id="S7" value="${getHumanResourceContentByMember.s7}" ></td>
											<td><input type="text" class="input-control8 input-control" name="S8" id="S8" value="${getHumanResourceContentByMember.s8}" ></td>
											<td><input type="text" class="input-control9 input-control" name="S9" id="S9" value="${getHumanResourceContentByMember.s9}" ></td>
											<td><input type="text" class="input-control10 input-control" name="S10" id="S10" value="${getHumanResourceContentByMember.s10}" ></td>
											<td><input type="text" class="input-control11 input-control" name="S11" id="S11" value="${getHumanResourceContentByMember.s11}" ></td>
											<td><input type="text" class="input-control12 input-control" name="S12" id="S12" value="${getHumanResourceContentByMember.s12}" ></td>
										</tr>
										<tr>
											<td>其他</td>
											
											<td><input type="text" class="input-control7 input-control" name="O7" id="O7" value="${getHumanResourceContentByMember.o7}" ></td>
											<td><input type="text" class="input-control8 input-control" name="O8" id="O8" value="${getHumanResourceContentByMember.o8}" ></td>
											<td><input type="text" class="input-control9 input-control" name="O9" id="O9" value="${getHumanResourceContentByMember.o9}" ></td>
											<td><input type="text" class="input-control10 input-control" name="O10" id="O10" value="${getHumanResourceContentByMember.o10}" ></td>
											<td><input type="text" class="input-control11 input-control" name="O11" id="O11" value="${getHumanResourceContentByMember.o11}" ></td>
											<td><input type="text" class="input-control12 input-control" name="O12" id="O12" value="${getHumanResourceContentByMember.o12}" ></td>
										</tr>
										<tr>
											<td>合計</td>
											
											<td><p id="setTotal7">${getHumanResourceContentByMember.total7}</p><input type="hidden" name="total7" id="total7" ></td>
											<td><p id="setTotal8">${getHumanResourceContentByMember.total8}</p><input type="hidden" name="total8" id="total8" ></td>
											<td><p id="setTotal9">${getHumanResourceContentByMember.total9}</p><input type="hidden" name="total9" id="total9" ></td>
											<td><p id="setTotal10">${getHumanResourceContentByMember.total10}</p><input type="hidden" name="total10" id="total10" ></td>
											<td><p id="setTotal11">${getHumanResourceContentByMember.total11}</p><input type="hidden" name="total11" id="total11" ></td>
											<td><p id="setTotal12">${getHumanResourceContentByMember.total12}</p><input type="hidden" name="total12" id="total12" ></td>
										</tr>
									</tbody>
								</table>
								
								
							</li>
						</ul>						
						<button type="submit" class="nextStepButton">
							<span class="next">恭喜您完成創業檢核表 !<i class="fa fa-arrow-right"></i></span>
						</button>
						<button type="button" class="nextStepButton mR"><a href="businessOrientation"><span class="next">上一步，填寫產業定位<i class="fa fa-arrow-left"></i></span></a></button>&nbsp;&nbsp;
					</div>
				</form>
			</div>
		</div>			
	</div>


	<!-- BEGIN MODAL WINDOWS -->
	<div id="help171" class="reveal-modal">
		<header class="reveal-modal-header"><h3>範例協助  : 創業所需的自我能力精進規畫</h3></header>
		<div class="cont clearfix">
			<p>增加法令素養，財務觀念， 業務能力...並在什麼時開始，利用什麼方式補強?</p>			
		</div>
	</div>	
	<div id="help172" class="reveal-modal">
		<header class="reveal-modal-header"><h3>範例協助  : 期待從外面找來補強的專長能力</h3></header>
		<div class="cont clearfix">
			<p>需要從外面找財物/研發/業務人員，各幾名? 來補強公司目前的不足</p>	
		</div>
	</div>
	<div id="help173" class="reveal-modal">
		<header class="reveal-modal-header"><h3>範例協助  : 目標人選</h3></header>
		<div class="cont clearfix">
			<p>業務人員5名，104網站找; 財務人員1名，朋友介紹...</p>			
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
	        	
	        	//textarea提示
	            $("#content171").attr("placeholder","增加法令素養，財務觀念， 業務能力...並在什麼時開始，利用什麼方式補強?");
				$("#content172").attr("placeholder","需要從外面找財物/研發/業務人員，各幾名? 來補強公司目前的不足");
				$("#content173").attr("placeholder","業務人員5名，104網站找; 財務人員1名，朋友介紹...");
				
	            $('nav.primary .rightnav').mobileMenu();	            
	            total1();
	            total2();
	            total3();
	            total4();
	            total5();
	            total6();
	            total7();
	            total8();
	            total9();
	            total10();
	            total11();
	            total12();
	            total13();
	           
	            
	            $('.input-control0').keyup(function(){
	            	total1();
	            });
	            
	            $('.input-control1').keyup(function(){
	            	total2()
		        });
	            
	            $('.input-control2').keyup(function(){
	            	total3()
		        });
	            
	            $('.input-control3').keyup(function(){
	            	total4()
		        });	
	            
	            $('.input-control4').keyup(function(){
	            	total5()
		        });
	            
	            $('.input-control5').keyup(function(){
	            	total6()
		        });
	            
	            $('.input-control6').keyup(function(){
	            	total7()
	            })
	            
	            $('.input-control7').keyup(function(){
	            	total8()
	            })
	            
	            $('.input-control8').keyup(function(){
	            	total9()
	            })
	            
	            $('.input-control9').keyup(function(){
	            	total10()
	            })
	            
	            $('.input-control10').keyup(function(){
	            	total11()
	            })
	            
	            $('.input-control11').keyup(function(){
	            	total12()
	            })
	            
	            $('.input-control12').keyup(function(){
	            	total13()
	            })
	            
	            $("#sendForm").validate({
	            	rules:{
	            		content171:{
	            			required:true,
	            			maxlength:150
	            		},			
						content172:{
			    			required:true,
			    			maxlength:150
			    		},
	            		content173:{
			    			required:true,
			    			maxlength:150
			    		}   		
	            	},
	            	messages:{
	            		content171:{
	            			required:"此欄位不能空白",
	            			maxlength:"長度不能超過{0}"
	            		},
	            		content172:{
	            			required:"此欄位不能空白",
	            			maxlength:"長度不能超過{0}"
	            		},
	            		content173:{
	            			required:"此欄位不能空白",
	            			maxlength:"長度不能超過{0}"
	            		}
	            	}
	            });	 
	            $(".input-control").each(function(){
	            	$(this).rules("add",{
		        		required:true,
		            	number: true,
		            	min:0,
		            	maxlength:9,
		    			digits:true,
		            	messages:{
		            		required:"請輸入數量",
		            		number:"請輸入數字",
		            		min:"請輸入大於0的數量",
		            		maxlength:"請輸入小於10位數的數量",
	            			digits:"請輸入整數" 
		            	}
		            });
	            });
	            
	            //M	
	            /*$("#M0").keyup(function(){
	            	M1Rule();
	            	M2Rule();
	            	M3Rule();
	            	M4Rule();
	            	M5Rule();
				});
	            $("#M1").keyup(function(){
	            	M1Rule();
	            	M2Rule();
	            	M3Rule();
	            	M4Rule();
	            	M5Rule();
				});
	            
	            $("#M2").keyup(function(){
	            	M2Rule();
	            	M3Rule();
	            	M4Rule();
	            	M5Rule();
				});
	            
	            $("#M3").keyup(function(){
	            	M3Rule();
	            	M4Rule();
	            	M5Rule();
				});
	            
	            $("#M4").keyup(function(){
	            	M4Rule();
	            	M5Rule();
				});
	            
	            $("#M5").keyup(function(){
	            	
	            });
	            
	            $("#M6").keyup(function(){
	            	
	            });
	            
	            $("#M7").keyup(function(){
	            	
	            });
	            
	            $("#M8").keyup(function(){
	            	
	            });
	            
	            $("#M9").keyup(function(){
	            	
	            });
	            
	            $("#M10").keyup(function(){
	            	
	            });
	            
	            $("#M11").keyup(function(){
	            	
	            });
	            
	            $("#M12").keyup(function(){
	            	
	            });
	            */	           
	            //R
	            /*$("#R0").keyup(function(){
	            	R1Rule();
	            	R2Rule();
	            	R3Rule();
	            	R4Rule();
	            	R5Rule();
				});	
	            $("#R1").keyup(function(){
	            	R1Rule();
	            	R2Rule();
	            	R3Rule();
	            	R4Rule();
	            	R5Rule();
				});	           
	            $("#R2").keyup(function(){
	            	R2Rule();
	            	R3Rule();
	            	R4Rule();
	            	R5Rule();
				});	          
	            $("#R3").keyup(function(){
	            	R3Rule();
	            	R4Rule();
	            	R5Rule();
				});
	            $("#R4").keyup(function(){
	            	R4Rule();
	            	R5Rule();
				});
	            $("#R5").keyup(function(){
	            	R5Rule();
				});
	            
	            $("#R6").keyup(function(){
	            	
	            });
	            
	            $("#R7").keyup(function(){
	            	
	            });
	            
	            $("#R8").keyup(function(){
	            	
	            });
	            
	            $("#R9").keyup(function(){
	            	
	            });
	            
	            $("#R10").keyup(function(){
	            	
	            });
	            
	            $("#R11").keyup(function(){
	            	
	            });
	            
	            $("#R12").keyup(function(){
	            	
	            });
	            */
	            //S 
	            /*$("#S0").keyup(function(){
	            	S1Rule();
	            	S2Rule();
	            	S3Rule();
	            	S4Rule();
	            	S5Rule(); 
				});	
	            $("#S1").keyup(function(){
	            	S1Rule();
	            	S2Rule();
	            	S3Rule();
	            	S4Rule();
	            	S5Rule(); 
				});	            	            
	            $("#S2").keyup(function(){
	            	S2Rule();
	            	S3Rule();
	            	S4Rule();
	            	S5Rule(); 
				});
	            $("#S3").keyup(function(){
	            	S3Rule();
	            	S4Rule();
	            	S5Rule(); 
				});	            
	            $("#S4").keyup(function(){
	            	S4Rule();
	            	S5Rule();
				});	            
	            $("#S5").keyup(function(){
	            	S5Rule(); 
				});
	            
	            $("#S6").keyup(function(){
	            	
	            });
	            
	            $("#S7").keyup(function(){
	            	
	            });
	            
	            $("#S8").keyup(function(){
	            	
	            });
	            
	            $("#S9").keyup(function(){
	            	
	            });
	            
	            $("#S10").keyup(function(){
	            	
	            });
	            
	            $("#S11").keyup(function(){
	            	
	            });
	            
	            $("#S12").keyup(function(){
	            	
	            });
	            */
	            //O 
	            /*$("#O0").keyup(function(){
	            	O1Rule();
	            	O2Rule();
	            	O3Rule();
	            	O4Rule();
	            	O5Rule();
				});
	            $("#O1").keyup(function(){
	            	O1Rule();
	            	O2Rule();
	            	O3Rule();
	            	O4Rule();
	            	O5Rule();
				});
	            $("#O2").keyup(function(){
	            	O2Rule();
	            	O3Rule();
	            	O4Rule();
	            	O5Rule();
				});
	            $("#O3").keyup(function(){
	            	O3Rule();
	            	O4Rule();
	            	O5Rule();
				});
	            $("#O4").keyup(function(){
	            	O4Rule();
	            	O5Rule();
				});
	            $("#O5").keyup(function(){
	            	O5Rule();
				});
	            
	            $("#O6").keyup(function(){
	            	
	            });
	            
	            $("#O7").keyup(function(){
	            	
	            });
	            
	            $("#O8").keyup(function(){
	            	
	            });
	            
	            $("#O9").keyup(function(){
	            	
	            });
	            
	            $("#O10").keyup(function(){
	            	
	            });
	            
	            $("#O11").keyup(function(){
	            	
	            });
	            
	            $("#O12").keyup(function(){
	            	
	            });
	            */
	        });
	        
	        function total1(){
	        	var setTotal0 = Number($('#M0').val())+Number($('#R0').val())+Number($('#S0').val())+Number($('#O0').val());
	        	$('#setTotal0').text(!isNaN(setTotal0)?setTotal0:0); 
	        	$('#total0').val(parseInt($('#setTotal0').text()));
	        }
	        
	        function total2(){
	        	var setTotal1 = Number($('#M1').val())+Number($('#R1').val())+Number($('#S1').val())+Number($('#O1').val());
	        	$('#setTotal1').text(!isNaN(setTotal1)?setTotal1:0);
           	 	$('#total1').val(parseInt($('#setTotal1').text()));
	        }
	        
	        function total3(){
	        	var setTotal2 = Number($('#M2').val())+Number($('#R2').val())+Number($('#S2').val())+Number($('#O2').val());
	        	$('#setTotal2').text(!isNaN(setTotal2)?setTotal2:0);
            	$('#total2').val(parseInt($('#setTotal2').text()));
	        }
	        
	        function total4(){
	        	var setTotal3 = Number($('#M3').val())+Number($('#R3').val())+Number($('#S3').val())+Number($('#O3').val());
	        	$('#setTotal3').text(!isNaN(setTotal3)?setTotal3:0);
           	 	$('#total3').val(parseInt($('#setTotal3').text()));
	        }
	        
	        function total5(){
	        	var setTotal4 = Number($('#M4').val())+Number($('#R4').val())+Number($('#S4').val())+Number($('#O4').val());
	        	$('#setTotal4').text(!isNaN(setTotal4)?setTotal4:0);
           		$('#total4').val(parseInt($('#setTotal4').text()));
	        }
	        
	        function total6(){
	        	var setTotal5 = Number($('#M5').val())+Number($('#R5').val())+Number($('#S5').val())+Number($('#O5').val());
	        	$('#setTotal5').text(!isNaN(setTotal5)?setTotal5:0);
	        	$('#total5').val(parseInt($('#setTotal5').text()));
	        }
	        function total7(){
	        	var setTotal6 = Number($('#M6').val())+Number($('#R6').val())+Number($('#S6').val())+Number($('#O6').val());
	        	$('#setTotal6').text(!isNaN(setTotal6)?setTotal6:0);
	        	$('#total6').val(parseInt($('#setTotal6').text()));
	        }
	        function total8(){
	        	var setTotal7 = Number($('#M7').val())+Number($('#R7').val())+Number($('#S7').val())+Number($('#O7').val());
	        	$('#setTotal7').text(!isNaN(setTotal7)?setTotal7:0);
	        	$('#total7').val(parseInt($('#setTotal7').text()));
	        }
	        function total9(){
	        	var setTotal8 = Number($('#M8').val())+Number($('#R8').val())+Number($('#S8').val())+Number($('#O8').val());
	        	$('#setTotal8').text(!isNaN(setTotal8)?setTotal8:0);
	        	$('#total8').val(parseInt($('#setTotal8').text()));
	        }
	        function total10(){
	        	var setTotal9 = Number($('#M9').val())+Number($('#R9').val())+Number($('#S9').val())+Number($('#O9').val());
	        	$('#setTotal9').text(!isNaN(setTotal9)?setTotal9:0);
	        	$('#total9').val(parseInt($('#setTotal9').text()));
	        }
	        function total11(){
	        	var setTotal10 = Number($('#M10').val())+Number($('#R10').val())+Number($('#S10').val())+Number($('#O10').val());
	        	$('#setTotal10').text(!isNaN(setTotal10)?setTotal10:0);
	        	$('#total10').val(parseInt($('#setTotal10').text()));
	        }
	        function total12(){
	        	var setTotal11 = Number($('#M11').val())+Number($('#R11').val())+Number($('#S11').val())+Number($('#O11').val());
	        	$('#setTotal11').text(!isNaN(setTotal11)?setTotal11:0);
	        	$('#total11').val(parseInt($('#setTotal11').text()));
	        }
	        function total13(){
	        	var setTotal12 = Number($('#M12').val())+Number($('#R12').val())+Number($('#S12').val())+Number($('#O12').val());
	        	$('#setTotal12').text(!isNaN(setTotal12)?setTotal12:0);
	        	$('#total12').val(parseInt($('#setTotal12').text()));
	        }
	        
	       /* function M1Rule(){
            	$("#M1").rules("add",{
	            	min: parseInt($("#M0").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }	   
	        
            function M2Rule(){
            	$("#M2").rules("add",{
	            	min:parseInt($("#M1").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            
            function M3Rule(){
            	$("#M3").rules("add",{
	            	min:parseInt($("#M2").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            
            function M4Rule(){
            	$("#M4").rules("add",{
	            	min:parseInt($("#M3").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            
            function M5Rule(){
            	$("#M5").rules("add",{
 	            	min:parseInt($("#M4").val()),
 	            	messages:{
 	            		min:"人員數量不能少於前季{0}人"
 	            	}
 	        	});
            }
            
            function R1Rule(){
            	$("#R1").rules("add",{
	 	            min:parseInt($("#R0").val()),
	 	            messages:{
	 	            	min:"人員數量不能少於前季{0}人"
	 	            }
	 	        });
            }
            
            function R2Rule(){
            	$("#R2").rules("add",{
 	            	min:parseInt($("#R1").val()),
 	            	messages:{
 	            		min:"人員數量不能少於前季{0}人"
 	            	}
 	        	});
            }
            
            function R3Rule(){
            	$("#R3").rules("add",{
 	            	min:parseInt($("#R2").val()),
 	            	messages:{
 	            		min:"人員數量不能少於前季{0}人"
 	            	}
 	        	});
            }
            
            function R4Rule(){
            	$("#R4").rules("add",{
	            	min:parseInt($("#R3").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            
            function R5Rule(){
            	$("#R5").rules("add",{
	            	min:parseInt($("#R4").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            
            function S1Rule(){
            	$("#S1").rules("add",{
	            	min:parseInt($("#S0").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            function S2Rule(){
            	$("#S2").rules("add",{
	            	min:parseInt($("#S1").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            function S3Rule(){
            	$("#S3").rules("add",{
	            	min:parseInt($("#S2").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            function S4Rule(){
            	$("#S4").rules("add",{
	            	min:parseInt($("#S3").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            function S5Rule(){
            	$("#S5").rules("add",{
 	            	min:parseInt($("#S4").val()),
 	            	messages:{
 	            		min:"人員數量不能少於前季{0}人"
 	            	}
 	        	});
            }
            function O1Rule(){
            	$("#O1").rules("add",{
 	            	min:parseInt($("#O0").val()),
 	            	messages:{
 	            		min:"人員數量不能少於前季{0}人"
 	            	}
 	        	});
            }
            function O2Rule(){
            	$("#O2").rules("add",{
 	            	min:parseInt($("#O1").val()),
 	            	messages:{
 	            		min:"人員數量不能少於前季{0}人"
 	            	}
 	        	});
            }
            function O3Rule(){
            	$("#O3").rules("add",{
 	            	min:parseInt($("#O2").val()),
 	            	messages:{
 	            		min:"人員數量不能少於前季{0}人"
 	            	}
 	        	});
            }
            function OQ4Rule(){
            	$("#O4").rules("add",{
	            	min:parseInt($("#O3").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            function O5Rule(){
            	$("#O5").rules("add",{
	            	min:parseInt($("#O4").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            */
	    </script>
	 <!-- responsive-table -->  
	    <script src="js/responsive-tables.js"></script>
</body>
</html>