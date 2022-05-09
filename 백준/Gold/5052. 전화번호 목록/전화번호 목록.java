import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			boolean ans = true;
			int n = Integer.parseInt(br.readLine());
			String[] nums = new String[n];
			for (int i = 0; i < n; i++) {
				nums[i] = br.readLine();
			}
			Arrays.sort(nums);
			for (int i = 0; i < n - 1; i++) {
				String prefix = nums[i];
				if(nums[i+1].startsWith(prefix)) {
					ans = false;
					break;
				}
			}
			System.out.println(ans ? "YES" : "NO");
		}
	}
}
