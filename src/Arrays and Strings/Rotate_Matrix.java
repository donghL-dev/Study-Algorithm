package com.donghun.coding_interview.Ch_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 행렬 회전
public class Rotate_Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(in.readLine());

        int[][] matrix = new int[n][n];

        matrix = rotate(matrix);
    }
    private static int[][] rotate(int[][] matrix) {
        int n = matrix.length;

        for (int layer=0; layer<n/2; layer++) {
            int first = layer;
            int last = n - 1 - layer;

            for(int i=first; i<last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                // 위쪽 <- 왼쪽
                matrix[first][i] = matrix[last - offset][first];

                // 왼쪽 <- 아래쪽
                matrix[last - offset][first] = matrix[last][last - offset];

                // 아래쪽 <- 오른쪽
                matrix[last][last - offset] = matrix[i][last];

                // 오른쪽 <- 위쪽
                matrix[i][last] = top;
            }
        }

        return matrix;
    }
}
