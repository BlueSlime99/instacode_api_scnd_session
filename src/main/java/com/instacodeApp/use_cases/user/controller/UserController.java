package com.instacodeApp.use_cases.user.controller;

import com.instacodeApp.use_cases.user.exposition.UserDto;
import com.instacodeApp.use_cases.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        return new ResponseEntity<>(this.userService.createUser(userDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable(name = "id") long userId){
        return new ResponseEntity<>(this.userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping
    public List<UserDto> getAllUsers(){
        return this.userService.getAllUsers();
    }

    /*@GetMapping("/getUserByName/{username}")
    public ResponseEntity<UserDto> getUserByName(@PathVariable(name="username") String username){
        return new ResponseEntity<>(this.userService.getUserByName(username), HttpStatus.OK);
    }*/

    @GetMapping("/getByUsername/{username}")
    public ResponseEntity<UserDto> getByUsername(@PathVariable(name="username")String username){
        return new ResponseEntity<>(this.userService.getByUsername(username),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable(name = "id") long userId, @RequestBody UserDto userDto){
        return new ResponseEntity<>(this.userService.updateUser(userId, userDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable(name = "id") long userId){
        this.userService.deleteUser(userId);
    }


}

