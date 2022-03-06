import java.util.Scanner;

public class swea1592_영식이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		
		int[] cnt = new int[N];
		int ans = 0;
		int idx = 0;
		while(true) {
			cnt[idx]++;
			if (cnt[idx]==M) {
				System.out.println(ans);
				break;
			}
			if(cnt[idx]%2==1) {
				idx += L;
				if(idx>=N) idx -= N;
				ans++;
			}
			else {
				idx -= L;
				if(idx<0) idx += N;
				ans++;
			}
		}
		sc.close();
	}

}
