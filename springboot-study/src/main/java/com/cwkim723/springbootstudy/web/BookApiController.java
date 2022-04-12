package com.cwkim723.springbootstudy.web;

import com.cwkim723.springbootstudy.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BookApiController {

    private final BookService bookService;


}
