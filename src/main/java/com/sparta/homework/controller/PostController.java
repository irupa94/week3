package com.sparta.homework.controller;

import com.sparta.homework.dto.PasswordRequestDto;
import com.sparta.homework.dto.PostRequestDto;
import com.sparta.homework.entity.Post;
import com.sparta.homework.repository.PostRepository;
import com.sparta.homework.service.PasswordCheckService;
import com.sparta.homework.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostRepository postRepository;
    private final PostService postService;
    private final PasswordCheckService passwordCheckService;


    @PostMapping("/api/posts")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        return postRepository.save(post);
    }
    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc();
    }
    @GetMapping("/api/posts/{id}")

    @DeleteMapping("/api/posts/{id}")
    public Long deletePost(@PathVariable Long id) {
        postRepository.deleteById(id);
        return id;
    }
    @PutMapping("/api/posts/{id}")
    public Long updatePost(@PathVariable Long id, @RequestBody PostRequestDto requestDto) {
        postService.update(id, requestDto);
        return id;
    }
    @PostMapping("/api/posts/{id}")
    public Long checkPost(@PathVariable Long id,@RequestBody PasswordRequestDto pwDto) {
        passwordCheckService.check(id, pwDto);
        return id;

    }

}
