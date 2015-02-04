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
 	<meta name="description" content="創業-支出結構-規畫你的創業第一年支出-創業e點通">  
	<title>收入結構-規畫你的創業第一年收入-創業e點通</title>

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
	<link rel="stylesheet" href="css/responsive-tables.css" media="screen">
	<!-- alertify -->
	<link rel="stylesheet" href="css/alertify.css" />
	<link rel="stylesheet" href="css/alertify.default.css"/> 
	
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
            		<p><a href="index.html">首頁</a> &gt; <a href="#">創業地圖</a> &gt; <a href="#">創業第一年營運排程地圖</a> &gt; <span>收入結構</span></p>
	            </div>
			</div>
			<!-- <div class="grid_3">
				<aside>
					<ul class="sideNav hideBlock">
						<li><a href="javascript:;"><i class="fa fa-child"></i>收入結構</a></li>
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
	        </div> -->
	        <div class="grid_12">
				<section class="ventureTypesTitle hideBlock">
					<h2><i class="fa fa-money fa-color"></i>收入結構</h2>
				</section>
				<form class="formset2">
				<a class="addProduct" data-reveal-id ="addProduct" data-closeonbackgroundclick="false"><i class="fa fa-plus"></i> 新增產品</a>
					<div class="ventureTypesInput clearfix">
						<ul>
							<li>
								<table class="productTable responsive">
									<thead>
										<tr>
											<th>產品名稱</th>
											<th>產品毛利</th>
											<th>年銷售數量</th>
											<th>編輯銷售數量</th>
											<th>產品總利潤</th>
											<th>編輯產品</th>
											<th>刪除</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${getProductList1}" var="product" varStatus="i">		
										<tr>
											<td>${product.name }</td>
											<td>${product.profit }</td>
											<td>${product.sum }</td>
											<td><a onclick="newProductSales(${i.index});"
												class="addProduct gray" data-reveal-id ="addProductSales" data-closeonbackgroundclick="false">
												<i class="fa fa-plus"></i> 新增數量</a>
											</td>								
											<td>${product.totalProfit }</td>
											<td>
												<a onclick="setEditProduct(${i.index});" 
												class="fa-color" data-reveal-id="editProduct" data-closeonbackgroundclick="false">
												<i class="fa fa-pencil-square-o fa-lg"></i></a>
											</td>
											<td>
												<a onclick="confirm(${i.index});" class="fa-color">		
												<i class="fa fa-times-circle fa-lg"></i></a>
											</td>
										</tr>						
									</c:forEach>
									
								</tbody>
							</table>
							</li>
						</ul>
						<div class="text-center">
							<ul class="pagination">
								<c:forEach items="${page.pagerList}" var="pager">
									<li class="${pager.indexClass}"><a href="${pager.url}">${pager.index}</a></li>
								</c:forEach>			
				            </ul>
                        </div>
						<a href="javascript:;" class="nextStepButton"><span class="next">下一步，填寫人力資源規劃<i class="fa fa-arrow-right"></i></span></a>
					</div>
				</form>
			</div>
		</div>			
	</div>

	<!-- addProduct BEGIN MODAL WINDOWS -->
	<div id="addProduct" class="reveal-modal">
		<div class="cont clearfix">
			<form id="sendForm" action="addProductRevenueStructure" method="post" class="formset clearfix">
				<fieldset class="fieldset2">
					<legend>1 產品名稱</legend>
					<div class="field">
						<label><span>產品名稱：</span> 
						<input type="text" class="form-control" name="name"> </label>
					</div>
				</fieldset>
				<fieldset class="fieldset2">
					<legend>2產品規格</legend>
					<textarea rows="8" name="specification"
						placeholder="近年來，由於經濟繁榮、國民所得提高、人們生活結構發生變化及單身比率年年升高..."></textarea>
				</fieldset>
				<fieldset class="fieldset2">
					<legend>3包裝說明</legend>
					<textarea rows="8" name="pack"
						placeholder="近年來，由於經濟繁榮、國民所得提高、人們生活結構發生變化及單身比率年年升高..."></textarea>
				</fieldset>
				<fieldset class="fieldset2">
					<legend>4終端消費者定價</legend>
					<div>
						<div class="field">
							<label>金額： <input type="text" name="endPrice" class="form-control">
							</label>
						</div>
					</div>
				</fieldset>
				<fieldset class="fieldset2">
					<legend>5實質銷售價格</legend>
					<div>
						<div class="field">
							<label>金額： <input type="text" name="salesPrice"	class="form-control">
							</label>
						</div>
					</div>
				</fieldset>
				<fieldset class="fieldset2">
					<legend>6直接成本</legend>
					<div>
						<div class="field">
							<label>金額： <input type="text" name="cost" class="form-control">
							</label>
						</div>
					</div>
				</fieldset>
				<button type="submit" class="finishButton">
					<span class="next">新增產品</span>
				</button>
				<button type="button" class="cancelButton">
					<span class="next">取消</span>
				</button>
			</form>
		</div>
		<a class="close-reveal-modal">&#215;</a>
	</div>
	
	<!-- BEGIN MODAL WINDOWS -->
        <div id="editProduct" class="reveal-modal">
		<div class="cont clearfix">
			<form id="sendForm1" action="editProductRevenueStructure" method="post" class="formset clearfix">
			<input type="hidden" id="editID" name="id">
				<fieldset class="fieldset2">
					<legend>1 產品名稱</legend>
					<div class="field">
						<label><span>產品名稱：</span> 
						<input type="text" id= "editName" class="form-control" name="name"></label>
					</div>
				</fieldset>
				<fieldset class="fieldset2">
					<legend>2產品規格</legend>
					<textarea rows="8" id="editSpecification" name="specification"
						placeholder="近年來，由於經濟繁榮、國民所得提高、人們生活結構發生變化及單身比率年年升高..."></textarea>
				</fieldset>
				<fieldset class="fieldset2">
					<legend>3包裝說明</legend>
					<textarea rows="8" id="editPack" name="pack"
						placeholder="近年來，由於經濟繁榮、國民所得提高、人們生活結構發生變化及單身比率年年升高..."></textarea>
				</fieldset>
				<fieldset class="fieldset2">
					<legend>4終端消費者定價</legend>
					<div>
						<div class="field">
							<label>金額： <input type="text" id="editEndPrice" name="endPrice" class="form-control">
							</label>
						</div>
					</div>
				</fieldset>
				<fieldset class="fieldset2">
					<legend>5實質銷售價格</legend>
					<div>
						<div class="field">
							<label>金額： <input type="text" id="editSalesPrice" name="salesPrice"	class="form-control">
							</label>
						</div>
					</div>
				</fieldset>
				<fieldset class="fieldset2">
					<legend>6直接成本</legend>
					<div>
						<div class="field">
							<label>金額： <input type="text" id="editCost" name="cost" class="form-control">
							</label>
						</div>
					</div>
				</fieldset>
				<button type="submit" class="finishButton">
					<span class="next">修改產品</span>
				</button>
				<button type="button" class="cancelButton" >
					<span class="next">取消</span>
				</button>
			</form>
		</div>
		<a class="close-reveal-modal">&#215;</a>
	</div>


	<!-- BEGIN MODAL WINDOWS -->
        <div id="addProductSales" class="reveal-modal">
                <div class="cont clearfix">
                        <form class="formset clearfix" id="sendForm2" action="addProductSalse" method="post">
                        		<input type="hidden" id="productID" name="productID">                        		
	                            <fieldset class="fieldset2">
	                                    <p id="productName"></p>
	                            </fieldset>
	                            <input type="hidden" id="delCount" value="1">
                                <fieldset id="addSalesQuantity" class="fieldset2">                                  	
								  	<legend>產品銷售數量 : </legend>								  			  	
								  	<button type="button" class="addbutton" onclick="addbutton();"><i class="fa fa-plus"></i> 新增數量</button>
									<div id="newMoney0" >
									  	<div class="deleteblock">
										  	<div class="field">
										  		<label>日期：
										  			<input type="month" class="form-control salsDate" id="salsDate0" name="salsDate" >
										  		</label>
										  	</div>
										  	<div class="field">
										  		<label>數量：
										  			<input type="text" class="form-control salsQuantity" id="salsQuantity0" name="salsQuantity" >
										  		</label>
										  	</div>
										  	<div class="field">
										  		<button type="button" class="deletebutton" onclick="deletebutton(0);"><i class="fa fa-times"></i> 刪除</button>
										  	</div>					  		
									  	</div>
									</div>								  	
								</fieldset>
                                <button type="submit" class="finishButton" id="addProductSalesSubmit">
								<span class="next">確認修改</span>
								</button>
								<button type="button" class="cancelButton" >
									<span class="next">取消</span>
								</button>
                          </form>
                </div>
                <a class="close-reveal-modal">&#215;</a>
        </div>



	<!-- import jquery -->	
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<!-- import nav slideToggle RWD js -->	
		<script src="js/nav.js"></script>
	<!-- Reveal Modal -->
		<script src="js/jquery.reveal.js"></script>
	<!-- jquery.mobilemenu.js -->
		<script src="js/jquery.validate.js"></script>
		<script src="js/messages_zh_TW.js"></script>
		<script src="js/additional-methods.js"></script>
		<script src="js/alertify.min.js"></script>
		<script type="text/javascript">
			var addSalesQuantityCount = 1;
			var index = 1;
			var count = 1;
			var deletedIndex = 0;
	        $(function(){
	            $(".cancelButton").click(function(){
	            	alert("hehe");
					$(".close-reveal-modal").trigger("click");
					alert("321");
				});
	            $("#sendForm2").validate({
	            	rules:{},
	            	messages:{},
    	        	submitHandler:function(form){
    					$(".salsDate").attr("name","salsDate");
    					form.submit();
    					$(".salsQuantity").attr("name","salsQuantity");
    					form.submit();
    				}
	            });	 
	           $("#addProductSalesSubmit").click(function(){
	            	var salsClassCount = $('.salsDate').length
	            	if(salsClassCount>1){
	            		$("#salsDate0").rules("add",{
	    	        		required:true,
	    	            	messages:{
	    	            		required:"請輸入日期",	            		
	    	            	}
	    	        	});	        	

	    	        	$("#salsQuantity0").rules("add",{
	    	        		required:true,
	    	            	number: true,
	    	            	min:1,
	    	            	maxlength:12,
	    	            	messages:{
	    	            		required:"請輸入數量",
	    	            		num:"請輸入數字",
	    	            		min:"請輸入大於0的數量",
	    	            		maxlength:"請輸入小於12位數的數量"
	    	            	}
	    	        	});        		    	        	
	            	}else{	            		
	            		if($('.salsDate').val()!="" || $('.salsQuantity').val()!=""){
	            			$("#salsDate0").rules("add",{
		    	        		required:true,
		    	            	messages:{
		    	            		required:"請輸入日期",	            		
		    	            	}
		    	        	});	        	

		    	        	$("#salsQuantity0").rules("add",{
		    	        		required:true,
		    	            	number: true,
		    	            	min:1,
		    	            	maxlength:12,
		    	            	messages:{
		    	            		required:"請輸入數量",
		    	            		num:"請輸入數字",
		    	            		min:"請輸入大於0的數量",
		    	            		maxlength:"請輸入小於12位數的數量"
		    	            	}
		    	        	});        	
		    	        	
	            		}else{
	            			alert("請注意，因為您沒有輸入任何資料，此產品的銷售數量為0。");
	            			$(".close-reveal-modal").trigger("click");
	            		}        
	            	}
				});	   
	     	});
	        
	        function deleteProduct(){
	        	$.ajax({
					url:"getProductSalesListByMemberID",
					data:{
						productID : list[i].id
					},
					dataType:"json",
	        	})
	        }
	        
	        function addValidate(getIndex){
	        	alert(123321);
	        	alert("index="+getIndex);
	        	$("#salsDate"+getIndex).rules("add",{
	        		required:true,
	            	messages:{
	            		required:"請輸入日期",	            		
	            	}
	        	});	        	

	        	$("#salsQuantity"+getIndex).rules("add",{
	        		required:true,
	            	number: true,
	            	min:1,
	            	maxlength:12,
	            	messages:{
	            		required:"請輸入數量",
	            		num:"請輸入數字",
	            		min:"請輸入大於0的數量",
	            		maxlength:"請輸入小於12位數的數量"
	            	}
	        	});
	        }
	        
	        function setEditProduct(i){
				var list = $.parseJSON('${getProductList2}');
				$('#editID').val(list[i].id);
				$('#editName').val(list[i].name);
				$('#editSpecification').val(list[i].specification);
				$('#editPack').val(list[i].pack);
				$('#editEndPrice').val(list[i].endPrice);
				$('#editSalesPrice').val(list[i].salesPrice);
				$('#editCost').val(list[i].cost);
			}
	        
	        function addbutton(){
	        	var addSalesQuantityText =
				  	'<div class="deleteblock" id="newMoney'+index+'">'+
					'<div class="field">'+  	
					'<label>日期：'+		
					'<input type="month" class="form-control salsDate" id="salsDate'+index+'" name="salsDate'+index+'">'+  			
					'</label>'+  		
					'</div>'+  	
					'<div class="field">'+  	
					'<label>數量：'+ 		
					'<input type="text" class="form-control salsQuantity"  id="salsQuantity'+index+'" name="salsQuantity'+index+'">'+ 			
					'</label>'+  		
					'</div>'+  	
					'<div class="field">'+  	
					'<button type="button" class="deletebutton" onclick="deletebutton('+index+');"><i class="fa fa-times"></i> 刪除</button>'+  		
					'</div>'+  				  		
				  	'</div>';	            		
	            	$('#addSalesQuantity').append(addSalesQuantityText);
	            	var delCount = $('#delCount').val();
	            	delCount++;	            	
	            	$('#delCount').val(delCount);
	            	addValidate(index);
	            	index++;
	        }
	        
	        function deletebutton(index){
	        	var delCount = $('#delCount').val();
	        	if(delCount>1){
            		$("#newMoney"+index).remove();  
            		delCount--;
            		$('#delCount').val(delCount);
	        	}else{
	        		$("#salsDate"+index).val("");  
	        		$("#salsQuantity"+index).val(""); 
	        	}
           	}
	        
	        function newProductSales(i){
				var list = $.parseJSON('${getProductList2}');
				$('#productID').val(list[i].id);
				$('#productName').text(list[i].name);
				$('#delCount').val(1);
				var delCount = $('#delCount').val();
				$.ajax({
					url:"getProductSalesListByMemberID",
					data:{
						productID : list[i].id
					},
					dataType:"json",
					success:function(result){
						$('#addSalesQuantity').html("");
						var addSalesQuantityText = 
							'<legend>產品銷售數量 : </legend>'+							  			  	
						  	'<button type="button" class="addbutton" onclick="addbutton();"><i class="fa fa-plus"></i> 新增數量</button>'+
							'<div id="newMoney0" >'+
							'<div class="deleteblock">'+
							'<div class="field">'+
							'<label>日期：'+
							'<input type="month" class="form-control salsDate" id="salsDate0" name="salsDate">'+
							'</label>'+
							'</div>'+
							'<div class="field">'+
							'<label>數量：'+
							'<input type="text" class="form-control salsQuantity" id="salsQuantity0" name="salsQuantity">'+
							'</label>'+
							'</div>'+
							'<div class="field">'+
							'<button type="button" class="deletebutton" onclick="deletebutton(0);"><i class="fa fa-times"></i> 刪除</button>'+
							'</div>'+		  		
							'</div>'+
							'</div>';
						$('#addSalesQuantity').append(addSalesQuantityText);
						$("#salsDate0").val("");
						$("#salsQuantity0").val("");
						if(result.length>0){
							$("#salsDate0").val(result[0].date_string);
							$("#salsQuantity0").val(result[0].quantity);							
							for(var i=1; i<result.length; i++){
				            	$('#delCount').val($('#delCount').val()+1)
								addSalesQuantityText = 
								  	'<div class="deleteblock" id="newMoney'+index+'">'+
									'<div class="field">'+  	
									'<label>日期：'+		
									'<input type="month" class="form-control salsDate" id="salsDate'+index+'" name="salsDate'+index+'" value="'+result[i].date_string+'">'+  			
									'</label>'+  		
									'</div>'+  	
									'<div class="field">'+  	
									'<label>數量：'+ 		
									'<input type="text" class="form-control salsQuantity" id="salsQuantity'+index+'" name="salsQuantity'+index+'" value="'+result[i].quantity+'">'+ 			
									'</label>'+  		
									'</div>'+  	
									'<div class="field">'+  	
									'<button type="button" class="deletebutton" onclick="deletebutton('+index+');"><i class="fa fa-times"></i> 刪除</button>'+  		
									'</div>'+  				  		
								  	'</div>';
				            	$('#addSalesQuantity').append(addSalesQuantityText);	
				            	delCount++;
				            	$('#delCount').val(delCount);
				            	addValidate(index);
				            	index++;
							}
						}
					}
				});
			}
	        
	        function reset() {
				$("#toggleCSS").attr("href", "../themes/alertify.default.css");
				alertify.set({
					labels : {
						ok     : "確認刪除",
						cancel : "取消"
					},
					delay : 5000,
					buttonReverse : false,
					buttonFocus   : "ok"
				});
			}
	        
	        function confirm(i){
	        	var list = $.parseJSON('${getProductList2}');
				var productName =list[i].name;
	        	reset();
	   			alertify.confirm("請問您確定要刪除"+productName+"?", function (e) {
	   				if (e) {
	   					$.ajax({
	   						url:"delProductRevenueStructure",
	   						data:{
	   							productID : list[i].id
	   						},
	   						dataType:"json",
	   						success:function(result){
	   						}
	   					});	   					
	   					location.reload();
	   					alertify.success("刪除成功!");
	   				} else {
	   					alertify.error("取消刪除!");
	   				}
   				});
   				return false;
	        }
	        
	        
	    </script>
</body>
</html>