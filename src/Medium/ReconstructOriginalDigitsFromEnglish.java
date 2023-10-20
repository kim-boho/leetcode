package Medium;

public class ReconstructOriginalDigitsFromEnglish {
    public String originalDigits(String s) {
        int[] chars = new int[26];
        int[] ans = new int[10];

        for(int i=0; i<s.length(); i++){
            int idx = s.charAt(i)-'a';
            chars[idx]++;
        }

        String[] numsSt = {"zero","one","two","three","four","five","six","seven","eight","nine"};

        if(chars['g'-'a'] > 0) removeNum(chars['g'-'a'], numsSt[8], chars, ans, 8);
        if(chars['u'-'a'] > 0) removeNum(chars['u'-'a'], numsSt[4], chars, ans, 4);
        if(chars['w'-'a'] > 0) removeNum(chars['w'-'a'], numsSt[2], chars, ans, 2);
        if(chars['x'-'a'] > 0) removeNum(chars['x'-'a'], numsSt[6], chars, ans, 6);
        if(chars['z'-'a'] > 0) removeNum(chars['z'-'a'], numsSt[0], chars, ans, 0);
        if(chars['f'-'a'] > 0) removeNum(chars['f'-'a'], numsSt[5], chars, ans, 5);
        if(chars['s'-'a'] > 0) removeNum(chars['s'-'a'], numsSt[7], chars, ans, 7);
        if(chars['r'-'a'] > 0) removeNum(chars['r'-'a'], numsSt[3], chars, ans, 3);
        if(chars['i'-'a'] > 0) removeNum(chars['i'-'a'], numsSt[9], chars, ans, 9);
        if(chars['o'-'a'] > 0) removeNum(chars['o'-'a'], numsSt[1], chars, ans, 1);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<ans.length; i++){
            while(ans[i]-- > 0) sb.append(i);
        }

        return sb.toString();
    }

    private void removeNum(int count, String s, int[] chars, int[] ans, int num){
        for(int i=0; i<s.length(); i++){
            chars[s.charAt(i)-'a'] -= count;
        }
        ans[num] += count;
    }
}
