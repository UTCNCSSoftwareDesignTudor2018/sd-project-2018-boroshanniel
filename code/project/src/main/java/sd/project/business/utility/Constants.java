package sd.project.business.utility;

import java.util.Date;

public class Constants {

    //flags
    public static final int MEMBER_FLAG = 1;
    public static final int ADMIN_FLAG = 0;

    //stock
    public static final int INCREMENT_STOCK = 1;
    public static final int DECREMENT_STOCK = -1;

    //book return
    public static final int COMPLETED = 1;
    public static final int NONCOMPLETED = 0;

    //comparison types
    public static final String STRONG = "STRONG";
    public static final String WEAK = "WEAK";

    //for user
    public static final int CNP_LENGTH = 13;
    public static final int ADDRESS_NAME_LENGTH = 50;
    public static final int PHONE_NUMBER_LENGTH = 13;

    //for validators
    public static final String ADDRESS_VALIDATOR = "ADDRV";
    public static final String CNP_VALIDATOR = "CNPV";
    public static final String PHONE_NUMBER_VALIDATOR = "PHONENRV";
    public static final String NAME_VALIDATOR = "NAMEV";
    public static final String EMAIL_VALIDATOR = "EMAILV";

    //control values for cnp validator
    public static final int[] CONTROL_VALUES = new int[] {
            2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9
    };
    public static int[] YEAR_OFFSET = new int[] {
            0, 1900, 1900, 1800, 1800, 2000, 2000
    };

}
