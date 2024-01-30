package jpabook.jpashop.DTO.Member;
import jpabook.jpashop.Entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberInitResponse {

    private Long id;
    private String name;
    private List<Order> orders;
}
