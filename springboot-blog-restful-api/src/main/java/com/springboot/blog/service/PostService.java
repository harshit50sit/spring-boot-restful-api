package com.springboot.blog.service;

import com.springboot.blog.Payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto postDto);
}
