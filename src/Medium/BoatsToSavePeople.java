package Medium;

import java.util.Arrays;

public class BoatsToSavePeople {
    public int numRescueBoats(int[] people, int limit) {
        int len = people.length;
        int ans = 0;
        Arrays.sort(people);
        int left = 0;
        int right = len-1;
        while(left<=right){
            if(left == right){
                ans++;
                break;
            }
            if(people[right]+people[left] <= limit) left++;
            right--;
            ans++;
        }
        return ans;
    }
}
