package Medium;

import java.util.Arrays;

public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        int[] ans = new int[deck.length];
        helper(ans, deck, 0, 1, false);
        return ans;
    }
    private void helper(int[] ans, int[] deck, int d, int jump, boolean removeTop){
        if(d == deck.length) return;
        int i = 0;
        while(i < deck.length && ans[i] != 0) i++;
        for(; i<deck.length; i += jump){
            if(removeTop) removeTop = false;
            else{
                removeTop = true;
                if(ans[i] != 0) break;
                ans[i] = deck[d++];
            }
        }
        helper(ans, deck, d, jump+1, removeTop);
    }
}
