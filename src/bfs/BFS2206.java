package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS2206 {

    static int n,m,x,y,ax,ay,v;
    static int map[][]=new int[1001][1001];
    static int d[][][]=new int[1001][1001][2];
    static int dx[] = {1,-1,0,0};
    static int dy[] = {0,0,1,-1};

    public static void main(String args[]) throws NumberFormatException, IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());

        for(int i = 1 ; i <= n ; i++){
            String s = br.readLine();
            for(int j = 1 ; j <= m ; j++){
                map[i][j]=s.charAt(j-1)-'0';
            }
        }

        bfs(1,1);
        if(d[n][m][1] == 0){
            System.out.println(-1);
        }else{
            System.out.println(d[n][m][1]+1);
        }
    }

    public static void bfs(int a, int b){
        Queue<Node> q = new LinkedList();
        q.add(new Node(a,b,0));
        while(!q.isEmpty()){
            x = q.peek().x;
            y = q.peek().y;
            v = q.poll().visited;

            for(int i = 0 ; i < 4 ; i++){
                ax = x+dx[i];
                ay = y+dy[i];
                if(ax>0&&ay>0&&ax<=n&&ay<=m){
                    if(map[ax][ay]==0){
                        if(v==0){
                            if(d[ax][ay][0]==0 || d[ax][ay][0]>d[x][y][0]+1){
                                d[ax][ay][0]=d[x][y][0]+1;
                                q.add(new Node(ax,ay,0));
                            }
                        }
                        if(d[ax][ay][1]==0 || d[ax][ay][1]>d[x][y][1]+1){
                            d[ax][ay][1] = d[x][y][1]+1;
                            q.add(new Node(ax,ay,1));
                        }
                    }
                    else{
                        if(v==0){
                            if(d[ax][ay][1]==0 || d[ax][ay][1]>d[x][y][0]+1){
                                d[ax][ay][1]=d[x][y][0]+1;
                                q.add(new Node(ax,ay,1));
                            }
                        }
                    }
                }
            }
        }
    }
}

class Node{
    int x;
    int y;
    int visited;
    Node(int _x, int _y,int v){
        x=_x;
        y=_y;
        visited=v;
    }
}