import java.util.Scanner;

public class swea1989_회문 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int flag = 1;
			String word = sc.next();
			int length = word.length()-1;
			for(int i=0; i<length; i++) {
				if(word.charAt(i) != word.charAt(length)) {
					flag = 0;
					break;
				}
				length--;
			}
			System.out.println("#"+tc+" "+flag);
		}//tc
		sc.close();
	}//main
	
}
