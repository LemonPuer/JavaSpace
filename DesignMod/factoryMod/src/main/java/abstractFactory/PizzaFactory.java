package abstractFactory;

import domain.Pizza;

/**
 * description: add a description
 *
 * @author Lemon
 * @version 1.0.0
 * @date 2024/06/02 17:25:53
 */
public interface PizzaFactory {
    public abstract Pizza createPizza(String type);
}
