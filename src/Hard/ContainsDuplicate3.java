package Hard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;

public class ContainsDuplicate3 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeMap<Integer, ArrayList<Integer>> tm = new TreeMap();
        for(int i=0; i<nums.length; i++){
            if(tm.containsKey(nums[i])){
                if(Math.abs(tm.get(nums[i]).get(tm.get(nums[i]).size()-1) - i) <= indexDiff) return true;
                tm.get(nums[i]).add(i);
            } else {
                ArrayList<Integer> temp = new ArrayList();
                temp.add(i);
                tm.put(nums[i], temp);
            }
        }

        Iterator it = tm.keySet().iterator();
        LinkedList<Integer> prev = new LinkedList();
        while(it.hasNext()){
            int i = (int) it.next();
            for(int j=prev.size()-1; j>=0; j--){
                if(Math.abs(i-prev.get(j))<=valueDiff){
                    if(compareIdx(tm.get(i), tm.get(prev.get(j)), indexDiff)) return true;
                } else{
                    while(j-->=0) prev.remove(0);
                    break;
                }
            }
            prev.add(i);
        }

        return false;

    }

    private boolean compareIdx(ArrayList<Integer> li1, ArrayList<Integer> li2, int indexDiff){
        int idx1 = 0;
        int idx2 = 0;
        while(idx1<li1.size() && idx2<li2.size()){
            int i = li1.get(idx1);
            int j = li2.get(idx2);
            if(Math.abs(i-j)<=indexDiff) return true;
            if(i>j) idx1++;
            else idx2++;
        }
        if(idx1 == li1.size()){
            while(idx2<li2.size()){
                int i = li1.get(idx1-1);
                int j = li2.get(idx2++);
                if(Math.abs(i-j)<=indexDiff) return true;
            }
        }
        if(idx2 == li2.size()){
            while(idx1<li1.size()){
                int i = li1.get(idx1++);
                int j = li2.get(idx2-1);
                System.out.println(i+", "+j);
                if(Math.abs(i-j)<=indexDiff) return true;
            }
        }
        return false;
    }
}
