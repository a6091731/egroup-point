<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html lang="zh-tw">
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
 	<meta name="description" content="創業前檢核表地圖-請依順序完成您的創業前檢核表-創業e點通">  
	<title>創業前檢核表地圖-請依順序完成您的創業前檢核表-創業e點通</title>
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
	<!-- jQUERY UI dateTimePicker -->
	<link rel="stylesheet" href="css/jquery-ui-1.9.2.custom.css">
	<!-- layout -->
	<link rel="stylesheet" href="css/layout.css">
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
							<a href="venturePlanMap" id="loginButton"><span>創業地圖</span></a>
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
            		<p><a href="index">首頁</a> &gt; 
            		<a href="venturePlanMap">創業地圖</a> &gt; <span>創業前檢核表地圖</span></p>
	            </div>
			</div>
	        <div class="grid_6 prefix_3 suffix_3">
				<section class="ventureChecklistTitle">
					<img alt="創業前檢核表圖示" src="images/ventureCheck.png">
					<h2>創業前檢核表</h2>
					<ul>
						<li>請填寫您的創業時間，我們將以您設定的時間為基準往後一年作為您的營運排程。</li>
						<li>您創業第一年的時間：</li>
						<li>
							<input class="form-control2 monthYearPicker" id="startDate" 
							value="${fn:substring(getMember.capitalDate,0,7) }" readonly>至
							<input class="form-control2 monthYearPicker" id="endDate" disabled>							
						</li>
						<li>1.請依照順序完成您的創業前檢核表</li>
						<li>2.最後您可以按下"儲存創業檢核表" 儲存您的創業檢核表至您的電腦</li>
						<li>3.若在填表過程中您不清楚方向，可按下"我需要協助"來幫助自己完成填表</li>
					</ul>
				</section>
			</div>
		</div>			
	</div>
	<div class="ventureChecklist clearfix">
		<div class="container">
			<div class="grid_6 prefix_3 suffix_3">
				<ul>
					<li>
						<div class="ventureBox clearfix">
							<div class="progressCircle" data-dimension="80" data-text="${getMember.percent11>0?getMember.percent11:0}%" data-fontsize="16" 
							data-percent="${getMember.percent11}" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" 
							data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>創業業種</h3>
								<p>填寫創業業種、商業模式和在此行業的一技之長</p>
							</div>
							<i class="fa fa-angle-right fa-5x"></i>
							<a href="ventureTypes" target="_self"></a>
						</div>
 					</li>
					<li>
						<div class="${getMember.percent11>0? 'ventureBox clearfix':'ventureBoxLocked clearfix'}">
							<div class="progressCircle" data-dimension="80" data-text="${getMember.percent12>0?getMember.percent12:0}%" data-fontsize="16" 
							data-percent="${getMember.percent12}" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" 
							data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>目標市場描述</h3>
								<p>填寫目標客戶、提供給顧客什麼價值、顧客從中能得到什麼好處</p>
							</div>
							<i class="${getMember.percent11>0? 'fa fa-angle-right fa-5x':'fa fa-lock fa-4x fa-top'}"></i>
							<a href="${getMember.percent11>0? 'targetMarketDescribe':'javascript:;'}" target="_self"></a>
						</div>
 					</li>
 					<li>
						<div class="${getMember.percent12>0? 'ventureBox clearfix':'ventureBoxLocked clearfix'}">
							<div class="progressCircle" data-dimension="80" data-text="${getMember.productCount>0? 100:0}%" data-fontsize="16" 
							data-percent="${getMember.productCount>0? 100:0}" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" 
							data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>產品描述</h3>
								<p>填寫產品相關資訊，目前有${getMember.productCount }項產品資訊</p>
							</div>
							<i class="${getMember.percent12>0? 'fa fa-angle-right fa-5x':'fa fa-lock fa-4x fa-top'}"></i>
							<a href="${getMember.percent12>0? 'showAllProductDescribe':'javascript:;'}" target="_self"></a>
						</div>
 					</li>
 					<li>
						<div class="${getMember.productCount>0? 'ventureBox clearfix':'ventureBoxLocked clearfix'}">
							<div class="progressCircle" data-dimension="80" data-text="${getMember.percent14>0?getMember.percent14:0}%" data-fontsize="16" 
							data-percent="${getMember.percent14}" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" 
							data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>業務</h3>
								<p>填寫業務銷售通路、業務銷售末端消費者</p>
							</div>
							<i class="${getMember.productCount>0? 'fa fa-angle-right fa-5x':'fa fa-lock fa-4x fa-top'}"></i>
							<a href="${getMember.productCount>0? 'businessSales':'javascript:;'}" target="_self"></a>
						</div>
 					</li>
 					<li>
						<div class="${getMember.percent14>0? 'ventureBox clearfix':'ventureBoxLocked clearfix'}">
							<div class="progressCircle" data-dimension="80" data-text="${getMember.percent15>0?getMember.percent15:0}%" data-fontsize="16" 
							data-percent="${getMember.percent15}" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" 
							data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>行銷</h3>
								<p>填寫行銷策略、付費行銷、免費行銷</p>
							</div>
							<i class="${getMember.percent14>0? 'fa fa-angle-right fa-5x':'fa fa-lock fa-4x fa-top'}"></i>
							<a href="${getMember.percent14>0? 'businessMarket':'javascript:;'}" target="_self"></a>
						</div>
 					</li>
 					<li>
						<div class="${getMember.percent15>0? 'ventureBox clearfix':'ventureBoxLocked clearfix'}">
							<div class="progressCircle" data-dimension="80" data-text="${getMember.percent16>0?getMember.percent16:0}%" data-fontsize="16" 
							data-percent="${getMember.percent16}" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" 
							data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>產業定位</h3>
								<p>填寫在產業供應練中的位置</p>
							</div>
							<i class="${getMember.percent15>0? 'fa fa-angle-right fa-5x':'fa fa-lock fa-4x fa-top'}"></i>
							<a href="${getMember.percent15>0? 'businessOrientation':'javascript:;'}" target="_self"></a>
						</div>
 					</li>
 					<li>
						<div class="${getMember.percent16>0? 'ventureBox clearfix':'ventureBoxLocked clearfix'}">
							<div class="progressCircle" data-dimension="80" data-text="${getMember.percent17>0?getMember.percent17:0}%" data-fontsize="16"
							 data-percent="${getMember.percent17}" data-fgcolor="#30B455" data-bgcolor="#eee" data-width="10" 
							 data-bordersize="10" data-animationstep="2"></div>
							<div class="progressDescribe">
								<h3>人力資源規劃</h3>
								<p>填寫人力規劃、組織規模及人力養成圖表</p>
							</div>
							<i class="${getMember.percent16>0? 'fa fa-angle-right fa-5x':'fa fa-lock fa-4x fa-top'}"></i>
							<a href="${getMember.percent16>0? 'humanResourcePlan':'javascript:;'}" target="_self"></a>
						</div>
 					</li>
 					
				</ul>		
			
			
			</div>
		</div>
	</div>

	<!-- import jquery -->
	<!-- <script src="js/jquery-1.9.1.min.js"></script>此版本jquery 無法顯示彈窗，看要不要改成1.7.1 -->
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	
	<!-- import nav slideToggle RWD js -->	
	<script src="js/nav.js"></script>
	
	<!-- import Reveal Modal -->
	<script src="js/jquery.reveal.js"></script>
	
	<!-- import jquery.mobilemenu.js -->
	<script src="js/jquery.mobilemenu.js"></script>
	
	<!-- import progressbar -->
	<script src="js/progressbar.js"></script>
	
	<!-- import progresscircle -->	
	<script src="js/jquery.circliful.js"></script>
	
	<!-- import month picker引入jqueryUI -->
	<script src="js/jquery-ui-1.9.2.custom.js"></script>
	
	<script src="js/jquery.validate.js"></script>
	<script src="js/messages_zh_TW.js"></script>
	<script src="js/additional-methods.js"></script>	

	<script type="text/javascript">
		$(function() {
			//percent圖示
			progressBar(20, $('#progressBar'));
			$('.progressCircle').circliful();
			
			//起始時間限制
			var endDate = calculateEndDate($('#startDate').val());
			$('#endDate').val(endDate);		
			
			// month picker
			$('.monthYearPicker').datepicker({ 				
				changeMonth: true,
				changeYear: true,
				showButtonPanel: true,
				dateFormat: 'yy-MM',
				showMonthAfterYear: true,
			}).focus(function() {					
				var thisCalendar = $(this);
				$('.ui-datepicker-calendar').detach();
				$('.ui-datepicker-close').click(function() {						
					var month = $("#ui-datepicker-div .ui-datepicker-month :selected").val();
					var year = $("#ui-datepicker-div .ui-datepicker-year :selected").val();
					thisCalendar.datepicker('setDate', new Date(year, month, 1));
					setEndDate(year, month);
				});
			});
		});		
		
		$("#sendForm").validate({
        	//focus導致datepicker失效，暫時關閉
        	focusInvalid:false
        });	
        
        //日期validate
        $.validator.addMethod("dRequired", $.validator.methods.required, "請填入日期");
        //金額validate   
        $.validator.addMethod("cRequired", $.validator.methods.required, "請輸入金額");
        $.validator.addMethod("digits", $.validator.methods.digits, "請輸入整數");
        $.validator.addMethod("min", $.validator.methods.min, "請輸入大於0的");
        $.validator.addMethod("cMaxlength", $.validator.methods.maxlength, "請輸入小於10位數的金額");
       
        jQuery.validator.addClassRules({
        	dateValidate: {
        		dRequired: true,
        		//customDateValidator: true,
        		/*dateMin: '${fn:substring(getMember.capitalDate,0,7)}',
        		dateMax: calculateEndDate('${fn:substring(getMember.capitalDate,0,7)}')	 */          		
        	},
        	moneyValidate: {
        		cRequired: true,
        		digits: true,
        		min: 1,
        		cMaxlength: 9
        	}
        }) 
				
		function calculateEndDate(startDate){
			var endDate;
			var endYear = parseInt(startDate.substring(0,4));
			var endMon = parseInt(startDate.substring(5,7))-1;
			if(endMon == 0){
				endDate = endYear+'-12';
			}else{
				endYear++;
				endMon = '0'+endMon;
				endDate = endYear+'-'+endMon.substring(endMon.length-2,endMon.length);
			}
			alert('endDate='+endDate);
			return endDate;
		}
		
		function setEndDate(startYear , startDate){
			alert("startYear="+startYear);
			alert("startDate="+startDate);
			var startDate = $(this).val();
			if(startYear != '' && startDate!= ''){
				alertify.confirm("當您修改日期，將會刪除你設定日期範圍外的資料", function (e) {
		   			if (e) {
		   				if(startMonth != ''){
			   				$.ajax({
			   					url:"modiVenturePlanStartDate",
			   					data:{
			   						startDate : startDate
			   					},
			   					success:function(){
			   						var endDateCombin = startYear+'-'+startDate;
			   						var endDate = calculateEndDate(endDateCombin);
			   						$('#endDate').val(endDate);
			   		   				alertify.success("更新成功!");
			   					}
			   				});
		   				}else{
		   					$('#endDate').val('');
		   				}
		   			} else {
		   				$('#startDate').val('${fn:substring(getMember.capitalDate,0,7) }');
		   				alertify.error("取消更新!");
		   			}
	   			});
			}else{
				if(startDate != ''){
	   				$.ajax({
	   					url:"modiVenturePlanStartDate",
	   					data:{
	   						startDate : startDate
	   					},
	   					success:function(){
	   						var endDate = calculateEndDate(startDate);
	   						$('#endDate').val(endDate);
	   		   				alertify.success("更新成功!");
	   					}
	   				});
   				}else{
   					$('#endDate').val('');
   				}
			}
		}
		</script>
</body>
</html>