package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CommentDaoJdbcImpl implements CommentDao{

    private JdbcTemplate jdbcTemplate;

    //prepared Statements
    private static final String INSERT_COMMENT_SQL =
            "insert into comment (post_id, create_date, commenter_name, comment) values ( ?, ?, ?, ?)";
    private static final String SELECT_COMMENT_SQL =
            "select * from comment where comment_id = ?";
    private static final String SELECT_ALL_COMMENT_SQL =
            "select * from comment";
    private static final String UPDATE_COMMENT_SQL =
            "update comment set post_id = ?, create_date = ?, commenter_name = ?, comment = ? where comment_id = ?";
    private static final String DELETE_COMMENT_SQL =
            "delete from comment where comment_id =?";




    @Autowired
    public CommentDaoJdbcImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Comment createComment(Comment comment) {

        jdbcTemplate.update(
                INSERT_COMMENT_SQL,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment());


        int id = jdbcTemplate.queryForObject("select LAST_INSERT_ID()", Integer.class);

        comment.setCommentId(id);

        return comment;
    }

    @Override
    public Comment getComment(int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_COMMENT_SQL, this::mapRowToComment, id);
        } catch (EmptyResultDataAccessException e) {
            // if there is no match for this album id, return null
            return null;
        }
    }

    @Override
    public List<Comment> getAllComments() {

        return jdbcTemplate.query(SELECT_ALL_COMMENT_SQL, this::mapRowToComment);
    }

    @Override
    public void updateComments(Comment comment) {

        jdbcTemplate.update(
                UPDATE_COMMENT_SQL,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment(),
                comment.getCommentId());
    }

    @Override
    public void deleteComment(int id) {
        jdbcTemplate.update(DELETE_COMMENT_SQL, id);
    }
    private Comment mapRowToComment(ResultSet rs, int rowNum) throws SQLException {

        Comment comment = new Comment();

        comment.setCommentId(rs.getInt("comment_id"));
        comment.setCreateDate(rs.getDate("create_date").toLocalDate());
        comment.setCommenterName(rs.getString("commenter_name"));
        comment.setPostId(rs.getInt("post_id"));
        comment.setComment(rs.getString("comment"));

        return comment;
    }
}
