import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for (int i = 0; i <= heights.length; i++) {
            int curr = i == heights.length ? 0 : heights[i];

            while (!st.isEmpty() &&
                   (i == heights.length || heights[st.peek()] > curr)) {

                int h = heights[st.pop()];
                int left = st.isEmpty() ? -1 : st.peek();

                ans = Math.max(ans, h * (i - left - 1));
            }

            if (i < heights.length)
                st.push(i);
        }

        return ans;
    }
}