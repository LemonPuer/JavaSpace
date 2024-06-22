package abstractFactory;

import domain.NaiLaoPizza;
import domain.Pizza;
import domain.ZhiShiPizza;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/06/02 17:32:06
 */
public class EnglandPizzaFactory implements PizzaFactory {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza;
        if (type.equalsIgnoreCase("nailao")) {
            pizza = new NaiLaoPizza();
        } else if (type.equalsIgnoreCase("zhishi")) {
            pizza = new ZhiShiPizza();
        } else {
            throw new RuntimeException("英国不提供该类型披萨！");
        }
        return pizza;
    }
}
