package Medium;

import java.util.ArrayList;
import java.util.HashSet;

public class MinimumGeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> bankInSet = new HashSet<>();
        for(String gene : bank) bankInSet.add(gene);
        if(!bankInSet.contains(endGene)) return -1;
        ArrayList<String> currentCheckingGene = new ArrayList<>();
        currentCheckingGene.add(startGene);
        bankInSet.remove(startGene);
        int count = 1;
        while(!currentCheckingGene.isEmpty()){
            ArrayList<String> nextCheckingGene = new ArrayList<>();
            for(String gene : currentCheckingGene){
                for(String geneToCompare : bankInSet){
                    if(isMadeWithOneMutation(gene,geneToCompare)){
                        if(geneToCompare.equals(endGene)) return count;
                        nextCheckingGene.add(geneToCompare);
                    }
                }
                bankInSet.remove(gene);
            }
            count++;
            currentCheckingGene = nextCheckingGene;
        }
        return -1;
    }

    private boolean isMadeWithOneMutation(String startGene, String endGene){
        char[] startChar = startGene.toCharArray();
        char[] endChar = endGene.toCharArray();
        int count = 0;
        for(int i=0; i<startChar.length; i++){
            if(startChar[i] != endChar[i]) count++;
            if(count > 1) return false;
        }
        return true;
    }
}
