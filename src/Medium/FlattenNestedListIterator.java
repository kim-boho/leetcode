package Medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FlattenNestedListIterator implements Iterator<Integer> {
    ArrayList<Integer> arr;
    int idx = 0;
    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        arr = new ArrayList<>();
        addInts(arr,nestedList);
    }

    private void addInts(ArrayList<Integer> q, List<NestedInteger> li){
        for(NestedInteger i:li){
            if(i.isInteger()) arr.add(i.getInteger());
            else{
                if(i.isInteger()) arr.add(i.getInteger());
                else addInts(arr,i.getList());
            }
        }
    }

    @Override
    public Integer next() {
        return arr.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx != arr.size();
    }
}
