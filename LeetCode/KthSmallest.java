import java.util.*;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
 */
public class KthSmallest {
    public static int kthSmallest(int[][] matrix, int k) {
        if (matrix[0] == null) {
            return -1;
        }

        int size = matrix[0].length;
        int row = k / size;
        int offset = k % size;
        return matrix[row][offset - 1];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;

        System.out.println(kthSmallest(matrix, k));
    }
}