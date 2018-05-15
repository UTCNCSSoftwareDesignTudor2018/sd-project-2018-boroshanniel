package sd.project.business.services;

import org.springframework.stereotype.Service;
import sd.project.business.utility.Constants;
import sd.project.persistence.entity.User;
import sd.project.persistence.repository.UserRepo;

import javax.inject.Inject;

@Service
public class UserService {

    @Inject
    UserRepo userRepo;
    @Inject
    MemberService memberService;
    @Inject
    AdminService adminService;

    public User login(String username, String password){
        User loggedInUser;
        loggedInUser = userRepo.findByUsernameAndPassword(username,password);
        if(loggedInUser == null){
            throw new IllegalArgumentException("Login Failed!\n");
        }
        return loggedInUser;
    }

    public User registerUser(User userToRegister){

        User registeredUser = userRepo.save(userToRegister);
        if(userToRegister.getFlag() == Constants.MEMBER_FLAG){
            memberService.registerMember(userToRegister.getMember());
        }
        else if(userToRegister.getFlag() == Constants.ADMIN_FLAG){
            adminService.registerAdmin(userToRegister.getAdmin());
        }
        return registeredUser;
    }

    public User updateUser(User userToUpdate){
        return userRepo.save(userToUpdate);
    }
}
