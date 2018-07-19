package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Tomato {
    private static int max = Integer.MIN_VALUE;
    private static int m,n;
    private static int map[][];
    private static boolean visited[][];
    private static String[] input;
    private static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().trim().split(" ");

        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        map = new int[n][m];
        visited = new boolean[n][m];

        init();

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!visited[i][j] && map[i][j]==1) {
                    bfs(i,j);
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(map[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
                if(max < map[i][j]) {
                    max = map[i][j];
                }
            }
        }

        System.out.print(max-1);
    }

    public static void init() throws IOException {
        for(int i=0;i<n;i++) {
            input = br.readLine().trim().split(" ");
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
    }

    private static void bfs(int a, int b) {
        Queue<Node> q = new <Node>LinkedList();
        q.offer(new Node(a, b));
        while(!q.isEmpty()) {
            Node node = q.poll();

            int x, y, ax, ay;

            x= node.getX();
            y = node.getY();

            int[] dx = {1,-1, 0, 0};
            int[] dy = {0, 0, 1,-1};

            for(int i=0; i<4; i++) {
                ax = x + dx[i];
                ay = y + dy[i];
                if(ax >= 0 && ax < n && ay >=0 && ay <m) {
                    if((map[ax][ay] == 0 || map[ax][ay] > map[x][y]+1)) {
                        map[ax][ay] = map[x][y]+1;
                        q.offer(new Node(ax, ay));
                    }
                }
            }
        }

    }

    static class Node {
        private int x;
        private int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
        int getX(){
            return x;
        }
        int getY(){
            return y;
        }
    }
}
