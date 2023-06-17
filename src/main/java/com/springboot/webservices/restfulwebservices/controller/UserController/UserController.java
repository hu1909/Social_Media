package com.springboot.webservices.restfulwebservices.controller.UserController;

import com.springboot.webservices.restfulwebservices.Model.User.UserDaoService;
import com.springboot.webservices.restfulwebservices.Model.User.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private UserDaoService userDaoService;


    @Autowired
    public UserController(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    @GetMapping(value = "/users")
    public List<Users> list_user(){
        return userDaoService.findAll();
    }

    @GetMapping(value = "/users/{id}")
    public Users retrieve_user(@PathVariable Long id){
        Users user = userDaoService.findOne(id);

        if(user == null){
            throw new UserNotFoundException("id: " + id);
        }

        return user;
    }

    @PostMapping(value = "/users")
    public ResponseEntity<Object> add_user(@RequestBody Users user){
        Users saveUser = userDaoService.saver(user);

        // Indicate the location of detail information of the new user
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(saveUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
