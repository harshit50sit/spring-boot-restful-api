package com.springboot.blog.service.impl;

import com.springboot.blog.Payload.PostDto;
import com.springboot.blog.entity.Post;
import com.springboot.blog.repository.PostRepository;
import com.springboot.blog.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    //Constructor based dependency injection can be added here if needed
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto){
        // Implementation logic to create a post
        //convert DTO to entity
        Post post = maptToEntity(postDto);
        Post newPost = postRepository.save(post);

        //convert entity to DTO
        PostDto postResponse = mapToDTO(newPost);
        return postResponse; // Replace with actual implementation
    }

    @Override
    public List<PostDto> getAllPost() {
        // Implementation logic to get all posts
        // For now, we return a placeholder response
        List<Post> posts = postRepository.findAll();
        // Convert List<Post> to List<PostDto>
        return posts.stream().map(post-> mapToDTO(post)).collect(Collectors.toList());
    }

    //Conveted Entity to DTO
    private PostDto mapToDTO(Post post){
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setDescription(post.getDescription());
        postDto.setContent(post.getContent());
        return postDto;
    }

    //Convert DTO to Entity
    private Post maptToEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}
