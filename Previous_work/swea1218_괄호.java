import java.util.Scanner;
import java.util.Stack;

public class swea1218_괄호 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		for(int tc=1; tc<=10 ;tc++) {
			int len = sc.nextInt();
			String bracket = sc.next();
			int err = 0;
			out:
			for(int i = 0; i<len; i++) {
				char token = bracket.charAt(i);
				switch (token) {
					case '(' : 
					case '{' :
					case '<' :
					case '[' :
						stack.push(token);
						break;
						
					case ')':
						if (stack.peek()=='(') {
							stack.pop();
							break;
						}
						err = 1;
						break out;
					case '}':
						if (stack.peek()=='{') {
							stack.pop();
							break;
						}
						err = 1;
						break out;
					case '>':
						if (stack.peek()=='<') {
							stack.pop();
							break;
						}
						err = 1;
						break out;
					case ']':
						if (stack.peek()=='[') {
							stack.pop();
							break;
						}
						err = 1;
						break out;
				}
			}
			if(!stack.isEmpty() || err==1) {
				System.out.println("#"+tc+" "+0);
			}
			else {
				System.out.println("#"+tc+" "+1);
			}
			stack.clear();
		}//testCase
	}//main
}
