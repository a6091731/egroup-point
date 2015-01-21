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
				<a class="addProduct" data-reveal-id ="addProduct"><i class="fa fa-plus"></i> 新增一項產品的收入</a>
					<div class="ventureTypesInput clearfix">
						<ul>
							<li>
								<table class="productTable responsive">
									<thead>
										<tr>
											<th>產品名稱</th>
											<th>產品售價</th>
											<th>產品成本</th>
											<th>產品毛利</th>
											<th>總銷售數量</th>
											<th>編輯</th>
											<th>刪除</th>
										</tr>
									</thead>
									<tbody>
									<tr>
										<td>好吃的旺旺仙貝</td>
										<td>200</td>
										<td>180</td>
										<td>100</td>
										<td>100</td>
										<td><a href="javascript:;" class="fa-color"><i class="fa fa-pencil-square-o fa-lg"></i></a></td>
										<td><a href="javascript:;" class="fa-color"><i class="fa fa-times-circle fa-lg"></i></a></td>
									</tr>
									<tr>
										<td>好吃的乖乖</td>
										<td>200</td>
										<td>180</td>
										<td>100</td>
										<td>100</td>
										<td><a href="javascript:;" class="fa-color"><i class="fa fa-pencil-square-o fa-lg"></i></a></td>
										<td><a href="javascript:;" class="fa-color"><i class="fa fa-times-circle fa-lg"></i></a></td>
									</tr>
									<tr>
										<td>好吃的洋芋片</td>
										<td>200</td>
										<td>180</td>
										<td>100</td>
										<td>100</td>
										<td><a href="javascript:;" class="fa-color"><i class="fa fa-pencil-square-o fa-lg"></i></a></td>
										<td><a href="javascript:;" class="fa-color"><i class="fa fa-times-circle fa-lg"></i></a></td>
									</tr>
									<tr>
										<td>好吃的旺旺仙貝</td>
										<td>200</td>
										<td>180</td>
										<td>100</td>
										<td>100</td>
										<td><a href="javascript:;" class="fa-color"><i class="fa fa-pencil-square-o fa-lg"></i></a></td>
										<td><a href="javascript:;" class="fa-color"><i class="fa fa-times-circle fa-lg"></i></a></td>
									</tr>
								</tbody>
							</table>
							</li>
						</ul>
						<div class="text-center">
							<ul class="pagination">
	                            <li class="prev disabled"><a href="#">←</a></li>
	                            <li class="active"><a href="#">1</a></li>
	                            <li><a href="javascript:;">2</a></li>
	                            <li><a href="javascript:;">3</a></li>
	                            <li class="next"><a href="#">→</a></li>
	                        </ul>
                        </div>
						<a href="javascript:;" class="nextStepButton"><span class="next">下一步，填寫人力資源規劃<i class="fa fa-arrow-right"></i></span></a>
					</div>
				</form>
			</div>
		</div>			
	</div>

	<!-- BEGIN MODAL WINDOWS -->
        <div id="addProduct" class="reveal-modal">
                <div class="cont clearfix">
                        <form class="formset clearfix">
                                <fieldset class="fieldset2">
                                        <legend>1 選擇欲新增收入的產品</legend>
                                        <div class="field">
                                                <label><span>產品：</span>
                                                	<select>
                                                		<option value="">請選擇</option>
                                                		<option value="1">好吃的旺旺仙貝</option>
                                                		<option value="2">好吃的乖乖</option>
                                                		<option value="3">好吃的洋芋片</option>
                                                	</select>
                                                </label>
                                        </div>
                                </fieldset>                           
                                <fieldset  class="fieldset2">
                                        <legend>2產品售價</legend>
                                        <div>
                                                <div class="field">
                                                        <label>金額：
                                                                <input type="text" class="form-control" name="money3">
                                                        </label>
                                                </div>                                          
                                        </div>
                                </fieldset>     
                                <fieldset  class="fieldset2">
                                        <legend>3產品成本</legend>
                                        <div>
                                                <div class="field">
                                                        <label>金額：
                                                                <input type="text" class="form-control" name="money3">
                                                        </label>
                                                </div>                                          
                                        </div>
                                </fieldset>
                                <fieldset  class="fieldset2">
                                        <legend>4產品毛利</legend>
                                        <div>
                                                <div class="field">
                                                        <label>金額：
                                                                <input type="text" class="form-control" name="money3">
                                                        </label>
                                                </div>                                          
                                        </div>
                                </fieldset>
                                <fieldset  class="fieldset2">
								  	<legend>5銷售數量</legend>
								  	<button class="addbutton"><i class="fa fa-plus"></i> 新增一筆費用</button>
								  	<div>
									  	<div class="field">
									  		<label>日期：
									  			<input type="month" class="form-control" name="cardDate">
									  		</label>
									  	</div>
									  	<div class="field">
									  		<label>數量：
									  			<input type="text" class="form-control" name="cardCost">
									  		</label>
									  	</div>
									  	<div class="field">
									  		<button class="deletebutton" ><i class="fa fa-times"></i> 刪除</button>
									  	</div>					  		
								  	</div>
								</fieldset>
                                <a href="javascript:;" class="finishButton"><span class="next">新增產品收入</span></a>          
                                <a href="javascript:;" class="cancelButton"><span class="next">取消</span></a>
                          </form>
                </div>
                <a class="close-reveal-modal">&#215;</a>
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
	        $(function() {
	            $('nav.primary .rightnav').mobileMenu();

	        });
	    </script>
	<!-- responsive-table -->  
	    <script src="js/responsive-tables.js"></script>
</body>
</html>