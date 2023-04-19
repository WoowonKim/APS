import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, R;
	static int[] data;
	static int[] sel;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		data = new int[N];
		sel = new int[R];
		for(int i = 0; i < N; i++) {
			data[i] = i+1;
		}
		perm(0, 0);
	}
	
	static void perm(int cnt, int visited) {
		if(cnt == R) {
			System.out.println(Arrays.toString(sel).replace(",", "").replace("[", "").replace("]", ""));
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if((visited & 1 << i) > 0) continue;
			sel[cnt] = data[i];
			perm(cnt+1, visited | 1 << i);
		}
	}
}
