package Medium;

public class OptimalPartitionOfString {
    public int partitionString(String s) {
        boolean[] checkedChars = new boolean[26];
        char[] sArr = s.toCharArray();
        int ans = 0;
        for(int i=0; i<sArr.length; i++){
            char c = sArr[i];
            if(checkedChars[c-'a']){
                checkedChars = new boolean[26];
                ans++;
            }
            checkedChars[c-'a'] = true;
        }
        ans++;
        return ans;
    }
}
