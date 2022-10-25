package com.ashraf.blog.payloads.responseDtos;

import com.ashraf.blog.payloads.UserDto;
import lombok.Data;

@Data
public class JwtAuthResponse {

    private String token;

    private UserDto user;
}
