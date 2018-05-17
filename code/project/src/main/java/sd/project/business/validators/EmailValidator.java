package sd.project.business.validators;

import sd.project.persistence.entity.User;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

public class EmailValidator implements Validator<User>{
    @Override
    public void validate(User user) {
        String email = user.getEmail();

        boolean valid = true;
        try{
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException e) {
            valid = false;
        }
        if(!valid){
            throw new IllegalArgumentException("Email is invalid: " + user.getEmail());
        }
    }
}
