package g_2;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Lemon
 * @create 2022-10-08-20:08
 */
public class draft_test {
    @Test
    public void test1(){
        Set<Integer> set=new HashSet();
        set.add(1);
        set.add(2);
        set.add(3);
        for(Integer i:set){
            System.out.println(i);
        }
    }
    @Test
    public void test2(){
        int[] num=new int[]{16,5,91,75,13,26,15,18,6,13,16};
        Set<Integer> set=new HashSet();
        for(Integer i:num){
            set.add(i);
        }
        int[] num1=new int[set.size()];
        int j=0;
        for(Integer i:set) {
            num1[j] = i;
            j++;
        }
        Arrays.sort(num1);
        for(Object o:num1){
            System.out.println(o);
        }
    }
}
