package Medium;

import java.util.TreeMap;

public class CarPooling {
    public boolean carPooling(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> starts = new TreeMap<>();
        TreeMap<Integer, Integer> ends = new TreeMap<>();
        for(int[] arr:trips){
            starts.put(arr[1], starts.getOrDefault(arr[1],0)+arr[0]);
            ends.put(arr[2], ends.getOrDefault(arr[2],0)+arr[0]);
        }
        int ppl = 0;
        while(!starts.isEmpty() && !ends.isEmpty()){
            int firStart = starts.firstKey();
            int firEnd = ends.firstKey();
            while(firStart < firEnd){
                ppl  += starts.pollFirstEntry().getValue();
                if(ppl > capacity) return false;
                if(!starts.isEmpty()) firStart = starts.firstKey();
                else firStart = Integer.MAX_VALUE;
            }
            while(firStart >= firEnd){
                ppl -= ends.pollFirstEntry().getValue();
                if(!ends.isEmpty()) firEnd = ends.firstKey();
                else break;
            }
        }
        return true;
    }
}
