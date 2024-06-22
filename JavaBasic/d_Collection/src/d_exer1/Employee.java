package d_exer1;

/**
 * @author Lemon
 * @create 2022-09-21-10:05
 */
public class Employee implements Comparable<Employee>{
    private String name;
    private int age;
    private MyDate brithday;

    public Employee() {
    }

    public Employee(String name, int age, MyDate brithday) {
        this.name = name;
        this.age = age;
        this.brithday = brithday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBrithday() {
        return brithday;
    }

    public void setBrithday(MyDate brithday) {
        this.brithday = brithday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", brithday=" + brithday +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.name);
    }
}
