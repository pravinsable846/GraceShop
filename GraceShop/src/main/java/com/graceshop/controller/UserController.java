package com.graceshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.graceshop.Dto.ApiResponseMsg;
import com.graceshop.Dto.UserDto;
import com.graceshop.Entity.User;
import com.graceshop.Service.UserService;
import com.graceshop.Utility.ErrorCode;

@RestController
@RequestMapping("/users")

public class UserController {

@Autowired
private ErrorCode errorCode;
@Autowired 
private UserService userservice;
@PostMapping("/create")
  public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
	UserDto userDto1 = userservice.createUser(userDto);
	return new ResponseEntity<>(userDto1,HttpStatus.CREATED);
}

 @PutMapping("/{userId}")
 public ResponseEntity<UserDto> updateUser(@PathVariable("userId")String userId,
		 @RequestBody UserDto userDto){
	 UserDto userDto2 = userservice.upadateUser(userDto, userId);
			return new ResponseEntity<>(userDto2,HttpStatus.OK);
 }
 @DeleteMapping("/{userId}")
 public ResponseEntity<ApiResponseMsg>deleteUser(@PathVariable String userId){
	 userservice.deleteUser(userId);
	 ApiResponseMsg message = ApiResponseMsg.builder()
			 .message("user deleted succeffully")
			 .status(HttpStatus.OK)
			 .success(true)
			 .build();
	return new ResponseEntity<>(message,HttpStatus.OK);
	 
 }
 @GetMapping("/{userId}")
 public ResponseEntity<UserDto>getUser(@PathVariable String userId){
	 UserDto userDto = userservice.getUserById(userId);
	return new ResponseEntity<>(userDto,HttpStatus.OK);
	 
 }
 @GetMapping("/email/{email}")
 public ResponseEntity<UserDto>getUserByEmail(@PathVariable String email){
	 return new ResponseEntity<>(userservice.getUserByEmail(email),HttpStatus.OK);
 }
}