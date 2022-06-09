import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = 0;
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num == 1) continue;
			boolean flag = true;
			for(int j = 2; j <num; j++) {
				if(num%j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) ans ++;
		}
		System.out.println(ans);
	}
}