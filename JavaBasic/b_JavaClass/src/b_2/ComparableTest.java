package b_2;

import org.junit.Test;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Lemon
 * @create 2022-09-09-22:16
 */
public class ComparableTest {
    @Test
    public void Test() {
        A[] a = new A[3];
        a[0] = new A(12, "d");
        a[1] = new A(25, "c");
        a[2] = new A(12, "a");
        Arrays.sort(a);
//        for(int i=0;i<a.length;i++){
//            System.out.println(a[i]);
//        }
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void Test1() {
        A[] a = new A[3];
        a[0] = new A(12, "d");
        a[1] = new A(25, "c");
        a[2] = new A(12, "a");
        Arrays.sort(a, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {//按照价格从高到低排序
                if(o1 instanceof A && o2 instanceof A){
                    A a= (A) o1;
                    A b= (A) o2;
                    if(a.getPrice()>b.getPrice()){
                        return -1;
                    }else if(a.getPrice()==b.getPrice()){//按照名字从高到低排序
                        return -a.getName().compareTo(b.getName());
                    }else
                        return 1;
                }
                throw new RuntimeException("不属于商品类型");
            }
        });
        System.out.println(Arrays.toString(a));
    }
}

class A implements Comparable {
    private int price;
    private String name;

    public A(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "A{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof A) {
            A a = (A) o;
            if (this.price > a.price) {
                return 1;
            } else if (this.price == a.price) {
                return this.name.compareTo(a.name);
            } else
                return -1;
        } else
            throw new RuntimeException("不属于商品类型");
    }

}