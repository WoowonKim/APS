import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(stk.nextToken());
		int b = Integer.parseInt(stk.nextToken());
		int n = Integer.parseInt(stk.nextToken());
		int w = Integer.parseInt(stk.nextToken());
		
		int[] ans = new int[2];
		int cnt = 0;
		
		for(int i = 1, j = n - 1; i < n; i++, j--) {
			if(i*a + j*b == w) {
				cnt++;
				ans = new int[]{i, j};
			}
		}
		if(cnt != 1) System.out.println(-1);
		else System.out.println(Arrays.toString(ans).replaceAll("[\\[,\\]]", ""));
	}
	
}
