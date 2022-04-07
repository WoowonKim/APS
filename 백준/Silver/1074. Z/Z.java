import java.util.Scanner;

public class Main {

	static int idx = 0;
	static int r, c;
	static int P;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		P = sc.nextInt();
		int N = (int) Math.pow(2, P);

		r = sc.nextInt();
		c = sc.nextInt();

		Z(N, r, c);
		sc.close();
	}

	private static void Z(int N, int stR, int stC) {
		if (stR == 0 && stC == 0) {
			System.out.println(idx);
			return;
		}
		P -= 1;
		int add = (int) Math.pow(4, P); 
		if (stR >= N / 2 && stC >= N / 2) {// 4 사분면
			idx += add * 3;
			stR %= N / 2;
			stC %= N / 2;
		} else if (stR >= N / 2) {// 3 사분면
			idx += add * 2;
			stR %= N / 2;
		} else if (stC >= N / 2) {// 2 사분면
			idx += add;
			stC %= N / 2;
		}
		Z(N / 2, stR, stC);
	}
}
