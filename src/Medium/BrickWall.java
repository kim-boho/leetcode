package Medium;

import java.util.HashMap;
import java.util.List;

public class BrickWall {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer, Integer> edges = new HashMap();
        int ans = 0;
        int sum = 0;
        for(int n: wall.get(0)) sum += n;
        for(int i=0; i<wall.size(); i++){
            int edge = 0;
            System.out.println(i+"th list");
            for(int j=0; j<wall.get(i).size(); j++){
                edge += wall.get(i).get(j);
                if(edges.containsKey(edge)){
                    edges.put(edge, edges.get(edge)+1);
                    System.out.println(edge+", "+edges.get(edge));
                } else{
                    edges.put(edge, 1);
                }
                if(edge != sum && ans < edges.get(edge)) ans = edges.get(edge);
            }
        }
        return wall.size() - ans;
    }
}
