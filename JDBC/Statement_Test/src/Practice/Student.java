package Practice;

/**
 * @author Lemon
 * @create 2022-10-12-8:24
 */
public class Student {
    private int FlowID;
    private int Type;
    private String IDCard;
    private String ExamCard;
    private String StudentName;
    private String Location ;
    private int Grade;

    @Override
    public String toString() {
        return  "流水号：" + FlowID +"\n"+
                "四级/六级：" + Type +"\n"+
                "身份证号：'" + IDCard + '\'' +"\n"+
                "准考证号：'" + ExamCard + '\'' +"\n"+
                "学生姓名：'" + StudentName + '\'' +"\n"+
                "区域：'" + Location + '\'' +"\n"+
                "成绩：" + Grade;
    }
}
