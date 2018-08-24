package org.rashmi.firstRESTFulApp.messenger.database;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.rashmi.firstRESTFulApp.messenger.model.Profile;

public class ProfileDao {
	public static HashMap<String, Profile> map;
	private static ProfileDao object;
	public static Integer nextId;
	
	private ProfileDao() {
		map = new HashMap<>();
		nextId = 1;
		int id = getNextId();
		updateOrInsert("rash", new Profile(id, "rash", "rahul", "sharma"));
		id = getNextId();
		updateOrInsert("nish", new Profile(id, "nish", "niraj", "sharma"));
	}
	
	public static ProfileDao getInstance() {
		if(object == null) {
			synchronized(ProfileDao.class) {
				if(object == null) {
					object = new ProfileDao();
				}
			}
		}
		return object;
	}
	
	public static Profile getProfile(String key) {
		return map.get(key);
	}
	
	public static List<Profile> getAllProfiles(){
		return new ArrayList<Profile>(map.values());
	}
	
	public static List<Profile> getAllProfiles(String str){
		ArrayList<Profile> res = new ArrayList<>();
		for(Profile profile : map.values()) {
			if(profile.getProfileName().contains(str)) {
				res.add(profile);
			}
		}
		return res;
	}
	
	public static Profile updateOrInsert(String key, Profile value) {
		Profile prev = map.get(key);
		if(prev != null) {
			Integer id = prev.getId();
			value.setId(id);
		}
		else {
			value.setId(getNextId());
		}

		value.setCreated(new Date());
		map.put(key, value);
		return map.get(key);
	}
	
	public static Integer getNextId() {
		return nextId++;
	}
	
	public static void delete(String profileName) {
		map.remove(profileName);
	}

	public List<Profile> getAllProfiles(Integer start, Integer size) {
		ArrayList<Profile> list = new ArrayList<>(map.values());
		
		if(size == 0 || start == 0 || start > list.size()) {
			return new ArrayList<Profile>();
		}
		
		if((start + size) > list.size()) {
			return list.subList(start - 1, list.size());
		}
		
		return list.subList(start - 1, (start + size) - 1);
		
	}
}
