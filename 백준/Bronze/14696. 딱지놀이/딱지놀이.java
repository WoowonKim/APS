import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int round = 0; round < T; round++) {
			int[] A = new int[5];
			int[] B = new int[5];
			int numA = sc.nextInt();
			for (int i = 0; i < numA; i++) {
				A[sc.nextInt()]++;
			}
			int numB = sc.nextInt();
			for (int i = 0; i < numB; i++) {
				B[sc.nextInt()]++;
			}
			for(int i = 4;i>0;i--) {
				if(A[i]>B[i]) {
					System.out.println("A");
					break;
				}
				if(B[i]>A[i]) {
					System.out.println("B");
					break;
				}
				if(i==1 &&A[i]==B[i]) {
					System.out.println("D");
				}
			}
		}
	}
}