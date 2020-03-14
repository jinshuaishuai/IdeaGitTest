package com.jin.controller;

import com.jin.entity.AO.BookAO;
import com.jin.entity.DO.BookDO;
import com.jin.entity.query.BookQuery;
import com.jin.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(value = "/getBookById")
    public BookDO getBookById(@RequestParam int id) {
        BookDO bookDO = bookService.getBookById(id);
        return bookDO;
    }

    @PostMapping(value = "getBookByParams")
    public List<BookDO> getBookByParams(@RequestBody BookQuery bookQuery) {
        List<BookDO> result = bookService.getBookByParams(bookQuery);
        return  result;
    }

    
}
