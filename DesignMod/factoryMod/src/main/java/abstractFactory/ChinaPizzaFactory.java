package abstractFactory;

import domain.LiuLianPizza;
import domain.Pizza;
import domain.ZhiShiPizza;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/06/02 17:28:27
 */
public class ChinaPizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza;
        if (type.equalsIgnoreCase("liulian")) {
            pizza = new LiuLianPizza();
        } else if (type.equalsIgnoreCase("zhishi")) {
            pizza = new ZhiShiPizza();
        } else {
            throw new RuntimeException("中国不提供该类型披萨！");
        }
        return pizza;
    }
}
