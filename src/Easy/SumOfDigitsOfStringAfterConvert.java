package Easy;

import java.util.*;

public class SumOfDigitsOfStringAfterConvert {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append((int) (s.charAt(i) - 'a' + 1));
        }
        String st = sb.toString();
        int ans = 0;
        while (k-- > 0) {
            int temp = 0;
            for (int i = 0; i < st.length(); i++) {
                temp += (st.charAt(i) - '0');
            }
            ans = temp;
            st = String.valueOf(temp);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
