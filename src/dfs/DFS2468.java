package dfs;

import java.util.Scanner;

public class DFS2468 {
    static int N;
    static int height;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] counts;  // 높이별 안전 단지 수
    static int count;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

    }

    public static void dfs(int row, int col, int height) {
        visited[row][col] = true;
    }

    public static void dfsAll(int row, int col,int height) {

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[row][col] && matrix[row][col]>height) {
                    dfs(row,col,height);
                    count++;
                }
            }
        }
    }
}
