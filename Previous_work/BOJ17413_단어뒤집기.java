import java.util.Scanner;
import java.util.Stack;

public class BOJ17413_단어뒤집기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<Character>();
		String snt = sc.nextLine();
		
		for(int i = 0; i < snt.length(); i++) {
			if (snt.charAt(i)=='<') {
				while(snt.charAt(i)!='>') {
					System.out.print(snt.charAt(i++));
				}
				System.out.print(snt.charAt(i));
				continue;
			}
			
			while(i<snt.length() && snt.charAt(i) != '<'&& snt.charAt(i) != ' ') {
				stack.push(snt.charAt(i++));
			}
			
			if(i == snt.length() ||snt.charAt(i) == '<') i--;
			
			int k = stack.size();
			for (int j=0; j<k; j++) {
				System.out.print(stack.pop());
				if(j==k-1 && snt.charAt((i==snt.length()-1)? i : i+1)!='<') System.out.print(' ');
			}
			
		}

	}
}
