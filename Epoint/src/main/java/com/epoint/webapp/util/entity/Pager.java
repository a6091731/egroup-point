package com.epoint.webapp.util.entity;

public class Pager {
	private String index;
	private String indexClass;
	private String url;
	
	public Pager(String index, String indexClass, String url) {
		super();
		this.index = index;
		this.indexClass = indexClass;
		this.url = url;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public String getIndexClass() {
		return indexClass;
	}
	public void setIndexClass(String indexClass) {
		this.indexClass = indexClass;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
