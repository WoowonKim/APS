import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		for(int 택희 = 2; 택희 < N; 택희+=2) {
			for(int 영훈 = 1; 영훈 < N; 영훈++) {
				int 남규 = N - 택희 - 영훈;
				if(남규 >= 영훈 + 2) ans++;
			}
		}
		System.out.println(ans);
	}
	
}
