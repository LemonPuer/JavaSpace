package d_exer;

import org.junit.Test;

import java.util.*;

/**
 *1.请从键盘随机输入10个整数保存到List中，并按倒序、从大到小的顺序显示出来
 *  @author Lemon
 * @create 2022-09-19-20:59
 */
public class StudentTest {
    @Test
    public void Test() {
        Scanner scan = new Scanner(System.in);
        int a;
        List list = new ArrayList();
//        int[] b=new int[10];
//        System.out.println("请输入十个整数");
//        for (int i = 0; i < b.length; i++) {
//            a = scan.nextInt();
//            b[i]=a;
//        }
//        Arrays.sort(b);
//        for (int i =b.length; i >0; i--) {
//            list.add(b[i-1]);
//        }
        //使用工具类Collections
        for (int i = 0; i < 10; i++) {
            System.out.println("请输入十个整数");
            a = scan.nextInt();
            list.add(a);
        }
        Collections.sort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Integer && o2 instanceof Integer) {
                    Integer a = (Integer) o1;
                    Integer b = (Integer) o2;
                    return -a.compareTo(b);
                }
                throw new RuntimeException("数据格式不符合");
            }
        });
        for (Object o : list) {
            System.out.println(o);
        }
    }
/**
 *2.请把学生名与考试分数录入到集合中，并按分数显示前三名成绩学员的名字。
 * @author: Lemon
 * @create: 2022/9/20-9:56
*/
    @Test
    public void Test2() {
        Scanner scan = new Scanner(System.in);
        int b;
        String a;
        Set set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Student && o2 instanceof Student) {
                    Student a = (Student) o1;
                    Student b = (Student) o2;
                    if (a.getScore() > b.getScore()) {
                        return -1;
                    } else if (a.getScore() == b.getScore()){
                        return 0;
                    }else
                        return 1;
                }
                throw new RuntimeException("数据不匹配");
            }
        });
        for (int i = 0; i < 5; i++) {
            System.out.println("请输入学生姓名：");
            a = scan.next();
            System.out.println("请输入学生成绩：");
            b = scan.nextInt();
            set.add(new Student(a, b));
        }
        int i=0;
        for(Object o:set){
            System.out.println(o);
            if(i==2)
                break;
            i++;
        }

    }

    class Student {
        private String name;
        private int score;

        public Student() {
        }

        public Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", score=" + score +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return score == student.score && Objects.equals(name, student.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, score);
        }
    }
}