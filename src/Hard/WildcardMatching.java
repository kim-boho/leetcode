package Hard;

public class WildcardMatching {

    public boolean isMatch(String s, String p) {
        // time limitation fail

        int index = 0;
        StringBuilder sb = new StringBuilder("");
        p = p.replaceAll("\\*{1,}","\\*");
        while(index<p.length()){
            char ch = p.charAt(index);
            if(ch == '*'){
                sb.append("[a-z]*");
            } else if(ch == '?'){
                sb.append("[a-z]");
            } else{
                sb.append("["+String.valueOf(ch)+"]");
            }
            index++;
        }
        System.out.println(sb.toString());
        return s.matches(sb.toString());
    }

    public boolean isMatch2(String s, String p) {
        int sIdx = 0;
        int pIdx = 0;
        int matched = -1;
        int star = -1;

        while(sIdx < s.length()){
            if(pIdx < p.length() && (s.charAt(sIdx) == p.charAt(pIdx) || p.charAt(pIdx) == '?')){
                sIdx++; pIdx++;
            } else if(pIdx < p.length() && p.charAt(pIdx) == '*'){
                // save matched index in s
                matched = sIdx;

                // star's index
                star = pIdx;

                pIdx++;
            } else if(matched != -1){
                // if star had appeared

                // assume the character in s is valid by star
                // so, return to next index of star
                pIdx = star + 1;

                // update matched index
                matched++;

                // move s index to mached index
                sIdx = matched;
            } else {
                return false;
            }
        }
        // if pattern was left
        while(pIdx < p.length()){
            if(p.charAt(pIdx++) != '*'){
                return false;
            }
        }
        return true;
    }
}
