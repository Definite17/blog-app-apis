package com.ashraf.blog.payloads;

import com.ashraf.blog.entities.Category;
import com.ashraf.blog.entities.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class PostDto {

    private String title;

    private String content;

    private String imageName;

    private Date createdAt;

    private Category category;

    private User user;
}
