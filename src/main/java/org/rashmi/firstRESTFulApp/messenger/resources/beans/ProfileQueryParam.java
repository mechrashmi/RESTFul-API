package org.rashmi.firstRESTFulApp.messenger.resources.beans;

import javax.ws.rs.QueryParam;


public class ProfileQueryParam {
	@QueryParam("profileSubStr") String str;
	@QueryParam("start") Integer start;
	@QueryParam("size") Integer size;
	
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	

}
