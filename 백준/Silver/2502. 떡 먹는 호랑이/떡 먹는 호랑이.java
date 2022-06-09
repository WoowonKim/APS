import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int D = sc.nextInt();
		int K = sc.nextInt();
		int[] a = new int[31];
		int[] b = new int[31];
		a[1] = 1;
		b[2] = 1;
		for(int i = 3; i <= D; i++) {
			a[i] = a[i-2] + a[i-1];
			b[i] = b[i-2] + b[i-1];
		}
		int[] ans = new int[2];
		for(int i = 1; i < K; i++) {
			if((K-a[D]*i)%b[D] == 0) {
				ans[0] = i;
				ans[1] = (K-a[D]*i)/b[D];
				break;
			}
		}
		System.out.println(ans[0]);
		System.out.println(ans[1]);
	}
}