package com.ashraf.blog.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Integer categoryId;

    @NotEmpty
    @Size(min = 3, message = "categoryTitle must be minimum of 3 chars")
    private String categoryTitle;

    @NotEmpty
    private String categoryDescription;
}
