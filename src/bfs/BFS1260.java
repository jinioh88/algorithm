package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS1260 {
    private static int N,M;
    private static int V;
    private static int matrix[][];
    private static boolean visited[];
    static Scanner sc = new Scanner(System.in);
    private static final int[] dx = {0,-1,0,1};
    private static final int[] dy = {-1,0,1,0};

    public static void main(String[] args) {
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        matrix = new int[100][100];
        visited = new boolean[100];

        for(int i=0;i<M;i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            matrix[x-1][y-1] = matrix[y-1][x-1] = 1;
        }

        dfs(0);

        for(int i=0;i<matrix.length;i++) {
            visited[i] = false;
        }
        System.out.println();

        bfs(0);
    }

    public static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        int out;

        queue.offer(v+1);
        visited[v] = true;
        System.out.println(v+1+" ");

        while(!queue.isEmpty()) {
            out = queue.poll();
            for(int i=0;i<M;i++) {
                if(matrix[out-1][i]==1 && !visited[i]) {
                    queue.offer(i+1);
                    visited[i] = true;
                    System.out.println(i+1+" ");
                }
            }
        }
    }

    public static void dfs(int v) {
        visited[v] = true;
        System.out.println(v+1);
        for(int i=0;i<N;i++) {
            if(matrix[v][i]==1 && !visited[i]) {
                dfs(i);
            }
        }
    }

}
