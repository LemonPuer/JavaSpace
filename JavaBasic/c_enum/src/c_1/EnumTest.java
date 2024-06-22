package c_1;

import org.junit.Test;

/**
 * @author Lemon
 * @create 2022-09-11-21:44
 */
public class EnumTest {
    @Test
    public void Test(){
        Season a = Season.SPRING;
        System.out.println(a);
        Season1 b = Season1.SPRING;
        System.out.println(b);
    }
}

class Season {
    private final String season;
    private final String discrab;

    private Season(String season, String discrab) {
        this.season = season;
        this.discrab = discrab;
    }

    public static final Season SPRING = new Season("春天", "春暖花开");
    public static final Season SUMMER = new Season("夏天", "夏日炎炎");
    public static final Season AUTUMN = new Season("秋天", "秋高气爽");
    public static final Season WINTER = new Season("冬天", "冬山如睡");

    public String getSeason() {
        return season;
    }

    public String getDiscrab() {
        return discrab;
    }

//    @Override
//    public String toString() {
//        return "Season{" +
//                "season='" + season + '\'' +
//                ", discrab='" + discrab + '\'' +
//                '}';
//    }
}
enum Season1{
    SPRING("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","冰天雪地");
    private String name;
    private String dis;
    private Season1(String name,String dis){
        this.name=name;
        this.dis=dis;
    }
}