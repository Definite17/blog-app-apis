package com.ashraf.blog.payloads;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private Integer postId;

    private String title;

    private String content;

    private String imgName;

    private Date createdAt;

    private CategoryDto category;

    private UserDto user;
}
