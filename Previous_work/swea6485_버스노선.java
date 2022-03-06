import java.util.Scanner;

public class swea6485_버스노선 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] A = new int[N];
			int[] B = new int[N];
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
				B[i] = sc.nextInt();
			}
			int[] P = new int[sc.nextInt()];
			for (int i = 0; i < P.length; i++) {
				P[i]=sc.nextInt();
			}
			int[] ans = new int[P.length];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < ans.length; j++) {
					if(P[j]<=B[i] && P[j]>=A[i]) ans[j]++;
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < P.length; i++) {
				System.out.print(ans[i] + " ");
			}
			System.out.println();
		}
		sc.close();
	}
}
