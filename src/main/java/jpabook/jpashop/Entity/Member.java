package jpabook.jpashop.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NamedQuery(
        name="Member.findByUsername",
        query = "select m from Member m where m.userName = :username"
)
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
}
