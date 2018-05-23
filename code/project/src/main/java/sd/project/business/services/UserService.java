package sd.project.business.services;

import org.springframework.stereotype.Service;
import sd.project.business.utility.Constants;
import sd.project.business.validators.Validator;
import sd.project.business.validators.ValidatorFactory;
import sd.project.persistence.entity.Admin;
import sd.project.persistence.entity.Member;
import sd.project.persistence.entity.User;
import sd.project.persistence.repository.UserRepo;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Inject
    UserRepo userRepo;
    @Inject
    MemberService memberService;
    @Inject
    AdminService adminService;

    private List<Validator<User>> validators;

    public User login(String username, String password){
        User loggedInUser;
        loggedInUser = userRepo.findByUsernameAndPassword(username,password);
        if(loggedInUser == null){
            throw new IllegalArgumentException("Login Failed!\n");
        }
        return loggedInUser;
    }

    public User registerUser(User userToRegister){

        validateUser(userToRegister);

        User registeredUser = userRepo.save(userToRegister);
        if(userToRegister.getFlag() == Constants.MEMBER_FLAG){
            Member newMember = new Member();
            newMember.setUser(userToRegister);
            userToRegister.setMember(newMember);
            memberService.registerMember(userToRegister.getMember());
        }
        else if(userToRegister.getFlag() == Constants.ADMIN_FLAG){
            Admin newAdmin = new Admin();
            newAdmin.setUser(userToRegister);
            userToRegister.setAdmin(newAdmin);
            adminService.registerAdmin(userToRegister.getAdmin());
        }
        return registeredUser;
    }

    public User updateUser(User userToUpdate){
        validateUser(userToUpdate);
        return userRepo.save(userToUpdate);
    }

    public void validateUser(User user){
        ValidatorFactory validatorFactory = ValidatorFactory.getInstance();

        validators = new ArrayList<>();

        validators.add(validatorFactory.getValidator(Constants.ADDRESS_VALIDATOR));
        validators.add(validatorFactory.getValidator(Constants.CNP_VALIDATOR));
        validators.add(validatorFactory.getValidator(Constants.EMAIL_VALIDATOR));
        validators.add(validatorFactory.getValidator(Constants.NAME_VALIDATOR));
        validators.add(validatorFactory.getValidator(Constants.PHONE_NUMBER_VALIDATOR));

        for(Validator<User> uv: validators){
            uv.validate(user);
        }
    }

    public User getUserById(int id){
        return userRepo.findById(id).get();
    }
}
