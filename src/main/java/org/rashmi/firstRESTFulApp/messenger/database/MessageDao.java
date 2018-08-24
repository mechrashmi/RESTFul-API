package org.rashmi.firstRESTFulApp.messenger.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.rashmi.firstRESTFulApp.messenger.model.Message;

public class MessageDao {
	public static HashMap<Integer, Message> map;
	private static MessageDao object;
	public static Integer nextId;
	
	private MessageDao() {
		map = new HashMap<>();
		nextId = 1;
		int id = getNextId();
		updateOrInsert(id, new Message(id, "hello world", "me"));
		id = getNextId();
		updateOrInsert(id, new Message(id, "hello pagal", "me1"));
	}
	
	public static MessageDao getInstance() {
		if(object == null) {
			synchronized(MessageDao.class) {
				if(object == null) {
					object = new MessageDao();
				}
			}
		}
		return object;
	}
	
	public static Message getMessage(Integer key) {
		return map.get(key);
	}
	
	public static List<Message> getAllMessages(){
		return new ArrayList<Message>(map.values());
	}
	
	public static Message updateOrInsert(Integer key, Message value) {
		map.put(key, value);
		return map.get(key);
	}
	
	public static Integer getNextId() {
		return nextId++;
	}
	
	public static void delete(Integer id) {
		map.remove(id);
	}

}
