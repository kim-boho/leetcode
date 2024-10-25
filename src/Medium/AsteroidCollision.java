package Medium;

import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int asteroid : asteroids) {
            if (st.isEmpty()) st.add(asteroid);
            else {
                int a = asteroid;
                if (a > 0) {
                    st.add(a);
                } else {
                    while (true) {
                        int num = st.peek();
                        if (num < 0) {
                            st.add(a);
                            break;
                        } else {
                            if (num + a < 0) {
                                st.pop();
                                if (st.isEmpty()) {
                                    st.add(a);
                                    break;
                                }
                            } else if (num + a == 0) {
                                st.pop();
                                break;
                            } else break;
                        }
                    }
                }
            }
        }
        int[] ans = new int[st.size()];
        for(int i=ans.length-1; i>=0; i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}
