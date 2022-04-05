import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, R;
	static int[] data;
	static int[] sel;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		data = new int[N];
		sel = new int[R];
		for(int i = 0; i < N; i++) {
			data[i] = sc.nextInt();
		}
		Arrays.sort(data);
		comb(0,0);
		sc.close();
		bw.flush();
	}
	
	static void comb(int cnt, int start) throws IOException {
		if(cnt == R) {
			for(int i : sel) {
				bw.append(i+" ");
			}
			bw.append("\n");
			return;
		}
		
		for(int i = start; i < N; i++) {
			//if((visited & 1<<i) > 0) continue;
			sel[cnt] = data[i];
			comb(cnt + 1, i+1);
		}
	}
}
