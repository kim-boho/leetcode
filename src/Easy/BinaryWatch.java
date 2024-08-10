package Easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        int[] h = {1,2,4,8};
        int[] m = {1,2,4,8,16,32};
        for(int i=0; i<=Math.min(turnedOn,3); i++){
            int j = turnedOn-i;
            if(j<=5){
                ArrayList<Integer> temp = new ArrayList<>();
                combi(i,0,temp,h,0,0);
                ArrayList<Integer> temp2 = new ArrayList<>();
                combi(j,0,temp2,m,0,0);
                for (Integer hour : temp) {
                    for (Integer min : temp2) {
                        if (hour < 12 && min < 60) {
                            String s;
                            if (min < 10) {
                                s = hour + ":0" + min;
                            } else {
                                s = hour + ":" + min;
                            }
                            ans.add(s);
                        }
                    }
                }
            }
        }
        return ans;
    }

    private void combi(int depth, int count, ArrayList<Integer> nums, int[] arr, int start, int sum) {
        if(depth == count){
            nums.add(sum);
            return;
        }

        for(int i=start; i<arr.length; i++){
            combi(depth, count+1, nums, arr, i+1, sum+arr[i]);
        }
    }
}
