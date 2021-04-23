package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;

import java.util.List;

public interface PostDao {

    Post createPost(Post post);

    Post getPost(int id);

    List<Post> getAllPosts();

    void updatePosts(Post post);

    void deletePosts(int id);
}
