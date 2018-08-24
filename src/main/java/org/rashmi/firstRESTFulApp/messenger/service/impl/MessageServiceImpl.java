package org.rashmi.firstRESTFulApp.messenger.service.impl;

import java.util.List;

import org.rashmi.firstRESTFulApp.messenger.database.MessageDao;
import org.rashmi.firstRESTFulApp.messenger.model.Message;
import org.rashmi.firstRESTFulApp.messenger.service.MessageService;

public class MessageServiceImpl  implements MessageService{
	public MessageDao daoInstance;
	private static MessageService instance = new MessageServiceImpl();
	
	public MessageServiceImpl() {
		daoInstance = MessageDao.getInstance();
	}

	@Override
	public Message addMessage(Message msg) {
		Integer id = daoInstance.getNextId();
		msg.setId(id);
		daoInstance.updateOrInsert(id, msg);
		return daoInstance.getMessage(id);
	}

	@Override
	public Message getMessage(Integer id) {
		return daoInstance.getMessage(id);
	}

	@Override
	public List<Message> getAllMessages() {
		return daoInstance.getAllMessages();
	}

	@Override
	public Message updateMessage(Integer id, Message msg) {
		msg.setId(id);
		return daoInstance.updateOrInsert(id, msg);
	}

	@Override
	public void deleteMessage(Integer id) {
		daoInstance.delete(id);
	}
	
	public static MessageService getInstance() {
		return instance;
	}

}
