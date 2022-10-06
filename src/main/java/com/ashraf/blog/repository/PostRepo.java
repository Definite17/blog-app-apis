package com.ashraf.blog.repository;

import com.ashraf.blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer> {
}
