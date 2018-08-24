package org.rashmi.firstRESTFulApp.messenger.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class Message {
	private Integer id;
	private String text;
	private Date created;
	private String author;
	private Map<Integer, Comment> commentsList;
	private List<Link> links = new ArrayList<>();
	
	
	
	
	
	public void addLink(Link link) {
		links.add(link);
	}

	public List<Comment> getCommentsList() {
		ArrayList<Comment> comments = new ArrayList<>();
		for(Comment c : commentsList.values()) {
			comments.add(c);
		}
		return comments;
	}
	
	public Comment getComment(Integer comID) {
		return commentsList.get(comID);
	}

	public void addComment(Comment comment) {
		commentsList.put(comment.getId(), comment);
	}

	public Message() {
		
	}
	
	public Message(Integer id, String text, String author) {
		this.id = id;
		this.text = text;
		this.created = new Date();
		this.author = author;
		commentsList = new HashMap<Integer, Comment>();

	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
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
	
	public void setLinks(List<Link> links) {
		this.links = links;
	}

	public List<Link> getLinks() {
		return links;
	}
	

}
