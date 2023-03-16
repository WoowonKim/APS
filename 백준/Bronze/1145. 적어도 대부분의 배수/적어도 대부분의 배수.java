import java.io.*;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[5];
		StringTokenizer stk = new StringTokenizer(br.readLine());
		for(int i = 0; i < 5; i++) arr[i] = Integer.parseInt(stk.nextToken());
		int ans = 0;
		while(true) {
			ans++;
			int cnt = 0;
			for(int num : arr) if(ans % num == 0) cnt++;
			if(cnt >= 3) break;
		}
		System.out.println(ans);
	}
	
}