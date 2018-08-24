package org.rashmi.firstRESTFulApp.messenger.service;

import java.util.List;

import org.rashmi.firstRESTFulApp.messenger.model.Profile;

public interface ProfileService {
public Profile addProfile(Profile msg);
	
	public Profile getProfile(String profileName);
	
	public List<Profile> getAllProfiles();
	
	public List<Profile> getAllProfiles(String str);
	
	public Profile updateProfile(String profileName, Profile msg);
	
	public void deleteProfile(String profileName);
	
	public ProfileService getInstance();

	public List<Profile> getAllProfiles(Integer start, Integer size);
	
}
