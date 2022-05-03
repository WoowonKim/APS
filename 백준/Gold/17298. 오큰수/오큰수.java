import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> st = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(stk.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
				nums[st.pop()] = nums[i];
			}
			st.push(i);
		}
		
		while (!st.isEmpty()) {
			nums[st.pop()] = -1;
		}

		for (int i = 0; i < N; i++) {
			sb.append(nums[i]).append(' ');
		}
		System.out.println(sb);
	}
}
