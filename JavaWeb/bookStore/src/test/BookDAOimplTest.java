package test;

import DAO.Book.Book;
import DAO.Book.BookDAOimpl;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author Lemon
 * @create 2022-10-24-10:47
 */
public class BookDAOimplTest {
    private BookDAOimpl bdi=new BookDAOimpl();
    @Test
    public void addBook() {
        int i = bdi.addBook(new Book(0,"1001", new BigDecimal(15), "1", 200, 200, null));
        System.out.println(i);
    }

    @Test
    public void deleteBookById() {
        System.out.println(bdi.deleteBookById(22));
    }

    @Test
    public void updateBook() {
        bdi.updateBook(new Book(22,"1002", new BigDecimal(15), "1", 200, 200, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bdi.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for(Object o:bdi.queryBooks()){
            System.out.println(o);
        }
    }
    @Test
    public void selNOte(){
        System.out.println(bdi.selNote());
    }
    @Test
    public void test(){
        BigDecimal a=new BigDecimal(0);
        a=a.add(new BigDecimal(5));
        System.out.println(a);
    }
}