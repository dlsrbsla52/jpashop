package DTO.Member;
import Entity.Order;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MemberInitResponse {

    private String id;
    private String name;
    private List<Order> orders;
}
