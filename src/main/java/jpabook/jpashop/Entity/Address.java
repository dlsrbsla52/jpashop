package jpabook.jpashop.Entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@Builder
@Embeddable
public class Address {

    private String city;
    private String Street;
    private String zipcode;

}
