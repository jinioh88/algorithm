package dfs;


import java.util.Scanner;

// 돌다가 처음 위치로 돌아오면 count++
public class dfs_10451 {
    static int cycle[];
    static int arr[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T>0) {
            T--;
            int N = sc.nextInt();
            arr = new int[N];

            for(int i=0;i<N;i++) {
                arr[i] = sc.nextInt();
            }

            cycle = new int[N];

            int count = 0;
            for(int i=0;i<N;i++) {
                if(cycle[arr[i]]==0) {
                    dfs(i,count++);
                }
            }
            System.out.println(count);
        }
    }

    static void dfs(int x, int cnt) {
        cycle[x] = cnt;
        int tmp = arr[x];
        if(cycle[x]==0) {
            dfs(tmp,cnt);
        }
    }
}
