package Medium;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        int i = 0;
        char[] arr = s.toCharArray();
        int ans = 0;
        while(i < arr.length){
            int temp = i;
            i++;
            int count = 1;
            while(i < arr.length && arr[temp] == arr[i]){
                count++;
                i++;
            }
            ans += (count*(count+1)/2);
            int next = i;
            temp--;
            while(temp >= 0 && i < arr.length && arr[temp] == arr[i]){
                ans++;
                i++;
                temp--;
            }
            i = next;
        }
        return ans;
    }
}
