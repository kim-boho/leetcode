package Easy;

public class DesignCompressedStringIterator {
    String st;
    int idx;
    int count;
    char c;
    public DesignCompressedStringIterator(String compressedString) {
        st = compressedString;
        idx = 0;
        count = 0;
        setNextChar();
    }

    public char next() {
        if(count == 1){
            char temp = c;
            count--;
            setNextChar();
            return temp;
        } else if(count == 0){
            return ' ';
        } else{
            count--;
            return c;
        }
    }

    public boolean hasNext() {
        return count > 0;
    }

    private void setNextChar(){
        if(idx >= st.length()) return;
        c = st.charAt(idx++);
        int temp = idx;
        while(temp < st.length() && st.charAt(temp) >= '0' && st.charAt(temp) <= '9') temp++;
        String sub = st.substring(idx,temp);
        int val = Integer.parseInt(sub);
        count = val;
        idx = temp;
    }
}
