package Easy;

import java.util.HashSet;

public class StrongPasswordChecker2 {
    public boolean strongPasswordCheckerII(String password) {
        if(password.length() < 8) return false;
        boolean lowerCase = false;
        boolean upperCase = false;
        boolean digit = false;
        boolean special = false;
        char[] pw = password.toCharArray();
        char prev = '.';
        HashSet<Character> hs = new HashSet<>();
        hs.add('!');
        hs.add('@');
        hs.add('#');
        hs.add('$');
        hs.add('%');
        hs.add('^');
        hs.add('&');
        hs.add('*');
        hs.add('(');
        hs.add(')');
        hs.add('-');
        hs.add('+');
        for(char c:pw){
            if(Character.isDigit(c)) digit = true;
            if(Character.isLowerCase(c)) lowerCase = true;
            if(Character.isUpperCase(c)) upperCase = true;
            if(hs.contains(c)) special = true;
            if(prev == c) return false;
            prev = c;
        }
        if(!digit || !lowerCase || !upperCase || !special) return false;
        else return true;
    }
}
