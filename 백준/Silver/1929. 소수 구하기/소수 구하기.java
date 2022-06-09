import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int M = sc.nextInt();
		int N = sc.nextInt();
		for(int i = M; i <= N; i++) {
			boolean flag = true;
			if(i==1) continue;
			for(int j = 2; j <= Math.sqrt(i); j++) {
				if(i%j == 0) {
					flag = false;
					break;
				}
			}
			if(flag) bw.write(i+"\n");
		}
		bw.flush();
	}
}