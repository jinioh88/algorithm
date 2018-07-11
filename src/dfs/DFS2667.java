package dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
  <힌트>
    단지 세는 변수 위치
    메트릭스 상하좌우 방향 체크
 */
public class DFS2667 {
    static int  n; // 입력 문자 갯수
    static int[][] matrix;  // 인접 행렬
    static boolean[][] visited;  // 방문했나 확인
    static final int[] dx = {0,-1,0,1};  // 행렬의 상하좌우 확인용
    static final int[] dy = {-1,0,1,0};
    static ArrayList<Integer> list = new ArrayList<>();  // 해당 집단 방문횟수 저장용.
    static int danjiN = 0;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        init();

        inputMatrix();

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=n;j++) {
                if(matrix[i][j]==1 && !visited[i][j]) {
                    danjiN++; // 위치가 여기라는거....
                    int cnt = dfs(i,j,danjiN,0);
                    list.add(cnt);
                }
            }
        }
        printRes();
    }

    static public void init() {
        n = sc.nextInt();
        matrix = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

    }

    static public void inputMatrix() {
        // console 1줄씩 값 입력.
        String[] s = new String[n+1];
        for(int i=1;i<=n;i++) {
            s[i] = sc.next();
            for(int j=1;j<=n;j++) {
                matrix[i][j] = s[i].charAt(j-1)-'0';
            }
        }
    }

    static public int dfs(int row, int col, int dan, int cnt) {
        int nextRow;
        int nextCol;

        cnt++;
        visited[row][col] = true;

        for(int i=0;i<4;i++) {
            nextRow = row + dx[i];
            nextCol = col + dy[i];
            if(nextRow>0 && nextRow<=n && nextCol>0 && nextCol<=n) {
                if(matrix[nextRow][nextCol]==1 && !visited[nextRow][nextCol]) {
                    cnt = dfs(nextRow, nextCol, dan, cnt);
                }
            }
        }
        return cnt;
    }

    static public void printRes() {
        Collections.sort(list);
        System.out.println("총 단지 수 : "+ danjiN);
        for(int n : list) {
            System.out.println(n);
        }
    }
}
