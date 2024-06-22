package d_1;

import org.junit.Test;

import java.util.*;

/**
 * @author Lemon
 * @create 2022-09-18-8:23
 */
public class CollectionTest {
    @Test
    public void Test() {
        Collection c = new ArrayList();
        c.add(234);
        List l = Arrays.asList(new String[]{"12", "AA"});
        List arr1 = Arrays.asList(new int[]{123, 456});
        System.out.println(arr1.size());//1
        List arr2 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(arr2.size());//2
        c.addAll(l);
        c.add(12);
        System.out.println(c.containsAll(l));
        c.remove("12");
//        c.removeAll(l);
        c.retainAll(l);
        System.out.println(c.contains(12));
        for (Object obj : c) {
            System.out.println(obj);
        }
        System.out.println("***********");
        for(int i=0;i<c.size();i++){
            if(c instanceof List){
                List a=(List)c;
                System.out.println(a.get(i));
            }
        }
    }
    @Test
    public void Test1(){
        List l=new LinkedList();
        l.add(123);
        List a=Arrays.asList("jom",123,"jerry",12.3);
        l.addAll(a);
        for(int i=0;i<l.size();i++){
            System.out.println(l.get(i));
        }
    }
    @Test
    public void Test2(){
        Set a=new HashSet();
        a.add("123");
        a.add(123);
        a.add(456);
        System.out.println(a);
        List b=new ArrayList();
        b.addAll(a);
        System.out.println(b);
        Iterator i=a.iterator();
        while(i.hasNext()){
            System.out.println(i.next());
        }
        System.out.println("*********");
        for(Object o:a){
            System.out.println(o);
        }
    }
}
