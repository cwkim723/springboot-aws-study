package com.cwkim723.springbootstudy.web.dto;

import com.cwkim723.springbootstudy.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private Long writer;
    private String name;

    public PostsResponseDto(Posts entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.writer = entity.getWriter();
        this.name = entity.getUser().getName();
    }
}
