package com.sj902.graph;

public class FloodFill {

    public static void main(String[] args) {
        floodFill(new int[][]{{1,1,1},{1,1,0},{1,0,1}}, 1,1,2);
    }
    static int[][] dirs;

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;

        int srcCol = image[sr][sc];
        dirs = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};

        dfs(image, sr, sc, srcCol, color);
        return image;
    }

    private static void dfs(int[][] image, int sr, int sc, int srcCol, int color) {
        int m = image.length;
        int n = image[0].length;
        if(sr>=m || sc>=n) return;
        if(sr<0 || sc<0) return;
        image[sr][sc] = color;
        for (int[] dir:dirs) {
            if(sr+dir[0]<m && sc+dir[1]<n && image[sr+dir[0]][sc+dir[1]] == srcCol){
                dfs(image, sr+dir[0], sc+dir[1], srcCol, color);
            }
        }
    }
}
