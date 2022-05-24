import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int[] arr = new int[N];
		int[] sum = new int[N+1];
		stk = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(stk.nextToken());
			sum[i+1] += sum[i] + arr[i];
		}
		for(int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(stk.nextToken());
			int ed = Integer.parseInt(stk.nextToken());
			sb.append(sum[ed]-sum[st-1]);
			sb.append("\n");
		}
		System.out.println(sb);
	}
}