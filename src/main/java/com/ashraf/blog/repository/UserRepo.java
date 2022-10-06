package com.ashraf.blog.repository;

import com.ashraf.blog.entities.Category;
import com.ashraf.blog.entities.Post;
import com.ashraf.blog.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
	List<Post> findByUser(User user);
	List<Category> findByUser(Category category);
}
