package com.stitchline.api.controller;

import com.stitchline.api.model.User;
import com.stitchline.api.service.UserService;
import com.stitchline.api.util.StandardResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/stitch/user")
@Api(value = "User", description = "REST API for User", tags = { "User" })
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value="Post User", tags = { "User" })
    @PostMapping
    public ResponseEntity addUser(@Valid @RequestBody User user) {
        User result = userService.addUser(user);
        return new ResponseEntity(new StandardResponse("201", "Done", result), HttpStatus.CREATED);
    }

    @ApiOperation(value="Put User", tags = { "User" })
    @PutMapping
    public ResponseEntity updateUser(@RequestBody User user) {
        return new ResponseEntity(new StandardResponse("200", "Done", userService.updateUser(user)), HttpStatus.OK);
    }

    @ApiOperation(value="Get All User", tags = { "User" })
    @GetMapping
    public ResponseEntity getAllUser() {
        return new ResponseEntity(new StandardResponse("200", "Done", userService.getAllUser()), HttpStatus.OK);
    }

    @ApiOperation(value="Get User by UserName and Password", tags = { "User" })
    @GetMapping("searchuser/{userName}/{password}")
    public ResponseEntity searchUserByUserNameAndPassword(@PathVariable String userName, @PathVariable String password) {
        return new ResponseEntity(new StandardResponse("200", "Done", userService.searchUserByUserNameAndPassword(userName, password)), HttpStatus.OK);
    }

    @ApiOperation(value="Get User by Email", tags = { "User" })
    @GetMapping("search/{email}")
    public ResponseEntity<User> searchUserByUserNameAndPassword(@PathVariable String email) {
        return new ResponseEntity(new StandardResponse("200", "Done", userService.searchUserByEmail(email)), HttpStatus.OK);
    }

    @ApiOperation(value="Delete User", tags = { "User" })
    @DeleteMapping("/{email}")
    public ResponseEntity<Object> deleteUser(@PathVariable String email) {
        userService.deleteUser(email);
        return new ResponseEntity(new StandardResponse("200", "Done", null), HttpStatus.OK);
    }
}
