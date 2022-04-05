import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Node {
		int dist = -1;
		int num;
		boolean visited = false;
		List<Node> node = new LinkedList<>();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Node> queue = new LinkedList<>();
		int N = sc.nextInt();
		int person1 = sc.nextInt() - 1;
		int person2 = sc.nextInt() - 1;

		Node[] family = new Node[N];
		for (int i = 0; i < family.length; i++) {
			family[i] = new Node();
			family[i].num = i;
		}

		int nodeNum = sc.nextInt();
		for (int i = 0; i < nodeNum; i++) {
			int node1 = sc.nextInt() - 1;
			int node2 = sc.nextInt() - 1;
			family[node1].node.add(family[node2]);
			family[node2].node.add(family[node1]);
		}
		queue.add(family[person1]);
		family[person1].visited = true;
		while (!queue.isEmpty()) {
			Node person = queue.poll();
			if (person.num == person2)
				break;
			for (Node node : person.node) {
				if (!node.visited) {
					node.dist = person.dist + 1;
					queue.add(node);
					node.visited = true;
				}
			}
		}
	
		System.out.println(family[person2].dist > 0? family[person2].dist+1:family[person2].dist);
	}

}
