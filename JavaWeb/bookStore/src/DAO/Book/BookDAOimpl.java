package DAO.Book;

import DAO.BaseDAO;
import DAO.Page.Page;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-24-10:15
 */
public class BookDAOimpl extends BaseDAO implements BookDAO {
    @Override
    public int addBook(Book book) {
        String sql = "insert into book(name,price,author,sales,stock,img_path) values(?,?,?,?,?,?)";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImg_path());
    }

    @Override
    public int deleteBookById(Integer id) {
        String sql = "delete from book where id=?";
        return update(sql, id);
    }

    @Override
    public int updateBook(Book book) {
        String sql = "update book set name=?,price=?,author=?,sales=?,stock=?,img_path=? where id=?";
        return update(sql, book.getName(), book.getPrice(), book.getAuthor(), book.getSales(), book.getStock(), book.getImg_path(), book.getId());
    }

    @Override
    public Book queryBookById(Integer id) {
        String sql = "select * from book where id=?";
        return selectByOne(Book.class, sql, id);
    }

    @Override
    public List<Book> queryBooks() {
        String sql = "select * from book";
        return selectFOrList(Book.class, sql);
    }

    @Override
    public List<Book> selPage(int pageNO,  int allPage) {
        pageNO = (pageNO - 1) * Page.NOTECOUNT;
        String sql = "select * from book limit ?,?";
        return selectFOrList(Book.class, sql, pageNO, Page.NOTECOUNT);
    }

    @Override
    public int selNote() {
        String sql = "select count(*) from book";
        return ((Number) singleRes(sql)).intValue();
    }

    @Override
    public List<Book> pageByPrice(int pageNO, int allPage, int max, int min) {
        pageNO = (pageNO - 1) * Page.NOTECOUNT;
        String sql = "select * from book where price between ? and ? order by price limit ?,?";
        return selectFOrList(Book.class,sql,min,max,pageNO,Page.NOTECOUNT);
    }

    @Override
    public int notePrice(int min, int max) {
        String sql = "select count(*) from book where price between ? and ?";
        return ((Number) singleRes(sql,min,max)).intValue();
    }

}
