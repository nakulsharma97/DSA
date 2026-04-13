import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {

            boolean destroyed = false;

            // collision condition
            while (!st.isEmpty() && st.peek() > 0 && a < 0) {

                int top = st.peek();

                if (top < -a) {
                    // top gets destroyed
                    st.pop();
                } else if (top == -a) {
                    // both destroyed
                    st.pop();
                    destroyed = true;
                    break;
                } else {
                    // current gets destroyed
                    destroyed = true;
                    break;
                }
            }

            if (!destroyed) {
                st.push(a);
            }
        }

        // convert stack to array
        int[] res = new int[st.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = st.pop();
        }

        return res;
    }
}