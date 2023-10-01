package Medium;

import java.util.HashSet;

public class MaximumProductOfWordLengths {
    public int maxProduct(String[] words) {
        HashSet<Integer>[] digits = new HashSet[words.length];
        for(int i=0; i<words.length; i++){
            String s = words[i];
            int len = s.length();
            digits[i] = new HashSet();
            for(int j=0; j<len; j++){
                int idx = s.charAt(j)-'a';
                digits[i].add(idx);
            }
        }


        int max = 0;
        for(int i=0; i<words.length; i++){
            int len = words[i].length();
            for(int j=i+1; j<words.length; j++){
                if(!isIntersected(digits[i], digits[j])){
                    max = Math.max(max, len*words[j].length());
                }
            }
        }
        return max;
    }

    private boolean isIntersected(HashSet<Integer> hs1, HashSet<Integer> hs2){
        HashSet<Integer> intersection = new HashSet<Integer>(hs1);
        intersection.retainAll(hs2);
        return intersection.size() > 0 ? true:false;
    }
}
