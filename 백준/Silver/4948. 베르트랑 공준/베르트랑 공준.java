import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int N = sc.nextInt();
			if(N==0) break;
			int ans = 0;
			for(int i = N+1; i <= N*2; i++) {
				boolean flag = true;
				for(int j = 2; j <= Math.sqrt(i); j++) {
					if(i%j==0) {
						flag = false;
						break;
					}
				}
				if(flag) ans++;
			}
			System.out.println(ans);
		}
	}
}