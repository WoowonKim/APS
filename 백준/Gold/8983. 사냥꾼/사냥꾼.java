import java.util.*;
import java.io.*;

public class Main {
	static int M, N, L;
	static int[] hunter;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		M = Integer.parseInt(stk.nextToken());
		N = Integer.parseInt(stk.nextToken());
		L = Integer.parseInt(stk.nextToken());
		hunter = new int[M];

		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			hunter[i] = Integer.parseInt(stk.nextToken());
		}
		
		Arrays.sort(hunter);
		
		int ans = 0;
		for (int i = 0; i < N; i++) {
			stk = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(stk.nextToken());
			int y =	Integer.parseInt(stk.nextToken());
			if (y > L)
				continue;
			int left = x - Math.abs(L - y);
			int right = x + Math.abs(L - y);
			
			int hunterLeft = 0;
			int hunterRight = M - 1;
			while (hunterLeft <= hunterRight) {
				int mid = (hunterLeft + hunterRight) / 2;
				if (hunter[mid] < left)
					hunterLeft = mid + 1;
				else if (hunter[mid] > right)
					hunterRight = mid - 1;
				else {
					ans++;
					break;
				}
			}
		}
		System.out.println(ans);
	}

}