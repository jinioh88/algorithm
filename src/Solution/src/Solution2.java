import java.util.*;

public class Solution2 {
    public static int[] solution(int []arr) {
        int[] answer = {};
        if(arr.length>1000000)
            return null;

        int temp;

        Queue<Integer> queue = new LinkedList<>();

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");

        if(arr[0]<0 && arr[0]>9) {
            return null;
        }

        temp = arr[0];
        queue.add(temp);

        for(int i=1;i<arr.length;i++) {
            if(arr[i]<0 && arr[i]>9) {
                return null;
            }
            if(arr[i]==temp) {
                continue;
            }
            temp = arr[i];
            queue.add(temp);
        }

        int[] res = new int[queue.size()];
        int index = 0;
        while(!queue.isEmpty()) {
            res[index] = queue.remove();
            index++;
        }

        answer = res.clone();
        System.out.println(Arrays.toString(answer));

        return answer;
    }

    public static void main(String[] args) {
        int arr[] = {1, 1, 3, 3, 0, 1, 1};
        solution(arr);
    }
}
