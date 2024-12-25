package Easy;

public class GoatLatin {
    public String toGoatLatin(String sentence) {
        String[] strs = sentence.split(" ");
        for(int i=0; i<strs.length; i++){
            String s = strs[i];
            StringBuilder sb = new StringBuilder();
            if(isVowel(s.charAt(0))){
                sb.append(s);
            } else{
                sb.append(s.substring(1,s.length()));
                sb.append(s.charAt(0));
            }
            sb.append("ma");
            for(int j=0; j<i+1; j++){
                sb.append('a');
            }
            strs[i] = sb.toString();
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<strs.length; i++){
            ans.append(strs[i]+" ");
        }
        return ans.toString().trim();
    }
    private boolean isVowel(char c){
        return c=='a' || c=='A' || c=='e' || c=='E' || c=='i' || c=='I' || c=='o' || c=='O' || c=='u' || c=='U';
    }
}
