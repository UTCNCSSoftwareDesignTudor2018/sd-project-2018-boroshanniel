package sd.project.business.validators;

import sd.project.business.utility.Constants;
import sd.project.business.utility.Function;
import sd.project.persistence.entity.User;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Boros on 3/27/2018.
 */
public class CnpValidator implements Validator<User> {

    public void validate(User user) {

        String cnp = user.getCnp();

        if (!isValid(cnp))
            throw new IllegalArgumentException("CNP is invalid: " + user.getCnp());
    }

    public boolean isValid(String cnp){

        if(cnp == null)
            return false;

        if(!Function.isNumeric(cnp)
                || !Function.isWellFormed(cnp,Constants.CNP_LENGTH,Constants.STRONG)){
            return false;
        }

        int[] cnpDigits = getDigits(cnp);
        if(cnpDigits == null){
            return false;
        }

        if(cnpDigits[Constants.CNP_LENGTH - 1] != getControlSum(cnpDigits)){
            return false;
        }

        //validate birthdate
        int month = cnpDigits[3] * 10 + cnpDigits[4];
        if(month < 1 && month > 12){
            return false;
        }
        int dayOfMonth = cnpDigits[5] * 10 + cnpDigits[6];
        if(dayOfMonth < 1){
            return false;
        }
        int year = Constants.YEAR_OFFSET[cnpDigits[0]] + cnpDigits[1] * 10 + cnpDigits[2];
        int maxDayOfMonth = new GregorianCalendar(year, month,dayOfMonth).getActualMaximum(Calendar.DAY_OF_MONTH);
        if(dayOfMonth > maxDayOfMonth){
            return false;
        }

        return true;
    }

    private static int getControlSum(int[] twelveDigits) {
        int k = 0;
        for (int i = 0; i < 12; i++) {
            k += Constants.CONTROL_VALUES[i] * twelveDigits[i];
        }
        k %= 11;
        if (k == 10) {
            k = 1;
        }
        return k;
    }

    private static int[] getDigits(String cnp) {
        int[] digits = new int[Constants.CNP_LENGTH];
        for (int i = 0; i < Constants.CNP_LENGTH; i++) {
            char c = cnp.charAt(i);
            if (!Character.isDigit(c)) {
                return null;
            }
            digits[i] = (byte) Character.digit(c, 10);
        }
        return digits;
    }
}
