package com.instacodeApp.use_cases.follow.service;

import com.instacodeApp.use_cases.follow.domain.Follow;
import com.instacodeApp.use_cases.follow.exposition.FollowDto;
import com.instacodeApp.use_cases.follow.repository.FollowRepository;
import com.instacodeApp.use_cases.user.domain.User;
import com.instacodeApp.use_cases.user.exposition.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DefaultFollowService implements FollowService{

    private FollowRepository followRepository;
    private ModelMapper modelMapper;

    public DefaultFollowService(FollowRepository followRepository, ModelMapper modelMapper) {
        this.followRepository = followRepository;
        this.modelMapper = modelMapper;

    }


    @Override
    public FollowDto createFollow(FollowDto followDto) {
        Follow follow = mapToEntity(followDto);
        Follow newFollow = this.followRepository.save(follow);
        return mapToDto(newFollow);
    }


    @Override
    public List<FollowDto> getAllFollows() {
        List<Follow> follows = this.followRepository.findAll();
        return follows.stream().map(follow -> mapToDto(follow)).collect(Collectors.toList());
    }

    @Override
    public FollowDto getFollowById(long id) {
        Follow follow = this.followRepository.getById(id);
        return mapToDto(follow);
    }

    @Override
    public FollowDto updateFollow(FollowDto followDto, long id) {
        Follow follow = this.followRepository.getById(id);

        follow.setFollowedUserName(followDto.getFollowedUserName());
        follow.setFollowerUserName(followDto.getFollowerUserName());

        Follow updatedFollow = this.followRepository.save(follow);
        return mapToDto(updatedFollow);
    }

    @Override
    public void deleteFollowById(long id) {
        Follow follow = this.followRepository.findById(id).orElseThrow();
        this.followRepository.delete(follow);
    }

    @Override
    public List<FollowDto> getFollowsByFollowerUserName(String follower) {
        List<Follow> follows = this.followRepository.findFollowsByFollowerUserName(follower);
        return follows.stream().map(follow -> mapToDto(follow)).collect(Collectors.toList());
    }

    @Override
    public List<FollowDto> getFollowsByFollowedUserName(String followed) {
        List<Follow> follows = this.followRepository.findFollowsByFollowedUserName(followed);
        return follows.stream().map(follow -> mapToDto(follow)).collect(Collectors.toList());
    }


    private FollowDto mapToDto(Follow follow){
        return modelMapper.map(follow, FollowDto.class);
    }

    private Follow mapToEntity(FollowDto followDto){
        return modelMapper.map(followDto,Follow.class);
    }
}
