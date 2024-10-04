package Medium;

import java.util.Arrays;

public class DividePlayersIntoTeamsOfEqualSkill {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        long ans = skill[0]*skill[n-1];
        int sum = skill[0]+skill[n-1];
        for(int i=1; i<n/2; i++){
            if(skill[i]+skill[n-i-1] == sum) ans += skill[i]*skill[n-i-1];
            else return -1;
        }
        return ans;
    }
}
