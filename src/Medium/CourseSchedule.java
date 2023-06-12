package Medium;

import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for(int i=0; i<prerequisites.length; i++){
            if(hm.containsKey(prerequisites[i][0])){
                hm.get(prerequisites[i][0]).add(prerequisites[i][1]);
            } else{
                ArrayList<Integer> li = new ArrayList<>();
                li.add(prerequisites[i][1]);
                hm.put(prerequisites[i][0], li);
            }
        }


        Iterator it = hm.keySet().iterator();


        while(it.hasNext()){
            int course = (int) it.next();
            Queue<Integer> q = new LinkedList<>();
            HashSet<Integer> isChecked = new HashSet<>();
            for(int i=0; i<hm.get(course).size(); i++) q.add(hm.get(course).get(i));
            while(q.size() != 0){
                int pre = q.poll();
                isChecked.add(pre);
                if(hm.containsKey(pre)){
                    for(int i=0; i<hm.get(pre).size(); i++){
                        if(hm.get(pre).get(i) == course) return false;
                        if(!isChecked.contains(hm.get(pre).get(i))){
                            q.add(hm.get(pre).get(i));
                            isChecked.add(hm.get(pre).get(i));
                        }
                    }
                }
            }
        }

        return true;
    }
}
