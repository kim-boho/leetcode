package Easy;

public class FindTheDifference {
    public char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }
        arr[t.charAt(s.length())-'a']--;

        for(int i=0; i<26; i++){
            if(arr[i] != 0) return (char)('a'+i);
        }
        return 'a';
    }
}
