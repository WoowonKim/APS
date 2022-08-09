import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0){
            int n = sc.nextInt();
            int[] parents = new int[n+1];
            for(int i = 1; i < n; i++){
                int parent = sc.nextInt();
                int child = sc.nextInt();
                parents[child] = parent;
            }
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            Stack<Integer> stk1 = new Stack<>();
            Stack<Integer> stk2 = new Stack<>();
            stk1.push(num1);
            stk2.push(num2);
            while (parents[num1] != 0){
                stk1.push(parents[num1]);
                num1 = parents[num1];
            }
            while (parents[num2] != 0){
                stk2.push(parents[num2]);
                num2 = parents[num2];
            }

            int ans = 0;
            while(true && !(stk1.isEmpty() || stk2.isEmpty())){
                 int a = stk1.pop();
                 int b = stk2.pop();
                if(a != b){
                    break;
                }
                ans = a;
            }
            System.out.println(ans);
        }
    }
}
