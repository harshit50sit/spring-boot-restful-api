package com.springboot.blog.controller;

import com.springboot.blog.Payload.PostDto;
import com.springboot.blog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    // Define the endpoints for Post operations here
    // For example, you can create methods for creating, retrieving, updating, and deleting posts
    private PostService postService;
    // Constructor based dependency injection can be added here if needed
    public PostController(PostService postService) {
        this.postService = postService;
    }

     // Define the endpoints for Post operations here
     // For example, you can create methods for creating, retrieving, updating, and deleting posts

    // Create blog post api
     @PostMapping
     public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto) {
         PostDto createdPost = postService.createPost(postDto);
         return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
     }

     //get all post rest api
     //
     @GetMapping
    public List<PostDto> getAllPosts() {
        // This method should return all posts, but for now, we return a placeholder response
        return postService.getAllPost();
    }
}
