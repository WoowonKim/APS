import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();

		Stack<Character> stack = new Stack<Character>();
		Stack<Integer> stack2 = new Stack<Integer>();
		for (int i = 0; i < s.length(); i++) {
			stack.add(s.charAt(i));
		}
		int total = 0;
		while (!stack.isEmpty()) {
			char c = stack.pop();
			if (c == '(') {
				total *= stack.pop() - '0';
				total += stack2.pop();
			} else {
				if (c == ')') {
					stack2.add(total);
					total = 0;
					continue;
				}
				total++;
			}
		}
		System.out.println(total);
	}
}