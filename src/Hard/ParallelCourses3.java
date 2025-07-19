package Hard;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;

public class ParallelCourses3 {
    public int minimumTime(int n, int[][] relations, int[] time) {
        HashSet<Integer>[] pre = new HashSet[n+1];
        HashSet<Integer>[] next = new HashSet[n+1];
        int[] totalMonth = new int[n+1];
        for(int i=1; i<n+1; i++){
            pre[i] = new HashSet();
            next[i] = new HashSet();
        }
        for(int[] relation:relations){
            int preCourse = relation[0];
            int nextCourse = relation[1];
            pre[nextCourse].add(preCourse);
            next[preCourse].add(nextCourse);
        }
        int ans = 0;
        Queue<Integer> takenCourses = new ArrayDeque();
        for(int i=1; i<n+1; i++){
            if(pre[i].isEmpty()){
                takenCourses.add(i);
                totalMonth[i] = time[i-1];
                ans = Math.max(ans,totalMonth[i]);
            }
        }
        while(!takenCourses.isEmpty()){
            Queue<Integer> temp = new ArrayDeque();
            while(!takenCourses.isEmpty()){
                int course = takenCourses.poll();
                HashSet<Integer> nextCourses = next[course];
                for(int c:nextCourses){
                    pre[c].remove(course);
                    totalMonth[c] = Math.max(totalMonth[course]+time[c-1],totalMonth[c]);
                    ans = Math.max(ans,totalMonth[c]);
                    if(pre[c].isEmpty()) temp.add(c);
                }
            }
            takenCourses = temp;
        }
        return ans;
    }
}
