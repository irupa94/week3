package com.sparta.homework.repository;

import com.sparta.homework.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.List;

public interface PostRepository extends JpaRepository<Post , Long>{
    List<Post> findAllByOrderByModifiedAtDesc();
}