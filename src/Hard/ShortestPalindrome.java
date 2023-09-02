package Hard;

public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if(s.length() < 2) return s;
        char[] arr = s.toCharArray();
        int len = s.length()*2;
        int r = -1;

        for(int i=s.length()-1; i>=0; i--){
            int left = i-1;
            int right = i+1;
            while(left>=0 && arr[left] == arr[i]) left--;
            while(right<s.length() && arr[right] == arr[i]) right++;

            while(left>=0 && right<s.length() && arr[left] == arr[right]){
                left--;
                right++;
            }

            if(left == -1 && right == s.length()) return s;
            int totalLen = -1;
            if(left < 0){
                totalLen = s.length()*2 - right;
            }

            if(totalLen != -1 && totalLen < len){
                len = totalLen;
                r = right;
                break;
            }
        }

        String frontStr = s.substring(r, s.length());
        StringBuilder sb = new StringBuilder(frontStr);
        sb.reverse();
        s = sb.toString() + s;
        return s;
    }
}
