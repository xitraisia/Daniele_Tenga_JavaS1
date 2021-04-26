package com.trilogyed.stwitter.feign;

import com.trilogyed.stwitter.model.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@FeignClient(name = "comment-service")
public interface CommentClient {

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    public Comment createComment(@RequestBody Comment comment);

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    public Comment getComment( @PathVariable int id);

    @RequestMapping(value = "/comment/comment/{postId}", method = RequestMethod.GET)
    public List<Comment> getAllCommentsForPosts(@PathVariable int postId);

    @RequestMapping(value = "/comment", method = RequestMethod.PUT)
    public void updateNotes(@Valid @RequestBody Comment comment);

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    public void deleteComment(@PathVariable int id);
}