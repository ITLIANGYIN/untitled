package cn.jxcia.demo1;

public class BookServiceImpl implements BookService{
    private BookDao bookDao;
    private UserDao userDao;
//setter注入
//    public void setBookDao(BookDao bookDao) {
//        this.bookDao = bookDao;
//    }

//构造器注入
    public BookServiceImpl(BookDao bookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.userDao = userDao;
    }

    public void save() {
        System.out.println("book service save...");
        bookDao.save();
        userDao.save();
    }
}
