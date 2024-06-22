package bookStoreServlet;

import DAO.Book.Book;
import DAO.Page.Page;
import DAO.Tool;
import Service.Book.BService;
import Service.Book.BServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Lemon
 * @create 2022-10-27-16:28
 */
public class clientServlet extends baseServlet {
    protected void cPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BService bs = new BServiceImpl();
        int pageNo = Integer.parseInt(req.getParameter("pageNo"));
        Page<Book> page = bs.getPage(pageNo);
        req.setAttribute("page",page);
        req.setAttribute("url", "clientServlet?action=cPage");
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

    protected void pageByPrice(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BService bs= new BServiceImpl();
        int pageNo = Tool.parseInt(req.getParameter("pageNo"),1);
        int max = Tool.parseInt(req.getParameter("max"),Integer.MAX_VALUE);
        int min = Tool.parseInt(req.getParameter("min"),0);
        Page<Book> page = bs.getPage(pageNo, min, max);
        StringBuilder sb=new StringBuilder("clientServlet?action=pageByPrice");
        if(req.getParameter("max")!=null){
            sb.append("&max=").append(max);
        }
        if(req.getParameter("min")!=null){
            sb.append("&min=").append(min);
        }
        req.setAttribute("page",page);
        req.setAttribute("url",sb.toString());
        req.getRequestDispatcher("/pages/client/index.jsp").forward(req, resp);
    }

}
