
import java.util.Scanner;

//0 : red, 1 : blue
//left : red, right : blue;
public class Main {
	static int ans;

	static class Node {
		int redLeft;
		int blueLeft;
		int depth;

		public Node(int redLeft, int blueLeft, int depth) {
			ans++;
			this.redLeft = redLeft;
			this.blueLeft = blueLeft;
			this.depth = depth;
			makeLeft();
			makeRight();
		}

		public void makeLeft() {
			if (redLeft > depth) {
				new Node(redLeft - depth - 1, blueLeft, depth + 1);
			}
		}

		private void makeRight() {
			if (blueLeft > depth) {
				new Node(redLeft, blueLeft - depth - 1, depth + 1);
			}
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			ans = 0;
			int red = sc.nextInt();
			int blue = sc.nextInt();
			new Node(red - 1, blue, 1);
			new Node(red, blue - 1, 1);
			System.out.println(ans);
		}
	}
}
