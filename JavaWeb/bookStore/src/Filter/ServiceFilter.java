package Filter;

import DAO.JDBCUtils;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author Lemon
 * @create 2022-11-02-10:23
 */
public class ServiceFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            JDBCUtils.commit();
        }catch (Exception e){
            JDBCUtils.rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
