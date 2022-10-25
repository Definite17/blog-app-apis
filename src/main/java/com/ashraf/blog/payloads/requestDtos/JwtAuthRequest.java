package com.ashraf.blog.payloads.requestDtos;

import lombok.Data;

@Data
public class JwtAuthRequest {

    private String username;

    private String password;
}
