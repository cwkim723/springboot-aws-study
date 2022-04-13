package com.cwkim723.springbootstudy.web.dto;

import com.cwkim723.springbootstudy.domain.posts.Posts;
import com.cwkim723.springbootstudy.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostsListResponseDto {

    private Long id;
    private String title;
    private Long writer;
    private String name;
    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.writer = entity.getWriter();
        this.name = entity.getUser().getName();
        this.modifiedDate = entity.getModifiedDate();
    }
}
