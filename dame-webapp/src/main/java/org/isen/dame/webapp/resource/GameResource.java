package org.isen.dame.webapp.resource;


import org.isen.dame.webapp.service.Service;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.*;

public class GameResource {

    private Service service = new Service();

    @Path("test")
    @GET
    public String doGet() {
        return service.createNewGame();
    }

    /*@PUT
    public Post doUpdate(Post updatedPost) {
        return dao.update(post.getId(), updatedPost.getUser(), updatedPost.getTitle(),
                updatedPost.getContent());
    }

    @DELETE
    public void doDelete() {
        dao.delete(post.getId());
    }

    @Path("comments")
    @POST
    public Comment createComment(Comment newComment) {
        return cdao.create(newComment.getAuthor(), newComment.getContent(), post.getId());
    }
    
    @Path("comments")
    @GET
    public List<Comment> getComments() {
        return cdao.list(post.getId());
    }*/

}
