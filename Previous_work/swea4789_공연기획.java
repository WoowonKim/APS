import java.util.Scanner;

public class swea4789_공연기획 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <=T; tc++) {
			String P = sc.next();
			int ans = 0;
			int sum = 0;
			int[] p = new int[P.length()];
			for(int i = 0; i < P.length(); i++) {
				p[i] = P.charAt(i)-'0';
			}
			for(int i = 0; i < P.length(); i++) {
				if(p[i]==0) continue;
				if(sum<i) {
					while(sum!=i) {
						sum++;
						ans++;
					}
				}
				sum += p[i];
			}
			System.out.println("#"+tc+" "+ans);
		}
		sc.close();
	}

}
