package com.ashraf.blog.repository;

import com.ashraf.blog.models.Category;
import com.ashraf.blog.models.Post;
import com.ashraf.blog.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    Page<Post> findByUser(User user, Pageable pageable);
    Page<Post> findByCategory(Category category, Pageable p);

    List<Post> findByTitleContaining(String title);


    /*

    Or can use this if it gives error.

    keyword in the PostServiceImpl will be changed like this -> "%"+keyword+"%"
    List<Post> posts = this.postRepo.findByTitleContaining("%"+keyword+"%");
    */
    /*
    @Query("select p from Post p where p.title like :key")
    List<Post> findByTitleContaining(@Param("key") String title);
    */

}
