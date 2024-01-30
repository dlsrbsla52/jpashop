package jpabook.jpashop.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {

    private String city;
    private String Street;
    private String zipcode;
}
