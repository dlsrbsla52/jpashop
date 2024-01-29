package Controller;

import DTO.Member.MemberInitRequest;
import DTO.Member.MemberInitResponse;
import Service.Member.MemberLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    MemberLogic memberLogic;

    @PostMapping(value = "/initMember")
    public MemberInitResponse memberInit(MemberInitRequest request){

        return memberLogic.memberInit(request);
    }
}
