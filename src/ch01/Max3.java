package ch01;
/*
// 3개 수중 최댓값 구하기
*/

import java.util.Scanner;

public class Max3 {

    // 4개중 최댓 값 구하기
    static int max4(int a, int b, int c, int d){
        int max = a;
        if(b>max)
            max = b;
        if(c>max)
            max = c;
        if(d>max)
            max = d;
        return max;
    }

    // 3개 중 최소값 구하기
    static int min3(int a, int b, int c) {
        int min = a;
        if(b<min)
            min = b;
        if(c<min)
            min = c;

        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        System.out.println("세 정수 입력 ");
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();
//
//        int max = a;
//        if(b>max)
//            max = b;
//        if(c>max)
//            max = c;
//
//        System.out.println("Max = "+max);
        System.out.println("max is " + max4(1,2,3,4));
        System.out.println("min is " + min3(1,2,3));
    }
}
