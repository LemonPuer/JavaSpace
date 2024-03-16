package com.example.demo9.myConfig;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/01/24 22:37:17
 */
@Slf4j
// @WebFilter("/*")
public class MyFiltter implements Filter {
    private static class MyResponseWrapper extends HttpServletResponseWrapper {
        private final MyPrintWriter myPrintWriter = new MyPrintWriter();

        public MyResponseWrapper(HttpServletResponse response) {
            super(response);
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return myPrintWriter;
        }

        public String getContent() {
            return myPrintWriter.getContent();
        }
    }

    private static class MyPrintWriter extends PrintWriter {
        private final StringBuilder content = new StringBuilder();

        public MyPrintWriter() {
            super(System.out);
        }

        @Override
        public void write(char[] buf, int off, int len) {
            content.append(buf, off, len);
            super.write(buf, off, len);
        }

        public String getContent() {
            return content.toString();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("MyFiltter doFilter");
        log.info("字符集为：{}", servletRequest.getCharacterEncoding());
        Enumeration<String> attributeNames = servletRequest.getAttributeNames();
        if (attributeNames.hasMoreElements()) {
            System.out.println(attributeNames.nextElement());
        }
        // 包装原始的 HttpServletResponse
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        MyResponseWrapper responseWrapper = new MyResponseWrapper(httpServletResponse);

        // 在调用 filterChain.doFilter 之前使用包装后的 response
        filterChain.doFilter(servletRequest, responseWrapper);

        // 获取响应体内容
        String responseBody = responseWrapper.getContent();

        // 输出修改后的响应体
        PrintWriter writer = servletResponse.getWriter();
        writer.write(responseBody);
        writer.flush();
        writer.close(); // 关闭 PrintWriter

        log.info("响应体的ContentType：{}", servletResponse.getContentType());
        log.info("MyFilter doFilter end");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
