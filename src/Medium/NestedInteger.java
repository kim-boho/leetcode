package Medium;

import java.util.List;

public interface NestedInteger {

    public boolean isInteger();

    public Integer getInteger();

    public void setInteger(int value);

    public void add(NestedInteger ni);
    public List<NestedInteger> getList();
}
