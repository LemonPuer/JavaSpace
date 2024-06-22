package f_1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author Lemon
 * @create 2022-09-24-16:50
 */
public class inetTest {
    @Test
    public void Test() {
        InetAddress inet = null;
        InetAddress inet1 = null;
        try {
            inet = InetAddress.getLocalHost();
            System.out.println(inet);
            System.out.println(inet.getHostAddress());
            System.out.println(inet.getHostName());
            inet1 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet1);
            System.out.println(inet1.getHostAddress());
            System.out.println(inet1.getHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

@Test
public void Test1() {
    Socket desk = null;
    OutputStream out = null;
    BufferedInputStream bs = null;
    InputStreamReader isr=null;
    try {
        desk = new Socket("169.254.52.166", 8848);
        out = desk.getOutputStream();
        bs = new BufferedInputStream(new FileInputStream("H:\\workspace\\workspace_idea\\e_IO\\1.png"));
        byte[] picture = new byte[5];
        int len;
        while ((len = bs.read(picture)) != -1) {
            out.write(picture, 0, len);
        }
        System.out.println("发送成功！");
        desk.shutdownOutput();
        //不推荐，当数组picture一次装不下，会出现乱码
//            while ((len = desk.getInputStream().read(picture)) != -1) {
//                System.out.println(new String(picture, 0, len));
//            }
        isr = new InputStreamReader(desk.getInputStream());
        char[] get = new char[5];
        while((len = isr.read(get))!=-1){
            System.out.print(new String(get,0,len));
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (bs != null) {
            try {
                bs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (desk != null) {
            try {
                desk.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(isr!=null){
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
@Test
public void Test2() {
    ServerSocket ss = null;
    Socket s = null;
    InputStream in = null;
    BufferedOutputStream bs = null;
    try {
        ss = new ServerSocket(8848);
        s = ss.accept();
        in = s.getInputStream();
        bs = new BufferedOutputStream(new FileOutputStream("1.png"));
        byte[] picture = new byte[1024];
        int len;
        while ((len = in.read(picture)) != -1) {
            bs.write(picture, 0, len);
        }
        System.out.println("接收完成！");
        s.getOutputStream().write("断开连接。。。".getBytes());
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (bs != null) {
            try {
                bs.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (s != null) {
            try {
                s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (ss != null) {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
}
