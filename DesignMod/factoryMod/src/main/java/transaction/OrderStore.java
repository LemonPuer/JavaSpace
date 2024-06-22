package transaction;

import domain.Pizza;

import java.util.Scanner;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/06/02 16:31:09
 */
public class OrderStore {
    private abstractFactory.PizzaFactory pizzaFactory;

    public OrderStore() {
        Pizza pizza;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入订购的披萨名");
        do {
            // String s = scanner.nextLine();
            // if (s.equalsIgnoreCase("liulian")) {
            //     pizza = new LiuLianPizza();
            // } else if (s.equalsIgnoreCase("zhishi")) {
            //     pizza = new ZhiShiPizza();
            // } else {
            //     System.out.println("不存在该类型披萨！");
            //     break;
            // }
            pizza = PizzaFactory.createPizza(scanner.nextLine());
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }

    public OrderStore(abstractFactory.PizzaFactory pizzaFactory){
        Pizza pizza;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入订购的披萨名");
        do {
            pizza = pizzaFactory.createPizza(scanner.nextLine());
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }
}
