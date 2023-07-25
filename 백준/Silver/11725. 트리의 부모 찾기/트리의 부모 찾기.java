import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node{
		List<Integer> link = new ArrayList<Integer>();
		int parent = -1;;
		boolean flag = false;
	}
	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Node[] tree = new Node[N+1];
		for(int i=0 ; i<N+1 ;i++) tree[i] = new Node();
		for(int i = 1 ; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			tree[a].link.add(b);
			tree[b].link.add(a);
		}
		queue.add(1);
		tree[1].flag = true;
		while(!queue.isEmpty()) {
			int num = queue.poll();
			List<Integer> childs = tree[num].link;
			for(int l : childs) {
				if(!tree[l].flag) {
					queue.add(l);
					tree[l].flag = true;
					tree[l].parent = num;
				}
			}
		}
		
		for(int i = 2; i <=N; i++) {
			System.out.println(tree[i].parent);
		}
	}

}
