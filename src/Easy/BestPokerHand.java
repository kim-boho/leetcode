package Easy;

public class BestPokerHand {
    public String bestHand(int[] ranks, char[] suits) {
        int[] rank = new int[14];
        char prev = suits[0];
        rank[ranks[0]]++;
        int max = 1;
        for(int i=1; i<ranks.length; i++){
            if(prev != suits[i]) prev = 'x';
            rank[ranks[i]]++;
            max = Math.max(max,rank[ranks[i]]);
        }
        if(prev != 'x') return "Flush";
        else if(max >= 3) return "Three of a Kind";
        else if(max >= 2) return "Pair";
        else return "High Card";
    }
}
