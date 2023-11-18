package Easy;

public class ReverseString2 {
    public String reverseStr(String s, int k) {
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean isReverse = true;
        int i = 0;
        while(i < s.length()){
            int temp = i+k-1;
            if(isReverse){
                while(temp>=s.length()) temp--;
                while(temp>=i){
                    sb.append(charArr[temp--]);
                }
                i = Math.min(s.length(), i+k);
                isReverse = false;
            } else{
                while(i < s.length() && i<=temp){
                    sb.append(charArr[i++]);
                }
                isReverse = true;
            }
        }
        return sb.toString();
    }
}
