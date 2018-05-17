package sd.project.business.validators;

import org.hibernate.tool.hbm2ddl.SchemaValidatorTask;
import sd.project.business.utility.Constants;

public class ValidatorFactory {

    //singleton pattern
    private static ValidatorFactory instance = new ValidatorFactory();

    private ValidatorFactory(){

    }

    public static ValidatorFactory getInstance(){
        return instance;
    }

    public Validator getValidator(String validatorType){
        if(validatorType == null){
            return null;
        }
        if(validatorType.equalsIgnoreCase(Constants.ADDRESS_VALIDATOR)){
            return new PhoneValidator();
        }
        if(validatorType.equalsIgnoreCase(Constants.CNP_VALIDATOR)){
            return new CnpValidator();
        }
        if(validatorType.equalsIgnoreCase(Constants.PHONE_NUMBER_VALIDATOR)){
            return new PhoneValidator();
        }
        if(validatorType.equalsIgnoreCase(Constants.NAME_VALIDATOR)){
            return new NameValidator();
        }
        if(validatorType.equalsIgnoreCase(Constants.EMAIL_VALIDATOR)){
            return new EmailValidator();
        }

        return null;
    }
}
