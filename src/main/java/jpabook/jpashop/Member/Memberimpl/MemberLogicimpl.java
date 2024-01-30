package jpabook.jpashop.Member.Memberimpl;

import jakarta.transaction.Transactional;
import jpabook.jpashop.DTO.Member.MemberInitRequest;
import jpabook.jpashop.DTO.Member.MemberInitResponse;
import jpabook.jpashop.Entity.Member;
import jpabook.jpashop.Interface.MemberRepositoryImpl;
import jpabook.jpashop.Member.MemberLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberLogicimpl implements MemberLogic {

    @Autowired
    private MemberRepositoryImpl memberRepository;

    @Override
    public MemberInitResponse memberInit(MemberInitRequest request) {
        return null;
    }

    @Override
    @Transactional
    public MemberInitResponse SearchMember(Long id) {
        Member findByUserName = memberRepository.findByUserName("HelloJpa");
//        MemberInitResponse response = MemberInitResponse.builder().build();
        MemberInitResponse response = new MemberInitResponse();
        if(findByUserName != null){
            response.setId(findByUserName.getId());
            response.setName(findByUserName.getUserName());
        }
        return response;
    }
}
