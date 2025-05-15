package Medium;

import java.util.List;

public class ApplySubstitutions {
    public String applySubstitutions(List<List<String>> replacements, String text) {
        String[][] vals = new String[26][2];
        for(List<String> str:replacements){
            String s = str.get(1);
            char c = str.get(0).charAt(0);
            vals[c-'A'][0] = s;
            vals[c-'A'][1] = s.indexOf("%") == -1? "x":"o";
        }
        for(int i=0; i<vals.length; i++){
            String[] strFlag = vals[i];
            if(strFlag[1] != null && strFlag[1].equals("o")){
                replaceStr(i, vals);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<text.length(); i++){
            char c = text.charAt(i);
            if(c != '%') sb.append(c);
            else{
                sb.append(vals[text.charAt(i+1)-'A'][0]);
                i += 2;
            }
        }
        return sb.toString();
    }

    private String replaceStr(int idx, String[][] vals){
        String val = vals[idx][0];
        if(vals[idx][1].equals("x")){
            return val;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<val.length(); i++){
            char c = val.charAt(i);
            if(c != '%') sb.append(c);
            else{
                int temp = val.charAt(i+1)-'A';
                sb.append(replaceStr(temp,vals));
                i+=2;
            }
        }
        vals[idx][1] = "o";
        vals[idx][0] = sb.toString();
        return vals[idx][0];
    }
}
