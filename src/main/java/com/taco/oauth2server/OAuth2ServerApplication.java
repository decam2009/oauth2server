package com.taco.oauth2server;

import com.taco.oauth2server.users.User;
import com.taco.oauth2server.users.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OAuth2ServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(OAuth2ServerApplication.class, args);
  }
  @Bean
  public ApplicationRunner dataLoader(UserRepository repo, PasswordEncoder encoder) {
    return args -> {
      repo.save(new User("habuma", encoder.encode("password"), "ROLE_ADMIN"));
      repo.save(new User("tacochef", encoder.encode("password"), "ROLE_ADMIN"));
    };
  }

}
