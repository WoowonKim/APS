import java.util.Scanner;

public class swea1209_sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int testCase=1; testCase<=10; testCase++) {
			//입력
			int t = sc.nextInt();
			int[][] arr = new int[100][100];
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			//
			//알고리즘
			int[] sumRow = new int [100];
			int[] sumCol = new int [100];
			int sumCro1 = 0;
			int sumCro2 = 0;
			int[] col = new int[100];
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					col[j] = arr[j][i];
				}
				sumRow[i] = sum(arr[i]);
				sumCol[i] = sum(col);
				sumCro1 += arr[i][i];
				sumCro2 += arr[i][99-i];
			}
			int[] maxs = {max(sumRow), max(sumCol), Math.max(sumCro2, sumCro1)};
			
			System.out.println("#"+t+" "+max(maxs));
		}//testCase
	sc.close();	
	}//main
	//배열의 합
	public static int sum(int[] arr) {
		int sum = 0;
		for (int i=0; i < arr.length; i++) {
			sum+=arr[i];
		}
		return sum;
	}
	//배열의 최댓값
	public static int max(int[] arr) {
		int max = -987654321;
		for (int i=0; i < arr.length; i++) {
			if(arr[i]>max) max = arr[i];
		}
		return max;
	}
}//class
