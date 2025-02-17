package com.instacodeApp.use_cases.post.controller;


import com.instacodeApp.use_cases.post.exposition.PostDto;
import com.instacodeApp.use_cases.post.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping public ResponseEntity<PostDto> createPost(@Valid @RequestBody PostDto postDto) {
        return new ResponseEntity<>(this.postService.createPost(postDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable(name = "id") long postId){
        return new ResponseEntity<>(this.postService.getPostById(postId),HttpStatus.OK);}

    @GetMapping
    public List<PostDto> getAllPosts(){
        return this.postService.getAllPosts();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<PostDto> updatePost(@PathVariable(name = "id") long postId,@Valid @RequestBody PostDto postDto){
        return new ResponseEntity<>(this.postService.updatePost(postDto, postId), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable(name = "id") long postId){
        this.postService.deletePostById(postId);
    }


}
