package sd.project.business.validators;


import sd.project.business.utility.Constants;
import sd.project.business.utility.Function;
import sd.project.persistence.entity.User;

/**
 * Created by Boros on 3/27/2018.
 */
public class PhoneValidator implements Validator<User> {
    public void validate(User user) {
        if(!Function.isNumeric(user.getPhoneNumber()) || !Function.isWellFormed(user.getPhoneNumber(),Constants.PHONE_NUMBER_LENGTH,Constants.STRONG)){
            throw new IllegalArgumentException("Phone number is invalid: " + user.getPhoneNumber());
        }
    }
}
