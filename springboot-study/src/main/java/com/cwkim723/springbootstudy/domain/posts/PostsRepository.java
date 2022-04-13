package com.cwkim723.springbootstudy.domain.posts;

import com.cwkim723.springbootstudy.web.dto.PostsResponseDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // entity 클래스와 기본 entity repository는 함께 위치해야 함

    @Query("SELECT p, u.name FROM Posts p LEFT OUTER JOIN User u ON p.writer = u.id ORDER BY p.id DESC")
    List<Posts> findAllDesc();

    @Query("SELECT p, u.name FROM Posts p LEFT OUTER JOIN User u ON p.writer = u.id WHERE p.id = :id")
    PostsResponseDto findOnePosts(@Param("id") Long id);
}
