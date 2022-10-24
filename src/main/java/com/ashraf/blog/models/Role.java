package com.ashraf.blog.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Role {

    @Id
    private Integer id; // not incrementing cz we will have few roles which we will define

    private String name;
}
