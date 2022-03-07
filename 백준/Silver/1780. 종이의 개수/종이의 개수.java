import java.util.Scanner;

public class Main {
	static int N = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int in1 = 0, in2 = 0, in3 = 0;
		int[][] arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == -1)
					in1++;
				if (arr[i][j] == 0)
					in2++;
				if (arr[i][j] == 1)
					in3++;
			}
		}

		int ans1 = recur(-1, 3, in1, arr);
		int ans2 = recur(0, 3, in2, arr);
		int ans3 = recur(1, 3, in3, arr);

		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans3);
		sc.close();
	}

	static int recur(int a, int size, int ans, int[][] arr) {
		if(N==1) return ans;
		if (size == N) {
			for (int x = 0; x < N; x += size) {
				for (int y = 0; y < N; y += size) {
					boolean flag = true;
					out :for (int i = x; i < x+size; i++) {
						for (int j = y; j < y+size; j++) {
							if(arr[i][j]!=a) {
								flag = false;
								break out;
							}
						}
					}
					if(flag) ans -= 8;
				}
			}
			return ans;
		}
		for (int x = 0; x < N; x += size) {
			for (int y = 0; y < N; y += size) {
				boolean flag = true;
				out :for (int i = x; i < x+size; i++) {
					for (int j = y; j < y+size; j++) {
						if(arr[i][j]!=a) {
							flag = false;
							break out;
						}
					}
				}
				if(flag) ans -= 8;
			}
		}
		return recur(a, size * 3, ans, arr);
	}
}
