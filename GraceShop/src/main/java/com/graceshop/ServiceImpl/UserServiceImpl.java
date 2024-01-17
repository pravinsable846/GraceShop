package com.graceshop.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graceshop.Dto.UserDto;
import com.graceshop.Entity.User;
import com.graceshop.Repository.UserRepository;
import com.graceshop.Service.UserService;
@Service
public class UserServiceImpl implements UserService{
    
    @Autowired
    private UserRepository userrepository;
    @Override
	public UserDto createUser(UserDto userdto) {
    	if(userrepository.findById(userdto.getUserid()).isPresent()) {
    		throw new RuntimeException("user already exist with given UserId");
    	}
  
    	User user=DtoToEntity(userdto);
    	User savedUser=userrepository.save(user);
    	UserDto dto2=EntityToDto(savedUser);
    	return dto2;
	}

	@Override
	public UserDto upadateUser(UserDto userdto, String userId) {
		User user = userrepository.findById(userId).orElseThrow(()-> new RuntimeException("user not found with given userId"));
		user.setName(userdto.getName());
		user.setPassword(userdto.getPassword());
		User newUser = userrepository.save(user);
		UserDto newDto = EntityToDto(newUser);
		return newDto;
	}

	@Override
	public void deleteUser(String userId) {
		User user = userrepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found with given userId"));
		userrepository.delete(user);
	}

	@Override
	public UserDto getUserById(String userId) {
		User user = userrepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found with given userId"));
		UserDto userDto = EntityToDto(user);
		return userDto;
	}

	@Override
	public UserDto getUserByEmail(String email) {
	User user = userrepository.findByEmail(email).orElseThrow(()-> new RuntimeException("User not found with given userId"));
		return EntityToDto(user);
	}
	
	private UserDto EntityToDto(User savedUser) {
		UserDto userDto=new UserDto();
		userDto.setUserid(savedUser.getUserId());
		userDto.setEmail(savedUser.getEmail());
		userDto.setPassword(savedUser.getPassword());
		userDto.setName(savedUser.getName());
		return userDto;
		
	}
	private User DtoToEntity(UserDto userDto) {
		User user=new User();
		user.setEmail(userDto.getEmail());
		user.setName(userDto.getName());
		user.setPassword(userDto.getPassword());
		user.setUserId(userDto.getUserid());
		return user;
				}

}
