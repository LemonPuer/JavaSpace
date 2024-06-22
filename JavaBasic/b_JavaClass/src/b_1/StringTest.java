package b_1;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author Lemon
 * @Description
 * @create 2022-09-06-10:13
 */
public class StringTest {
    @Test
    public void Test8() {
        String a = "123";
        String b = "123";
        String c = new String("123");
        String d = new String("123");
        System.out.println(a.equals(b));
        System.out.println(a == b);
        System.out.println(c.equals(d));
        System.out.println(c == d);
        System.out.println(a.equals(c));
        System.out.println(a == c);
    }

    @Test
    public void Test7() {
//        String str = null;
//        System.out.println(str);
        String str = "";
        System.out.println(str);
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());
        System.out.println(sb);
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);
    }

    @Test
    //String类型转换练习
    public void Test6() {
        String a = "123456";
        char[] b = new char[5];
        b[0] = '0';
        b[1] = '5';
        a.getChars(1, 5, b, 1);
        System.out.println(b);
        char[] arr2 = new char[]{'1', '2', '3', '4', '5'};
        String str3 = new String(arr2, 3, 1);//"2"
        System.out.println(str3);
    }

    @Test
    //StringBuilder的练习
    public void Test5() {
        StringBuilder a = new StringBuilder("ajfsdf");
        a.append(123);
        System.out.println(a);
        a.append('1');
        System.out.println(a);
        a.append("123");
        System.out.println(a);

        String b = "hello";
        String c = "helloworld";
        b += "world";
        System.out.println(b == c);
    }

    //    5.对字符串中字符进行自然顺序排序。
//    提示：
//            1）字符串变成字符数组。
//            2）对数组排序，选择，冒泡，Arrays.sort();
//            3）将排序后的数组变成字符串。
    @Test
    public void Test4() {
        String a = "klajlfkj中国";
        char[] b = a.toCharArray();
        Arrays.sort(b);
        System.out.println(new String(b));
    }

    //    4.获取两个字符串中最大相同子串。比如：str1 = "abcwerthelloyuiodef";str2 = "cvhellobnm"
//    提示：将短的那个串进行长度依次递减的子串与较长的串比较。
    @Test
    public void Test3() {
        String a = "abcwerthelloyuiodef";
        String b = "cvhellobnm";
//        String a = "abcd";
//        String b = "cxd";
        System.out.println(sameString(a, b));
    }
    public String sameString(String a, String b){
//        String c = null;
//        String d = null;
//        String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。
        for (int i = a.length(); i > 0; i--) {
            if (i == a.length()) {
                if (a.length() > b.length()) {
                    i = b.length();
                }
            }
            //方式一：
//            for (int j = 0; j < a.length() - i + 1; j++) {
//                c = a.substring(j, j + i);
//                for (int k = 0; k < b.length() - i + 1; k++) {
//                    d = b.substring(k, k + i);
//                    if (d.equals(c)) {
//                        return d;
//                    }
//                }
//            }
            //方式二：
                for (int j = 0; j < b.length() - i + 1; j++) {
                    if (a.contains(b.substring(j, i))) {
                        return b.substring(j, i);
                    }
                }
        }
        return "no find";
    }

    @Test
//    3.获取一个字符串在另一个字符串中出现的次数。比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
    public void Test2() {
        String a = "abkkcadkabkebfkabkskab";
        System.out.println(a.length());
//        System.out.println(a.indexOf("ab"));
//        System.out.println(a.indexOf("ab",0));//0,8,15,20
        System.out.println(Time(a, "ab"));
    }

    public int Time(String a, String b) {
        char[] c = a.toCharArray();
//        System.out.println(c.length);
        int i = 0, j = 0;
        while (i < c.length) {
            if (a.indexOf(b, i) < 0) {
                break;
            }
            i = a.indexOf(b, i);
            i++;//优化：i+=b.length();
            j++;
        }
        return j;
    }

    @Test
//    2.将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反 转为”abfedcg” 2 5
    public void Test1() {
        String a = "abcdefg";
        String b = changeString(a, 2, 5);
        System.out.println(b);
    }

    public String changeString(String a, int top, int last) {
        char[] b = a.toCharArray();
        char c = ' ';
        while (top < last) {
            c = b[top];
            b[top++] = b[last];
            b[last--] = c;
        }
        return new String(b);
    }

    @Test
    //1.模拟一个trim方法，去除字符串两端的空格。
    public void Test0() {
        String a = "  hel  lo   wo  rl d  ";
        char c = ' ';
//        String b=a.trim();
        String b = trimMethods(a);
        System.out.println(b);
    }

    public String trimMethods(String a) {
        char[] b = a.toCharArray();
        int j = b.length - 1;
        while (b[0] == ' ') {
            for (int i = 0; i < b.length - 1; i++) {
                b[i] = b[i + 1];
            }
        }
        while (b[j] == ' ') {
            j--;
        }
        char[] c = new char[j + 1];
        for (int i = 0; i < j + 1; i++) {
            c[i] = b[i];
        }
        return new String(c);
    }
}
