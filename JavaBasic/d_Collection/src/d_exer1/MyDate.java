package d_exer1;

/**
 * @author Lemon
 * @create 2022-09-21-10:06
 */
public class MyDate {
    private int year;
    private int mouth;
    private int day;

    public MyDate() {
    }

    public MyDate(int year, int mouth, int day) {
        this.year = year;
        this.mouth = mouth;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMouth() {
        return mouth;
    }

    public void setMouth(int mouth) {
        this.mouth = mouth;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", mouth=" + mouth +
                ", day=" + day +
                '}';
    }
}
