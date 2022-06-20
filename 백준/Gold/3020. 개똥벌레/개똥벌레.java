import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int H = Integer.parseInt(stk.nextToken());
		int[] up = new int[H+1];
		int[] down = new int[H+1];
		int upSum = N/2, downSum = N/2;
		
		for(int i = 0; i < N ;i++) {
			if(i%2 == 0) {
				up[Integer.parseInt(br.readLine())]++;
			}else {
				down[Integer.parseInt(br.readLine())]++;
			}
		}
		for(int i = 1; i <= H; i++) {
			int temp = up[i];
			up[i] = upSum;
			upSum -= temp;
			
			temp = down[i];
			down[i] = downSum;
			downSum -= temp;
		}

		int ansTotal = 0;
		int ans = Integer.MAX_VALUE;
		int[] toBreak = new int[H+1];
		for(int i = 1; i <= H; i++) {
			toBreak[i] = up[i] + down[H-i+1];
			if(toBreak[i] < ans) {
				ans = toBreak[i];
				ansTotal = 1;
			} else if(toBreak[i] == ans) {
				ansTotal++;
			}
		}
		System.out.println(ans + " " + ansTotal);
	}
}
