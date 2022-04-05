package com.cwkim723.springbootstudy.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    // entity 클래스와 기본 entity repository는 함께 위치해야 함
}
