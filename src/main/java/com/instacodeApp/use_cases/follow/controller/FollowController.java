package com.instacodeApp.use_cases.follow.controller;

import com.instacodeApp.use_cases.follow.exposition.FollowDto;
import com.instacodeApp.use_cases.follow.service.FollowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/follow")
public class FollowController {

    private  FollowService followService;


    public FollowController(FollowService followService) {
        this.followService = followService;
    }

    @PostMapping
    public ResponseEntity<FollowDto> createFollow(@RequestBody FollowDto followDto) {
        return new ResponseEntity<>(this.followService.createFollow(followDto), HttpStatus.CREATED);
    }

    @PostMapping("/checkFollow")
    public boolean checkFollow(@RequestBody FollowDto followDto){
        List<FollowDto> list = this.followService.getFollowsByFollowerUserName(followDto.followerUserName);
        for (FollowDto dto : list) {
            if (followDto.followedUserName.equals(dto.followedUserName)) {
                return true;
            }
        }
        return false;
    }


    @GetMapping("/{id}")
    public ResponseEntity<FollowDto> getFollowById(@PathVariable(name = "id") long id){
        return new ResponseEntity<>(this.followService.getFollowById(id),HttpStatus.OK);}

    @GetMapping("/follower/{followerUserName}")
    public List<FollowDto> getFollowsByFollowerName(@PathVariable(name="followerUserName") String followerUserName){
        return this.followService.getFollowsByFollowerUserName(followerUserName);
    }

    @GetMapping("/followed/{followedUserName}")
    public List<FollowDto> getFollowsByFollowedName(@PathVariable(name="followedUserName") String followedUserName){
        return this.followService.getFollowsByFollowedUserName(followedUserName);
    }

    @GetMapping
    public List<FollowDto> getAllFollows(){
        return this.followService.getAllFollows();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FollowDto> updateFollow(@PathVariable(name = "id") long id,@Valid @RequestBody FollowDto followDto){
        return new ResponseEntity<>(this.followService.updateFollow(followDto, id), HttpStatus.OK);
    }

    @PostMapping("/deleteFollow")
    public void deleteFollow(@RequestBody FollowDto followDto){
        List<FollowDto> list = this.followService.getFollowsByFollowerUserName(followDto.followerUserName);
        for (FollowDto dto : list) {
            if (followDto.followedUserName.equals(dto.followedUserName)) {
                deleteFollowById(dto.id);
            }
        }

    }
    @DeleteMapping("/{id}")
    public void deleteFollowById(@PathVariable(name = "id") long id){
        this.followService.deleteFollowById(id);
    }
}
