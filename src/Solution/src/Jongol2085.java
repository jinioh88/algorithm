import java.util.Scanner;

public class Jongol2085 {
    public static void main(String[] args) {
        int a, b;
        int count = 0;

        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();

        int temp;
        if(a>b) {
            temp = b;
            b = a;
            a = temp;
        }

        for(int i=a+1;i<=b;i++) {
            if(i%4==0) {
                if(i%100==0) {
                    if(i%400==0) {
                        count++;
                        continue;
                    }
                    continue;
                }
                    count++;
            }
        }

        System.out.println(count);
    }

}
