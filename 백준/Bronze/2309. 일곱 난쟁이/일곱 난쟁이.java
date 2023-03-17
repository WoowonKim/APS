import java.util.*;
import java.io.*;

public class Main {
	
	static final int N = 9;
	static final int M = 7;
	static int[] arr;
	static boolean[] sel;
	static StringBuilder sb;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[N];
		sel = new boolean[N];
		for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
		
		Arrays.sort(arr);
		comb(0,0,0);
		System.out.println(sb);
	}

	private static void comb(int cnt, int total, int idx) {
		if(cnt == M) {
			if(total == 100) {
				sb = new StringBuilder();
				for(int i = 0; i < N; i++) {
					if(sel[i]) sb.append(arr[i]).append("\n");
				}
			}
			return;
		}
		
		for(int i = idx; i < N; i++) {
			sel[i] = true;
			comb(cnt + 1, total + arr[i], i + 1);
			sel[i] = false;
		}
	}
	
}
