package Service.Book;

import DAO.Book.Book;
import DAO.Page.Page;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-26-11:43
 */
public interface BService {
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
    //查询所有页数
    public int allPage();
    //根据页码返回page实例
    public Page<Book> getPage(int pageNo);
    //根据价格区间和页码返回page实例
    public Page<Book> getPage(int pageNo,int min,int max);
}
