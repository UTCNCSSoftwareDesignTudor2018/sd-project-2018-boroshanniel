package sd.project.business.utility;

public class Function {

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }

    public static boolean isWellFormed(String str,int length,String type)
    {
        if(type.equals(Constants.STRONG))
            return length==str.length();
        if(type.equals(Constants.WEAK))
            return length>=str.length();

        else
            return false;
    }
}
