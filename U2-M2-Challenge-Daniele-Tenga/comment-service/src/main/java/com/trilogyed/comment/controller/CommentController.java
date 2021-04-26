package com.trilogyed.comment.controller;

import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RefreshScope
public class CommentController {

    private CommentDao dao;

    @Autowired
    public CommentController(CommentDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "/comments", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Comment createComment(@RequestBody Comment comment){
        return dao.createComment(comment);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public Comment getComment( @PathVariable int id){
        return dao.getComment(id);
    }

    @RequestMapping(value = "/comment", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllComments(){
        return dao.getAllComments();
    }

    @RequestMapping(value = "/comment/comment/{postId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Comment> getAllCommentsForPosts(@PathVariable int postId){
        return dao.getAllComments();
    }

    @RequestMapping(value = "/comment", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateNotes(@Valid @RequestBody Comment comment){
        dao.updateComments(comment);
    }

    @RequestMapping(value = "/comment/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteComment(@PathVariable int id){
        dao.deleteComment(id);
    }
}
