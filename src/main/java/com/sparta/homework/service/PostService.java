package com.sparta.homework.service;

import com.sparta.homework.dto.PasswordRequestDto;
import com.sparta.homework.dto.PostRequestDto;
import com.sparta.homework.entity.Post;
import com.sparta.homework.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long update(Long id, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        post.update(requestDto);
        return post.getId();

    }
}