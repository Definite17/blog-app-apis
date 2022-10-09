package com.ashraf.blog.service;

import com.ashraf.blog.entities.Post;
import com.ashraf.blog.payloads.PostDto;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    Post updatePost(PostDto postDto);

    void deletePost(Integer postId);

    List<PostDto> getAllPost();

    Post getPostById(Integer postId);

    List<PostDto> getPostByCategory(Integer categoryId);

    List<PostDto> getPostByUser(Integer userId);

    List<PostDto> searchPost(String keyword);
}
