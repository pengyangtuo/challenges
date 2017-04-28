import java.util.*;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        Stack<Integer> pos = new Stack<Integer>();
        int max = 0;
        int i = 0;
        for (; i <= size; i++) {
            int h = (i == size) ? 0 : heights[i];
            if (!pos.empty() && h < heights[pos.peek()]) {
                while(!pos.empty() && heights[pos.peek()] > h) {
                    int lastHeightIdx = pos.pop();
                    int lastHeight = heights[lastHeightIdx];
                    int localMax = lastHeight * (i - (pos.empty() ? 0 : (pos.peek()+1)));
                    if(localMax > max){ // 4ms faster (30% increase in leetcode submission ranking) comparing to use Math.max()
                        max = localMax;
                    }
                }
            }

            pos.push(i);
        }

        return max;
    }

    public static void main(String[] args) {
        LargestRectangleInHistogram sol = new LargestRectangleInHistogram();

        int[] heights = {4, 2, 0, 3, 2, 5};
        System.out.println(sol.largestRectangleArea(heights));
    }
}