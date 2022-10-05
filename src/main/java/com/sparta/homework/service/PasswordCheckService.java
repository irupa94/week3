package com.sparta.homework.service;

import com.sparta.homework.dto.PasswordRequestDto;
import com.sparta.homework.entity.Post;
import com.sparta.homework.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PasswordCheckService {

    private final PostRepository postRepository;

    @Transactional
    public Long check(Long id,PasswordRequestDto pwDto) {
        Optional<Post> optional = postRepository.findById(id);
        Post post = optional.get();
        String realpassword = post.getPassword();
        if (post.check(pwDto)==true) {
                System.out.println("비밀번호가 일치합니다.");
            } else {
                System.out.println("비밀번호가 일치하지않습니다.");
            }

        post.check(pwDto);
        return post.getId();
    }
}