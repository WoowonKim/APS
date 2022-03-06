import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class BOJ1918_후위표기 {
	static Map<Character, Integer> priority = new HashMap<>();
	static {
		priority.put('(', 0);
		priority.put('+', 1);
		priority.put('-', 1);
		priority.put('*', 2);
		priority.put('/', 2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		String md = sc.next();
		for (int i = 0; i < md.length(); i++) {
			char t = md.charAt(i);
			if (t >= 'A' && t <= 'Z') {
				sb.append(t);
				continue;
			}
			if (t == '(') {
				stack.push(t);
				continue;
			}
			if (t == ')') {
				while (stack.peek() != '(') {
					sb.append(stack.pop());
				}
				stack.pop();
				continue;
			}
			if (stack.empty()) {
				stack.push(t);
				continue;
			}
			while (!stack.empty() && priority.get(t) <= priority.get(stack.peek())) {
				sb.append(stack.pop());
			}
			stack.push(t);
		}

		while (!stack.empty()) {
			sb.append(stack.pop());
		}

		System.out.println(sb.toString());
		sc.close();
	}
}
