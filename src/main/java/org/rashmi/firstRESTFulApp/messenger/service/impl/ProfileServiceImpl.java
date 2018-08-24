package org.rashmi.firstRESTFulApp.messenger.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.rashmi.firstRESTFulApp.messenger.database.ProfileDao;
import org.rashmi.firstRESTFulApp.messenger.exceptions.DataNotFoundException;
import org.rashmi.firstRESTFulApp.messenger.model.Profile;
import org.rashmi.firstRESTFulApp.messenger.model.Profile;
import org.rashmi.firstRESTFulApp.messenger.service.ProfileService;
import org.rashmi.firstRESTFulApp.messenger.service.ProfileService;

public class ProfileServiceImpl implements ProfileService {

	public ProfileDao daoInstance;
	private static ProfileService instance = new ProfileServiceImpl();
	
	public ProfileServiceImpl() {
		daoInstance = ProfileDao.getInstance();
	}

	@Override
	public Profile addProfile(Profile msg) {
		Integer id = daoInstance.getNextId();
		msg.setId(id);
		msg.setCreated(new Date());
		daoInstance.updateOrInsert(msg.getProfileName(), msg);
		return daoInstance.getProfile(msg.getProfileName());
	}

	@Override
	public Profile getProfile(String profileName) {
		Profile profile = daoInstance.getProfile(profileName);
		if(profile == null) {
			throw new DataNotFoundException(profileName + " not found!!");
		}
		
		return profile;
	}

	@Override
	public List<Profile> getAllProfiles() {
		return daoInstance.getAllProfiles();
	}
	
	@Override
	public List<Profile> getAllProfiles(String str){
		return daoInstance.getAllProfiles(str);
	}

	@Override
	public Profile updateProfile(String profileName, Profile msg) {
		return daoInstance.updateOrInsert(profileName, msg);
	}

	@Override
	public void deleteProfile(String profileName) {
		daoInstance.delete(profileName);
	}

	@Override
	public ProfileService getInstance() {
		return instance;
	}

	@Override
	public List<Profile> getAllProfiles(Integer start, Integer size) {
		return daoInstance.getAllProfiles(start, size);
	}

}
