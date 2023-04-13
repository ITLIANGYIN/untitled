package cn.jxcia.service.impl;

import cn.jxcia.dao.BookDao;
import cn.jxcia.dao.impl.BookDaoImpl;
import cn.jxcia.service.BookService;

public class BookServiceImpl implements BookService {
//    private BookDao bookDao=new BookDaoImpl();
    private  BookDao bookDao;

    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    public void save() {
        System.out.println("book service save");
        bookDao.save();
    }
}
