import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[21];
		arr[1] = 1;
		for(int i = 2; i <= N; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(arr[N]);
	}
}