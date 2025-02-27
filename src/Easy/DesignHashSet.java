package Easy;

public class DesignHashSet {
    boolean[] hs;
    public DesignHashSet() {
        hs = new boolean[1000001];
    }

    public void add(int key) {
        hs[key] = true;
    }

    public void remove(int key) {
        hs[key] = false;
    }

    public boolean contains(int key) {
        return hs[key];
    }
}
