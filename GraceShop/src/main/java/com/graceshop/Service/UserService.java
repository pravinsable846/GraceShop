package com.graceshop.Service;

import com.graceshop.Dto.UserDto;

public interface UserService {
UserDto createUser(UserDto userdto);
UserDto upadateUser(UserDto userdto,String userId);
 void deleteUser(String userId);
 UserDto getUserById(String userId);
 UserDto getUserByEmail(String email);
}
