package Medium;

import java.util.HashMap;
import java.util.Iterator;

public class DesignAddAndSearchWordsDataStructure {
    class WordDictionary {
        Trie[] trieArr;
        public WordDictionary() {
            trieArr = new Trie[26];
        }

        public void addWord(String word) {
            char[] arr = word.toCharArray();
            if(trieArr[arr[0]-'a'] == null){
                trieArr[arr[0]-'a'] = new Trie(arr[0]);
            }
            Trie t = trieArr[arr[0]-'a'];
            for(int i=1; i<arr.length; i++){
                char c = arr[i];
                HashMap<Character, Trie> hm = t.next;
                if(!hm.containsKey(c)){
                    t.addNext(c);
                }
                t = hm.get(c);
            }
            t.isEnd = true;
        }

        public boolean search(String word) {
            char c = word.charAt(0);
            if(c == '.'){
                for(Trie t:trieArr){
                    if(t != null && helper(word, t, 1)) return true;
                }
                return false;
            } else if(trieArr[word.charAt(0)-'a'] != null){
                Trie start = trieArr[word.charAt(0)-'a'];
                return helper(word, start, 1);
            } else return false;
        }

        private boolean helper(String word, Trie t, int idx){
            if(idx == word.length()){
                return t.isEnd;
            }
            char c = word.charAt(idx);
            if(c == '.'){
                Iterator it = t.next.keySet().iterator();
                while(it.hasNext()){
                    Trie temp = t.next.get((char)it.next());
                    if(helper(word, temp, idx+1)) return true;
                }
                return false;
            } else{
                if(t.next.get(c) != null){
                    return helper(word, t.next.get(c), idx+1);
                } else return false;
            }
        }
    }

    class Trie{
        char val;
        HashMap<Character, Trie> next;
        boolean isEnd = false;
        public Trie(char c){
            val = c;
            next = new HashMap();
        }

        public void addNext(char c){
            if(!next.containsKey(c)){
                Trie temp = new Trie(c);
                next.put(c, temp);
            }
        }
    }
}
