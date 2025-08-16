package Medium;

public class HIndex2 {
    public int hIndex(int[] citations) {
        int numOfPapers = citations.length;
        int left = 0;
        int right = numOfPapers-1;
        int ans = citations[0] == 0? 0:1;
        while(left <= right){
            int mid = left+(right-left)/2;
            if(citations[mid] >= numOfPapers-mid){
                ans = numOfPapers-mid;
                right = mid-1;
            } else left = mid+1;
        }
        return ans;
    }
}
