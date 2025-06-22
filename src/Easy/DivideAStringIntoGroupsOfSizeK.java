package Easy;

public class DivideAStringIntoGroupsOfSizeK {
    public String[] divideString(String s, int k, char fill) {
        int newLen = ((int)Math.ceil((double)s.length()/(double)k))*k;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<newLen-s.length(); i++) sb.append(fill);
        String newS = s+sb.toString();
        String[] ans = new String[newLen/k];
        int j = 0;
        for(int i=0; i<newLen; i+=k) ans[j++] = newS.substring(i,i+k);
        return ans;
    }
}
