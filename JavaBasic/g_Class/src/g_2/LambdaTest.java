package g_2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author Lemon
 * @create 2022-09-28-8:23
 */
public class LambdaTest {
    @Test
    public void Test() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("你好！");
            }
        };
        Runnable r2 = () -> System.out.println("你好！");

        Consumer<String> c1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Consumer<String> c2 = (String s) -> System.out.println(s);
        Consumer<String> c3 = (s) -> System.out.println(s);//类型推断
        Consumer<String> c4 = s -> System.out.println(s);


        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };
        Comparator<Integer> com2 = (o1, o2) -> {
            return o1.compareTo(o2);
        };
        Comparator<Integer> com3 = (o1, o2) -> o1.compareTo(o2);
    }

    @Test
public void Test1() {
    List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
    List<String> filterList1 = filter(list, new Predicate<String>() {
        @Override
        public boolean test(String s) {
            return s.contains("京");
        }
    });
    List<String> filterList2 = filter(list, s -> s.contains("京"));
    for(Object o: filterList2){
        System.out.println(o);
    }
}

public List<String> filter(List<String> list, Predicate<String> pre) {
    ArrayList<String> filterList =new ArrayList<>();
    for(String s:list){
        if(pre.test(s))
        filterList.add(s);
    }
    return filterList;
}
}
