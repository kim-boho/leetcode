package Medium;

import java.util.ArrayList;
import java.util.HashMap;

public class RestoreTheArrayFromAdjacentPairs {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length;
        HashMap<Integer,Integer> hm1 = new HashMap();
        HashMap<Integer,Integer> hm2 = new HashMap();
        for (int[] adjacentPair : adjacentPairs) {
            int num1 = adjacentPair[0];
            int num2 = adjacentPair[1];
            if (hm1.containsKey(num1)) hm2.put(num1, num2);
            else hm1.put(num1, num2);
            if (hm1.containsKey(num2)) hm2.put(num2, num1);
            else hm1.put(num2, num1);
        }
        ArrayList<Integer> li = new ArrayList();
        li.add(adjacentPairs[0][0]);
        li.add(adjacentPairs[0][1]);

        int left = li.get(0);
        int right = li.get(1);

        while(hm1.containsKey(right) || hm2.containsKey(right)){
            Integer next = hm1.containsKey(right) && hm1.get(right) == left? hm2.get(right):hm1.get(right);
            if(next == null) break;
            li.add(next);
            left = right;
            right = next;
        }

        left = li.get(0);
        right = li.get(1);
        ArrayList<Integer> li2 = new ArrayList();
        while(hm1.containsKey(left) || hm2.containsKey(left)){
            Integer next = hm1.containsKey(left) && hm1.get(left) == right? hm2.get(left):hm1.get(left);
            if(next == null) break;
            li2.add(next);
            right = left;
            left = next;
        }

        int[] ans = new int[n+1];
        int count = 0;
        for(int i=li2.size()-1; i>=0; i--){
            ans[count++] = li2.get(i);
        }

        for (Integer integer : li) {
            ans[count++] = integer;
        }

        return ans;
    }
}
