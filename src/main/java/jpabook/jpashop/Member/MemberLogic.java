package jpabook.jpashop.Member;

import jpabook.jpashop.DTO.Member.MemberInitRequest;
import jpabook.jpashop.DTO.Member.MemberInitResponse;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberLogic {
    MemberInitResponse memberInit();

    MemberInitResponse SearchMember(Long id);

    List<MemberInitResponse> SearchNameMember(String userName);

    List<MemberInitResponse> SearchNameMemberTestTest (String username);
}
