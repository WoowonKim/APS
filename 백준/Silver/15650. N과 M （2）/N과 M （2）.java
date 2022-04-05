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
		comb(0, 0);
	}
	
	static void comb(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(sel).replace(",", "").replace("[", "").replace("]", ""));
			return;
		}
		for(int i = start; i < N; i++) {
			sel[cnt] = data[i];
			comb(cnt + 1, i +1);
		}
		
	}
}
