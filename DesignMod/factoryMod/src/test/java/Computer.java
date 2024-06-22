import com.alibaba.fastjson2.JSONObject;
import lombok.Data;

import java.io.ObjectOutputStream;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/06/08 14:15:09
 */
@Data
public class Computer implements Cloneable {
    private String name;
    private String brand;
    private Screen screen;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Computer computer = (Computer) super.clone();
        computer.setScreen((Screen) screen.clone());
        return computer;
    }

    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.setName("电脑");
        computer.setBrand("联想");
        computer.setScreen(new Screen());
        computer.getScreen().setBrand("三星");
        computer.getScreen().setSize("20寸");
        System.out.println(computer);
        Computer clone = null;
        // try {
        //     clone = (Computer) computer.clone();
        // } catch (Exception e) {
        //     System.out.println(e.getMessage());
        // }
        // System.out.println(clone);
        clone = JSONObject.parseObject(JSONObject.toJSONString(computer), Computer.class);
        System.out.println(clone);
    }
}

@Data
class Screen implements Cloneable {
    private String brand;
    private String size;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}