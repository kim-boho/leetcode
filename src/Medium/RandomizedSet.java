package Medium;

import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
    int size;
    HashMap<Integer,Integer> hm;
    Random rd;
    int[] arr;
    public RandomizedSet() {
        size = 0;
        hm = new HashMap<>();
        rd = new Random();
        arr = new int[200000];
    }

    public boolean insert(int val) {
        if(hm.containsKey(val)) return false;
        else{
            arr[size] = val;
            hm.put(val,size++);
            return true;
        }
    }

    public boolean remove(int val) {
        if(size == 0 || !hm.containsKey(val)) return false;
        else{
            int idx = hm.get(val);
            arr[idx] = arr[size-1];
            hm.put(arr[idx],idx);
            hm.remove(val);
            size--;
            return true;
        }
    }

    public int getRandom() {
        int i = rd.nextInt(size);
        return arr[i];
    }
}
