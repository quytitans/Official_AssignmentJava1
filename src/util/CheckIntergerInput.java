package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckIntergerInput {
    public static boolean checkIntergerInput(String strNumber) {
        Pattern pattern = Pattern.compile("\\d*");
        Matcher matcher = pattern.matcher(strNumber);
        return matcher.matches();
    }
}
