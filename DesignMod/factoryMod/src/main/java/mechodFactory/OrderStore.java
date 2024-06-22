package mechodFactory;

import domain.Pizza;

import java.util.Scanner;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/06/02 17:42:38
 */
public abstract class OrderStore {
    abstract Pizza orderPizza(String type);

    public OrderStore() {
        Pizza pizza;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入订购的披萨名");
        do {
            pizza = orderPizza(scanner.nextLine());
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
        } while (true);
    }
}
