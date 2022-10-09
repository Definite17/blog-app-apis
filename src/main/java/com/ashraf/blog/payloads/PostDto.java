package com.ashraf.blog.payloads;

import com.ashraf.blog.entities.Category;
import com.ashraf.blog.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

    private String title;

    private String content;

    private String imageName;

    private Date createdAt;

    private CategoryDto category;

    private UserDto user;
}
