package com.jin.dao;

import com.jin.entity.DO.BookDO;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao extends CrudRepository<BookDO, Integer>,JpaSpecificationExecutor {

    BookDO getBookById(int id);
}
