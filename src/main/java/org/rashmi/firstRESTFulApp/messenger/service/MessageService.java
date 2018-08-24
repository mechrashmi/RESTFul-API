package org.rashmi.firstRESTFulApp.messenger.service;

import java.util.List;

import org.rashmi.firstRESTFulApp.messenger.model.Message;

public interface MessageService {
	public Message addMessage(Message msg);
	
	public Message getMessage(Integer id);
	
	public List<Message> getAllMessages();
	
	public Message updateMessage(Integer id, Message msg);
	
	public void deleteMessage(Integer id);

}
