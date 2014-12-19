<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Chart</title>
</head>
<body>
	chart
	<c:set var="dateList" value="${dataList}" />
	<div id="canvas-holder">
		<canvas id="chart-area" width="300" height="300"/>
	</div>

	<script>
		var pieData = [
			<c:forEach items='${dataList}' var='label' varStatus='status'>
				{
					value : ${label.value},
					color: '${label.color}',
					//highlight: '${label.highlight}',
					label: '${label.label}'
				}
				<c:if test="${!status.last}">,</c:if>
			</c:forEach>
	        ];
			window.onload = function(){
				var ctx = document.getElementById("chart-area").getContext("2d");
				alert('before');
				window.myPie = new Chart(ctx).Pie(pieData);
				alert('after');
			};

	</script>
	<script src="js/Chart.js"></script>
</body>
</html>