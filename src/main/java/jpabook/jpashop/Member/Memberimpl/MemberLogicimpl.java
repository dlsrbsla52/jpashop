package jpabook.jpashop.Member.Memberimpl;

import jpabook.jpashop.DTO.Member.MemberInitRequest;
import jpabook.jpashop.DTO.Member.MemberInitResponse;
import jpabook.jpashop.Entity.Member;
import jpabook.jpashop.Interface.MemberRepository;
import jpabook.jpashop.Member.MemberLogic;

public class MemberLogicimpl implements MemberLogic {

    private MemberRepository memberRepository;

    @Override
    public MemberInitResponse memberInit(MemberInitRequest request) {
        return null;
    }

    @Override
    public MemberInitResponse SearchMember(Long id) {
        Member findByUserName = memberRepository.findByUserName("HelloJpa");
//        MemberInitResponse response = MemberInitResponse.builder().build();
        MemberInitResponse response = new MemberInitResponse();
        response.setId(findByUserName.getId());
        response.setName(findByUserName.getUsername());
        return response;
    }
}
