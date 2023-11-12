package Easy;

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i=1; i<=len/2; i++){
            String st = s.substring(0,i);
            if(len % st.length() == 0){
                StringBuilder sb = new StringBuilder(st);
                int len2 = st.length();
                while(len2 < len){
                    sb.append(st);
                    len2 += st.length();
                }
                if(sb.toString().equals(s)) return true;
            }
        }
        return false;
    }
}
