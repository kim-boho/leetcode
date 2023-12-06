package Medium;

import java.util.LinkedList;
import java.util.List;

public class DiagonalTraverse2 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> li = new LinkedList();
        List<Integer> idxs = new LinkedList();
        int total = 0;
        for(List<Integer> l:nums) total += l.size();
        int[] ans = new int[total];
        int i = 0;
        int row = 0;
        while(i < total){
            if(row < nums.size()){
                li.add(0,nums.get(row++));
                idxs.add(0,0);
            }
            int k = 0;
            while(i < total && li.size() > k){
                int idx = idxs.get(k);
                int size = li.get(k).size();
                if(size > idx){
                    ans[i++] = li.get(k).get(idx);
                    idxs.set(k, ++idx);
                }
                if(idx == size){
                    li.remove(k);
                    idxs.remove(k);
                } else{
                    k++;
                }
            }
        }
        return ans;

    }
}
