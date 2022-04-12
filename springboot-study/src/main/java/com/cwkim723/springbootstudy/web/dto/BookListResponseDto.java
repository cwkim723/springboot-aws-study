package com.cwkim723.springbootstudy.web.dto;

import com.cwkim723.springbootstudy.domain.book.Book;
import lombok.Getter;

@Getter
public class BookListResponseDto {
    private Long id;
    private String title;
    private String author;
    private int stockQuantity;

    public BookListResponseDto(Book entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.stockQuantity = entity.getStockQuantity();
    }
}
