package Hard;

import java.util.ArrayList;
import java.util.HashMap;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        // too slow
        if(t.length()>s.length()) return "";
        else{
            HashMap<Character, Integer> occurence = new HashMap<>();
            for(int i=0; i<t.length(); i++){
                char ch = t.charAt(i);
                if(occurence.containsKey(ch)){
                    occurence.put(ch, occurence.get(ch)+1);
                } else{
                    occurence.put(ch, 1);
                }
            }

            ArrayList<Integer> li = new ArrayList<>();
            for(int i=0; i<s.length(); i++){
                if(occurence.containsKey(s.charAt(i))) li.add(i);
            }

            int start = -1;
            int finish = s.length()+1;
            for(int i=0; i<li.size(); i++){
                int end = i;
                HashMap<Character, Integer> tempOccurence = new HashMap<>();
                boolean isMade = false;
                while(end<li.size()){
                    char ch = s.charAt(li.get(end));
                    if(tempOccurence.containsKey(ch)){
                        if(tempOccurence.get(ch) < occurence.get(ch)){
                            tempOccurence.put(ch, tempOccurence.get(ch)+1);
                        }
                    } else{
                        tempOccurence.put(ch, 1);
                    }
                    if(tempOccurence.equals(occurence)){
                        isMade = true;
                        break;
                    }
                    end++;
                }
                if(tempOccurence.equals(occurence)){
                    if(finish-start+1 > li.get(end)-li.get(i)+1){
                        start = li.get(i);
                        finish = li.get(end);
                    }
                }
            }
            if(start != -1){
                return s.substring(start, finish+1);
            } else return "";

        }
    }

    public String minWindow2(String s, String t) {
        if(t.length()>s.length()) return "";
        else{
            HashMap<Character, Integer> occurence = new HashMap<>();
            for(int i=0; i<t.length(); i++){
                char ch = t.charAt(i);
                if(occurence.containsKey(ch)){
                    occurence.put(ch, occurence.get(ch)+1);
                } else{
                    occurence.put(ch, 1);
                }
            }

            int ansIdx  = -1;
            int ansIdx2 = s.length()+1;
            int start = 0;
            int end = 0;
            int targetCount = t.length();
            while(end<s.length()){
                char ch = s.charAt(end);
                if(occurence.containsKey(ch)){
                    if(occurence.get(ch) > 0) targetCount--;
                    occurence.put(ch, occurence.get(ch)-1);
                }
                if(targetCount == 0) break;
                end++;
            }
            // find the first length

            if(targetCount != 0) return "";
            // if the string doesn't contain the target


            while(targetCount == 0){
                char ch = s.charAt(start);
                if(occurence.containsKey(ch) && occurence.get(ch) == 0) break;
                if(occurence.containsKey(ch)) occurence.put(ch, occurence.get(ch)+1);
                start++;
            } // move start index

            ansIdx = start;
            ansIdx2 = end;


            // whenever the end index is character in target, try to move the start index and decrease length
            for(int i=end+1; i<s.length(); i++){
                char ch = s.charAt(i);
                boolean moveStart = false;
                if(occurence.containsKey(ch)){
                    occurence.put(ch, occurence.get(ch)-1);
                    moveStart = true;
                }
                if(moveStart){
                    char ch2 = s.charAt(start);
                    while(start<s.length()){
                        if(occurence.containsKey(ch2) && occurence.get(ch2) < 0){
                            occurence.put(ch2, occurence.get(ch2)+1);
                        } else if(occurence.containsKey(ch2) && occurence.get(ch2) == 0) break;
                        start++;
                        ch2 = s.charAt(start);
                    }
                    if(ansIdx2-ansIdx > i-start){
                        ansIdx = start;
                        ansIdx2 = i;
                    }
                }
            }

            if(ansIdx == -1) return "";
            else return s.substring(ansIdx, ansIdx2+1);

        }
    }
}
