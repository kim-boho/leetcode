package Easy;

import java.util.ArrayList;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        ArrayList<Character> li1 = new ArrayList<>();
        ArrayList<Character> li2 = new ArrayList<>();
        for(char c:arr1){
            li1.add(0,c);
        }
        for(char c:arr2){
            li2.add(0,c);
        }
        int idx = Math.min(li1.size(), li2.size());
        int prev = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<idx; i++){
            int i1 = li1.get(i)-'0';
            int i2 = li2.get(i)-'0';
            int ans = i1+i2+prev;
            if(ans > 9){
                prev = 1;
                ans -= 10;
            } else{
                prev = 0;
            }
            sb.append(ans);
        }
        ArrayList<Character> remain = li1.size() > li2.size()? li1:li2;
        for(int i=idx; i<remain.size(); i++){
            int i1 = remain.get(i)-'0'+prev;
            if(i1 == 10){
                prev = 1;
                i1 = 0;
            } else{
                prev = 0;
            }
            sb.append(i1);
        }
        if(prev == 1) sb.append(1);
        StringBuilder sb2 = sb.reverse();
        return sb2.toString();
    }
}
