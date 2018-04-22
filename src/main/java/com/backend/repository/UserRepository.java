package com.backend.repository;


import com.backend.model.User;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long>{
  /**
   * Find a user by username
   *
   * @param username the user's username
   * @return user which contains the user with the given username or null.
   */
    User findOneByUsername(String username);

}
