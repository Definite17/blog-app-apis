package com.ashraf.blog.service;

import com.ashraf.blog.entities.Post;
import com.ashraf.blog.payloads.PostDto;
import com.ashraf.blog.payloads.PostResponse;

import java.util.List;

public interface PostService {

    PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

    Post updatePost(PostDto postDto);

    void deletePost(Integer postId);

    PostResponse getAllPost(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    PostDto getPostById(Integer postId);

    PostResponse getPostByCategory(Integer categoryId, Integer pageNumber, Integer pageSize);

    PostResponse getPostByUser(Integer userId, Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

    List<PostDto> searchPost(String keyword);
}
