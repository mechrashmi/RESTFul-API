package org.rashmi.firstRESTFulApp.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Comment {
	String text;
	Integer id;
	Date created;
	String author;
	
	
	public Comment(Integer id, String text, String author) {
		this.text = text;
		this.id = id;
		this.created = new Date();
		this.author = author;
	}
	
	public Comment() {
		
	}
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
