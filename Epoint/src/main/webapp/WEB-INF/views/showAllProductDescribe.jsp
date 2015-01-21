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
<title>產品描述-填寫每項產品的規格、說明、定價、銷售價格、直接成本-創業e點通</title>

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
					<a href="index.html"><img src="./images/egroup.png"
						alt="創業e點通品牌標誌"></a>
				</div>
				<!-- logo -->
				<nav class="clearfix">
					<div class="top-nav">
						<div class="top-nav-right">
							<a href="javascript:;" id="loginButton"><span>創業地圖</span></a>
						</div>
					</div>
					<!-- top-nav -->
				</nav>
			</div>
			<!-- grid_12 -->
		</div>
		<!-- container -->
	</header>
	<div class="wrapper">
		<div class="container">
			<div class="grid_12">
				<div class="banner">
					<div class="imgHolder">
						<img src="images/banner-office.jpg" alt="banner圖片-辦公室">
					</div>
				</div>
				<div class="breadcrumbs">
					<p>
						<a href="index.html">首頁</a> &gt; <a href="#">創業地圖</a> &gt; <a
							href="#">創業前檢核表地圖</a> &gt;<span>創業前檢核表【產品描述】</span>
					</p>
				</div>
			</div>
			<div class="grid_3">
				<aside>
					<ul class="sideNav hideBlock">
						<li><a href="javascript:;"><i class="fa fa-child"></i>創業業種</a></li>
						<li><a href="javascript:;"><i class="fa fa-lock"></i>目標市場描述</a></li>
						<li><a href="javascript:;"><i class="fa fa-file-text-o"></i>產品描述</a></li>
						<li><div class="mask"></div>
							<a href="javascript:;"><i class="fa fa-lock"></i>業務</a></li>
						<li><div class="mask"></div>
							<a href="javascript:;"><i class="fa fa-lock"></i>行銷</a></li>
						<li><div class="mask"></div>
							<a href="javascript:;"><i class="fa fa-lock"></i>產品定位</a></li>
						<li><div class="mask"></div>
							<a href="javascript:;"><i class="fa fa-lock"></i>人力資源規劃</a></li>
					</ul>
					<div class="memberRwdnav clearfix">
						<nav class="primary">
							<ul class="rightnav">
								<li><a href="javascript:;">公司成立</a></li>
								<li><a href="javascript:;">(鎖) 營業場所完工</a></li>
								<li><a href="javascript:;">(鎖) 人員到位</a></li>
								<li><a href="javascript:;">(鎖) 生產設備建置</a></li>
								<li><a href="javascript:;">(鎖) 試產</a></li>
								<li><a href="javascript:;">(鎖) 原料採購</a></li>
								<li><a href="javascript:;">(鎖) 試營運</a></li>
								<li><a href="javascript:;">(鎖) 通路開發</a></li>
								<li><a href="javascript:;">(鎖) 行銷推廣</a></li>
							</ul>
						</nav>
					</div>
				</aside>
			</div>
			<div class="grid_9">
				<section class="ventureTypesTitle hideBlock">
					<h2>
						<i class="fa fa-file-text-o fa-color"></i>產品描述
					</h2>
				</section>

				<form class="formset2">
					<a class="addProduct" data-reveal-id="addProduct" data-closeonbackgroundclick="false">
					<i class="fa fa-plus"></i> 新增一項產品</a>
					<div class="ventureTypesInput clearfix">
						<ul>
							<li>
								<table class="productTable responsive">
									<thead>
										<tr>
											<th>產品名稱</th>
											<th>終端消費者定價</th>
											<th>實質銷售價格</th>
											<th>直接成本</th>
											<th>編輯</th>
											<th>刪除</th>
										</tr>
									</thead>
									<tbody>
									<c:forEach items="${getProductList1}" var="product" varStatus="i">		
										<tr>
											<td>${product.name }</td>
											<td>${product.endPrice }</td>
											<td>${product.salesPrice }</td>
											<td>${product.cost }</td>											
											<td>
											 	<!-- <a onclick="setEditProduct('${product}','${product.name}','${product.specification}','${product.pack}','${product.endPrice}','${product.salesPrice}','${product.cost}');" 
												class="fa-color" data-reveal-id="editProduct" data-closeonbackgroundclick="false">
												<i class="fa fa-pencil-square-o fa-lg"></i></a>
												 -->
												
												<a onclick="setEditProduct(${i.index});" 
												class="fa-color" data-reveal-id="editProduct" data-closeonbackgroundclick="false">
												<i class="fa fa-pencil-square-o fa-lg"></i></a>
											</td>
											<td>
												<a href="javascript:;" class="fa-color">
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
				        </div><!-- page -->
						<a href="javascript:;" class="nextStepButton"><span
							class="next">下一步，填寫人力資源規劃<i class="fa fa-arrow-right"></i></span></a>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- addProduct BEGIN MODAL WINDOWS -->
	<div id="addProduct" class="reveal-modal">
		<div class="cont clearfix">
			<form id="sendForm" action="addProduct" method="post" class="formset clearfix">
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
	<!-- editProduct BEGIN MODAL WINDOWS -->
	<div id="editProduct" class="reveal-modal">
		<div class="cont clearfix">
			<form id="sendForm" action="editProduct" method="post" class="formset clearfix">
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



	<!-- import jquery -->
	<script
		src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<!-- import nav slideToggle RWD js -->
	<script src="js/nav.js"></script>
	<!-- Reveal Modal -->
	<script src="js/jquery.reveal.js"></script>
	<!-- jquery.mobilemenu.js -->
	<script src="js/jquery.mobilemenu.js"></script>
	<script type="text/javascript">
		$(function() {
			$('nav.primary .rightnav').mobileMenu();
			$(".cancelButton").click(function(){
				$(".close-reveal-modal").trigger("click");
			});
		});
		
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
	</script>
	<!-- responsive-table -->
	<script src="js/responsive-tables.js"></script>
</body>
</html>