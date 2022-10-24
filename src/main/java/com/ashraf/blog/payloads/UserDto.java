package com.ashraf.blog.payloads;

import com.ashraf.blog.models.Comment;
import com.ashraf.blog.models.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private Integer id;

	@NotEmpty
	@Size(min = 4, message = "Username must be min of 4 characters")
	private String name;

	@Email(message = "Email Address is not valid !")
	private String email;

	@NotEmpty // can use "@Pattern(regexp = "vv")" for specific pattern
	@Size(min = 3, max = 10, message = "Password must be min 3 chars & max of 10 chars !")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;

	@NotEmpty
	private String about;

	private Set<RolesDto> roles=new HashSet<>();

//	private Set<Comment> comments=new HashSet<>();
}

 /*
 Java Bean is validated with JSR 380 known as Bean Validation 2.0
 JSR 380 is specification for the Java Api for bean validation.
 ex - @NotNull, @Size, @NotEmpty
 */
