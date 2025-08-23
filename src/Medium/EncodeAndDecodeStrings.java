package Medium;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecodeStrings {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder delimiterIdx = new StringBuilder();
        StringBuilder strings = new StringBuilder();
        int len = 0;
        for(String s:strs){
            len += s.length();
            delimiterIdx.append(len+",");
            strings.append(s);
        }
        delimiterIdx.replace(delimiterIdx.length()-1,delimiterIdx.length(),"|");
        delimiterIdx.append(strings);
        return delimiterIdx.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        String[] delimiterIdx = s.substring(0,s.indexOf("|")).split(",");
        String strings = s.substring(s.indexOf("|")+1,s.length());
        int prevEndIdx = 0;
        List<String> ans = new ArrayList<>();
        for(String d : delimiterIdx){
            int idx = Integer.parseInt(d);
            ans.add(strings.substring(prevEndIdx,idx));
            prevEndIdx = idx;
        }
        return ans;
    }
}
