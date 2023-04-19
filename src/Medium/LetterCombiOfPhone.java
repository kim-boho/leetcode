package Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LetterCombiOfPhone {
    public static void main(String[] args) {
        LetterCombiOfPhone obj = new LetterCombiOfPhone();
        List<String> str = obj.letterCombinations("23");
        for(String st:str) System.out.println(st);
    }
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        Set<String> hs = new HashSet<>();
        if(digits.length()==0) return ans;
        char[] combi = new char[digits.length()];
        boolean[] checked = new boolean[digits.length()];
        char[][] chars = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};
        int[] charDepth = {3,3,3,3,3,4,3,4};
        int depth = 0;
        dfs(depth, combi, digits, checked, charDepth, chars, hs);
        ans = new ArrayList<>(hs);
        return ans;
    }

    private void dfs(int depth, char[] combi, String digits, boolean[] checked, int[] charDepth, char[][] chars, Set<String> hs){
        if(depth == digits.length()){
            StringBuilder sb = new StringBuilder("");
            for(char c:combi) sb.append(c);
            hs.add(sb.toString());
        } else{
            int digit =  Character.getNumericValue(digits.charAt(depth));
            for(int i=0; i<digits.length(); i++){
                if(!checked[depth]) {
                    int secDepth = 0;
                    while(charDepth[digit - 2]>secDepth){
                        checked[depth] = true;
                        combi[depth] = chars[digit - 2][charDepth[digit - 2] - 1 - secDepth++];
                        dfs(depth + 1, combi, digits, checked, charDepth, chars, hs);
                        checked[depth] = false;
                    }
                }
            }
        }
    }
}
