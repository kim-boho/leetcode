package Easy;

public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        String ans = "";
        for(int i=0; i<Math.min(str1.length(),str2.length()); i++){
            if(str1.charAt(i) == str2.charAt(i)){
                sb.append(str1.charAt(i));
                String temp = sb.toString();
                if(str1.replace(temp,"").equals("") && str2.replace(temp,"").equals("")) ans = temp;
            } else{
                break;
            }
        }
        return ans;
    }
}
