package Medium;

public class DecodeString {
    public String decodeString(String s) {
        char[] chars = s.toCharArray();
        return recursionDecode(chars, 0, s.length());
    }

    private String recursionDecode(char[] chars, int start, int end){
        int sum = 0;
        String ans = "";
        String tempSt = "";
        while(start<end){
            char c = chars[start++];
            if(Character.isLowerCase(c)){
                tempSt += String.valueOf(c);
            } else if(Character.isDigit(c)){
                sum *= 10;
                sum = sum+(c-'0');
            } else if(c == '['){
                int count = 1;
                int temp = start;
                while(count>0 && start<end){
                    if(chars[start] == ']') count--;
                    else if(chars[start] == '[') count++;
                    start++;
                }
                String tempSt2 = recursionDecode(chars, temp, start-1);
                String added = "";
                for(int j=0; j<sum; j++) added += tempSt2;
                tempSt += added;
                ans += tempSt;
                sum = 0;
                tempSt = "";
            }
        }
        if(tempSt.length()>0) ans += tempSt;

        return ans;
    }
}
