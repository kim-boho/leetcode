package Medium;

import java.util.ArrayList;

public class CourseSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] taken = new boolean[numCourses];
        boolean[] needPre = new boolean[numCourses];
        ArrayList<Integer>[] pres = new ArrayList[numCourses];

        for(int i=0; i<numCourses; i++){
            ArrayList<Integer> pre = new ArrayList<>();
            pres[i] = pre;
        }

        for(int i=0; i<prerequisites.length; i++){
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            needPre[course] = true;
            pres[course].add(pre);
        }

        ArrayList<Integer> order = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            if(!needPre[i]){
                order.add(i);
                taken[i] = true;
            }
        }
        int[] ans = new int[numCourses];
        ans[0] = -1;
        int[] dummy = new int[0];
        dfs(numCourses, taken, order, pres, ans);
        return ans[0] != -1? ans:dummy;
    }

    private void dfs(int numCourses, boolean[] taken, ArrayList<Integer> order, ArrayList<Integer>[] pres, int[] ans){
        if(order.size() == numCourses){
            for(int i=0; i<ans.length; i++){
                ans[i] = order.get(i);
            }
            return;
        }

        for(int i=0; i<numCourses; i++){
            if(!taken[i]){
                ArrayList<Integer> tempPres = pres[i];
                boolean canTaken = true;
                for(int j=0; j<tempPres.size(); j++){
                    if(!taken[tempPres.get(j)]){
                        canTaken = false;
                        break;
                    }
                }
                if(canTaken){
                    order.add(i);
                    taken[i] = true;
                    dfs(numCourses, taken, order, pres, ans);
                    order.remove(order.size()-1);
                }
            }
        }
    }
}
