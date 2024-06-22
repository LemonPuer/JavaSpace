package e_1;

import org.junit.Test;

import java.io.*;
import java.util.*;

/**
 * @author Lemon
 * @create 2022-09-22-22:19
 */
public class InOutTest {
    /**
     * 实现图片加密操作。
     *
     * @author: Lemon
     * @create: 2022/9/22-22:36
     */
    @Test
    public void Test() {
        Secret("1.png", "2.png");
        System.out.println("加密完成");
        Secret("2.png", "3.png");
        System.out.println("解密完成");

        File file = new File("2.png");
        if (file.exists())
            file.delete();
        new File("3.png").renameTo(file);
    }

    public void Secret(String org, String des) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File(org)));
            bos = new BufferedOutputStream(new FileOutputStream(new File(des)));
            byte[] a = new byte[1024];
            int b;
            while ((b = bis.read(a)) != -1) {
                for (int i = 0; i < b; i++) {
                    a[i] = (byte) (a[i] ^ 5);
                }
                bos.write(a, 0, b);
            }
//            System.out.println("加密完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 获取文本上每个字符出现的次数
     *
     * @author: Lemon
     * @create: 2022/9/22-22:58
     */
    @Test
    public void Test1() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader("dbcp.txt");
            fw = new FileWriter("dbcp1.txt");
            int b, d;
            Map<Character, Integer> c = new HashMap<>();
            while ((b = fr.read()) != -1) {
                if (c.containsKey((char) b)) {
                    d = c.get((char) b);
                    c.put((char) b, ++d);
                    continue;
                }
                c.put((char) b, 1);
            }
            Set<Map.Entry<Character, Integer>> es = c.entrySet();
            Iterator<Map.Entry<Character, Integer>> iterator = es.iterator();
            while (iterator.hasNext()) {
                Map.Entry<Character, Integer> me = iterator.next();
//                System.out.println(me.getKey() + "---->" + me.getValue());
                switch (me.getKey()) {
                    case ' ':
                        fw.write("空格--->" + me.getValue());
                        break;
                    case '\t':
                        fw.write("tab--->" + me.getValue());
                        break;
                    case '\n':
                        fw.write("换行--->"+me.getValue());
                        break;
                    case '\r':
                        fw.write("回车--->"+me.getValue());
                        break;
                    default:
                        fw.write(me.getKey()+"--->"+me.getValue());
                }
                fw.write("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
