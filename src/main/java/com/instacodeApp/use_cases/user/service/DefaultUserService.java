package com.instacodeApp.use_cases.user.service;

import com.instacodeApp.use_cases.user.domain.User;
import com.instacodeApp.use_cases.user.exposition.UserDto;
import com.instacodeApp.use_cases.user.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultUserService implements UserService {

    private UserRepository userRepository;
    private ModelMapper modelMapper;

    public DefaultUserService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = mapToEntity(userDto);
        User newUser = this.userRepository.save(user);
        return mapToDto(newUser);
    }

    @Override
    public UserDto getUserById(long userId) {
        User user = this.userRepository.getById(userId);
        return mapToDto(user);

    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = this.userRepository.findAll();
        return users.stream().map(user -> mapToDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto userDto) {
        User user = this.userRepository.getById(userId);

        user.setUsername(userDto.getUsername());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        User updatedUser = this.userRepository.save(user);
        return mapToDto(updatedUser);


    }

    @Override
    public void deleteUser(long userId) {
        User user = this.userRepository.findById(userId).orElseThrow();
        this.userRepository.delete(user);

    }

    @Override
    public UserDto getByUsername(String username) {
        User user = this.userRepository.getByUsername(username);
        return mapToDto(user);    }

    /*@Override
    public UserDto getUserByName(String username) {
        User user = this.userRepository.getUserByName(username);
        return mapToDto(user);
    }*/


    private UserDto mapToDto(User user){
        return modelMapper.map(user, UserDto.class);
    }

    private User mapToEntity(UserDto userDto){
        return modelMapper.map(userDto, User.class);
    }

}
