package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class MilisecToDateTime {
    public static String convertToDateTime(long milliseconds) {
        DateFormat simpleDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss z");
        Date result = new Date(milliseconds);
        return simpleDate.format(result);
    }
}
