package com.backend.controller;


import com.backend.model.Hero;
import com.backend.model.User;
import com.backend.repository.HeroRepository;
import com.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@CrossOrigin

@Configuration
@RestController
@RequestMapping("/hero")
public class HeroController{
  UserService userService;
// @Autowired
 private AuthenticationManager authenticationManager;
    @Autowired
    private HeroRepository heroRepo;

   @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Hero>> getStudents(User user) {
     if(userService.hasUser(user)) {
       return new ResponseEntity<>(heroRepo.findAll(), HttpStatus.OK);
     }else{
       return null;
     }
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Hero getHero(@PathVariable long id) {
        return  heroRepo.findOne(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Collection<Hero>> deleteStudent(@PathVariable long id) {
        Hero hero = heroRepo.findOne(id);
        heroRepo.delete(id);

        return new ResponseEntity<>(heroRepo.findAll(), HttpStatus.OK);
    }



    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> addStudent(@RequestBody Hero hero) {
        return new ResponseEntity<>(heroRepo.save(hero), HttpStatus.CREATED);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<?>  updateStudent(@PathVariable("id") long id,
                                                          @RequestBody @Valid Hero hero){
        return new ResponseEntity<>(heroRepo.save(hero), HttpStatus.OK);
    }


}
//           localhost:8080/hero                 4aa98a3c-a31e-4217-9296-9ab2c6fb868a
/*
{
        "id": 4,
        "username": "mary",
        "password": "mary"
    }

    */
