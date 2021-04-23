package com.trilogyed.post.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trilogyed.post.dao.PostDao;
import com.trilogyed.post.model.Post;
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
@WebMvcTest(PostController.class)
@ImportAutoConfiguration(RefreshAutoConfiguration.class)
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostDao dao;

    private ObjectMapper mapper = new ObjectMapper();


    @Before
    public void setUp() {

    }

    @Test
    public void createPost()  throws Exception {

        Post inputPost = new Post();

        inputPost.setPost("feeling FOMO!!!!!");
        inputPost.setPostDate(LocalDate.of(2021,01,03));
        inputPost.setPosterName("Chrystal");

        String inputJson = mapper.writeValueAsString(inputPost);

        Post outPost = new Post();

        outPost.setPost("feeling FOMO!!!!!");
        outPost.setPostDate(LocalDate.of(2021,01,03));
        outPost.setPosterName("Chrystal");

        String outputJson = mapper.writeValueAsString(outPost);

        when(dao.createPost(inputPost)).thenReturn(outPost);

        // ACT
        this.mockMvc.perform(post("/posts")                                // perform the POST request
                        .content(inputJson)                         // Set the request body
                        .contentType(MediaType.APPLICATION_JSON)    // Tell the server it's in JSON format
        ).andDo(print())                                     // print results to console
                .andExpect(status().isCreated())                    // ASSERT (status code is 201)
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getPost() throws Exception {

        Post outPost = new Post();

        outPost.setPost("feeling FOMO!!!!!");
        outPost.setPostDate(LocalDate.of(2021,01,03));
        outPost.setPosterName("Chrystal");
        outPost.setPostID(2);

        String outputJson = mapper.writeValueAsString(outPost);

        when(dao.getPost(2)).thenReturn(outPost);

        this.mockMvc.perform(get("/posts/2"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json(outputJson));
    }

    @Test
    public void getAllPost() {

        Post inputPost = new Post();

        inputPost.setPost("feeling FOMO!!!!!");
        inputPost.setPostDate(LocalDate.of(2021,01,03));
        inputPost.setPosterName("Chrystal");

        Post outPost = new Post();

        outPost.setPost("feeling FOMO!!!!!");
        outPost.setPostDate(LocalDate.of(2021,01,03));
        outPost.setPosterName("Chrystal");


        List<Post> postList = new ArrayList<>();
        postList.add(inputPost);
        postList.add(outPost);

        when(dao.getAllPosts()).thenReturn(postList);
        assertEquals(2, postList.size());

    }

    @Test
    public void updatePostAndReturn204StatusCode() throws Exception {
        Post inputPost = new Post();

        inputPost.setPost("feeling FOMO!!!!!");
        inputPost.setPostDate(LocalDate.of(2021,01,03));
        inputPost.setPosterName("Chrystal");
        inputPost.setPostID(2);

        String inputJson = mapper.writeValueAsString(inputPost);

        mockMvc.perform(
                put("/posts")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void deletePostAndReturn204StatusCode() throws Exception {

        this.mockMvc.perform(delete("/posts/6"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}