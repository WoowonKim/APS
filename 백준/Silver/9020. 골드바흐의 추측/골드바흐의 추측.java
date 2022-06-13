import java.util.*;
public class Main {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = 10000;
		
		boolean check[] = new boolean[N+1]; 
		for (int i = 2; i <= N; i++) {
			check[i] = true;
		}
		
		// 에라토스테네스의 체
		for (int i = 2; i <= Math.sqrt(N); i++) {
			for (int j = i+i; j <= N; j += i) {
				check[j] = false;
			}
		}
		
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int tmp = n/2;
			
			for (int j = tmp; j >= 2; j--) {
				if(check[j] && check[n-j]) {
					System.out.println(j+" "+(n-j));
					break;
				}
			}
		}
	}
}