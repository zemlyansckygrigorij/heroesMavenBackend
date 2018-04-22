package com.backend.service;

import com.backend.model.User;
import com.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;



@Service("userService")
public class UserService  {


    private UserRepository userRepository;
    public boolean hasUser(User otherUser){
      User user =  userRepository.findOneByUsername(otherUser.getUsername());
      return user.equals(otherUser);
    }


}
