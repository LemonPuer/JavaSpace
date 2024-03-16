package arrayTest;

import java.io.*;

/**
 * @author Lemon
 * @create 2022-12-06-9:17
 */
public class XiShu {
    public static void main(String[] args) {
        //创建原始数组棋盘
        //0：无子；1：黑子；2：白子
        int arr1[][] = new int[11][11];
        arr1[1][3] = 1;
        arr1[3][6] = 2;
        arr1[1][4] = 1;
        //查看棋盘
        for (int a[] : arr1) {
            for (int b : a) {
                System.out.printf("%d  ", b);
            }
            System.out.println();
        }
        //获取非0数据的个数，别使用字符串获取数据，到时还得遍历字符串，得不偿失
        int sum = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //创建稀疏数组
        int arr2[][] = new int[sum + 1][3];
        arr2[0][0] = arr1.length;
        arr2[0][1] = arr1[0].length;
        arr2[0][2] = sum;
        //遍历二维数组，将非0的值存入稀疏数组
        int x = 0;//用于记录第几个非零数据
        for (int i = 1; i < arr1.length; i++) {
            for (int j = 0; j < arr1[0].length; j++) {
                if (arr1[i][j] != 0) {
                    x++;
                    arr2[x][0] = i;
                    arr2[x][1] = j;
                    arr2[x][2] = arr1[i][j];
                }
            }
        }
        //将稀疏数组存入磁盘
        FileWriter fw;
        try {
            fw = new FileWriter("arrTest.txt");
            for (int a[] : arr2) {
                for (int b : a)
                    fw.write(b + "  ");
                fw.write("\n");
            }
            fw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
