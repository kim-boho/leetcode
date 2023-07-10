package Medium;

import java.util.HashMap;

public class ImplementTrie {
    class Trie {
        TrieNode[] arr;
        public Trie() {arr = new TrieNode[26];}

        public void insert(String word) {
            TrieNode node = null;
            char c = word.charAt(0);
            if(arr[c-'a'] == null) arr[c-'a'] = new TrieNode(c);
            node = arr[c-'a'];
            for(int i=1; i<word.length(); i++){
                char temp = word.charAt(i);
                if(!node.children.containsKey(temp)){
                    TrieNode child = new TrieNode(temp);
                    node.children.put(temp, child);
                }
                node = node.children.get(temp);
            }
            node.destination = true;
            return;
        }

        public boolean search(String word) {
            char c = word.charAt(0);
            if(arr[c-'a'] == null) return false;
            TrieNode node = arr[c-'a'];
            for(int i=1; i<word.length(); i++){
                char temp = word.charAt(i);
                if(!node.children.containsKey(temp)) return false;
                node = node.children.get(temp);
            }
            return node.destination;
        }

        public boolean startsWith(String prefix) {
            char c = prefix.charAt(0);
            if(arr[c-'a'] == null) return false;
            TrieNode node = arr[c-'a'];
            for(int i=1; i<prefix.length(); i++){
                char temp = prefix.charAt(i);
                if(!node.children.containsKey(temp)) return false;
                node = node.children.get(temp);
            }
            return true;
        }
    }

    class TrieNode{
        char c;
        HashMap<Character, TrieNode> children;
        boolean destination;
        public TrieNode(char c){
            this.c = c;
            children = new HashMap<>();
            destination = false;
        }
    }
}
