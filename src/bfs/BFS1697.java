package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS1697 {
    static int N, K;
    static int MAX = 1001;
    static Scanner sc = new Scanner(System.in);
    static boolean[] visited;
    static int cnt = 0;

    public static void main(String[] args) {
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new boolean[MAX];

        move(N);
        System.out.println(cnt);
        sc.close();
    }

    public static void move(int v) {
        Queue<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.offer(v);
        while(!queue.isEmpty()) {
            int point = ((LinkedList<Integer>) queue).pop();
            if(point==K) {
                cnt++;
                System.out.println(cnt);
                return;
            } else if(v-1>=0 && !visited[v-1]) {
                visited[v-1] = true;
                queue.offer(v-1);
            } else if(v+1<=MAX && !visited[v+1]) {
                visited[v+1] = true;
                queue.offer(MAX);
            } else if(v*2<=MAX && !visited[v*2]) {
                visited[v*2] = true;
                queue.offer(v*2);
            }
            cnt++;
        }
    }
}
