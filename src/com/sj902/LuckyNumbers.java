package com.sj902;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbers {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] rowMin = new int[m];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        int[] colMax = new int[n];
        Arrays.fill(colMax, Integer.MIN_VALUE);

        for(int i = 0; i< m; ++i){
            for(int j = 0; j< n; ++j){
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
                colMax[j] = Math.max(colMax[i], matrix[i][j]);
            }
        }


        List<Integer> res= new ArrayList<>();
        for(int i = 0; i< m; ++i){
            for(int j = 0; j< n; ++j){
                if(matrix[i][j] == rowMin[i] && matrix[i][j]==colMax[j]){
                    res.add(matrix[i][j]);
                }
            }
        }
        return res;
    }
}