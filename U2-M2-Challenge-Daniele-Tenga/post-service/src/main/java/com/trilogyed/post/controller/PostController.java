package com.trilogyed.post.controller;

import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.exception.NotFoundException;
import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class PostController {

    private PostDao dao;

    @Autowired
    public PostController(PostDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Post createPost(@Valid @RequestBody Post post) {
                return dao.createPost(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Post getPost(@PathVariable int id) {
        Post post = dao.getPost(id);
        if (post == null)
            throw new NotFoundException("Post could not be retrieved for id " + id);
        return post;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Post> getAllPost() {
       return dao.getAllPosts();
    }

    @RequestMapping(value = "/posts/poster/{poster}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Post> getPostByPoster(@PathVariable String poster) {
        return dao.getAllPosts();
    }

    @RequestMapping(value = "/posts", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@Valid  @RequestBody Post post) {
        dao.updatePosts(post);
    }

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id) {
        dao.deletePosts(id);
    }
}
