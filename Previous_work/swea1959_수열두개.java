import java.util.Scanner;

public class swea1959_수열두개 {

	public static void main(String[] args) {
		//입력
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int testCase=1; testCase<=T; testCase++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] A = new int[N];
			int[] B = new int[M];
			for(int i=0; i<N; i++) {
				A[i] = sc.nextInt();
			}
			for(int i=0; i<M; i++) {
				B[i] = sc.nextInt();
			}
			//알고리즘
			int diff = N-M;
			int maxSum = 0;
			int sum = 0;
			if (diff<=0) {
				for(int i=0; i<=-diff; i++) {
					for(int j=0; j<N; j++) {
						sum += A[j]*B[j+i];
					}
					if (sum>maxSum) {
						maxSum=sum;
						sum=0;
					} else sum=0;
				}
			} else {
				for(int i=0; i<=diff; i++) {
					for(int j =0; j<M; j++) {
						sum += A[j+i]*B[j];
					}
					if (sum>maxSum) {
						maxSum=sum;
						sum=0;
					} else sum=0;
				}
				
			}
			System.out.println("#"+testCase+" "+maxSum);
		}
	}
}
