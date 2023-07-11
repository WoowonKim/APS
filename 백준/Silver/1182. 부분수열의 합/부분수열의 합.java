
import java.util.Scanner;

public class Main {
	static int ans;
	static int N, S;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		S = sc.nextInt();
		arr = new int[N];
		for(int i = 0;  i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		partSum(0,0);
		if(S==0) ans--;
		System.out.println(ans);
		
	}
	
	private static void partSum(int idx, int sum) {
		// TODO Auto-generated method stub
		if(idx == N) {
			if(sum==S) ans++;
			return;
		}
		partSum(idx+1, sum + arr[idx]);
		partSum(idx+1, sum);
		
	}


}
