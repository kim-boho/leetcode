package Hard;

public class RegexExpressionMatching {
    public boolean isMatch(String s, String p) {
        while(p.contains("\\*")){
            int index = p.indexOf("\\*");
            char validChar = p.charAt(index-1);
            String removed = p.substring(index-1, index+1);
            if(validChar == '.'){
                p = p.replace(removed,"[a-z]#");
            } else{
                String str = "["+String.valueOf(validChar)+"]#";
                p = p.replace(removed,str);
            }
        }
        while(p.contains("\\.")) p = p.replace("\\.","[a-z]");

        p = p.replaceAll("#","*");

        return s.matches(p);
    }
}
