package Medium;

public class MinimumTimeToMakeRopeColorful {
    public int minCost(String colors, int[] neededTime) {
        char[] arr = colors.toCharArray();
        int len = arr.length;
        int ans = 0;
        for(int i=0; i<len; i++){
            int temp = i;
            while(temp+1 < len && arr[i] == arr[temp+1]) temp++;
            if(temp != i){
                int count = 0;
                int max = 0;
                for(int j=i; j<=temp; j++){
                    count += neededTime[j];
                    if(max < neededTime[j]) max = neededTime[j];
                }
                count -= max;
                ans += count;
                i = temp;
            }
        }
        return ans;
    }
}
