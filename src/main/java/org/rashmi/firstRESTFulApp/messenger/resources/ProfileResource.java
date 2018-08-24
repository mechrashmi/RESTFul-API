package org.rashmi.firstRESTFulApp.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.rashmi.firstRESTFulApp.messenger.model.Profile;
import org.rashmi.firstRESTFulApp.messenger.resources.beans.ProfileQueryParam;
import org.rashmi.firstRESTFulApp.messenger.service.ProfileService;
import org.rashmi.firstRESTFulApp.messenger.service.impl.ProfileServiceImpl;

@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {
ProfileService service = new ProfileServiceImpl();
	
	@GET
	public List<Profile> getAllProfiles(@BeanParam ProfileQueryParam parambean) {
		if(parambean.getStr() != null) {
			return service.getAllProfiles(parambean.getStr());
		}
		if(parambean.getStart() != null && parambean.getSize() != null && parambean.getStart() >= 0 && parambean.getSize() >= 0) {
			return service.getAllProfiles(parambean.getStart(), parambean.getSize());
		}
		
		return service.getAllProfiles();
	}
	
	
	@POST
	public Response addProfile(Profile msg, @Context UriInfo uriInfo) {
		//return Response.status(Status.CREATED).entity(service.addProfile(msg)).build();
		Profile profile = service.addProfile(msg);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(profile.getId())).build();
		return Response.created(uri).entity(profile).build();
	}
	
	
	@GET
	@Path("/{profileName}")
	public Response getProfile(@PathParam("profileName") String profileName, @Context UriInfo uriInfo) {
		Profile profile = service.getProfile(profileName);
		if(profile == null) {
			return Response.status(Status.NOT_FOUND).build();
		}
	
		return Response.status(Status.FOUND).entity(profile).build();
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName")  String profileName,  Profile msg) {
		return service.updateProfile(profileName, msg);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName") String profileName) {
	  service.deleteProfile(profileName);
	}
	
}
