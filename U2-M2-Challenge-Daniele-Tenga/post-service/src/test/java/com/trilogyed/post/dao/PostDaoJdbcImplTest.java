package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PostDaoJdbcImplTest {
    @Autowired
    PostDao dao;

    private Post post;

    @Before
    public void setUp() throws Exception {
        clearDatabase();
        setUpTestObjects();
    }
    public void clearDatabase() {
        List<Post> posts = dao.getAllPosts();
        for (Post it : posts) {
            dao.deletePosts(it.getPostID());
        }
    }

    public void setUpTestObjects() {
        post = new Post();

        post.setPost("it's a lituation!!!!!");
        post.setPostDate(LocalDate.of(2021,01,03));
        post.setPosterName("Jasmine");

        post = dao.createPost(post);

    }


    @Test
    public void shouldCreateAndGetPost() {
        post = dao.createPost(post);

        Post post1 = dao.getPost(post.getPostID());
        assertEquals(post1,post);
    }

    @Test
    public void getAllPosts() {

        post = new Post();

        post.setPost("feeling FOMO!!!!!");
        post.setPostDate(LocalDate.of(2021,01,03));
        post.setPosterName("Chrystal");
        post = dao.createPost(post);

        Post post1 = new Post();

        post1.setPost("Galivanting..... ");
        post1.setPostDate(LocalDate.of(2021,01,03));
        post1.setPosterName("Chrystal");
        post1 = dao.createPost(post);


        List<Post> pList = dao.getAllPosts();
        assertEquals(3, pList.size());
    }

    @Test
    public void updatePosts() {

        Post post = new Post();

        post.setPost("feeling FOMO!!!!!");
        post.setPostDate(LocalDate.of(2021,01,03));
        post.setPosterName("Chrystal");
        post = dao.createPost(post);

        post.setPost("Sike");
        dao.updatePosts(post);

        Post post1 = dao.getPost(post.getPostID());
        assertEquals(post1,post);
    }

    @Test
    public void deletePosts() {

        Post post = new Post();

        post.setPost("feeling FOMO!!!!!");
        post.setPostDate(LocalDate.of(2021,01,03));
        post.setPosterName("Chrystal");
        post = dao.createPost(post);

        dao.deletePosts(post.getPostID());
        Post post2 = dao.getPost(post.getPostID());
        assertNull(post2);
    }
}