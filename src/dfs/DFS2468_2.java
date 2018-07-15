package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class DFS2468_2 {
    static int N;
    static int[][] data;
    static boolean[][] visited;
    static final int[] dx = {0,-1,0,1};
    static final int[] dy = {-1,0,1,0};

    public static void dfs(int x, int y, int h) {
        visited[x][y] = true;

        for(int i=0;i<4;i++) {
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            if(nextX>=0 && nextX<N && nextY>=0 && nextY<N) {
                if(visited[nextX][nextY]==false && data[nextX][nextY]>h) {
                    dfs(nextX,nextY,h);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        int max = 0;
        N = Integer.parseInt(st.nextToken());
        data = new int[N][N];

        for(int h=0;h<=max;h++) {
            st = new StringTokenizer(br.readLine());
            visited = new boolean[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(data[i][j]>=h) {
                        cnt++;
                        dfs(i,j,h);
                    }
                }
            }
            if(max<cnt) {
                max = cnt;
            }
        }
        System.out.println("최대 수 : "+max);
    }
}
