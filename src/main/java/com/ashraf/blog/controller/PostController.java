package com.ashraf.blog.controller;


import com.ashraf.blog.entities.Post;
import com.ashraf.blog.payloads.PostDto;
import com.ashraf.blog.payloads.PostResponse;
import com.ashraf.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/create")
    public ResponseEntity<PostDto> createPost(
            @RequestBody PostDto postDto,
            @PathVariable Integer userId,
            @PathVariable Integer categoryId
    )
    {
        PostDto createdPost = this.postService.createPost(postDto, userId, categoryId);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<PostResponse> getPostByCategory(@PathVariable Integer categoryId,
                                                           @RequestParam(value = "pageNumber", defaultValue ="0", required = false) Integer pageNumber,
                                                           @RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize){
        PostResponse postResponse = postService.getPostByCategory(categoryId, pageNumber, pageSize);

        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<PostResponse> getPostByUser(@PathVariable Integer userId,
                                                       @RequestParam(value = "pageNumber", defaultValue ="0", required = false) Integer pageNumber,
                                                       @RequestParam(value = "pageSize", defaultValue = "2", required = false) Integer pageSize){
        PostResponse postResponse = this.postService.getPostByUser(userId, pageNumber, pageSize);

        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
            @RequestParam(value = "pageSize", defaultValue = "5",required = false) Integer pageSize
    ){
        PostResponse postResponse = this.postService.getAllPost(pageNumber, pageSize);

        return new ResponseEntity<PostResponse>(postResponse, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
        PostDto postDto = this.postService.getPostById(postId);

        return ResponseEntity.ok(postDto);
    }

}
