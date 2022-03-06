import java.util.Scanner;

public class swea7087_제목 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[] alp = new char[N];
			String S = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
			for (int i = 0; i < alp.length; i++) {
				alp[i] = sc.next().charAt(0);
			}
			int ans = 0;
			for (int i = 0; i < S.length(); i++) {
				boolean flag =false;
				for (int j = 0; j < alp.length; j++) {
					if(alp[j]==S.charAt(i)) {
						ans++;
						flag = true;
						break;
					}
				}
				if(!flag) break;
			}
			System.out.println("#"+tc+" "+ans);
		}
		sc.close();
	}

}
