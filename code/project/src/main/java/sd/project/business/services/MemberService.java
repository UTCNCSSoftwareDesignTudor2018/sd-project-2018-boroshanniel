package sd.project.business.services;


import org.springframework.stereotype.Service;
import sd.project.persistence.entity.Member;
import sd.project.persistence.repository.MemberRepo;

import javax.inject.Inject;

@Service
public class MemberService {

    @Inject
    MemberRepo memberRepo;

    public Member registerMember(Member memberToRegister){

        return memberRepo.save(memberToRegister);
    }
}
