package Easy;

import java.util.ArrayList;
import java.util.List;

public class MergeSimilarItems {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        int[] sum = new int[1001];
        for(int[] i:items1){
            sum[i[0]] += i[1];
        }
        for(int[] i:items2){
            sum[i[0]] += i[1];
        }
        List<List<Integer>> ret = new ArrayList<>();
        for(int i=1; i<sum.length; i++){
            if(sum[i] != 0){
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(i);
                temp.add(sum[i]);
                ret.add(temp);
            }
        }
        return ret;
    }
}
