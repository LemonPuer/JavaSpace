package bookStoreServlet;

import DAO.Book.Book;
import DAO.Book.BookDAOimpl;
import DAO.Page.Page;
import Service.Book.BService;
import Service.Book.BServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author Lemon
 * @create 2022-10-24-11:04
 */
public class bookServlet extends baseServlet{
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        BService bs=new BServiceImpl();
        bs.deleteBookById(Integer.parseInt(id));
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        Page<Book> page = bs.getPage(pageNo);
        if(page.getPageNo()>page.getAllPage()){
            page.setPageNo(page.getAllPage());
        }
        resp.sendRedirect("/bookStore/bookServlet?action=selPage&pageNo="+page.getPageNo());
    }
    public void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BService bs=new BServiceImpl();
        Book book=new Book();
        try {
            BeanUtils.copyProperties(book,req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        bs.updateBook(book);
        String pageNo = req.getParameter("pageNo");
        resp.sendRedirect("/bookStore/bookServlet?action=selPage&pageNo="+pageNo);
    }
    public void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BService bs=new BServiceImpl();
        Book book=new Book();
        try {
            BeanUtils.copyProperties(book,req.getParameterMap());
        } catch (Exception e) {
            e.printStackTrace();
        }
        bs.addBook(book);
        req.setAttribute("book",book);
        int allPage = bs.allPage();
        resp.sendRedirect("/bookStore/bookServlet?action=selPage&pageNo="+allPage);
    }
    public void findBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        BService bs=new BServiceImpl();
        Book book = bs.queryBookById(Integer.parseInt(id));
        req.setAttribute("book",book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);
    }
    public void select(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BService bs=new BServiceImpl();
        List<Book> books = bs.queryBooks();
        req.setAttribute("books",books);
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
    public void selPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BService bs=new BServiceImpl();
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        Page<Book> page = bs.getPage(pageNo);
        req.setAttribute("page",page);
        req.setAttribute("url", "bookServlet?action=selPage");
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }
}
