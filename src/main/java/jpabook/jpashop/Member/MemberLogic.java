package jpabook.jpashop.Member;

import jpabook.jpashop.DTO.Member.MemberInitRequest;
import jpabook.jpashop.DTO.Member.MemberInitResponse;
import org.springframework.stereotype.Service;

@Service
public interface MemberLogic {
    MemberInitResponse memberInit(MemberInitRequest request);

    MemberInitResponse SearchMember(Long id);
}
