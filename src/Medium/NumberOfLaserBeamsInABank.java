package Medium;

public class NumberOfLaserBeamsInABank {
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int prev = 0;
        for(String s:bank){
            int count = 0;
            char[] arr = s.toCharArray();
            for (char c : arr) if (c == '1') count++;
            if(count == 0) continue;
            else{
                ans += prev*count;
                prev = count;
            }
        }
        return ans;
    }
}
