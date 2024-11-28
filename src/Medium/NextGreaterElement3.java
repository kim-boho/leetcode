package Medium;

import java.util.ArrayList;
import java.util.Collections;

public class NextGreaterElement3 {
    public int nextGreaterElement(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        int i = chars.length-1;
        ArrayList<Character> li = new ArrayList<>();
        while(i > 0){
            if(chars[i-1] < chars[i]){
                li.add(chars[i]);
                li.add(chars[i-1]);
                Collections.sort(li);
                int idx = i;
                boolean isSet = false;
                for (Character character : li) {
                    if (!isSet && character > chars[i - 1]) {
                        chars[i - 1] = character;
                        isSet = true;
                    } else chars[idx++] = character;
                }
                int ans = 0;
                for (char aChar : chars) {
                    ans *= 10;
                    ans += aChar - '0';
                }
                if(ans < n) return -1;
                else return ans;
            } else{
                li.add(chars[i]);
                i--;
            }
        }
        return -1;
    }
}
