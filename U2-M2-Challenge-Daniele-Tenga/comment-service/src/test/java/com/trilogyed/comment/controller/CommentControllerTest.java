package com.trilogyed.comment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.comment.dao.CommentDao;
import com.trilogyed.comment.model.Comment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CommentController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class CommentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CommentDao dao;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {

    }

    public void clearDatabase() {
        List<Comment> comments = dao.getAllComments();
        for (Comment it : comments) {
            dao.deleteComment(it.getCommentId());
        }
    }

    @Test
    public void createComment() throws Exception {

        Comment inputComment = new Comment();

        inputComment.setComment("DogeCoin to the Moon!!!");
        inputComment.setCommenterName("alyssa");
        inputComment.setPostId(3);
        inputComment.setCreateDate(LocalDate.of(2021,02,10));

        //Object to JSON in String
        String inputJson = mapper.writeValueAsString(inputComment);

        Comment outputComment = new Comment();

        outputComment.setComment("DogeCoin to the Moon!!!");
        outputComment.setCommenterName("alyssa");
        outputComment.setPostId(3);
        outputComment.setCreateDate(LocalDate.of(2021,02,10));

        //Object to JSON in String
        String outputJson = mapper.writeValueAsString(outputComment);

        when(dao.createComment(inputComment)).thenReturn(outputComment);

        this.mockMvc.perform(post("/comments")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON)
        ).andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getComment() throws Exception{

        Comment outputComment = new Comment();

        outputComment.setComment("DogeCoin to the Moon!!!");
        outputComment.setCommenterName("alyssa");
        outputComment.setPostId(3);
        outputComment.setCreateDate(LocalDate.of(2021,02,10));
        outputComment.setCommentId(3);

        String outputJson = mapper.writeValueAsString(outputComment);

        when(dao.getComment(3)).thenReturn(outputComment);

        this.mockMvc.perform(get("/comment/3"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllComments() {

        Comment inputComment = new Comment();

        inputComment.setComment("DogeCoin to the Moon!!!");
        inputComment.setCommenterName("alyssa");
        inputComment.setPostId(3);
        inputComment.setCreateDate(LocalDate.of(2021,02,10));

        Comment outputComment = new Comment();

        outputComment.setComment("DogeCoin to the Moon!!!");
        outputComment.setCommenterName("alyssa");
        outputComment.setPostId(3);
        outputComment.setCreateDate(LocalDate.of(2021,02,10));


        List<Comment> commentList = new ArrayList<>();
        commentList.add(inputComment);
        commentList.add(outputComment);

        when(dao.getAllComments()).thenReturn(commentList);
        assertEquals(2, commentList.size());
    }

    @Test
    public void updateNotes() throws Exception{

        Comment inputComment = new Comment();

        inputComment.setComment("DogeCoin to the Moon!!!");
        inputComment.setCommenterName("alyssa");
        inputComment.setPostId(3);
        inputComment.setCreateDate(LocalDate.of(2021,02,10));

        String inputJson = mapper.writeValueAsString(inputComment);

        mockMvc.perform(
                put("/comment")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deleteCommentAndReturn204StatusCode() throws Exception {

        this.mockMvc.perform(delete("/comment/3"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}