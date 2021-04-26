package com.trilogyed.stwitter.feign;
import com.trilogyed.stwitter.model.Post;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "post-service")
public interface PostClient {

    @RequestMapping(value = "/posts", method = RequestMethod.POST)
    public Post createPost(@Valid @RequestBody Post post);

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
    public Post getPost(@PathVariable int id);

    @RequestMapping(value = "/posts/poster/{poster}", method = RequestMethod.GET)
    public List<Post> getPostByPoster(@PathVariable String poster);

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public List<Post> getAllPost();

    @RequestMapping(value = "/posts", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePost(@Valid  @RequestBody Post post);

    @RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePost(@PathVariable int id);
}
