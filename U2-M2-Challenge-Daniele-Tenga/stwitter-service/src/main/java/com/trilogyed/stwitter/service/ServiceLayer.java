package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.feign.CommentService;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ServiceLayer {

    CommentService commentService;

    @Autowired
    public ServiceLayer(CommentService commentService) {
        this.commentService = commentService;
    }

        private StwitterViewModel buildStwitterViewModel(Post post, Comment comment){

        StwitterViewModel stwitterViewModel = new StwitterViewModel();

//        stwitterViewModel.setPost(post.getPost());
//        stwitterViewModel.setPostDate(post.getPostDate());
//        stwitterViewModel.setPosterName(post.getPosterName());
//        stwitterViewModel.setPostId(post.getPostID());
//        stwitterViewModel.setCommenterName(comment.getCommenterName());
//        stwitterViewModel.setComment(comment.getComment());
//        stwitterViewModel.setCommentId(comment.getCommentId());
//        stwitterViewModel.setComments(post.getComments());
//        stwitterViewModel.setCreateDate(comment.getCreateDate());

            stwitterViewModel.setPost(post.getPost());
            stwitterViewModel.setPostDate(post.getPostDate());
            stwitterViewModel.setPosterName(post.getPosterName());
            stwitterViewModel.setPostId(post.getPostID());
            stwitterViewModel.setComment(commentService.createComment(comment.getComment()));

        return stwitterViewModel;
    }

    public StwitterViewModel createPost(StwitterViewModel stwitterViewModel){

        Post post = new Post();
        post.setPost(stwitterViewModel.getPost());
        post.setPosterName(stwitterViewModel.getPosterName());
        post.setPostDate(stwitterViewModel.getPostDate());

    }

    public StwitterViewModel getPost(StwitterViewModel stwitterViewModel){

    }
}
