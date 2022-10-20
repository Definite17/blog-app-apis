package com.ashraf.blog.service;

import com.ashraf.blog.entities.Post;
import com.ashraf.blog.payloads.PostDto;
import com.ashraf.blog.payloads.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    Post updatePost(PostDto postDto);

    void deletePost(Integer postId);

    PostResponse getAllPost(Integer pageNumber, Integer pageSize);

    PostDto getPostById(Integer postId);

    List<PostDto> getPostByCategory(Integer categoryId);

    PostResponse getPostByUser(Integer userId, Integer pageNumber, Integer pageSize);

    List<PostDto> searchPost(String keyword);
}
