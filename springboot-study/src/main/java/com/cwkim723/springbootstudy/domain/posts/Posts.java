package com.cwkim723.springbootstudy.domain.posts;

import com.cwkim723.springbootstudy.domain.BaseTimeEntity;
import com.cwkim723.springbootstudy.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {
    // Entity에서는 setter X -> 생성자를 통해 최종 값을 채운 후 db 삽입. 값 변경 시에는 해당 이벤트에 맞는 public 메소드 호출하여 변경
    // 빌더 사용 이유 -> 어느 필드에 어떤 값을 채워야 할지 명확하게 인지 가능

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // GenerationType.IDENTITY를 추가해야 auto increment 가능
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private Long writer;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    @Builder
    public Posts(String title, String content, Long writer){
        this.title = title;
        this.content = content;
        this.writer = user.getId();
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
