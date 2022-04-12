package com.cwkim723.springbootstudy.service;

import com.cwkim723.springbootstudy.domain.book.BookRepository;
import com.cwkim723.springbootstudy.web.dto.BookListResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;

    @Transactional(readOnly = true)
    public List<BookListResponseDto> findAllDesc() {
        return bookRepository.findAllDesc().stream()
                .map(BookListResponseDto::new)
                .collect(Collectors.toList());
    }
}
