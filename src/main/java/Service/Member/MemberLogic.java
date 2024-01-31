package Service.Member;

import jpabook.jpashop.DTO.Member.MemberInitRequest;
import jpabook.jpashop.DTO.Member.MemberInitResponse;
import jpabook.jpashop.Entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MemberLogic {
    MemberInitResponse memberInit();

    MemberInitResponse productInit();

    int bulkPriceUp();

    MemberInitResponse SearchMember(Long id);

    List<MemberInitResponse> SearchNameMember(String userName);

    List<MemberInitResponse> SearchNameMemberTestTest (String username);

    List<MemberInitResponse> SearchNameMemberTest (String username);

    Page<Member> PageingTest(String username, Pageable pageable);
}
