package DAO.Order;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lemon
 * @create 2022-10-31-14:52
 */
public class Order {
    private String orderId;
    private String createTime;
    private BigDecimal allPrice;
    //-1未发货；0已发货；1已签收
    private int status = -1;
    private int userId;

    public Order() {
    }

    public Order(String orderId, String createTime, BigDecimal allPrice, int userId) {
        this.orderId = orderId;
        this.createTime = createTime;
        this.allPrice = allPrice;
        this.userId = userId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public BigDecimal getAllPrice() {
        return allPrice;
    }

    public void setAllPrice(BigDecimal allPrice) {
        this.allPrice = allPrice;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "order{" +
                "orderId='" + orderId + '\'' +
                ", createTime=" + createTime +
                ", allPrice=" + allPrice +
                ", status=" + status +
                ", userId=" + userId +
                '}';
    }
}
