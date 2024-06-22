package d_exer1;

import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Lemon
 * @create 2022-09-21-10:24
 */
public class EmployeeTest {
    @Test
    public void Test(){
        Employee[] e=new Employee[5];
        e[0]=new Employee("liming",32,new MyDate(1995,2,12));
        e[4]=new Employee("zhangming",35,new MyDate(1985,6,23));
        e[2]=new Employee("wangming",42,new MyDate(1985,8,22));
        e[3]=new Employee("liuming",29,new MyDate(1991,3,2));
        e[1]=new Employee("lihua",38,new MyDate(1996,4,15));
        Set<Employee> s = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int a=o1.getBrithday().getYear()-o2.getBrithday().getYear();
                int b=o1.getBrithday().getMouth()-o2.getBrithday().getMouth();
                int c=o1.getBrithday().getDay()-o2.getBrithday().getDay();
                if(a!=0){
                    return a;
                }else if(b!=0){
                    return b;
                }else if(c!=0){
                    return c;
                }
                return 0;
            }
        });
        for(int i=0;i<e.length;i++){
            s.add(e[i]);
        }
        for(Employee a:s){
            System.out.println(a);
        }
    }
}
