package d_exer;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Lemon
 * @create 2022-09-18-20:09
 */
public class TreeSetTest {
    public static void main(String[] arg) {
        Employee a = new Employee("李明", 32, new MyDate(1990, 8, 16));
        Employee b = new Employee("李四", 39, new MyDate(1983, 9, 21));
        Employee c = new Employee("张三", 28, new MyDate(1950, 2, 21));
        Employee d = new Employee("王五", 35, new MyDate(1950, 2, 28));
        Employee e = new Employee("赵六", 26, new MyDate(1960, 7, 19));
        Set s = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Employee && o2 instanceof Employee) {
                    Employee a = (Employee) o1;
                    Employee b = (Employee) o2;
                    int y = a.getBirthday().getYear() - b.getBirthday().getYear();
                    int m = a.getBirthday().getMonth() - b.getBirthday().getMonth();
                    int d = a.getBirthday().getDay() - b.getBirthday().getDay();
                    if (y != 0) {
                        return y;
                    } else if (m != 0) {
                        return m;
                    } else if(d != 0) {
                        return d;
                    }
                    return 0;
                } else {
                    throw new RuntimeException("雇员不存在");
                }
            }
        });
        s.add(a);
        s.add(b);
        s.add(c);
        s.add(d);
        s.add(e);
        for (Object o : s) {
            System.out.println(o);
        }
    }
}
