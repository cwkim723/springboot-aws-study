package com.cwkim723.springbootstudy.web;

import com.cwkim723.springbootstudy.config.auth.LoginUser;
import com.cwkim723.springbootstudy.config.auth.dto.SessionUser;
import com.cwkim723.springbootstudy.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RequiredArgsConstructor
@RestController
public class BookApiController {

    private final BookService bookService;

    @GetMapping("/book/list")
    public ModelAndView list(ModelAndView mv){
        mv.addObject("books", bookService.findAllDesc());
        mv.setViewName("book-list");

        return mv;
    }


}
