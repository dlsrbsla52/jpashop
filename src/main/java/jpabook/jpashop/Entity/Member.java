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
        query = "select m from Member m where m.username = :username"
)
@Entity
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    private String username;

    @Embedded
    private Address Address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<Order>();
}
