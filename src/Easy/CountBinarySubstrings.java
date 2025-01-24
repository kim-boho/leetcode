package Easy;

public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        char[] arr = s.toCharArray();
        int i=0;
        int ans = 0;
        while(i < arr.length){
            char curr = arr[i];
            int count = 0;
            while(i < arr.length && arr[i] == curr){
                i++;
                count++;
            }
            if(i != arr.length){
                int next = i;
                char opp = arr[i];
                while(count > 0 && i < arr.length && arr[i] == opp){
                    i++;
                    ans++;
                    count--;
                }
                i = next;
            }
        }
        return ans;
    }
}
