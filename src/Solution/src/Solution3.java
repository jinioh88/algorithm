import java.util.Stack;

public class Solution3 {
    public static int solution(String bowls) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        if(bowls.isEmpty())
            return 0;

        stack.push(bowls.charAt(0));
        answer += 10;

        for(int i=1;i<bowls.length();i++) {
            if(bowls.charAt(i)==stack.peek()) {
                answer+=5;
            } else {
                answer+=10;
                stack.push(bowls.charAt(i));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String str = "((((";

        int result = solution(str);
        System.out.println(result);
    }
}
