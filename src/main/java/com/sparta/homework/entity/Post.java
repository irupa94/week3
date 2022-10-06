package com.sparta.homework.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sparta.homework.dto.PasswordRequestDto;
import com.sparta.homework.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Post extends Timestamped { // 생성,수정 시간을 자동으로 만들어줍니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String post;
    @JsonIgnore // password 안보이게 하는 어노테이션
    @Column(nullable = false)
    private String password;

    public Post(String username, String title, String post, String password) {
        this.username = username;
        this.title = title;
        this.post = post;
        this.password = password;
    }
    public Post(PostRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.post = requestDto.getPost();
        this.password = requestDto.getPassword();

    }
    public void update(PostRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.title = requestDto.getTitle();
        this.post = requestDto.getPost();
        this.password = requestDto.getPassword();
    }

    public boolean check(PasswordRequestDto pwDto) {
        if(this.password.equals(pwDto.getPassword())){
         return true;
        }else return false;

    }


}