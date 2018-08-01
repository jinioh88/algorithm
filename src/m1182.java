import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
문제
N개의 정수로 이루어진 집합이 있을 때, 이 집합의 공집합이 아닌 부분집합 중에서 그 집합의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1≤N≤20, |S|≤1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다.
주어지는 정수의 절대값은 100,000을 넘지 않는다. 같은 수가 여러번 주어질 수도 있다.

출력
첫째 줄에 합이 S가 되는 부분집합의 개수를 출력한다.

예제 입력 1
5 0
-7 -3 -2 5 8

예제 출력 1
1
 */

public class m1182 {
    private static int N,S;
    private static int count = 0;
    private static BufferedReader br;
    private static int[] su;
    private static String[] input;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().trim().split(" ");

        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);

        su = new int[N];

        init();

        // 1개만 꺼낼때  1
        // 2개만 꺼낼때  1, 2, 12
        // ... N개만 꺼낼 때. 1, 12, 13, 123, 2, 23, 3
    }

    public static void init() throws IOException {
        input = br.readLine().trim().split(" ");
        for(int i=0;i<N;i++) {
            su[i] = Integer.parseInt(input[i]);
        }
    }
}
