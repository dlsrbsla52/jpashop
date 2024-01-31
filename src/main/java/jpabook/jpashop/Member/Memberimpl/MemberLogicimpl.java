package jpabook.jpashop.Member.Memberimpl;

import jakarta.transaction.Transactional;
import jpabook.jpashop.DTO.Member.MemberInitRequest;
import jpabook.jpashop.DTO.Member.MemberInitResponse;
import jpabook.jpashop.Entity.Address;
import jpabook.jpashop.Entity.Member;
import jpabook.jpashop.Interface.MemberRepositoryImpl;
import jpabook.jpashop.Member.MemberLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemberLogicimpl implements MemberLogic {

    @Autowired
    private MemberRepositoryImpl memberRepository;

    @Override
    public MemberInitResponse memberInit() {
        List<Member> memberList = new ArrayList<>();
        Address address = new Address();
        address.setCity("서울");
        address.setStreet("증가로");
        address.setZipcode("150");

        for(Long i = 0L; i < 101L; i++){
            Member member = new Member(i, "황인규_"+i.toString(), address);
            memberRepository.save(member);
        }

        return null;
    }

    @Override
    @Transactional
    public MemberInitResponse SearchMember(Long id) {
//        Optional<Member> findByUserName = memberRepository.findByUserName("HelloJpa");
        Optional<Member> findById = memberRepository.findById(1L);
//        MemberInitResponse response = MemberInitResponse.builder().build();
        MemberInitResponse response = new MemberInitResponse();
        Member member = findById.orElseThrow(() -> new RuntimeException());
        response.setId(member.getId());
        response.setName(member.getUserName());
        return response;
    }

    @Override
    public List<MemberInitResponse> SearchNameMember (String userName) {
        List<MemberInitResponse> responseList = new ArrayList<>();
        List<Member> resultList = memberRepository.findByUserNameContains(userName);

        for (Member mem : resultList) {
            responseList.add(new MemberInitResponse(mem.getId(), mem.getUserName(), mem.getAddress()));
        }

        return responseList;
    }

    @Override
    public List<MemberInitResponse> SearchNameMemberTestTest (String username) {
        List<MemberInitResponse> responseList = new ArrayList<>();
        List<Member> resultList = memberRepository.findByUsername(username);

        for (Member mem : resultList) {
            responseList.add(new MemberInitResponse(mem.getId(), mem.getUserName(), mem.getAddress()));
        }

        return responseList;
    }
}
