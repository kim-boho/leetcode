package Medium;

import java.util.ArrayList;

public class DesignBrowserHistory {
    ArrayList<String> history;
    int backPos;
    int forPos;
    public DesignBrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        backPos = -1;
        forPos = 1;
    }

    public void visit(String url) {
        for(int i=history.size()-1; i>=forPos; i--){
            history.remove(i);
        }
        history.add(url);
        backPos++;
        forPos = history.size();
    }

    public String back(int steps) {
        while(steps > 0 && forPos-1 > 0){
            steps--;
            forPos--;
            backPos--;
        }
        return history.get(forPos-1);
    }

    public String forward(int steps) {
        while(steps > 0 && forPos < history.size()){
            forPos++;
            backPos++;
            steps--;
        }
        return history.get(backPos+1);
    }
}
