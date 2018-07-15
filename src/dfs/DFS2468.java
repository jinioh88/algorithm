package dfs;

import java.util.Scanner;

public class DFS2468 {
    static int N;
    static int height;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] counts;  // 높이별 안전 단지 수
    static int count = 0;
    static final int[] dx = {0,-1,0,1};
    static final int[] dy = {-1,0,1,0};
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        init();
        inputMatrix();
        dfsAll(matrix, 3);
    }

    public static void init() {
        N = sc.nextInt();
        matrix = new int[N][N];
        visited = new boolean[N][N];
    }

    static public void inputMatrix() {
        // console 1줄씩 값 입력.
        String[] s = new String[N+1];
        for(int i=0;i<N;i++) {
            s[i] = sc.next();
            for(int j=0;j<N;j++) {
                matrix[i][j] = s[i].charAt(j)-'0';
            }
        }
    }

    public static void dfs(int[][] a, int row, int col, int height) {
        int nextRow;
        int nextCol;
        visited[row][col] = true;

        for(int i=0; i<4;i++) {
            nextRow = row + dx[i];
            nextCol = col + dy[i];
            if(nextRow>0 && nextRow<=N && nextCol>0 && nextCol<=N) {
                if(a[nextRow][nextCol]>height && !visited[nextRow][nextCol]) {
                    dfs(a, nextRow, nextCol, height);
                }
            }
        }
    }

    public static void dfsAll(int[][] a,int height) {
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && a[i][j]>height) {
                    visited[i][j] = true;
                    count++;
                    dfs(a, i,j,height);
                }
            }
        }
        System.out.println(count);
    }
}

