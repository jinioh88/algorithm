package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS1278 {
    static int M,N;
    static Scanner sc = new Scanner(System.in);
    static Queue<Integer> queue = new LinkedList<>();
    static int [][] matrix;
    static boolean[][] visited;
    boolean isTrue;
    static final int[] dx = {0,-1,0,1};  // 행렬의 상하좌우 확인용
    static final int[] dy = {-1,0,1,0};
    static int cnt = 0;

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();

        String[] s = new String[M+1];
        matrix = new int[N][M];

        for(int i=0;i<N;i++) {
            s[i] = sc.next();
            for(int j=0;j<M;j++) {
                matrix[i][j] = s[i].charAt(j)-'0';
            }
        }

        bfs(0,0);
    }

    public static void bfs(int x, int y) {
        int val = matrix[x][y];
        int nextX, nextY;
        for(int i=0;i<4;i++) {
            nextX = x+dx[i];
            nextY = y+dy[i];

            if(nextX>0 && nextX<=M && nextY>0 && nextY<=N) {
                if(matrix[nextX][nextY]==1 && !visited[nextX][nextY]) {
                    bfs(x,nextY);
                }
            }

        }
        System.out.println(cnt);
    }

}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
