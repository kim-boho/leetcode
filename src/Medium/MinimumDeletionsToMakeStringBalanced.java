package Medium;

public class MinimumDeletionsToMakeStringBalanced {
    public int minimumDeletions(String s) {
        char[] arr = s.toCharArray();
        int a = 0;
        int b = 0;
        for(char c:arr){
            if(c == 'a') a++;
        }
        int ans = a;
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 'a') a--;
            else b++;
            ans = Math.min(b+a,ans);
        }
        return ans;
    }
}
