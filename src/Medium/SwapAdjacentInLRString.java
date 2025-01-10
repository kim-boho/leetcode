package Medium;

import java.util.LinkedList;
import java.util.Queue;

public class SwapAdjacentInLRString {
    public boolean canTransform(String start, String result) {
        char[] arr1 = start.toCharArray();
        char[] arr2 = result.toCharArray();
        int i=0;
        int j=0;
        int len = arr1.length;
        while(j < len){
            Queue<Integer> r = new LinkedList<>();
            while(j < len && arr2[j] != 'L'){
                if(arr2[j] == 'R') r.add(j);
                j++;
            }
            Queue<Integer> r2 = new LinkedList<>();
            while(i < len && arr1[i] != 'L'){
                if(arr1[i] == 'R') r2.add(i);
                i++;
            }
            if(i < j || r.size() != r2.size()) return false;
            if((i == len && j != len) || (i != len && j == len)) return false;
            while(!r.isEmpty()){
                if(r.poll() < r2.poll()) return false;
            }
            i++;
            j++;
        }
        return true;
    }
}
