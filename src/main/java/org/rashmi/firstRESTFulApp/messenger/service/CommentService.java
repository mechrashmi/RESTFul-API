package org.rashmi.firstRESTFulApp.messenger.service;

import java.util.List;

import org.rashmi.firstRESTFulApp.messenger.model.Comment;
import org.rashmi.firstRESTFulApp.messenger.model.Message;

public interface CommentService {
	
	public Comment updateComment(Integer id, Comment msg);
	
	public void deleteComment(Integer id);
	
	public CommentService getInstance();

	Comment addComment(Message msg, Comment comment);

	List<Comment> getAllComments(Integer msgID);

	Comment getComment(Integer mesId, Integer comID);
	
	
}
