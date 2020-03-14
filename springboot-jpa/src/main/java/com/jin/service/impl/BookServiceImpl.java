package com.jin.service.impl;

import com.jin.dao.BookDao;
import com.jin.entity.AO.BookAO;
import com.jin.entity.DO.BookDO;
import com.jin.entity.query.BookQuery;
import com.jin.service.BookService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

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
        bookDao.save(bookDO);
    }

    @Override


    public BookDO getBookById(int id) {
        return bookDao.getBookById(id);
    }

    @Override
    public List<BookDO> getBookByParams(BookQuery bookQuery) {

        return null;
    }

}
