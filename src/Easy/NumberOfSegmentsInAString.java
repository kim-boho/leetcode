package Easy;

public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        if(s.length() == 0) return 0;
        int ans = 0;
        int idx = 0;
        while(idx < s.length()){
            while(idx < s.length() && s.charAt(idx) == ' ') idx++;
            if(idx < s.length()) ans++;
            while(idx < s.length() && s.charAt(idx) != ' ') idx++;
        }
        return ans;
    }
}
