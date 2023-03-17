import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int K = Integer.parseInt(stk.nextToken());

		while (K-- > 0) {
			if (N > M * 2)
				N--;
			else
				M--;
		}
		
		int ans = 0;
		while (M-- > 0) {
			if(N >= 2) {
				ans++;
				N -= 2;
			} else break;
		}
		System.out.println(ans);
	}

}
