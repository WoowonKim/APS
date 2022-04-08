import java.util.Scanner;

public class Main {
	static int[] a, op;
	static int N, m, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		m = 1<<30;
		M = 1<<31;
		a = new int[N];
		op = new int[4];
		for(int i=0; i<N; i++) a[i] = sc.nextInt();
		for(int i=0; i<4; i++) op[i] = sc.nextInt();
		recur(1,a[0]);
		System.out.printf("%d\n%d",M,m);
		
	}
	
	static void recur(int n, int val) {
		if(n == N) {
			if(M < val) M = val;
			if(m > val) m = val;
			return;
		}
		for(int i=0; i<4; i++) {
			if(op[i] > 0) {
				op[i]--;
				recur(n+1,cal(i,val,a[n]));
				op[i]++;
			}
		}
	}
	
	static int cal(int n, int f, int s) {
		if(n == 0)return f + s;
		if(n == 1)return f - s;
		if(n == 2)return f * s;
		return f / s;
	}
}