package com.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
  static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, updatable = false)
    private int id;



    @Column(name = "password", nullable = false)
    @NotEmpty(message = "Please provide your password")
    @Transient
    private String password;

    @Column(name = "username", nullable = false, unique = true)
    @NotEmpty(message = "Please provide your name")
    private String username;



  public String getPassword() {
        return password;
    }
  public String getUsername() {
    return username;
  }

  public boolean equals(User otherUser){
    if(!this.username.equals(otherUser.username)) return false;
    if(!this.password.equals(otherUser.password)) return false;
    return true;
  }
  public int hashCode(){
    return this.username.hashCode() + this.password.hashCode();
  }

}
