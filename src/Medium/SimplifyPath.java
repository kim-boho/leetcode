package Medium;

import java.util.ArrayList;
import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        int i = 0;
        Stack<String> dirs = new Stack<>();
        String[] strs = path.split("/+");
        for(String s:strs){
            if(s.isEmpty()) continue;
            else if(s.equals(".")) continue;
            else if(s.equals("..")){
                if(!dirs.isEmpty()) dirs.pop();
            }else{
                dirs.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> li = new ArrayList<>();
        while(!dirs.isEmpty()) li.add(dirs.pop());
        for(int j=li.size()-1; j>=0; j--){
            sb.append("/").append(li.get(j));
        }
        if(sb.toString().isEmpty()) return "/";
        else return sb.toString();
    }
}
