package sd.project.business.services;


import org.springframework.stereotype.Service;
import sd.project.persistence.entity.Member;
import sd.project.persistence.repository.MemberRepo;

import javax.inject.Inject;
import java.util.List;

@Service
public class MemberService {

    @Inject
    MemberRepo memberRepo;

    public Member registerMember(Member memberToRegister){

        return memberRepo.save(memberToRegister);
    }

    public Member updateMember(Member memberToUpdate){
        return memberRepo.save(memberToUpdate);
    }

    public List<Member> getAllMembers(){
        return memberRepo.findAll();
    }

    public Member getMemberById(Integer id){
        return memberRepo.findById(id).get();
    }
}
