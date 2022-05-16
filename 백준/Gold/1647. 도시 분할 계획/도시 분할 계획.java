import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] edges = new int[M][3];
		
		for(int i = 0; i < M; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
			edges[i][2] = sc.nextInt();
		}
		
		Arrays.sort(edges,(o1,o2)->o1[2]-o2[2]);
		
		p = new int[N+1];
		for(int i = 0; i <= N; i++) {
			p[i] = i;
		}
		int ans = 0;
		int max = 0;
		int pick = 0;
		for(int i = 0 ; i<M; i++) {
			int px = findSet(edges[i][0]);//시작점의 대표
			int py = findSet(edges[i][1]);//끝점의 대표
			
			if(px != py) {//시작점과 끝점의 대표가 다르다면
				union(px, py);//두 서로소 집합을 합치고
				ans += edges[i][2];//간선의 가중치 저장
				if (edges[i][2]>max) max = edges[i][2];
				pick++;//간선 갯수 증가
			}
			if(pick == (N-1)) break;//선택한 간선의 수가 N-1개가 되면 중단
		}
		System.out.println(ans - max);
	}
	private static void union(int x, int y) {
		// TODO Auto-generated method stub
		p[findSet(y)]= findSet(x);
	}
	private static int findSet(int x) {
		// TODO Auto-generated method stub
		if(x == p[x]) return x;
		return p[x] = findSet(p[x]); 
	}
}
