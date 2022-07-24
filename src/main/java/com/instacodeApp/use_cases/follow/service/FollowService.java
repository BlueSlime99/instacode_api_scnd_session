package com.instacodeApp.use_cases.follow.service;

import com.instacodeApp.use_cases.follow.domain.Follow;
import com.instacodeApp.use_cases.follow.exposition.FollowDto;

import java.util.List;

public interface FollowService {
    FollowDto createFollow(FollowDto followDto);
    List<FollowDto> getAllFollows();
    FollowDto getFollowById(long id);
    FollowDto updateFollow(FollowDto followDto, long id);
    void deleteFollowById(long id);
    List<FollowDto> getFollowsByFollowerUserName(String follower);
    List<FollowDto> getFollowsByFollowedUserName(String followed);
}
