package com.cwkim723.springbootstudy.service;

import com.cwkim723.springbootstudy.domain.book.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BookService {

    private final BookRepository bookRepository;
}
