package com.instacodeApp.use_cases.follow.repository;

import com.instacodeApp.use_cases.follow.domain.Follow;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;


public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findFollowsByFollowerUserName(String follower);
    List<Follow> findFollowsByFollowedUserName(String followed);
}
