package Hard;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] temp = new int[n];
        for(int i=0; i<n; i++) temp[i] = ratings[i];
        Arrays.sort(temp);

        int[] sortedIdxs = new int[n];
        int idx = 0;
        int pointer = 0;
        while(idx<n){
            while(idx+1<n && temp[idx] == temp[idx+1]) idx++;
            int min = temp[idx];
            for(int j=0; j<n; j++){
                if(ratings[j] == min) sortedIdxs[pointer++] = j;
            }
            idx++;
        }

        int[] candies = new int[n];
        for(int i=0; i<n; i++){
            int num = sortedIdxs[i];
            if(num-1>=0 && ratings[num-1]>ratings[num]) candies[num-1] = Math.max(candies[num-1],candies[num]+1);
            if(num+1<n && ratings[num+1]>ratings[num]) candies[num+1] = Math.max(candies[num+1],candies[num]+1);
        }

        int sum = 0;
        for(int num:candies) sum+=num;
        return sum+n;
    }
}
