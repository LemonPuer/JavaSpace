package Practice;

import JDBC_test1.JDBCUtils;
import org.junit.Test;

import java.util.List;
import java.util.Scanner;

/**
 * @author Lemon
 * @create 2022-10-12-8:03
 */
public class P_2 {
    public static void main(String[] args) {
        System.out.println("请选择您要输入的类型：\na:准考证号\nb:身份证号");
        Scanner scan = new Scanner(System.in);
        String t = scan.next();
        List list = null;
        if ("a".equals(t)) {
            System.out.println("请输入准考证号：");
            String a = scan.next();
            String sql = "select * from examstudent where ExamCard=?;";
            list = JDBCUtils.selectTable(Student.class, sql, a);
            if (list.size() > 0) {
                list.forEach(System.out::println);
            }else
                System.out.println("查无此人！请重新进入程序");
        } else if ("b".equals(t)) {
            System.out.println("请输入身份证号：");
            String b = scan.next();
            String sql = "select * from examstudent where IDCard=?;";
            list = JDBCUtils.selectTable(Student.class, sql, b);
            if (list.size() > 0) {
                list.forEach(System.out::println);
            }else
                System.out.println("查无此人！请重新进入程序");
        }else
            System.out.println("您的输入有误，请重新进入程序");
    }
    @Test
    public void test(){
        System.out.println("请输入学生考号：");
        Scanner scan=new Scanner(System.in);
        String examCard=scan.next();
        String sql= "delete from examstudent where ExamCard=?;";
        int i = P_1.updateData(sql, examCard);
        if(i>0){
            System.out.println("删除成功！");
        }else
            System.out.println("查无此人！请重新进入程序");
    }
}
