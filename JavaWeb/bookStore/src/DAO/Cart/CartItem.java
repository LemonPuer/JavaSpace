package DAO.Cart;

import java.math.BigDecimal;

/**
 * @author Lemon
 * @create 2022-10-30-19:35
 */
public class CartItem {
    private int id;
    private String name;
    private int count;
    //单价
    private BigDecimal price;
    //小计
    private BigDecimal xprice;

    public CartItem() {
    }

    public CartItem(int id, String name, int count, BigDecimal price, BigDecimal xprice) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.xprice = xprice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getXprice() {
        return xprice;
    }

    public void setXprice(BigDecimal xprice) {
        this.xprice = xprice;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", xprice=" + xprice +
                '}';
    }
}
