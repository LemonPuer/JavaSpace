package arrayTest;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
/**
 * @author Lemon
 * @create 2022-12-06-10:27
 */
public class ReXiShu {
    public static void main(String[] args) {
        //从磁盘中读取稀疏数组
        Reader r;
        try {
            r = new FileReader("arrTest.txt");
            int data;
            //使用r.read(new char[1024]);会返回字符总数，这里直接估计的
            char[] c = new char[50];
            int i = 0;
            //记录行数，10号字符是换行
            int hang = 0;
            while ((data = r.read()) != -1) {
                if (data == 10) {
                    hang++;
                    continue;
                }
                c[i] = (char) data;
                i++;
            }
            //将得到的数据存放在字符串中，去掉后面的空格
            StringBuilder s = new StringBuilder(new String(c).trim());
            int arr1[][] = new int[hang][3];
            for (i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ' ' && s.charAt(i + 1) == ' ') {
                    s.delete(i, i + 1);
                }
            }
            //创建临时数组存放数据
            int opt[] = new int[3 * hang];
            int a = 0;
            int b = 0;
            for (i = 0; i < s.length(); i++) {
                //最后一个数字后没有空格，需要特殊对待
                if (a == s.length() - 1) {
                    opt[b++] = Integer.parseInt(s.substring(s.length() - 1));
                    break;
                }
                if (s.charAt(i) == ' ') {
                    //防止思路乱，可以看看循环状况
                    System.out.printf("%d %d %d\n", a, b, i);
                    opt[b++] = Integer.parseInt(s.substring(a, i));
                    a = i + 1;
                }
            }
            i=0;
            //还原稀疏数组
            for (a = 0; a < hang; a++) {
                for (b = 0; b < 3; b++) {
                 arr1[a][b]=opt[i];
                 i++;
                }
            }
            //恢复棋局
            int arr2[][]=new int[arr1[0][0]][arr1[0][1]];
            for(a=1;a< arr1.length;a++){
                    arr2[arr1[a][0]][arr1[a][1]]=arr1[a][2];
            }
            //查看器棋局
            for(int o[]:arr2){
                for(int k:o){
                    System.out.print(k+"  ");
                }
                System.out.println();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
