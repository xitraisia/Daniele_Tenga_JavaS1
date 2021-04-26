package com.trilogyed.stwitter.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.stwitter.feign.CommentClient;
import com.trilogyed.stwitter.feign.PostClient;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.StwitterViewModel;
import com.trilogyed.stwitter.service.ServiceLayer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(StwitterController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class StwitterControllerTest {

    @MockBean
    private ServiceLayer service;

    @MockBean
    RabbitTemplate rabbitTemplate;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();

    private CommentClient commentClient;

    @Before
    public void setUp() {
    }

    private void setUpRabbitTemplateMock() {
        rabbitTemplate = mock(RabbitTemplate.class);
    }

    public void clearDatabase() {
        List<StwitterViewModel> post = service.getAllPost();
        for (StwitterViewModel it : post) {
            service.deletePost(it.getPostId());
        }
    }

    @Test
    public void createPost() throws Exception{

        StwitterViewModel inputPost = new StwitterViewModel();

        inputPost.setPost("to the moon!!!");
        inputPost.setPosterName("emily");
        inputPost.setPostDate(LocalDate.of(2021,03,03));

        Comment comment = new Comment();

        comment.setComment("Dogecoin to the moon!!!!");
        comment.setCommenterName("alyssa");
        comment.setCreateDate(LocalDate.of(2021,03,03));
        comment.setPostId(2);
        comment.setCommentId(2);

        Comment comment2 = new Comment();

        comment2.setComment("Bacon babie!!!");
        comment2.setCommenterName("Conor");
        comment2.setCreateDate(LocalDate.of(2021,03,03));
        comment2.setPostId(2);
        comment2.setCommentId(1);

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        commentList.add(comment2);

        inputPost.setComments(commentList);

        //Object to JSON in String
        String inputJson = mapper.writeValueAsString(inputPost);

        StwitterViewModel outputPost = new StwitterViewModel();

        outputPost.setPost("to the moon!!!");
        outputPost.setPosterName("emily");
        outputPost.setPostDate(LocalDate.of(2021,03,03));

        Comment comment1 = new Comment();

        comment1.setComment("Dogecoin to the moon!!!!");
        comment1.setCommenterName("alyssa");
        comment1.setCreateDate(LocalDate.of(2021,03,03));
        comment1.setPostId(2);
        comment1.setCommentId(2);

        Comment comment3 = new Comment();

        comment3.setComment("Bacon babie!!!");
        comment3.setCommenterName("Conor");
        comment3.setCreateDate(LocalDate.of(2021,03,03));
        comment3.setPostId(2);
        comment3.setCommentId(1);

        List<Comment> commentList2 = new ArrayList<>();
        commentList2.add(comment1);
        commentList2.add(comment3);

        outputPost.setComments(commentList2);

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(outputPost);

        when(service.createPost(inputPost)).thenReturn(outputPost);

        this.mockMvc.perform(post("/posts")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getPost() throws Exception{

        StwitterViewModel inputPost = new StwitterViewModel();

        inputPost.setPost("to the moon!!!");
        inputPost.setPosterName("emily");
        inputPost.setPostDate(LocalDate.of(2021,03,03));

        Comment comment = new Comment();

        comment.setComment("Dogecoin to the moon!!!!");
        comment.setCommenterName("alyssa");
        comment.setCreateDate(LocalDate.of(2021,03,03));
        comment.setPostId(2);
        comment.setCommentId(2);

        Comment comment2 = new Comment();

        comment2.setComment("Bacon babie!!!");
        comment2.setCommenterName("Conor");
        comment2.setCreateDate(LocalDate.of(2021,03,03));
        comment2.setPostId(2);
        comment2.setCommentId(1);

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        commentList.add(comment2);

        inputPost.setComments(commentList);

        String outputJson = mapper.writeValueAsString(inputPost);

        when(service.getPost(2)).thenReturn(inputPost);

        this.mockMvc.perform(get("/post/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getPostsByPoster() throws Exception{

        StwitterViewModel inputPost = new StwitterViewModel();

        inputPost.setPost("to the moon!!!");
        inputPost.setPosterName("emily");
        inputPost.setPostDate(LocalDate.of(2021,03,03));

        Comment comment = new Comment();

        comment.setComment("Dogecoin to the moon!!!!");
        comment.setCommenterName("alyssa");
        comment.setCreateDate(LocalDate.of(2021,03,03));
        comment.setPostId(2);
        comment.setCommentId(2);

        Comment comment2 = new Comment();

        comment2.setComment("Bacon babie!!!");
        comment2.setCommenterName("Conor");
        comment2.setCreateDate(LocalDate.of(2021,03,03));
        comment2.setPostId(2);
        comment2.setCommentId(1);

        List<Comment> commentList = new ArrayList<>();
        commentList.add(comment);
        commentList.add(comment2);

        inputPost.setComments(commentList);

        StwitterViewModel outputPost = new StwitterViewModel();

        outputPost.setPost("to the moon!!!");
        outputPost.setPosterName("emily");
        outputPost.setPostDate(LocalDate.of(2021,03,03));

        Comment comment1 = new Comment();

        comment1.setComment("Dogecoin to the moon!!!!");
        comment1.setCommenterName("alyssa");
        comment1.setCreateDate(LocalDate.of(2021,03,03));
        comment1.setPostId(2);
        comment1.setCommentId(2);

        Comment comment3 = new Comment();

        comment3.setComment("Bacon babie!!!");
        comment3.setCommenterName("Conor");
        comment3.setCreateDate(LocalDate.of(2021,03,03));
        comment3.setPostId(2);
        comment3.setCommentId(1);

        List<Comment> commentList2 = new ArrayList<>();
        commentList2.add(comment1);
        commentList2.add(comment3);

        outputPost.setComments(commentList2);


        List<StwitterViewModel> stwitterViewModelList = new ArrayList<>();
        stwitterViewModelList.add(inputPost);
        stwitterViewModelList.add(outputPost);

        String outputJson = mapper.writeValueAsString(stwitterViewModelList);

        when(service.getPostsByPoster(inputPost.getPosterName())).thenReturn(stwitterViewModelList);

        this.mockMvc.perform(get("/posts/user/emily"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }
}