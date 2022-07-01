import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int ans;
	static boolean[] know;
	static ArrayList<Integer>[] party;
	static ArrayList<Integer>[] people;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		know = new boolean[N + 1];
		people = new ArrayList[N+1];
        party = new ArrayList[M];
		for (int i = 1; i <= N; i++) {
			people[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			party[i] = new ArrayList<>();
		}

		int T = sc.nextInt();
		while (T-- > 0) {
			know[sc.nextInt()] = true;
		}
		for (int i = 0; i < M; i++) {
			int P = sc.nextInt();
			for (int j = 0; j < P; j++) {
				int person = sc.nextInt();
				party[i].add(person);
				people[person].add(i);
			}
		}
		bfs();
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		boolean visited[] = new boolean[M];
		for (int i = 1; i <= N; i++) {
			if (know[i]) {
				for (int k = 0; k < people[i].size(); k++) {
					if (!visited[people[i].get(k)]) {
						q.add(people[i].get(k));
						visited[people[i].get(k)] = true;
					}
				}
			}
		}
		while (!q.isEmpty()) {
			int partyNum = q.poll(); 
			for (int num : party[partyNum]) {
				for (int partyInfo : people[num]) {
					if (!visited[partyInfo]) {
						q.add(partyInfo);
						visited[partyInfo] = true;
					}
				}
			}

		}
		for (int i = 0; i < M; i++) {
			if (!visited[i]) {
				ans++;
			}
		}
		System.out.println(ans);
	}

}