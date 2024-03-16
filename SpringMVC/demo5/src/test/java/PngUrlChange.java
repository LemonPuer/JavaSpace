import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2023/11/27 21:23:08
 */
public class PngUrlChange {
    public static void main(String[] args) throws Exception {
        // RestTemplate restTemplate = new RestTemplate();
        // MultipartFile file = restTemplate.getForObject("https://seazean.oss-cn-beijing.aliyuncs.com/img/Java/NIO-Selector.png", MultipartFile.class);
        URL url = new URL("https://seazean.oss-cn-beijing.aliyuncs.com/img/Java/NIO-Selector.png");
        // 打开URL连接
        URLConnection connection = url.openConnection();

        // 获取输入流
        try (InputStream inputStream = connection.getInputStream()) {
            int byteLength;
            byte[] buffer = new byte[1024];
            int totalBytes = 0;

            // 读取字节并计算总字节长度
            while ((byteLength = inputStream.read(buffer)) != -1) {
                totalBytes += byteLength;
            }

            // 输出字节长度
            System.out.println("字节长度: " + totalBytes);
        }
    }
}
