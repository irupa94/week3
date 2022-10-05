package com.sparta.homework;

import com.sparta.homework.entity.Post;
import com.sparta.homework.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PostingApplication {



	public static void main(String[] args) {

		SpringApplication.run(PostingApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(PostRepository postRepository) {
		return(args) -> {
			postRepository.save(new Post("유저이름", "제목" , "글내용" ,"password"));
		}	;
	}
}
