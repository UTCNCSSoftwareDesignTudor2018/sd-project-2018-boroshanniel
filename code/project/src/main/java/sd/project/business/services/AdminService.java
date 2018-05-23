package sd.project.business.services;


import org.springframework.stereotype.Service;
import sd.project.persistence.entity.Admin;
import sd.project.persistence.repository.AdminRepo;

import javax.inject.Inject;

@Service
public class AdminService {

    @Inject
    AdminRepo adminRepo;

    public Admin registerAdmin(Admin adminToRegister){

        return adminRepo.save(adminToRegister);
    }

    public Admin updateAdmin(Admin adminToUpdate){
        return adminRepo.save(adminToUpdate);
    }
}
