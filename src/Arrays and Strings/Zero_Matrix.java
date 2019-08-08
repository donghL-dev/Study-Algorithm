package com.donghun.coding_interview.Ch_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 0 행렬
public class Zero_Matrix {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(in.readLine());
        int row = Integer.valueOf(token.nextToken());
        int col = Integer.valueOf(token.nextToken());
        int[][] matrix =  randomMatrix(row, col, -10, 10);

        setZeros(matrix);

    }
    private static int[][] randomMatrix(int M, int N, int min, int max) {
        int[][] matrix = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = randomIntInRange(min, max);
            }
        }
        return matrix;
    }

    private static int randomIntInRange(int min, int max) {
        return randomInt(max + 1 - min) + min;
    }

    private static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    private static void setZeros(int[][] matrix) {
        boolean rowHasZero = false;
        boolean colHaszero = false;

        // 첫번째 행에 0이 있는지 확인
        for(int j=0; j<matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                rowHasZero = true;
                break;
            }
        }

        // 첫번째 열에 0이 있는지 확인
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][0] == 0) {
                colHaszero = true;
                break;
            }
        }

        // 나머지 배열에 0이 있는지 확인
        for(int i = 1; i<matrix.length; i++) {
            for(int j=1; j<matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // 첫번쨰 열을 이용해서 행을 0으로 바꾼다.
        for(int i=1; i<matrix.length; i++) {
            if(matrix[i][0] == 0) {
                nullifyRow(matrix, i);
            }
        }

        // 첫번째 행을 이용해서 열을 0으로 바꾼다.
        for(int j=1; j<matrix[0].length; j++) {
            if(matrix[j][0] == 0) {
                nullifyColumn(matrix, j);
            }
        }

        // 첫 번째 행을 0으로 바꾼다.
        if(rowHasZero) {
            nullifyRow(matrix, 0);
        }

        // 첫 번째 열을 0으로 바꾼다.
        if(colHaszero) {
            nullifyColumn(matrix, 0);
        }
    }

    private static void nullifyRow(int[][] matrix, int row) {
        for(int j=0; j<matrix[0].length; j++) {
            matrix[row][j] = 0;
        }
    }

    private static void nullifyColumn(int[][] matrix, int col) {
        for(int i=0; i<matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }
}
