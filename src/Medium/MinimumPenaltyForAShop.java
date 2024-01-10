package Medium;

public class MinimumPenaltyForAShop {
    public int bestClosingTime(String customers) {
        char[] arr = customers.toCharArray();
        int n = arr.length;
        int temp = 0;
        for (char c : arr) {
            if (c == 'N') temp++;
        }
        int ans = n;
        int min = temp;
        for(int i=n-1; i>=0; i--){
            if(arr[i] == 'Y'){
                temp++;
            } else{
                temp--;
            }
            if(temp <= min){
                ans = i;
                min = temp;
            }
        }
        return ans;
    }
}
