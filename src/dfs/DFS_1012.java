package dfs;

import java.util.Scanner;

public class DFS_1012 {
    static int map[][];
    static boolean visited[][];
    static int m;
    static int n;

    static void dfs(int x, int y) {
        final int[] dx = {0,-1,0,1};
        final int[] dy = {-1,0,1,0};

        visited[x][y] = true;

        for(int i=0;i<4;i++) {
            int nextX = x+dx[i];
            int nextY = y+dy[i];
            if(nextX>=0 && nextX<m && nextY>=0 && nextY<n) {
                if(map[nextX][nextY]==1 && !visited[nextX][nextY]) {
                    dfs(nextX,nextY);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int test_case=0;test_case<T;test_case++) {
            m = sc.nextInt();
            n = sc.nextInt();
            int k = sc.nextInt();
            int cnt = 0;
            map = new int[m][n];
            visited = new boolean[m][n];

            for(int i=0;i<k;i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[x][y] = 1;
            }

            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(map[i][j]==1 && !visited[i][j]) {
                        dfs(i,j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }
}
