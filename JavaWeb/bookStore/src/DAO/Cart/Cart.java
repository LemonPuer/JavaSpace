package DAO.Cart;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Lemon
 * @create 2022-10-30-19:27
 */
public class Cart {
    //商品总量
    private int allCount;
    //商品总价
    private BigDecimal allPrice;
    //商品内容,这里使用LinkedHashMap是为了能以添加顺序遍历
    private Map<Integer, CartItem> items = new LinkedHashMap<>();

    public Cart() {
    }

    //添加购物车
    public void addItem(CartItem item) {
        CartItem cartItem = items.get(item.getId());
        if (cartItem == null) {
            items.put(item.getId(), item);
        } else {
            cartItem.setCount(cartItem.getCount() + 1);
            cartItem.setXprice(cartItem.getPrice().multiply(new BigDecimal(cartItem.getCount())));
        }
    }

    //删除商品
    public void deleteItem(int id) {
        items.remove(id);
    }

    //清空购物车
    public void clear() {
        items.clear();
    }

    //修改商品数量
    public void update(int id, int count) {
        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);
            cartItem.setXprice(cartItem.getPrice().multiply(new BigDecimal(count)));
        }
    }

    public int getAllCount() {
        allCount = 0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            allCount += entry.getValue().getCount();
        }
        return allCount;
    }

    public BigDecimal getAllPrice() {
        allPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            allPrice=allPrice.add(entry.getValue().getXprice());
        }
        return allPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "allCount=" + allCount +
                ", allPrice=" + allPrice +
                ", items=" + items +
                '}';
    }
}
