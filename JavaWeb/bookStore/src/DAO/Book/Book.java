package DAO.Book;

import java.math.BigDecimal;

/**
 * id int primary key auto_increment,
 * `name` varchar(20) not null unique key,
 * `price` decimal(11,2),
 * `author` varchar(20),
 * `sales` int,
 * `stock` int,
 * `img_path` varchar(200)
 *
 * @author Lemon
 * @create 2022-10-24-10:04
 */
public class Book {
    private int id;
    private String name;
    private BigDecimal price;
    private String author;
    private int sales;
    private int stock;
    private String img_path = "static/img/default.jpg";

    public Book() {
    }

    public Book(int id, String name, BigDecimal price, String author, int sales, int stock, String img_path) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.author = author;
        this.sales = sales;
        this.stock = stock;
        if (!"".equals(img_path) && img_path != null) {
            this.img_path = img_path;
        }
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getImg_path() {
        return img_path;
    }

    public void setImg_path(String img_path) {
        if (!"".equals(img_path) && img_path != null) {
            this.img_path = img_path;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                ", sales=" + sales +
                ", stock=" + stock +
                ", img_path='" + img_path + '\'' +
                '}';
    }
}
