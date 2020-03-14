package com.jin.service;

import com.jin.entity.AO.BookAO;
import com.jin.entity.DO.BookDO;
import com.jin.entity.query.BookQuery;

import java.util.List;

public interface BookService {

    public void save(BookAO bookAO);

    BookDO getBookById(int id);

    List<BookDO> getBookByParams(BookQuery bookQuery);
}
