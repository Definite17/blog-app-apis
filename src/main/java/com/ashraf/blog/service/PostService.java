package com.ashraf.blog.service;

import com.ashraf.blog.entities.Post;
import com.ashraf.blog.payloads.PostDto;

import java.util.List;

public interface PostService {

    Post createPost(PostDto postDto, Integer userId, Integer categoryId);

    Post updatePost(PostDto postDto);

    void deletePost(Integer postId);

    List<Post> getAllPost();

    Post getPostById(Integer postId);

    List<Post> getPostByCategory(Integer categoryId);

    List<Post> getPostByUser(Integer userId);

    List<Post> searchPost(String keyword);
}
