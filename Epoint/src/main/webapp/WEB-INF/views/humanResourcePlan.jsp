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
											<td><input type="text" class="input-control0 input-control" name="MQ0" id="MQ0" value="${getHumanResourceContentByMember.MQ0}" ></td>
											<td><input type="text" class="input-control1 input-control" name="MQ1" id="MQ1" value="${getHumanResourceContentByMember.MQ1}" ></td>
											<td><input type="text" class="input-control2 input-control" name="MQ2" id="MQ2" value="${getHumanResourceContentByMember.MQ2}" ></td>
											<td><input type="text" class="input-control3 input-control" name="MQ3" id="MQ3" value="${getHumanResourceContentByMember.MQ3}" ></td>
											<td><input type="text" class="input-control4 input-control" name="MQ4" id="MQ4" value="${getHumanResourceContentByMember.MQ4}" ></td>
										</tr>
										<tr>
											<td>研發生產</td>
											<td><input type="text" class="input-control0 input-control" name="RQ0" id="RQ0" value="${getHumanResourceContentByMember.RQ0}" ></td>
											<td><input type="text" class="input-control1 input-control" name="RQ1" id="RQ1" value="${getHumanResourceContentByMember.RQ1}" ></td>
											<td><input type="text" class="input-control2 input-control" name="RQ2" id="RQ2" value="${getHumanResourceContentByMember.RQ2}" ></td>
											<td><input type="text" class="input-control3 input-control" name="RQ3" id="RQ3" value="${getHumanResourceContentByMember.RQ3}" ></td>
											<td><input type="text" class="input-control4 input-control" name="RQ4" id="RQ4" value="${getHumanResourceContentByMember.RQ4}" ></td>
										</tr>
										<tr>
											<td>行銷業務</td>
											<td><input type="text" class="input-control0 input-control" name="SQ0" id="SQ0" value="${getHumanResourceContentByMember.SQ0}" ></td>
											<td><input type="text" class="input-control1 input-control" name="SQ1" id="SQ1" value="${getHumanResourceContentByMember.SQ1}" ></td>
											<td><input type="text" class="input-control2 input-control" name="SQ2" id="SQ2" value="${getHumanResourceContentByMember.SQ2}" ></td>
											<td><input type="text" class="input-control3 input-control" name="SQ3" id="SQ3" value="${getHumanResourceContentByMember.SQ3}" ></td>
											<td><input type="text" class="input-control4 input-control" name="SQ4" id="SQ4" value="${getHumanResourceContentByMember.SQ4}" ></td>
										</tr>
										<tr>
											<td>其他</td>
											<td><input type="text" class="input-control0 input-control" name="OQ0" id="OQ0" value="${getHumanResourceContentByMember.OQ0}" ></td>
											<td><input type="text" class="input-control1 input-control" name="OQ1" id="OQ1" value="${getHumanResourceContentByMember.OQ1}" ></td>
											<td><input type="text" class="input-control2 input-control" name="OQ2" id="OQ2" value="${getHumanResourceContentByMember.OQ2}" ></td>
											<td><input type="text" class="input-control3 input-control" name="OQ3" id="OQ3" value="${getHumanResourceContentByMember.OQ3}" ></td>
											<td><input type="text" class="input-control4 input-control" name="OQ4" id="OQ4" value="${getHumanResourceContentByMember.OQ4}" ></td>
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
	            $("#MQ0").keyup(function(){
	            	MQ1Rule();
	            	MQ2Rule();
	            	MQ3Rule();
	            	MQ4Rule();
	            	MQ5Rule();
				});
	            $("#MQ1").keyup(function(){
	            	MQ1Rule();
	            	MQ2Rule();
	            	MQ3Rule();
	            	MQ4Rule();
	            	MQ5Rule();
				});
	            
	            $("#MQ2").keyup(function(){
	            	MQ2Rule();
	            	MQ3Rule();
	            	MQ4Rule();
	            	MQ5Rule();
				});
	            
	            $("#MQ3").keyup(function(){
	            	MQ3Rule();
	            	MQ4Rule();
	            	MQ5Rule();
				});
	            
	            $("#MQ4").keyup(function(){
	            	MQ4Rule();
	            	MQ5Rule();
				});
	            	           
	            //R
	            $("#RQ0").keyup(function(){
	            	RQ1Rule();
	            	RQ2Rule();
	            	RQ3Rule();
	            	RQ4Rule();
	            	RQ5Rule();
				});	
	            $("#RQ1").keyup(function(){
	            	RQ1Rule();
	            	RQ2Rule();
	            	RQ3Rule();
	            	RQ4Rule();
	            	RQ5Rule();
				});	           
	            $("#RQ2").keyup(function(){
	            	RQ2Rule();
	            	RQ3Rule();
	            	RQ4Rule();
	            	RQ5Rule();
				});	           
	            $("#RQ3").keyup(function(){
	            	RQ3Rule();
	            	RQ4Rule();
	            	RQ5Rule();
				});
	            $("#RQ4").keyup(function(){
	            	RQ4Rule();
	            	RQ5Rule();
				});
	            $("#RQ5").keyup(function(){
	            	RQ5Rule();
				});
	            
	            //S 
	            $("#SQ0").keyup(function(){
	            	SQ1Rule();
	            	SQ2Rule();
	            	SQ3Rule();
	            	SQ4Rule();
	            	SQ5Rule(); 
				});	
	            $("#SQ1").keyup(function(){
	            	SQ1Rule();
	            	SQ2Rule();
	            	SQ3Rule();
	            	SQ4Rule();
	            	SQ5Rule(); 
				});	            	            
	            $("#SQ2").keyup(function(){
	            	SQ2Rule();
	            	SQ3Rule();
	            	SQ4Rule();
	            	SQ5Rule(); 
				});
	            $("#SQ3").keyup(function(){
	            	SQ3Rule();
	            	SQ4Rule();
	            	SQ5Rule(); 
				});	            
	            $("#SQ4").keyup(function(){
	            	SQ4Rule();
	            	SQ5Rule();
				});	            
	            $("#SQ5").keyup(function(){
	            	SQ5Rule(); 
				});
	            
	            //O 
	            $("#OQ0").keyup(function(){
	            	OQ1Rule();
	            	OQ2Rule();
	            	OQ3Rule();
	            	OQ4Rule();
	            	OQ5Rule();
				});
	            $("#OQ1").keyup(function(){
	            	OQ1Rule();
	            	OQ2Rule();
	            	OQ3Rule();
	            	OQ4Rule();
	            	OQ5Rule();
				});
	            $("#OQ2").keyup(function(){
	            	OQ2Rule();
	            	OQ3Rule();
	            	OQ4Rule();
	            	OQ5Rule();
				});
	            $("#OQ3").keyup(function(){
	            	OQ3Rule();
	            	OQ4Rule();
	            	OQ5Rule();
				});
	            $("#OQ4").keyup(function(){
	            	OQ4Rule();
	            	OQ5Rule();
				});
	            $("#OQ5").keyup(function(){
	            	OQ5Rule();
				});
	            
	            
	        });
	        
	        function total1(){
	        	var setTotal0 = Number($('#MQ0').val())+Number($('#RQ0').val())+Number($('#SQ0').val())+Number($('#OQ0').val());
	        	$('#setTotalQ0').text(!isNaN(setTotal0)?setTotal0:0); 
	        	$('#totalQ0').val(parseInt($('#setTotalQ0').text()));
	        }
	        
	        function total2(){
	        	var setTotal1 = Number($('#MQ1').val())+Number($('#RQ1').val())+Number($('#SQ1').val())+Number($('#OQ1').val());
	        	$('#setTotalQ1').text(!isNaN(setTotal1)?setTotal1:0);
           	 	$('#totalQ1').val(parseInt($('#setTotalQ1').text()));
	        }
	        
	        function total3(){
	        	var setTotal2 = Number($('#MQ2').val())+Number($('#RQ2').val())+Number($('#SQ2').val())+Number($('#OQ2').val());
	        	$('#setTotalQ2').text(!isNaN(setTotal2)?setTotal2:0);
            	$('#totalQ2').val(parseInt($('#setTotalQ2').text()));
	        }
	        
	        function total4(){
	        	var setTotal3 = Number($('#MQ3').val())+Number($('#RQ3').val())+Number($('#SQ3').val())+Number($('#OQ3').val());
	        	$('#setTotalQ3').text(!isNaN(setTotal3)?setTotal3:0);
           	 	$('#totalQ3').val(parseInt($('#setTotalQ3').text()));
	        }
	        
	        function total5(){
	        	var setTotal4 = Number($('#MQ4').val())+Number($('#RQ4').val())+Number($('#SQ4').val())+Number($('#OQ4').val());
	        	$('#setTotalQ4').text(!isNaN(setTotal4)?setTotal4:0);
           		$('#totalQ4').val(parseInt($('#setTotalQ4').text()));
	        }
	        
	        function MQ1Rule(){
            	$("#MQ1").rules("add",{
	            	min: parseInt($("#MQ0").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }	   
	        
            function MQ2Rule(){
            	$("#MQ2").rules("add",{
	            	min:parseInt($("#MQ1").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            
            function MQ3Rule(){
            	$("#MQ3").rules("add",{
	            	min:parseInt($("#MQ2").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            
            function MQ4Rule(){
            	$("#MQ4").rules("add",{
	            	min:parseInt($("#MQ3").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            
            function MQ5Rule(){
            	$("#MQ5").rules("add",{
 	            	min:parseInt($("#MQ4").val()),
 	            	messages:{
 	            		min:"人員數量不能少於前季{0}人"
 	            	}
 	        	});
            }
            
            function RQ1Rule(){
            	$("#RQ1").rules("add",{
	 	            min:parseInt($("#RQ0").val()),
	 	            messages:{
	 	            	min:"人員數量不能少於前季{0}人"
	 	            }
	 	        });
            }
            
            function RQ2Rule(){
            	$("#RQ2").rules("add",{
 	            	min:parseInt($("#RQ1").val()),
 	            	messages:{
 	            		min:"人員數量不能少於前季{0}人"
 	            	}
 	        	});
            }
            
            function RQ3Rule(){
            	$("#RQ3").rules("add",{
 	            	min:parseInt($("#RQ2").val()),
 	            	messages:{
 	            		min:"人員數量不能少於前季{0}人"
 	            	}
 	        	});
            }
            
            function RQ4Rule(){
            	$("#RQ4").rules("add",{
	            	min:parseInt($("#RQ3").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            
            function RQ5Rule(){
            	$("#RQ5").rules("add",{
	            	min:parseInt($("#RQ4").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            
            function SQ1Rule(){
            	$("#SQ1").rules("add",{
	            	min:parseInt($("#SQ0").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            function SQ2Rule(){
            	$("#SQ2").rules("add",{
	            	min:parseInt($("#SQ1").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            function SQ3Rule(){
            	$("#SQ3").rules("add",{
	            	min:parseInt($("#SQ2").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            function SQ4Rule(){
            	$("#SQ4").rules("add",{
	            	min:parseInt($("#SQ3").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            function SQ5Rule(){
            	$("#SQ5").rules("add",{
 	            	min:parseInt($("#SQ4").val()),
 	            	messages:{
 	            		min:"人員數量不能少於前季{0}人"
 	            	}
 	        	});
            }
            function OQ1Rule(){
            	$("#OQ1").rules("add",{
 	            	min:parseInt($("#OQ0").val()),
 	            	messages:{
 	            		min:"人員數量不能少於前季{0}人"
 	            	}
 	        	});
            }
            function OQ2Rule(){
            	$("#OQ2").rules("add",{
 	            	min:parseInt($("#OQ1").val()),
 	            	messages:{
 	            		min:"人員數量不能少於前季{0}人"
 	            	}
 	        	});
            }
            function OQ3Rule(){
            	$("#OQ3").rules("add",{
 	            	min:parseInt($("#OQ2").val()),
 	            	messages:{
 	            		min:"人員數量不能少於前季{0}人"
 	            	}
 	        	});
            }
            function OQ4Rule(){
            	$("#OQ4").rules("add",{
	            	min:parseInt($("#OQ3").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
            function OQ5Rule(){
            	$("#OQ5").rules("add",{
	            	min:parseInt($("#OQ4").val()),
	            	messages:{
	            		min:"人員數量不能少於前季{0}人"
	            	}
	        	});
            }
	    </script>
	 <!-- responsive-table -->  
	    <script src="js/responsive-tables.js"></script>
</body>
</html>