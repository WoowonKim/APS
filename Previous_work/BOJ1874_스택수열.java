import java.util.Scanner;
import java.util.Stack;

public class BOJ1874_스택수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack<>();
		StringBuilder op = new StringBuilder();
		
		int N = sc.nextInt();
		int[] ansArr = new int[N];
		for (int i = 0; i < N; i++) {
			ansArr[i] = sc.nextInt();
		}
		
		int idx = 0;
		for(int i=1;i<=N;i++) {
			stack.push(i);
			op.append("+\n");
			while(stack.peek()==ansArr[idx]) {
				stack.pop();
				op.append("-\n");
				idx++;
				if(stack.empty()) {
					break;
				}
			}
		}
		
		if(!stack.empty()) {
			System.out.println("NO");}
		
		else {
			System.out.println(op);
			
		}
		
		sc.close();
	}
}
