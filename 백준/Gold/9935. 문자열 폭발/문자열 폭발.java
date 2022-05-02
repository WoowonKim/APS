import java.util.Scanner;
import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Stack<Character> st = new Stack<Character>();
		StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		String sentence = sc.nextLine();
		String pattern = sc.nextLine();
		
		int patternL = pattern.length();


		for (int i = 0; i < sentence.length(); i++) {
			st.push(sentence.charAt(i));
			if (st.size() >= patternL) {
				boolean flag = true;
				for (int j = 0; j < patternL; j++) {
					if (st.get(st.size() - patternL + j) != pattern.charAt(j)) {
						flag = false;
						break;
					}
				}
				if (flag) {
					for (int j = 0; j < patternL; j++) {
						st.pop();
					}
				}
			}
		}
		for(Character c : st) {
			sb.append(c);
		}
		System.out.println(sb.length()==0? "FRULA" : sb.toString());
	}

}
