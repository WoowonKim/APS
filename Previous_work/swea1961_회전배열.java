import java.util.Scanner;

public class swea1961_회전배열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[][] nums = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					nums[i][j] = sc.nextInt();
				}
			} // 입력
			int[][] ans = new int[N][N*3+2];
			for (int k = 0; k < N*3+2; k+=(N+1)) {
				nums = rotate(nums);
				for (int i = 0, n=0; i < ans.length; i++,n++) {
					for (int j = k, m=0; j < k+N; j++,m++) {
						ans[i][j]=nums[n][m];
					}
				}
			}//회전 후 저장
			
			System.out.println("#" + tc);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N * 3 + 2; j++) {
					if(j%(N+1)==N) {
						System.out.print(" ");
						continue;
					}
					System.out.print(ans[i][j]);
				}
				System.out.println();
			}//출력
		} // testCase
		sc.close();
	}

	private static int[][] rotate(int[][] nums) {
		int[][] rotnum= new int[nums.length][nums.length];
		for (int i = 0; i < rotnum.length; i++) {
			for (int j = 0; j < rotnum.length; j++) {
				rotnum[i][j] = nums[nums.length-1-j][i]; 
			}
		}
		return rotnum;
	}// main

}
