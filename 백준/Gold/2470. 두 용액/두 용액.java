import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int[] liquid = new int[N];
		for (int i = 0; i < N; i++) {
			liquid[i] = Integer.parseInt(stk.nextToken());
		}
		Arrays.sort(liquid);
		int[] ans = new int[2];
		int previous = Integer.MAX_VALUE;
		int pointer1 = 0;
		int pointer2 = liquid.length - 1;

		while (pointer1 < pointer2) {
			int merge = liquid[pointer1] + liquid[pointer2];
			if (Math.abs(merge) < previous) {
				previous = Math.abs(merge);
				ans[0] = liquid[pointer1];
				ans[1] = liquid[pointer2];
			}
			if(merge > 0) pointer2--;
			else pointer1++;
		}
		System.out.println(ans[0] + " " + ans[1]);
	}
}