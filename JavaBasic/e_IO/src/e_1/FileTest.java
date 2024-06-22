package e_1;

import org.junit.Test;

import java.io.*;
import java.util.List;

/**
 * @author Lemon
 * @create 2022-09-21-18:56
 */
public class FileTest {
    @Test
    public void Test() {
        File file1 = new File("D:\\Java\\Test\\hello.txt");
        File file2 = new File("D:\\Java\\Test");
        file2.mkdirs();
        try {
            boolean b = file1.createNewFile();
            if (b) {
                System.out.println("创建成功!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        File[] filelist = file2.listFiles();
        for(Object o:filelist){
            System.out.println(o);
        }
        file1.delete();
        filelist=file2.listFiles();
        for(Object o:filelist){
            System.out.println(o);
        }
        file2.delete();
    }
    @Test
    public void Test1(){
        Integer a=5;
        System.out.println(a);
        List<Object> list1 = null;
        List<String> list2 = null;
        //list1 = list2;
        File file=new File("1.png");
        System.out.println(file.getAbsolutePath());
    }
    /**
     *分别使用节点流：FileInputStream、FileOutputStream和缓冲流：
     * BufferedInputStream、BufferedOutputStream实现文本文件/图片/视频文件的
     * 复制。并比较二者在数据复制方面的效率
     * @author: Lemon
     * @create: 2022/9/22-22:36
    */
    @Test
    public void Test2(){
        long start =System.currentTimeMillis();
        FileInOut("1.png","2.png");
        long end =System.currentTimeMillis();
        System.out.println("运行时间为："+(end-start));
        System.out.println("************");
        start=System.currentTimeMillis();
        BufferInOut("1.png","2.png");
        end=System.currentTimeMillis();
        System.out.println("运行时间为："+(end-start));
        System.out.println("************");
        start =System.currentTimeMillis();
        FileInOut("p3.flv","p1.flv");
        end =System.currentTimeMillis();
        System.out.println("运行时间为："+(end-start));
        System.out.println("************");
        start=System.currentTimeMillis();
        BufferInOut("p3.flv","p1.flv");
        end=System.currentTimeMillis();
        System.out.println("运行时间为："+(end-start));
        File file=new File("2.png");
        if(file.exists()){
            file.delete();
        }
        file=new File("p1.flv");
        if(file.exists()){
            file.delete();
        }

    }
    public static  void BufferInOut(String org,String des){
        BufferedInputStream bis = null;
        BufferedOutputStream bos= null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File(org)));
            bos = new BufferedOutputStream(new FileOutputStream(new File(des)));
            byte[] a=new byte[1024];
            int b;
            while((b=bis.read(a))!=-1){
                bos.write(a,0,b);
            }
            System.out.println("复制完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void FileInOut(String org,String des){
        FileInputStream file1 = null;
        FileOutputStream file2= null;
        try {
            file1 = new FileInputStream(new File(org));
            file2 = new FileOutputStream(new File(des));
            byte[] a=new byte[1024];
            int b;
            while((b=file1.read(a))!=-1){
                file2.write(a,0,b);
            }
            System.out.println("复制成功");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(file1!=null){
                try {
                    file1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(file2!=null){
                    try {
                        file2.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
