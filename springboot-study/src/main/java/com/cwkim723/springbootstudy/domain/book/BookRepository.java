package com.cwkim723.springbootstudy.domain.book;

import com.cwkim723.springbootstudy.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b ORDER BY b.id DESC")
    List<Posts> findAllDesc();
}
