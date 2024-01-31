package jpabook.jpashop.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String userName;

    @Embedded
    private Address Address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public Member() {}

    public Member(Long id, String userName, jpabook.jpashop.Entity.Address address) {
        this.id = id;
        this.userName = userName;
        Address = address;
    }
}
