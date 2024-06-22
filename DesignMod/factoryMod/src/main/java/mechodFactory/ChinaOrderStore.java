package mechodFactory;

import domain.LiuLianPizza;
import domain.Pizza;
import domain.ZhiShiPizza;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/06/02 17:47:37
 */
public class ChinaOrderStore extends OrderStore {
    @Override
    Pizza orderPizza(String type) {
        Pizza pizza;
        if (type.equalsIgnoreCase("liulian")) {
            pizza = new LiuLianPizza();
        } else if (type.equalsIgnoreCase("zhishi")) {
            pizza = new ZhiShiPizza();
        } else {
            throw new RuntimeException("中国不存在该类型披萨！");
        }
        return pizza;
    }
}
