package Easy;

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] orders = new int[26];
        char[] chars = order.toCharArray();
        for(int i=0; i<chars.length; i++){
            orders[chars[i]-'a'] = i;
        }
        for(int i=0; i<words.length-1; i++){
            String s1 = words[i];
            String s2 = words[i+1];
            char[] chars1 = s1.toCharArray();
            char[] chars2 = s2.toCharArray();
            int j=0;
            int min = Math.min(chars1.length,chars2.length);
            for(; j<min; j++){
                if(orders[chars1[j]-'a'] > orders[chars2[j]-'a']) return false;
                else if(orders[chars1[j]-'a'] < orders[chars2[j]-'a']) break;
            }
            if(j == min){
                if(chars1.length > chars2.length) return false;
            }
        }
        return true;
    }
}
