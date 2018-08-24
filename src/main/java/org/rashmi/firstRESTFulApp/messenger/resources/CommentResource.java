package org.rashmi.firstRESTFulApp.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rashmi.firstRESTFulApp.messenger.model.Comment;
import org.rashmi.firstRESTFulApp.messenger.model.Message;
import org.rashmi.firstRESTFulApp.messenger.service.CommentService;
import org.rashmi.firstRESTFulApp.messenger.service.impl.CommentServiceImpl;
import org.rashmi.firstRESTFulApp.messenger.service.impl.MessageServiceImpl;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CommentResource {
CommentService service = new CommentServiceImpl();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageID") Integer msgID) {
		return service.getAllComments(msgID);
	}
	
	@POST
	public Comment addComment(@PathParam("messageID") Integer messageID, Comment comment) {
		Message message = MessageServiceImpl.getInstance().getMessage(messageID);
		return service.addComment(message, comment);
	}
	

	@GET
	@Path("/{commentID}")
	public Comment getComment(@PathParam("messageID") Integer msgID, @PathParam("commentID") Integer commentId) {
		return service.getComment(msgID, commentId);
	}
	
	@PUT
	@Path("/{commentID}")
	public Comment updateComment(@PathParam("commentID") Integer CommentId,  Comment msg) {
		return service.updateComment(CommentId, msg);
	}
	
	@DELETE
	@Path("/{id}")
	public void deleteComment(@PathParam("id") Integer id) {
	  service.deleteComment(id);
	}
}
