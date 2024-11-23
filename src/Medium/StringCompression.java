package Medium;

public class StringCompression {
    public int compress(char[] chars) {
        if(chars.length == 1) return 1;
        int idx = 0;
        int count = 1;
        char prev = chars[0];
        for(int i=1; i<chars.length; i++){
            if(chars[i] == prev){
                count++;
            } else{
                chars[idx++] = prev;
                if(count > 1){
                    String s = String.valueOf(count);
                    for(char c:s.toCharArray()){
                        chars[idx++] = c;
                    }
                }
                count = 1;
                prev = chars[i];
            }
        }
        chars[idx++] = prev;
        if(count > 1){
            String s = String.valueOf(count);
            for(char c:s.toCharArray()){
                chars[idx++] = c;
            }
        }
        return idx;
    }
}
