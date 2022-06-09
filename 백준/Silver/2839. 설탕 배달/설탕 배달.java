import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = Integer.MAX_VALUE;
		boolean flag = false;
		for(int i = 1; (N-3*i) >= 0; i++) {
			if((N-3*i)%5 == 0) {
				int temp = i + (N-3*i)/5;
				if(temp < ans) ans = temp;
				flag = true;
			}
			if((N-5*i) == 0) {
				int temp = i + (N-5*i)/3;
				if(temp < ans) ans = temp;
				flag = true;
			}
		}
		System.out.println(flag? ans:-1);
	}
}