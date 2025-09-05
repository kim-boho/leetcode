package Medium;

import java.util.Arrays;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]) return a[1]-b[1];
            else return a[0]-b[0];
        });
        int[][] ans = new int[people.length][2];
        boolean[] positioned = new boolean[people.length];
        for(int i=0; i<people.length; i++){
            int currrentPplHeight = people[i][0];
            int neededTallPpl = people[i][1];
            for(int j=0; j<positioned.length; j++){
                if(positioned[j] == false){
                    if(neededTallPpl == 0){
                        ans[j] = people[i];
                        positioned[j] = true;
                        break;
                    } else{
                        neededTallPpl--;
                    }
                } else{
                    if(ans[j][0] >= currrentPplHeight) neededTallPpl--;
                }
            }
        }
        return ans;
    }
}
