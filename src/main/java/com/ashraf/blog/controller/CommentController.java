package com.ashraf.blog.controller;

import com.ashraf.blog.payloads.responseDtos.ApiResponse;
import com.ashraf.blog.payloads.CommentDto;
import com.ashraf.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/{postId}/create")
    public ResponseEntity<CommentDto> createComment(@RequestBody CommentDto commentDto,
                                                    @PathVariable Integer postId){
        CommentDto savedComment = this.commentService.createComment(commentDto, postId);

        return new ResponseEntity<>(savedComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable Integer commentId){
        this.commentService.deleteComment(commentId);

        return new ResponseEntity<>(new ApiResponse("Comment Deleted", true), HttpStatus.OK);
    }
}
