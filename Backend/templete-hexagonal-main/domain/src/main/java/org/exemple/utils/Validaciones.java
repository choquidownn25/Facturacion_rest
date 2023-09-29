package org.exemple.utils;
// Java program to validate the
// DateTime(YYYY-MM-DD HH:MM:SS) using Regex
import java.util.regex.*;
public class Validaciones {

    // Function to validate the
    // DateTime(YYYY-MM-DD HH:MM:SS)
    public static boolean isValid_DateTime(String str) {

        // Regex to check valid
        // DateTime(YYYY-MM-DD HH:MM:SS)
        String regex
                = "^([0-9]{4})-((01|02|03|04|05|06|07|08|09|10|11|12|"
                + "(?:J(anuary|u(ne|ly))|February|Ma(rch|y)|"
                + "A(pril|ugust)|(Jan|Feb|Mar|Apr|May|Jun|Jul|"
                + "Aug|Sep|Oct|Nov|Dec)|(JANUARY|FEBRUARY|MARCH|"
                + "APRIL|MAY|JUNE|JULY|AUGUST|SEPTEMBER|OCTOBER|"
                + "NOVEMBER|DECEMBER)|(September|October|November|"
                + "December)|(jan|feb|mar|apr|may|jun|jul|aug|sep|"
                + "oct|nov|dec)|(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP"
                + "|OCT|NOV|DEC)))|(january|february|march|april|may|"
                + "june|july|august|september|october|november|december))"
                + "-([0-3][0-9])\\s([0-1][0-9]|[2][0-3]):([0-5][0-9])"
                + ":([0-5][0-9])$";
        // Compile the ReGex
        Pattern p = Pattern.compile(regex);

        // If the str
        // is empty return false
        if (str == null) {
            return false;
        }

        // Pattern class contains matcher()
        // method to find matching between
        // given str using regex.
        Matcher m = p.matcher(str);

        // Return if the str
        // matched the ReGex
        return m.matches();
    }

}
