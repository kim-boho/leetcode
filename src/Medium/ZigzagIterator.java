package Medium;

import java.util.List;

public class ZigzagIterator {
    List<Integer> v1;
    List<Integer> v2;
    int i;
    int j;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;
        this.v2 = v2;
        i = 0;
        j = 0;
    }

    public int next() {
        if(i == v1.size() || j == v2.size()){
            if(i == v1.size()) return v2.get(j++);
            else return v1.get(i++);
        } else{
            if(i <= j) return v1.get(i++);
            else return v2.get(j++);
        }
    }

    public boolean hasNext() {
        return i < v1.size() || j < v2.size();
    }
}
