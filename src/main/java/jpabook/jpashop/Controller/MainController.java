package jpabook.jpashop.Controller;

import jpabook.jpashop.DTO.Member.MemberInitRequest;
import jpabook.jpashop.DTO.Member.MemberInitResponse;
import jpabook.jpashop.Member.MemberLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    MemberLogic memberLogic;

    @PostMapping(value = "/initMember")
    public MemberInitResponse memberInit(MemberInitRequest request){

        return memberLogic.memberInit(request);
    }

    @GetMapping(value = "/search")
    public MemberInitResponse SearchMember(@RequestParam(value = "id") Long id){
        return memberLogic.SearchMember(id);
    }

    @PostMapping(value = "/search/test")
    public MemberInitResponse SearchMembertest(){
        Long test = 100L;
        return memberLogic.SearchMember(test);
    }
}
