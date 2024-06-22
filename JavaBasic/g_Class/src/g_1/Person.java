package g_1;

/**
 * @author Lemon
 * @create 2022-09-26-21:37
 */
public class Person extends Animal<String> implements Comparable<Integer>{
    private String name;
    int age;
    public int id;

    public Person() {
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }
    private void show(){
        System.out.println("I am a person");
    }
    public String country(String c){
        System.out.println("I am "+c);
        return c;
    }
    public static void showDesc(){
        System.out.println("My life is filled with work !");
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", ID=" + id +
                '}';
    }


    @Override
    public int compareTo(Integer o) {
        return 0;
    }
}
class Animal<T>{

}