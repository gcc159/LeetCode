package DynamicProgramming.Maximal_Square;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public int maximalSquare(char[][] matrix) {
        int[][] maxSize = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            maxSize[i][0] = matrix[i][0] - '0';
        }
        for (int j = 0; j < matrix[0].length; j++)
            maxSize[0][j] = matrix[0][j] - '0';

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++)
                if (matrix[i][j] == '0')
                    maxSize[i][j] = 0;
                else
                    maxSize[i][j] = Math.min(maxSize[i - 1][j - 1], Math.min(maxSize[i - 1][j], maxSize[i][j - 1])) + 1;
        }

        int res = 0;

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++)
                res = maxSize[i][j] > res ? maxSize[i][j] : res;

        }
        return res * res;
    }
}
