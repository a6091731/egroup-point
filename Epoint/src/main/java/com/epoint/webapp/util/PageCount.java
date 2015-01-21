package com.epoint.webapp.util;

import java.util.ArrayList;
import java.util.List;

import com.epoint.webapp.util.entity.Pager;

public class PageCount {
	private int pageNow;
	private int pageSize;
	private int count;	private int pages;
	private int start;
	private int end;
	private int startPage=1;
	private int endPage;
	private int prePage;
	private int nextPage;
	private boolean showStart;
	private boolean showEnd;
	private String url;
	private String endUrl;
	private List<Pager> pagerList;
	private boolean show;
	public PageCount(int pageNow, int pageSize, int count, String url) {
		super();
		this.pageNow = pageNow;
		this.pageSize = pageSize;
		this.count = count;
		this.url = url;
	}
	
	public int getPageNow() {
		return pageNow;
	}

	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isShowStart() {
		return showStart;
	}

	public void setShowStart(boolean showStart) {
		this.showStart = showStart;
	}

	public boolean isShowEnd() {
		return showEnd;
	}

	public void setShowEnd(boolean showEnd) {
		this.showEnd = showEnd;
	}

	public String getEndUrl() {
		return endUrl;
	}

	public void setEndUrl(String endUrl) {
		this.endUrl = endUrl;
	}


	public List<Pager> getPagerList() {
		return pagerList;
	}

	public void setPagerList(List<Pager> pagerList) {
		this.pagerList = pagerList;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}
	
	/*public void calculate(){
		show = (count==0?false:true);
		pagerList = new ArrayList<Pager>();
		pages = count==0?1:(count/pageSize)+(count%pageSize==0?0:1);
		start = (pageNow-1)*pageSize;
		end = start+pageSize;
		startPage = 1;
		if((pageNow <= 3) || (pageNow == 4 && pages == 4))
			startPage = 1;
		else if(pageNow+1 > pages)
			startPage = pageNow-4;
		else if(pageNow+2 > pages)
			startPage = pageNow-3;
		else
			startPage = pageNow-2;
		endPage = (pages==0?1:((startPage+4)>=pages?pages:(startPage+4)));
		prePage = (pageNow-1)<=0?1:(pageNow-1);
		nextPage = pages==0?1:((pageNow+1)>=pages?pages:(pageNow+1));
		showStart = (pageNow-2<2 || pages<=5)?false:true;
		showEnd = (pageNow+1>pages || pages<5)?false:true;
		
		if(pageNow != 1){
			Pager pager1 = new Pager("←", "prev disabled", url+"?p="+prePage);
			pagerList.add(pager1);
			if(showStart){
				Pager pager2 = new Pager("1...", "", url+"?p=1");
				pagerList.add(pager2);
			}
		}
		for(int i=startPage; i<=endPage; i++){
			Pager pager = new Pager(String.valueOf(i), (pageNow==i?"active":""), url+"?p="+i);
			pagerList.add(pager);
		}
		if(pageNow != pages){
			if(endPage < pages){
				Pager pager3 = new Pager("..."+String.valueOf(pages), "", url+"?p="+pages);
				pagerList.add(pager3);
			}
			if(showEnd){
				Pager pager4 = new Pager("→", "next", url+"?p="+nextPage);
				pagerList.add(pager4);
			}
			
		}
		
	}	*/
	

	public void calculate(){
	    show = (count==0?false:true);
		pagerList = new ArrayList<Pager>();
		pages = count==0?1:(count/pageSize)+(count%pageSize==0?0:1);
		start = (pageNow-1)*pageSize;
		end = start+pageSize;
		startPage = 1;
		if((pageNow <= 3) || (pageNow == 4 && pages == 4))
			startPage = 1;
		else if(pageNow+1 > pages)
			startPage = pageNow-4;
		else if(pageNow+2 > pages)
			startPage = pageNow-3;
		else
			startPage = pageNow-2;
		endPage = (pages==0?1:((startPage+4)>=pages?pages:(startPage+4)));
		prePage = (pageNow-5)<=0?1:(pageNow-5);
		nextPage = pages==0?1:((pageNow+5)>=pages?pages:(pageNow+5));
		showStart = (pageNow-2<=1 || pages<=5)?false:true;
		showEnd = (pageNow+2>=pages || pages<=5)?false:true;
		
		if(pageNow != 1){
			Pager pager1 = new Pager("←", "prev disabled", url+"?p="+prePage);
			pagerList.add(pager1);
			if(showStart){
				Pager pager2 = new Pager("1...", "", url+"?p=1"+endUrl);
				pagerList.add(pager2);
			}
		}
		for(int i=startPage; i<=endPage; i++){
			Pager pager = new Pager(String.valueOf(i), (pageNow==i?"active":""), url+"?p="+i);
			pagerList.add(pager);
		}
		if(pageNow != pages){
			if(endPage < pages){
				Pager pager3 = new Pager("..."+String.valueOf(pages), "", url+"?p="+pages);
				pagerList.add(pager3);
			}
			if(showEnd){
				Pager pager4 = new Pager("→", "next", url+"?p="+nextPage);
				pagerList.add(pager4);
			}
			
		}
		
	}
}
