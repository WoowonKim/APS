import java.util.Scanner;

public class Main {
	static int N, K;
	static int ans = -1;
	static boolean[] visited;
	static String[] words;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		sc.nextLine();
		words = new String[N];
		for (int i = 0; i < N; i++) {
			String word = sc.nextLine();
			word = word.replaceAll("[a,n,t,i,c]", "");
			words[i] = word;
		}
		visited = new boolean[26]; // 각 알파벳을 배웠는지 체크
		visited['a' - 'a'] = true;
		visited['c' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;
		
		if(K < 5) ans = 0;
		else backtracking(0, 0);
		
		System.out.println(ans);
	}

	private static void backtracking(int idx, int len) {
		if(len == K - 5) {
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                boolean flag = true;
                for(int j = 0; j < words[i].length(); j++) {
                    if(!visited[words[i].charAt(j) - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if(flag) cnt++;
            }
            ans = Math.max(ans, cnt);
            return;
        }
        
        for(int i = idx; i < 26; i++) {
            if(visited[i] == false) {
                visited[i] = true;
                backtracking(i, len + 1);
                visited[i] = false;
            }
        }
	}
}
