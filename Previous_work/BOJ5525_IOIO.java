import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ5525_IOIO {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int sLen = Integer.parseInt(bf.readLine());
		String str = bf.readLine();

		int ans = 0;
		int tmp = 0;
		for (int i = 0; i < sLen-2; i++) {
			if (str.charAt(i) == 'I' && str.charAt(i + 1) == 'O' && str.charAt(i + 2) == 'I') {
				i++;
				tmp++;
			} else {
				tmp = 0;
			}
			if(tmp >= n) {
				ans ++;
			}
		}
		System.out.println(ans);
	}// main
}// class