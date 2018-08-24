package org.rashmi.firstRESTFulApp.messenger.service.impl;

import java.util.List;

import org.rashmi.firstRESTFulApp.messenger.database.CommentDao;
import org.rashmi.firstRESTFulApp.messenger.model.Comment;
import org.rashmi.firstRESTFulApp.messenger.model.Message;
import org.rashmi.firstRESTFulApp.messenger.service.CommentService;
import org.rashmi.firstRESTFulApp.messenger.service.CommentService;

public class CommentServiceImpl implements CommentService{
	public CommentDao daoInstance;
	private static CommentService instance = new CommentServiceImpl();
	
	public CommentServiceImpl() {
		daoInstance = CommentDao.getInstance();
	}

	public Comment addComment(Message msg, Comment comment) {
		Integer id = daoInstance.getNextId();
		comment.setId(id);
		daoInstance.insert(msg, comment);
		return daoInstance.getComment(msg.getId(), comment.getId());
	}

	@Override
	public Comment getComment(Integer mesId, Integer comID) {
		return daoInstance.getComment(mesId, comID);
	}

	@Override
	public List<Comment> getAllComments(Integer msgID) {
		return daoInstance.getAllComments(msgID);
	}

	@Override
	public Comment updateComment(Integer mesgID, Comment comment) {
		comment.setId(mesgID);
		return daoInstance.update(mesgID, comment);
	}

	@Override
	public void deleteComment(Integer id) {
		daoInstance.delete(id);
	}

	@Override
	public CommentService getInstance() {
		return instance;
	}
}
