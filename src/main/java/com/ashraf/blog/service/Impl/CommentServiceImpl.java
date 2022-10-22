package com.ashraf.blog.service.Impl;

import com.ashraf.blog.exception.ResourceNotFoundException;
import com.ashraf.blog.models.Comment;
import com.ashraf.blog.models.Post;
import com.ashraf.blog.payloads.CommentDto;
import com.ashraf.blog.repository.CommentRepo;
import com.ashraf.blog.repository.PostRepo;
import com.ashraf.blog.service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CommentDto createComment(CommentDto commentDto, Integer postId) {

        Post post = this.postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("post", "Post ID", postId));

        Comment comment = this.modelMapper.map(commentDto, Comment.class);
        comment.setPost(post);
        Comment savedComment = this.commentRepo.save(comment);

        return this.modelMapper.map(savedComment, CommentDto.class);
    }

    @Override
    public void deleteComment(Integer commentId) {

        Comment comment=this.commentRepo.findById(commentId)
                .orElseThrow(()-> new ResourceNotFoundException("comment", "Comment ID", commentId));
        this.commentRepo.delete(comment);
    }
}
