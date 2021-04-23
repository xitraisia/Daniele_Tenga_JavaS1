package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
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
public class CommentDaoJdbcImplTest {

    @Autowired
    CommentDao dao;

    private Comment comment;

    @Before
    public void setUp() throws Exception {
        clearDatabase();
        setUpTestObjects();
    }
    public void clearDatabase() {
        List<Comment> comments = dao.getAllComments();
        for (Comment it : comments) {
            dao.deleteComment(it.getCommentId());
        }
    }

    public void setUpTestObjects() {
        comment = new Comment();

        comment.setComment("it's a lituation!!!!!");
        comment.setCreateDate(LocalDate.of(2021,01,03));
        comment.setCommenterName("Jasmine");
        comment.setPostId(1);

        comment = dao.createComment(comment);

    }

    @Test
    public void createComment() {

        comment = dao.createComment(comment);

        Comment comment1 = dao.getComment(comment.getCommentId());
        assertEquals(comment1,comment);
    }

    @Test
    public void getAllComments() {

        comment = new Comment();

        comment.setComment("it's a lituation!!!!!");
        comment.setCreateDate(LocalDate.of(2021,01,03));
        comment.setCommenterName("Jasmine");
        comment.setPostId(1);
        comment = dao.createComment(comment);

        Comment comment1 = new Comment();

        comment1.setComment("it's a lituation!!!!!");
        comment1.setCreateDate(LocalDate.of(2021,01,03));
        comment1.setCommenterName("Jasmine");
        comment1.setPostId(1);
        comment1 = dao.createComment(comment);


        List<Comment> cList = dao.getAllComments();
        assertEquals(3, cList.size());
    }

    @Test
    public void updateComments() {

        Comment comment = new Comment();

        comment.setComment("it's a lituation!!!!!");
        comment.setCreateDate(LocalDate.of(2021,01,03));
        comment.setCommenterName("Jasmine");
        comment.setPostId(1);
        comment = dao.createComment(comment);

        comment.setComment("Sike");
        dao.updateComments(comment);

        Comment comment1 = dao.getComment(comment.getCommentId());
        assertEquals(comment1,comment);
    }

    @Test
    public void deleteComment() {

        Comment comment = new Comment();

        comment.setComment("it's a lituation!!!!!");
        comment.setCreateDate(LocalDate.of(2021,01,03));
        comment.setCommenterName("Jasmine");
        comment.setPostId(1);
        comment = dao.createComment(comment);

        dao.deleteComment(comment.getCommentId());
        Comment comment2 = dao.getComment(comment.getCommentId());
        assertNull(comment2);
    }

}