import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Lemon
 * @create 2022-11-13-16:22
 */
public class myAjaxServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1.由于请求体数据有可能很大，所以Servlet标准在设计API的时候要求我们通过输入流来读取
        BufferedReader reader = req.getReader();

        // 2.创建StringBuilder对象来累加存储从请求体中读取到的每一行
        StringBuilder builder = new StringBuilder();

        // 3.声明临时变量
        String bufferStr = null;

        // 4.循环读取
        while((bufferStr = reader.readLine()) != null) {
            builder.append(bufferStr);
        }

        // 5.关闭流
        reader.close();

        // 6.累加的结果就是整个请求体
        String requestBody = builder.toString();
        System.out.println(requestBody);
    }
}
