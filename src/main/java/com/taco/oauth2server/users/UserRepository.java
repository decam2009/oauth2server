package com.taco.oauth2server.users;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
  User findByUsername(String username);
}
