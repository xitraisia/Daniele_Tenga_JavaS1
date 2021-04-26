package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.feign.CommentClient;
import com.trilogyed.stwitter.feign.PostClient;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.model.StwitterViewModel;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceLayer {
    public static final String EXCHANGE = "comment-exchange";
    public static final String ROUTING_KEY_PREFIX = "comment.create.stwitter.controller";

    @Autowired
    private CommentClient commentService;
    @Autowired
    private PostClient postClient;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public ServiceLayer(CommentClient commentService, PostClient postClient, RabbitTemplate rabbitTemplate) {
        this.commentService = commentService;
        this.postClient = postClient;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Transactional
    public StwitterViewModel createPost(StwitterViewModel stwitterViewModel){

        Post post = new Post();
        post.setPost(stwitterViewModel.getPost());
        post.setPosterName(stwitterViewModel.getPosterName());
        post.setPostDate(stwitterViewModel.getPostDate());
        post.setPostID(stwitterViewModel.getPostId());
        postClient.createPost(post);
        addComments(stwitterViewModel.getComments(), post.getPostID());

        return stwitterViewModel;

    }
    private void addComments(List<Comment> comments, final int postId) {
        comments.stream().forEach(
                comment -> {
                    Comment comment1 = new Comment();
                    comment1.setComment(comment.getComment());
                    comment1.setCommenterName(comment.getCommenterName());
                    comment1.setCreateDate(comment.getCreateDate());
                    comment1.setPostId(comment.getPostId());
                    System.out.println("Sending message...");
                    rabbitTemplate.convertAndSend(EXCHANGE, ROUTING_KEY_PREFIX, comment1);
                    System.out.println("Message Sent");
                }
        );
    }


    public StwitterViewModel getPost(int id){

        Post post = postClient.getPost(id);
        StwitterViewModel stvm = new StwitterViewModel();
        stvm.setPost(post.getPost());
        stvm.setPosterName(post.getPosterName());
        stvm.setPostId(post.getPostID());
        stvm.setPostDate(post.getPostDate());
        stvm.setComments(commentService.getAllCommentsForPosts(post.getPostID()));

        return stvm;
    }

    public List<StwitterViewModel> getAllPost(){

        List<Post> pList = postClient.getAllPost();
        List<StwitterViewModel> stwitterViewModelList = new ArrayList<>();

        for (Post post : pList) {
            StwitterViewModel stvm = buildStwitterViewModel(post);
            stwitterViewModelList.add(stvm);
        }

        return stwitterViewModelList;
    }

    public List<StwitterViewModel> getPostsByPoster(String poster){

        List<Post> pList = postClient.getPostByPoster(poster);
        List<StwitterViewModel> stwitterViewModelList = new ArrayList<>();

        for (Post post : pList) {
            StwitterViewModel stvm = buildStwitterViewModel(post);
            stwitterViewModelList.add(stvm);
        }

        return stwitterViewModelList;
    }

    public void deletePost(int id){
        postClient.deletePost(id);
    }

    private StwitterViewModel buildStwitterViewModel(Post post){

        StwitterViewModel stwitterViewModel = new StwitterViewModel();
        stwitterViewModel.setPost(post.getPost());
        stwitterViewModel.setPostDate(post.getPostDate());
        stwitterViewModel.setPosterName(post.getPosterName());
        stwitterViewModel.setPostId(post.getPostID());
        stwitterViewModel.setComments(commentService.getAllCommentsForPosts(post.getPostID()));

        return stwitterViewModel;
    }
}
