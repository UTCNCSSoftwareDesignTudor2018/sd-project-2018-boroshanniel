package sd.project.business.validators;


import sd.project.business.utility.Constants;
import sd.project.business.utility.Function;
import sd.project.persistence.entity.User;

/**
 * Created by Boros on 3/27/2018.
 */
public class NameValidator implements Validator<User> {
    public void validate(User user) {
        if(!Function.isWellFormed(user.getName(),Constants.ADDRESS_NAME_LENGTH,Constants.WEAK)){
            throw new IllegalArgumentException("Name is invalid (too big): " + user.getName());
        }
    }
}
