package com.jin.service.impl;

import com.jin.dao.BookDao;
import com.jin.entity.AO.BookAO;
import com.jin.entity.DO.BookDO;
import com.jin.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @date 2020/3/8 15:32
 * @Author lenovo
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    @Override
    public void save(BookAO bookAO) {
        BookDO bookDO = new BookDO();
        BeanUtils.copyProperties(bookAO, bookDO);
        bookDO.setIsDelete(0);
        bookDao.save(bookDO);
    }

}
