package com.instacodeApp.use_cases.user.service;

import com.instacodeApp.use_cases.user.exposition.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userdto);
    UserDto getUserById(long userId);
    List<UserDto> getAllUsers();
    UserDto updateUser(Long userId, UserDto userDto);
    void deleteUser(long userId);

}
