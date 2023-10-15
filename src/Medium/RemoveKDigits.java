package Medium;

import java.util.ArrayList;
import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        char[] charArr = num.toCharArray();
        Stack<Integer> monoSt = new Stack();
        ArrayList<Integer> removed = new ArrayList();
        for(int i=0; i<charArr.length; i++){
            char c = charArr[i];
            while(monoSt.size() > 0 && charArr[monoSt.peek()] > c)
                removed.add(monoSt.pop());
            monoSt.push(i);
        }

        int idx = 0;
        while(idx < k && idx < removed.size()){
            charArr[removed.get(idx++)] = '0'-1;
        }


        if(removed.size() < k){
            int leftLen = k-removed.size();
            int idx2 = charArr.length-1;
            while(leftLen > 0){
                while(charArr[idx2] < '0') idx2--;
                charArr[idx2] = '0'-1;
                leftLen--;
            }
        }

        int i = 0;
        while(i< charArr.length && charArr[i] <= '0') i++;
        StringBuilder sb = new StringBuilder("");
        while(i<charArr.length){
            if(charArr[i] >= '0') sb.append(charArr[i]);
            i++;
        }
        if(sb.length() == 0) return "0";
        else return sb.toString();
    }
}
