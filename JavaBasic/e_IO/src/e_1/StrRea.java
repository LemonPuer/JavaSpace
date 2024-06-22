package e_1;

import org.junit.Test;

import java.io.*;

/**
 * @author Lemon
 * @create 2022-09-23-19:27
 */
public class StrRea {
    @Test
    public void Test() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String s = null;
            System.out.println("请输入:");
            while ((s = br.readLine()) != null) {
                if ("e".equalsIgnoreCase(s) || "exit".equalsIgnoreCase(s)) {
                    System.out.println("退出");
                    break;
                }
                System.out.println(s.toUpperCase());
                System.out.println("继续输入:");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void Test1() {
        DataOutputStream dp = null;
        DataInputStream ds = null;
        String name = null;
        int age = 0;
        String like = null;
        try {
            dp = new DataOutputStream(new FileOutputStream("data.txt"));
            dp.writeUTF("李明");
            dp.writeInt(23);
            dp.writeUTF("喜欢打篮球");
            ds = new DataInputStream(new FileInputStream("data.txt"));
            name = ds.readUTF();
            age = ds.readInt();
            like = ds.readUTF();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ds != null) {
                try {
                    ds.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (dp != null) {
                try {
                    dp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("like = " + like);

    }

}
