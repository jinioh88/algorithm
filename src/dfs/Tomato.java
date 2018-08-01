package dfs;

import java.util.Scanner;

/*
  검사한 칸이 토마토가 익었는지 안익었는지 비었는지 구분.
 */
public class Tomato {
    static int M,N;
    static boolean[][] redtomato;
    static boolean[][] visited;
    static int matrix[][];
    static final int[] dx = {0,-1,0,1};
    static final int[] dy = {-1,0,1,0};
    static int date;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        init();

        inputMatrix();


        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                if(matrix[N][M]==1 && !redtomato[N][M] && !visited[N][M]) {
                    dfs(N,M);
                }
            }
        }
        System.out.println(date);
    }

    static public void inputMatrix() {
        // console 1줄씩 값 입력.
        String[] s = new String[M];
        for(int i=0;i<N;i++) {
            s[i] = sc.next();
            for(int j=0;j<M;j++) {
                matrix[i][j] = s[i].charAt(j)-'0';
            }
        }
    }

    public static void init() {
        M = sc.nextInt();
        N = sc.nextInt();
        matrix = new int[N][M];
        redtomato = new boolean[N][M];
        visited = new boolean[N][M];
        date = 0;
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        if(matrix[x][y]==1)
            redtomato[x][y] = true;
        for(int i=0;i<4;i++) {
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            if(nextX>=0 && nextX<N && nextY>=0 && nextY<N) {
                if(redtomato[nextX][nextY]==false && !visited[nextX][nextY] && matrix[nextX][nextY]==1) {
                    date++;
                    dfs(nextX,nextY);
                } else if(redtomato[nextX][nextY]==false && !visited[nextX][nextY] && matrix[nextX][nextY]==-1) {
                    date++;
                }
            }
        }
    }
}
