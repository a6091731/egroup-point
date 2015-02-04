$(function(){		
		
		
		var rollThis = $('.topheader'),	//滚动到此区块的时候开始随动
			offset = rollThis.offset(),	// 获取位置
			objWindow = $(window);			// 窗口元素

		objWindow.scroll(function() {
			if (objWindow.scrollTop() > offset.top){
				rollThis.addClass('topheader-fixed');
			} else {
				rollThis.removeClass('topheader-fixed');
			}
		});
	});