package div;

import java.io.IOException;
import java.util.Scanner;

public class Div11729 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int a = 0;
        int num = sc.nextInt();
        hanoi(num,1,2,3);
        sb.insert(num-1,a+"\n");
        System.out.println(sb);
    }

    private static void hanoi(int num, int from, int by, int to) {
        if(num==1) {
            System.out.println(num+" : "+from+"->"+to);
        } else {
            hanoi(num-1, from, to, by);
            sb.append(from + " " + to + "\n");
            hanoi(num-1,by, from, to);
        }
    }
}
