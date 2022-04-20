import java.util.Scanner;

public class Main {
	static int N,K,ans;
	static int[] word;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		word = new int[N];
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<str.length(); j++)word[i] |=1<<(str.charAt(j)-'a');
		}
		int t = 0;
		t |= 1<<('a'-'a');
		t |= 1<<('n'-'a');
		t |= 1<<('t'-'a');
		t |= 1<<('c'-'a');
		t |= 1<<('i'-'a');
		recur(5,0,t);
		System.out.println(ans);
		
	}
	
	static void recur(int n, int idx, int v) {
		if(n == K) {
			int cnt = 0;
			for(int i=0; i<N; i++)if((word[i] & v) == word[i])cnt++;
			ans = Math.max(ans, cnt);
			return;
		}
		else if(n > K)return;
		for(int i=idx; i<26; i++)if((v&1<<i) == 0) {
			recur(n+1,i,v|1<<i);
		}
	}
}