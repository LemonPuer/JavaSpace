package test;

import DAO.Book.Book;
import DAO.Page.Page;
import Service.Book.BService;
import Service.Book.BServiceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Lemon
 * @create 2022-10-30-10:24
 */
public class BServiceImplTest {
    BService bs=new BServiceImpl();
    @Test
    public void getPage() {
        Page<Book> page = bs.getPage(1);
        System.out.println(page);
    }

    @Test
    public void testGetPage() {
        Page<Book> page = bs.getPage(1, 10, 50);
        System.out.println(page);
    }
}