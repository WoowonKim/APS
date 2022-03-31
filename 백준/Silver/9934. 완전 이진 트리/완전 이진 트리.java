import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int size = (int) Math.pow(2, K);
		int[] tree = new int[size-1];
		
		for(int i = 0; i < tree.length; i++) {
			tree[i] = sc.nextInt();
		}
		int incre = K;
		for(int i = 0, st=size/2-1 ; i < K; i++, st/=2) {
			int adder = (int) Math.pow(2, incre--);
			int idx = st;
			for(int k = 0; k < Math.pow(2, i); k++) {
				System.out.print(tree[idx]+" ");
				idx+=adder;
			}
			System.out.println();
		}
	}
}
