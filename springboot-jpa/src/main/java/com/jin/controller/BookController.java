package com.jin.controller;

import com.jin.entity.AO.BookAO;
import com.jin.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/book")
@Slf4j
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping(value = "/addBook")
    public String addBook(@RequestBody BookAO bookAO) {
        try {
            bookService.save(bookAO);
            return "保存图书成功";
        } catch (Exception e) {
            log.error("保存书籍出现错误:------>{}", e.toString());
            return "保存图书失败";
        }
    }
}
