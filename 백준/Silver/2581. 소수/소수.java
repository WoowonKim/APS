import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int cnt=0;
		int min = Integer.MAX_VALUE;
		for(int i = M; i <= N; i++) {
			boolean flag = true;
			if(i==1) continue;
			for(int j = 2; j < i; j++) {
				if(i%j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				cnt += i;
				if(i < min) min = i;
			}
		}
		if(cnt == 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(cnt);
		System.out.println(min);
	}
}