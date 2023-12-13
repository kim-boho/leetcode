package Easy;

public class ConstructTheRectangle {
    public int[] constructRectangle(int area) {
        int[] ans = new int[2];
        ans[0] = area;
        ans[1] = 1;
        for(int i=2; i<=Math.sqrt(area); i++){
            if(area % i == 0){
                int larger = Math.max(i, area/i);
                int smaller = Math.min(i, area/i);
                if(ans[0]-ans[1] > larger - smaller){
                    ans[0] = larger;
                    ans[1] = smaller;
                }
            }
        }
        return ans;
    }
}
