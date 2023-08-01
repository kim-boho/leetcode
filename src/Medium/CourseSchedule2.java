package Medium;

import java.util.ArrayList;

public class CourseSchedule2 {
    boolean isDone = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        if(prerequisites.length == 0){
            for(int i=0; i<numCourses; i++) ans[i] = i;
            return ans;
        }
        boolean[] needPre = new boolean[numCourses];
        boolean[] checked = new boolean[numCourses];
        ArrayList<Integer>[] li = new ArrayList[numCourses];

        for(int i=0; i<li.length; i++){
            li[i] = new ArrayList<>();
        }

        for(int i=0; i<prerequisites.length; i++){
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            needPre[course] = true;
            li[pre].add(course);
        }

        ArrayList<Integer> order = new ArrayList<>();
        dfs(numCourses, needPre, checked, li, ans, order);
        if(isDone) return ans;
        else{
            ans = new int[0];
            return ans;
        }

    }

    public void dfs(int numCourses, boolean[] needPre, boolean[] checked, ArrayList<Integer>[] li, int[] ans, ArrayList<Integer> order){
        if(order.size() == numCourses){
            for(int i=0; i<order.size(); i++){
                ans[i] = order.get(i);
                isDone = true;
            }
            return;
        }
        for(int i=0; i<checked.length; i++){
            if(!isDone && !checked[i] && !needPre[i]){
                checked[i] = true;
                order.add(i);
                if(order.size() == numCourses) dfs(numCourses, needPre, checked, li, ans, order);
                if(li[i].size() != 0){
                    for(int j=0; !isDone && j<li[i].size(); j++){
                        int next = li[i].get(j);
                        needPre[next] = false;
                    }
                    dfs(numCourses, needPre, checked, li, ans, order);
                    for(int j=0; !isDone && j<li[i].size(); j++){
                        int next = li[i].get(j);
                        needPre[next] = true;
                    }
                }
                order.remove(order.size()-1);
                checked[i] = false;
            }
        }
    }
}
