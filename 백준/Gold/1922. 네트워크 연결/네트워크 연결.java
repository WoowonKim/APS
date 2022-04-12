import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] edges = new int[M][3];
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken())-1;
			edges[i][1] = Integer.parseInt(st.nextToken())-1;
			edges[i][2] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(edges, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		p = new int[N];
		for(int i = 0; i<N; i++) {
			p[i] = i;
		}
		
		int ans = 0;

				int pick = 0;
				for(int i = 0 ; i<M; i++) {
					int px = findSet(edges[i][0]);
					int py = findSet(edges[i][1]);
					
					if(px != py) {
						union(px, py);
						ans += edges[i][2];
						pick++;
					}
					if(pick == (N-1)) break;
				}

				System.out.println(ans);

			}
			
			static int findSet(int x){
				if(x ==p[x]) return x;
				return p[x] = findSet(p[x]);
			}
			
			static void union(int x, int y) {
				p[findSet(y)]= findSet(x); //정석
				
			}
			

}
