package com.trilogyed.stwitter.controller;

import com.trilogyed.stwitter.exception.NotFoundException;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.model.StwitterViewModel;
import com.trilogyed.stwitter.service.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StwitterController {

    @Autowired
    private ServiceLayer service;

    public StwitterController(ServiceLayer service) {
        this.service = service;
    }

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public StwitterViewModel createPost(@Valid @RequestBody StwitterViewModel post){
        return service.createPost(post);
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public StwitterViewModel getPost(@PathVariable int id){
        StwitterViewModel post = service.getPost(id);
        if (post == null)
            throw new NotFoundException("Post could not be retrieved by id " + id);
        return post;
    }

    @RequestMapping(value = "/posts/user/{poster_name}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<StwitterViewModel> getPostsByPoster(@PathVariable("poster_name") String poster) {
        List<StwitterViewModel> post = service.getPostsByPoster(poster);
        if (post != null && post.size() == 0)
            throw new NotFoundException("Post could not be retrieved by poster " + poster);
        return post;
    }
}
