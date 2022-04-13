package com.cwkim723.springbootstudy.web.dto;

import com.cwkim723.springbootstudy.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private String title;
    private String content;
    private Long writer;

    @Builder
    public PostsSaveRequestDto(String title, String content, Long writer){
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .writer(1L)
                .build();
    }
}
