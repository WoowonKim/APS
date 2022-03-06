import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class swea1224_계산기 {
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
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			System.out.println("#" + tc + " " + calc(postfix(sc.next())));
		}
		sc.close();
	}

	public static String postfix(String infix) {
		StringBuilder post = new StringBuilder();
		Stack<Character> op = new Stack<>();
		
		for(int i =0; i<infix.length(); i++) {
			char c = infix.charAt(i);
			if(c=='(') {
				op.push(c);
				continue;
			}
			if(c==')') {
				while(op.peek() != '(') {
					post.append(op.pop());
				}
				op.pop();
				continue;
			}
			if(c >= '0' && c<='9') {
				post.append(c);
				continue;
			}
			if(op.isEmpty()) {
				op.push(c);
				continue;
			}
			while(!op.isEmpty() && priority.get(c)<=priority.get(op.peek())) {
				post.append(op.pop());
			}
			op.push(c);
		}
		while(!op.isEmpty()) post.append(op.pop());
		return post.toString();
	}
	
	public static int calc(String post) {
		Stack<Integer> stack = new Stack<>();
		for(int i=0; i<post.length(); i++) {
			char c= post.charAt(i);
			if(c >= '0' && c<='9') {
				stack.push(c-'0');
				continue;
			}
			
			int num2 = stack.pop();
			int num1 = stack.pop();
			int result = 0;
			switch (c) {
			case '+':result = num1 + num2; break;
			case '-':result = num1 - num2; break;
			case '*':result = num1 * num2; break;
			case '/':result = num1 - num2; break;
			}
			stack.push(result);
		}
		return stack.pop();
	}
}
