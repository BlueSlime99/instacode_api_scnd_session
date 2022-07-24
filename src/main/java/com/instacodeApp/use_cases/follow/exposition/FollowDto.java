package com.instacodeApp.use_cases.follow.exposition;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class FollowDto {
    public Long id;
    @NotEmpty(message = "followerUserName should not be null or empty")
    public String followerUserName;
    @NotEmpty(message = "followedUserName should not be null or empty")
    public String followedUserName;
}
