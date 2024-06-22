package DAO.Order;

import java.math.BigDecimal;

/**
 * @author Lemon
 * @create 2022-10-31-14:58
 */
/*
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(10),
`count` INT,
price DECIMAL(8,2),
xPrice DECIMAL(8,2),
orderId VARCHAR(50),
 */
public class OrderItem {
    private int id;
    private String name;
    private int count;
    private BigDecimal price;
    private BigDecimal xPrice=new BigDecimal(0);
    private String orderId;

    public void setId(int id) {
        this.id = id;
    }

    public OrderItem() {
    }

    public OrderItem(int id, String name, int count, BigDecimal price, BigDecimal xPrice, String orderId) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.price = price;
        this.xPrice = xPrice;
        this.orderId = orderId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setxPrice(BigDecimal xPrice) {
        this.xPrice = xPrice;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getxPrice() {
        return xPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public String toString() {
        return "orderItem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", price=" + price +
                ", xPrice=" + xPrice +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
