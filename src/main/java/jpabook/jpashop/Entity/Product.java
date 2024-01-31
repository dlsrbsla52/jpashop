package jpabook.jpashop.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {

    @Id @GeneratedValue
    @Column(name = "PRODUCT_ID")
    private Long id;

    private String productName;

    private Double price;

    private int stockAmount;

    public Product(){}


    public Product(Long id, String productName, double price, int stockAmount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.stockAmount = stockAmount;
    }
}
