package com.instacodeApp.use_cases.post.service;

import com.instacodeApp.use_cases.post.exposition.PostDto;
import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);
    List<PostDto> getAllPosts();
    PostDto getPostById(long id);
    PostDto updatePost(PostDto postDto, long id);
    void deletePostById(long id);
    List<PostDto> getPostsByName(String username);
}
