package org.rashmi.firstRESTFulApp.messenger.resources;

import java.net.URI;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.eclipse.persistence.tools.profiler.Profile;
import org.rashmi.firstRESTFulApp.messenger.model.Link;
import org.rashmi.firstRESTFulApp.messenger.model.Message;
import org.rashmi.firstRESTFulApp.messenger.service.MessageService;
import org.rashmi.firstRESTFulApp.messenger.service.impl.MessageServiceImpl;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	MessageService service = MessageServiceImpl.getInstance();
	
	@GET
	public List<Message> getAllMessages() {
		return service.getAllMessages();
	}
	
	
	@POST
	public Message addMessage(Message msg) {
		return service.addMessage(msg);
	}
	
	private String getURIForSelf(UriInfo uriInfo, Integer msgId) {
		URI uri = uriInfo.getAbsolutePathBuilder().build();
		return uri.toString();
	}
	
	
	private String getURIForProfile(UriInfo uriInfo, String profileName) {
		URI uri = uriInfo.getBaseUriBuilder().path(ProfileResource.class).path(profileName).build();
		return uri.toString();
	}
	
	private String getURIForComment(UriInfo uriInfo, String msgId) {
		URI uri = uriInfo.getBaseUriBuilder().path(MessageResource.class).path(MessageResource.class,"getCommentResource").
				resolveTemplate("messageID", msgId).build();
		return uri.toString();
	}	
	
	@Path("/{messageID}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
	
	
	@GET
	@Path("/{messageID}")
	public Message getMessage(@PathParam("messageID") Integer messageId,  @Context UriInfo context) {
		Message msg = service.getMessage(messageId);
		Link selfLink = new Link();
		selfLink.setLink(getURIForSelf(context, messageId));
		selfLink.setRel("self");
		
		Link pfylLink = new Link();
		pfylLink.setLink(getURIForProfile(context, msg.getAuthor()));
		pfylLink.setRel("profile");
		
		Link cmntLink = new Link();
		cmntLink.setLink(getURIForComment(context, msg.getId() + ""));
		cmntLink.setRel("comment");
		
		msg.addLink(selfLink);
		msg.addLink(pfylLink);
		msg.addLink(cmntLink);
		return msg;
	}
	
	@PUT
	@Path("/{messageID}")
	public Message updateMessage(@PathParam("messageID") Integer messageId,  Message msg) {
		return service.updateMessage(messageId, msg);
	}
	
	@DELETE
	@Path("/{messageID}")
	public void deleteMessage(@PathParam("messageID") Integer id) {
	  service.deleteMessage(id);
	}

}
