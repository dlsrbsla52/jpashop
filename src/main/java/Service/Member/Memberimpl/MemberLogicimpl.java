package Service.Member.Memberimpl;

import Service.Member.MemberLogic;
import jakarta.transaction.Transactional;
import jpabook.jpashop.DTO.Member.MemberInitResponse;
import jpabook.jpashop.Entity.Address;
import jpabook.jpashop.Entity.Member;
import jpabook.jpashop.Entity.Product;
import jpabook.jpashop.Interface.MemberRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
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
    public MemberInitResponse productInit() {
        int stockAmount = 100;
        int price = 1;
        for(Long i = 0L; i <101L; i++){
            Product product = new Product(i, "상품이름_" + i.toString(), price, stockAmount);
            stockAmount += 1;
            price += 1;
            memberRepository.save(product);
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
        List<Member> resultList = memberRepository.findByUserName(username);

        for (Member mem : resultList) {
            responseList.add(new MemberInitResponse(mem.getId(), mem.getUserName(), mem.getAddress()));
        }

        return responseList;
    }

    @Override
    public List<MemberInitResponse> SearchNameMemberTest (String username) {
        List<MemberInitResponse> responseList = new ArrayList<>();
        List<Member> resultList = memberRepository.findByUsernametest(username);

        for (Member mem : resultList) {
            responseList.add(new MemberInitResponse(mem.getId(), mem.getUserName(), mem.getAddress()));
        }

        return responseList;
    }

    @Override
    public int bulkPriceUp() {
        int a = memberRepository.bulkPriceUp(20D);
        return a;
    }

    @Override
    public Page<Member> PageingTest(String username, Pageable pageable) {

        PageRequest pageRequest = PageRequest.of(0,10, Sort.by(Sort.Direction.DESC, "username"));

        Page<Member> result = memberRepository.findByUserNameContains("황인규", pageRequest);
        
        List<Member> members = result.getContent(); //조회된 데이터
        int totalPages = result.getTotalPages(); // 전체 페이지 수
        boolean hasNextPage = result.hasNext(); // 다음 페이지 존재 여부
        
        return null;
    }
}
