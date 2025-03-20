package Medium;

import java.util.ArrayList;
import java.util.List;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] check = new boolean[rooms.size()];
        check[0] = true;
        int unlock = 1;
        ArrayList<Integer> nextRooms = new ArrayList<>();
        nextRooms.add(0);
        while(nextRooms.size() > 0){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int r:nextRooms){
                List<Integer> keys = rooms.get(r);
                for(int k:keys){
                    if(!check[k]){
                        check[k] = true;
                        unlock++;
                        if(unlock == check.length) return true;
                        temp.add(k);
                    }
                }
            }
            nextRooms = temp;
        }
        return false;
    }
}
