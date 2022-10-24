package com.ashraf.blog;

import com.ashraf.blog.constants.AppConstants;
import com.ashraf.blog.constants.enums.RoleName;
import com.ashraf.blog.models.Role;
import com.ashraf.blog.repository.RoleRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootApplication
public class BlogAppApisApplication implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleRepo roleRepo;

	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
	}
	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("pass"));

		try {
			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
			role.setName(String.valueOf(RoleName.ADMIN_USER));

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName(RoleName.NORMAL_USER.toString());

			List<Role> roles = List.of(role, role1);

			List<Role> savedRoles = this.roleRepo.saveAll(roles);

			for (Role x: savedRoles){
				System.out.println(x.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}