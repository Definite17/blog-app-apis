package com.ashraf.blog.repository;

import com.ashraf.blog.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer  > {
}
