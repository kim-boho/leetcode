package Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandomO1DuplicatesAllowed {
    ArrayList<Integer> nums;
    HashMap<Integer,ArrayList<Integer>> idxs;
    public InsertDeleteGetRandomO1DuplicatesAllowed() {
        nums = new ArrayList<>();
        idxs = new HashMap<>();
    }

    public boolean insert(int val) {
        boolean isNew = false;
        if(!idxs.containsKey(val)){
            idxs.put(val,new ArrayList<>());
            isNew = true;
        }
        idxs.get(val).add(nums.size());
        nums.add(val);
        return isNew;
    }

    public boolean remove(int val) {
        if(!idxs.containsKey(val)) return false;
        ArrayList<Integer> idx = idxs.get(val);
        int targetIdx = idx.get(idx.size()-1);
        int putToTargetIdx = nums.get(nums.size()-1);
        nums.set(targetIdx,putToTargetIdx);
        ArrayList<Integer> changeIdx = idxs.get(putToTargetIdx);
        for(int i=0; i<changeIdx.size(); i++){
            if(changeIdx.get(i) == nums.size()-1){
                changeIdx.set(i,targetIdx);
                break;
            }
        }
        if(idx.size() == 1) idxs.remove(val);
        else idx.remove(idx.size()-1);
        nums.remove(nums.size()-1);
        return true;
    }

    public int getRandom() {
        Random rd = new Random();
        return nums.get(rd.nextInt(nums.size()));
    }
}
