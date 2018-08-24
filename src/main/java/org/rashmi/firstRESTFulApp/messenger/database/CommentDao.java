package org.rashmi.firstRESTFulApp.messenger.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.rashmi.firstRESTFulApp.messenger.model.Comment;
import org.rashmi.firstRESTFulApp.messenger.model.Message;

public class CommentDao {
	public static HashMap<Integer, Message> map;
	private static CommentDao object;
	public static Integer nextId;
	
	private CommentDao() {
		map = new HashMap<>();
		nextId = 1;
		/*
		int id = getNextId();
		insert(id, new Comment(id, "comment1", "comment1_aut"));
		id = getNextId();
		insert(id, new Comment(id, "comment2", "comment1_aut"));*/
	}
	
	public static CommentDao getInstance() {
		if(object == null) {
			synchronized(CommentDao.class) {
				if(object == null) {
					object = new CommentDao();
				}
			}
		}
		return object;
	}
	
	public static Comment getComment(Integer messageId, Integer commentId) {
		return map.get(messageId).getComment(commentId); 
	}
	
	public static List<Comment> getAllComments(Integer key){
		if(map.get(key)== null)
			return new ArrayList<>();
		
		ArrayList<Comment> list = (ArrayList<Comment>) map.get(key).getCommentsList();
		if(list == null) {
			list = new ArrayList<>();
		}
		return list;
	}
	
	public static Comment insert(Message msg, Comment comment) {
		msg.addComment(comment);
		map.put(msg.getId(), msg);
		return comment;
	}
	
	public static Comment update(Integer messageId, Comment comment) {
		if(map.get(messageId) != null) {
			Message msg = map.get(messageId);
			msg.addComment(comment);
			return comment;
		}
		return null;
	}
	
	public static Integer getNextId() {
		return nextId++;
	}
	
	public static void delete(Integer id) {
		map.remove(id);
	}
}
