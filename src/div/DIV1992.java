package div;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DIV1992 {
    static int[][] video;
    static StringBuffer sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        char[] low = null;
        video = new int[N][N];
        sb = new StringBuffer();

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            low = st.nextToken().toCharArray();
            for(int j=0;j<N;j++) {
                video[i][j] = Integer.parseInt(low[j]+"");
            }
        }
        compression(0,0,video.length);
        System.out.println(sb.toString());
    }

    private static void compression(int x, int y, int size) {
        int temp = video[x][y];
        boolean isSame = true;
        for(int i = x; (i < x+size) && isSame; i++){
            for(int j = y; (j < y+size) && isSame; j++){
                if(temp != video[i][j])
                    isSame = false;
            }
        }
        if(isSame)
            sb.append(temp);
        else{
            sb.append("(");
            compression(x, y, size/2);
            compression(x, y+size/2, size/2);
            compression(x+size/2, y, size/2);
            compression(x+size/2, y+size/2, size/2);
            sb.append(")");
        }
    }
}
