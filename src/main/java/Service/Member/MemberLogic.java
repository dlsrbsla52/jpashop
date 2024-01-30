package Service.Member;

import DTO.Member.MemberInitRequest;
import DTO.Member.MemberInitResponse;
import org.springframework.stereotype.Service;

@Service
public interface MemberLogic {
    MemberInitResponse memberInit(MemberInitRequest request);

    MemberInitResponse SearchMember(Long id);
}
