package org.isen.dame.webapp.service;

import org.isen.dame.webapp.dao.CommentDAO;
import org.isen.dame.webapp.dao.PostDAO;
import org.isen.dame.webapp.model.Post;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;


@Path("post")
@Produces({"application/json","text/xml"})
public class PostService {

    @Inject
    private PostDAO dao;

    @Inject
    private CommentDAO gdao;


    @POST
    public Post create(Post post) {
        return dao.create(post.getTitle(), post.getContent(), post.getUser());
    }

    @GET
    public List<Post> list(@QueryParam("first") @DefaultValue("0") int first,
                           @QueryParam("max") @DefaultValue("20") int max) {
        return dao.list(first, max);
    }

    @Path("{id}")
    public Object show(@PathParam("id") long id) {
        return new PostResource();
    }


}
