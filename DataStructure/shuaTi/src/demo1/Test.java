package demo1;

import java.util.List;
import java.util.UUID;

/**
 * @author Lemon
 * @create 2023-05-05-15:15
 */
public class Test {
    public static void main(String[] args) {
        List list1=null;
        List list2=null;
        System.out.println(list1==list2);//对
        //System.out.println(list1.equals(list2));//异常
        //System.out.println(UUID.randomUUID());
        System.out.println((byte)Integer.parseInt(new String("11111100"), 2));
        byte a=97;
        System.out.println((char)a);
        System.out.println(Integer.toBinaryString(28));

    }
}
