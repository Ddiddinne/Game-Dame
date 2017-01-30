package org.isen.dame.webapp.resource;


import org.isen.dame.core.Chip;
import org.isen.dame.core.Game;
import org.isen.dame.webapp.service.Service;

import javax.inject.Inject;
import javax.inject.Provider;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Produces(MediaType.APPLICATION_JSON)
public class GameResource {

    private Service service = new Service();

    @Path("game")
    @POST
    @Produces("application/json")
    public Game createGame() {
        return service.createNewGame();
    }

    @Path("getChips/{token}")
    @GET
    @Produces("application/json")
    public List<Chip> getChips(@PathParam("token") String token) {
        return service.getChips(token);
    }

    @Path("play/{token}")
    @GET
    public List<Chip> play(@PathParam("token") String token, @QueryParam("caseinit") String caseinit, @QueryParam("casefinal") String casefinal){
        return service.play(token, caseinit, casefinal);
    }


    @Path("testGame")
    @GET
    @Produces("application/json")
    public List<Game> testGame() {
        return service.testGame();
    }

    @Path("testChip")
    @GET
    @Produces("application/json")
    public List<Chip> testChip() {
        return service.testChip();
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
