package div;

import java.util.Scanner;

// 분할정복
public class a1074 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        zArray array = new zArray(sc.nextInt(),sc.nextInt(),sc.nextInt());
        array.zFind(0,0,array.w);
    }
}

class zArray {
    int n, w, findX, findY;
    int cnt = -1;
    boolean flag = false;

    public zArray(int n, int y, int x) {
        this.n = n;
        this.w = (int) Math.pow(2,n);
        findY = y;
        findX = x;
    }

    void zFind(int x, int y, int width) {
        if(width==1) {
            cnt++;
            if(findX==x && findY==y) {
                System.out.println(cnt);
                flag = true;
            }
            return;
        }
        if(flag)
            return;
        zFind(x,y,width/2);
        zFind(x+width/2,y,width/2);
        zFind(x,y+width/2,width/2);
        zFind(x+width/2, y+width/2, width/2);

        return;
    }
}
