package com.masai;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.masai.model.User;
import com.masai.repo.UserRepository;

@SpringBootApplication
public class SpringSecurityAppApplication implements CommandLineRunner {
	@Autowired
   private UserRepository userRepo;
	@Autowired
	public BCryptPasswordEncoder passwordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user=new User();
		user.setEmail("john@gmail.com");
		user.setUsername("john");
		user.setPassword(this.passwordEncoder.encode("ashish"));
		user.setRole("NORMAL");
		
		userRepo.save(user);
		
		User user1=new User();
		user1.setEmail("nancy@gmail.com");
		user1.setUsername("nancy");
		user1.setPassword(this.passwordEncoder.encode("rana"));
		user1.setRole("ADMIN");
		
		userRepo.save(user1);
		
	}

}
