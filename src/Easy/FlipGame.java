package Easy;

import java.util.ArrayList;
import java.util.List;

public class FlipGame {
    public List<String> generatePossibleNextMoves(String currentState) {
        int start = currentState.indexOf("++");
        List<String> ans = new ArrayList<>();
        while(start != -1){
            StringBuilder sb = new StringBuilder();
            sb.append(currentState.substring(0,start));
            sb.append("--");
            sb.append(currentState.substring(start+2,currentState.length()));
            ans.add(sb.toString());
            start = currentState.indexOf("++",start+1);
        }
        return ans;
    }
}
