import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static class Node {
		int parent;
		List<Integer> child = new ArrayList<Integer>();
	}
	static Node[] tree;
	static int ans, N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		tree = new Node[N];
		for(int i = 0; i < N; i++) tree[i] = new Node();
		int root = 0;
		for(int i = 0; i < N; i++) {
			int parent = sc.nextInt();
			tree[i].parent = parent;
			if(parent != -1) {
				tree[parent].child.add(i);
			} else root = i;
		}
		
		int toCut = sc.nextInt();
		int cutParent = tree[toCut].parent;
		
		if(cutParent == -1) {
			System.out.println(0);
			sc.close();
			return;
		}
		tree[cutParent].child.remove(tree[cutParent].child.indexOf(toCut));
		recur(root);
		System.out.println(ans);
		sc.close();
	}

	private static void recur(int node) {
		if(tree[node].child.isEmpty()) {
			ans++;
		}
		for(int child : tree[node].child) {
			recur(child);
		}
	}
}
