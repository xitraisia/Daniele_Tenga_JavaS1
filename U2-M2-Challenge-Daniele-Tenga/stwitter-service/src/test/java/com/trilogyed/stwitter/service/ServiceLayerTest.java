package com.trilogyed.stwitter.service;

import com.trilogyed.stwitter.feign.CommentClient;
import com.trilogyed.stwitter.feign.PostClient;
import com.trilogyed.stwitter.model.Comment;
import com.trilogyed.stwitter.model.Post;
import com.trilogyed.stwitter.model.StwitterViewModel;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceLayerTest {

    ServiceLayer service;
    RabbitTemplate rabbitTemplate;
    CommentClient commentClient;
    PostClient postClient;

    @Before
    public void setUp() throws Exception {

        setUpFeignCommentClientMock();
        setUpFeignPostClientMock();
        setUpRabbitTemplateMock();

        service = new ServiceLayer(commentClient, postClient, rabbitTemplate);
    }
    private void setUpRabbitTemplateMock() {
        rabbitTemplate = mock(RabbitTemplate.class);
    }

    private void setUpFeignCommentClientMock() {

        commentClient = mock(CommentClient.class);

        Comment comment = new Comment();

        comment.setComment("Dogecoin to the moon!!!!");
        comment.setCommenterName("alyssa");
        comment.setCreateDate(LocalDate.of(2021,03,03));
        comment.setPostId(2);
        comment.setCommentId(2);

        Comment comment1 = new Comment();

        comment1.setComment("Bacon babie!!!");
        comment1.setCommenterName("Conor");
        comment1.setCreateDate(LocalDate.of(2021,03,03));
        comment1.setPostId(2);
        comment1.setCommentId(1);

        List<Comment> comments = new ArrayList<>();
        comments.add(comment);
        comments.add(comment1);

        doReturn(comments).when(commentClient).getAllCommentsForPosts(2);
    }

    private void setUpFeignPostClientMock() {

        postClient = mock(PostClient.class);

        Post post = new Post();

        post.setPostID(2);
        post.setPost("Dogecoin forever");
        post.setPostDate(LocalDate.of(2021,03,03));
        post.setPosterName("chrystal");

        Post post2 = new Post();

        post2.setPost("Dogecoin forever");
        post2.setPostDate(LocalDate.of(2021,03,03));
        post2.setPosterName("chrystal");

        List<Post> posts = new ArrayList<>();
        posts.add(post);

        doReturn(post).when(postClient).createPost(post2);
        doReturn(posts).when(postClient).getPostByPoster("chrystal");
        doReturn(post).when(postClient).getPost(2);
    }

    @Test
    public void shouldCreatePost() {

        StwitterViewModel post = new StwitterViewModel();

        post.setPost("aayyyoo!!!");
        post.setPostDate(LocalDate.of(2021,03,03));
        post.setPosterName("chrystal");
        post.setPostId(2);

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

        post.setComments(commentList);

        StwitterViewModel whatIExpect = new StwitterViewModel();
        whatIExpect.setPosterName("chrystal");
        whatIExpect.setPost("aayyyoo!!!");
        whatIExpect.setPostDate(LocalDate.of(2021,03,03));
        whatIExpect.setPostId(2);

        List<Comment> expectedCommentList = new ArrayList<>();

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

        expectedCommentList.add(comment1);
        expectedCommentList.add(comment3);

        whatIExpect.setComments(expectedCommentList);

        StwitterViewModel whatIGot = service.createPost(post);

        assertEquals(whatIExpect, whatIGot);
    }

    @Test
    public void shouldGetPost() {

        StwitterViewModel whatIExpect = new StwitterViewModel();

        whatIExpect.setPost("Dogecoin forever");
        whatIExpect.setPostDate(LocalDate.of(2021,03,03));
        whatIExpect.setPosterName("chrystal");
        whatIExpect.setPostId(2);

        List<Comment> expectedCommentList = new ArrayList<>();

        Comment expectedComment = new Comment();

        expectedComment.setComment("Dogecoin to the moon!!!!");
        expectedComment.setCommenterName("alyssa");
        expectedComment.setCreateDate(LocalDate.of(2021,03,03));
        expectedComment.setPostId(2);
        expectedComment.setCommentId(2);

        Comment expectedComment2 = new Comment();

        expectedComment2.setComment("Bacon babie!!!");
        expectedComment2.setCommenterName("Conor");
        expectedComment2.setCreateDate(LocalDate.of(2021,03,03));
        expectedComment2.setPostId(2);
        expectedComment2.setCommentId(1);

        expectedCommentList.add(expectedComment);
        expectedCommentList.add(expectedComment2);

        whatIExpect.setComments(expectedCommentList);

        // Act
        StwitterViewModel whatIGot = service.getPost(2);

        // Assert
        assertEquals(whatIExpect, whatIGot);

    }

    @Test
    public void shouldGetPostsByPoster() {
        StwitterViewModel whatIExpect = new StwitterViewModel();

        whatIExpect.setPost("Dogecoin forever");
        whatIExpect.setPostDate(LocalDate.of(2021,03,03));
        whatIExpect.setPosterName("chrystal");
        whatIExpect.setPostId(2);
        whatIExpect.setComments(commentClient.getAllCommentsForPosts(2));

        Comment expectedComment = new Comment();

        expectedComment.setComment("Dogecoin to the moon!!!!");
        expectedComment.setCommenterName("alyssa");
        expectedComment.setCreateDate(LocalDate.of(2021,03,03));
        expectedComment.setPostId(2);
        expectedComment.setCommentId(2);

        Comment expectedComment2 = new Comment();

        expectedComment2.setComment("Bacon babie!!!");
        expectedComment2.setCommenterName("Conor");
        expectedComment2.setCreateDate(LocalDate.of(2021,03,03));
        expectedComment2.setPostId(2);
        expectedComment2.setCommentId(1);


        whatIExpect.setComments(Arrays.asList(expectedComment, expectedComment2));

        List<StwitterViewModel> whatIExpectList = new ArrayList<>();
        whatIExpectList.add(whatIExpect);

        // Act
        List<StwitterViewModel> whatIGot = service.getPostsByPoster("chrystal");

        // Assert
        assertEquals(whatIExpectList, whatIGot);
    }

}