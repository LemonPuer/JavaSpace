package Service.Book;

import DAO.Book.Book;
import DAO.Book.BookDAO;
import DAO.Book.BookDAOimpl;
import DAO.Page.Page;

import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-26-11:46
 */
public class BServiceImpl implements BService {
    private BookDAO bookDao = new BookDAOimpl();

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBookById(Integer id) {
        return bookDao.deleteBookById(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }

    @Override
    public int allPage() {
        int allNote = bookDao.selNote();
        if (allNote % Page.NOTECOUNT > 0)
            return allNote / Page.NOTECOUNT + 1;
        return allNote / Page.NOTECOUNT;
    }

    @Override
    public Page<Book> getPage(int pageNo) {
        Page<Book> page = new Page<>();
        page.setAllNote(bookDao.selNote());
        content(pageNo, page);
        page.setNoteData(bookDao.selPage(page.getPageNo(), page.getAllPage()));
        return page;
    }

    @Override
    public Page<Book> getPage(int pageNo, int min, int max) {
        Page<Book> page = new Page<>();
        page.setAllNote(bookDao.notePrice(min, max));
        content(pageNo, page);
        page.setNoteData(bookDao.pageByPrice(page.getPageNo(), page.getAllPage(), max, min));
        return page;
    }

    private void content(int pageNo, Page<Book> page) {
        if (page.getAllNote() % page.getNote() > 0) {
            page.setAllPage(page.getAllNote() / page.getNote() + 1);
        } else
            page.setAllPage(page.getAllNote() / page.getNote());
        if (pageNo > page.getAllPage()) {
            pageNo = page.getAllPage();
        } else if (pageNo < 1) {
            pageNo = 1;
        }
        page.setPageNo(pageNo);
    }
}
