package Medium;

public class StringToInteger {
    public int myAtoi(String s) {
        s = s.trim();
        if(s.length() == 0) return 0;
        char firChar = s.charAt(0);
        if(Character.isAlphabetic(firChar) || firChar == '.') return 0;

        boolean isPos = true;
        if(firChar == '-') isPos = false;

        int idx = 0;
        while(idx<s.length() && !Character.isDigit(s.charAt(idx))) idx++;
        int start = idx;
        if(start > 1 || idx == s.length()) return 0;
        while(idx<s.length() && Character.isDigit(s.charAt(idx))) idx++;
        String num = s.substring(start, idx);
        int ans = 0;
        try{
            ans = Integer.valueOf(num);
        } catch(Exception e){
            if(isPos) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        if(isPos) return (int)ans;
        else return (int)-ans;
    }
}
