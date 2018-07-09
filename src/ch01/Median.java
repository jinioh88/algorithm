package ch01;

import java.util.Scanner;

/*
  중앙값 구하기
 */
public class Median {
    static int med3(int a, int b, int c) {
        if(a>=b)
            if(b>=c)
                return b;
            else if(a<=c)
                return a;
            else
                return c;
        else if(a>c)
            return a;
        else if(b>c)
            return c;
        else
            return b;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        System.out.println("medi = "+med3(a,b,c));
    }
}
