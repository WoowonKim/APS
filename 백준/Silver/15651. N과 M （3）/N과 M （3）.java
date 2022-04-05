import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
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
			data[i] = i+1;
		}
		perm(0);
		sc.close();
		bw.flush();
	}
	
	static void perm(int cnt) throws IOException {
		if(cnt == R) {
			for(int i : sel) {
				bw.append(i+" ");
			}
			bw.append("\n");
			return;
		}
		
		for(int i = 0; i < N; i++) {
			sel[cnt] = data[i];
			perm(cnt+1);
		}
	}
}
