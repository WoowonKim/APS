import java.util.Scanner;

public class swea5432_쇠막대기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T; tc++) {
			int ans = 0;
			int stick = 0;
			String rasStick = sc.next();
			for(int i = 0; i<rasStick.length(); i++) {
				if(rasStick.charAt(i)=='(' && rasStick.charAt(i+1)==')') {
					ans += stick;
					i++;
				}else if(rasStick.charAt(i)=='('){
					stick++;
				}
				else {
					stick--;
					ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}//tc
	}//main
}//class
