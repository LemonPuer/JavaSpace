package DAO.Book;

import DAO.Page.Page;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-24-10:12
 */
public interface BookDAO {
    //添加图书
    public int addBook(Book book);
    //删除图书
    public int deleteBookById(Integer id);
    //更新图书
    public int updateBook(Book book);
    //查询图书
    public Book queryBookById(Integer id);
    //查询所有图书
    public List<Book> queryBooks();
    //查询当前页码图书列表
    public List<Book> selPage(int pageNo,int allPage);
    //查询图书总数
    public int selNote();
    //根据价格查询当前页码图书列表
    public  List<Book> pageByPrice(int pageNo,int allPage,int max,int min);
    //查询当前价位图书总数
    public int notePrice(int min,int max);
}
