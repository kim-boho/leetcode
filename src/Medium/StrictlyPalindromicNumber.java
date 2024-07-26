package Medium;

import java.util.ArrayList;
import java.util.Objects;

public class StrictlyPalindromicNumber {
    public boolean isStrictlyPalindromic(int n) {
        for(int i=2; i<=n-2; i++){
            int temp = n;
            ArrayList<Integer> li = new ArrayList<>();
            while(temp > 0){
                li.add(temp%i);
                temp /= i;
            }
            int l = 0;
            int r = li.size()-1;
            while(l < r){
                if(!Objects.equals(li.get(l++), li.get(r--))) return false;
            }
        }
        return true;
    }
}
