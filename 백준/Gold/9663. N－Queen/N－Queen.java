import java.util.Scanner;
 
public class Main {
 
	public static int[] arr;
	public static int N;
	public static int ans = 0;
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		recur(0);
		System.out.println(ans);
 
	}
 
	public static void recur(int cnt) {
		if (cnt == N) {
			ans++;
			return;
		}
 
		for (int i = 0; i < N; i++) {
			arr[cnt] = i;
			if (setQueen(cnt)) {
				recur(cnt + 1);
			}
		}
 
	}
 
	public static boolean setQueen(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[col] == arr[i]) {
				return false;
			} 	
			if (Math.abs(col - i) == Math.abs(arr[col] - arr[i])) {
				return false;
			}
		}
		return true;
	}
}