
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer stk;
		StringBuilder ans = new StringBuilder();
		stk = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(stk.nextToken());
		int M = Integer.parseInt(stk.nextToken());
		int[] cnt = new int[N + 1];
		List<Integer>[] adjArr = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			adjArr[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			stk = new StringTokenizer(br.readLine());
			int st = Integer.parseInt(stk.nextToken());
			int ed = Integer.parseInt(stk.nextToken());
			adjArr[st].add(ed);
			cnt[ed]++;
		}
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) {
			if(cnt[i] == 0) queue.add(i);
		}
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			ans.append(curr).append(" ");
			for(int next : adjArr[curr]) {
				if(--cnt[next] == 0) queue.add(next);
			}
		}
		System.out.println(ans);
	}

}
