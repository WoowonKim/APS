import java.util.Scanner;

public class swea_2817_부분수열 {
	
	static int cnt = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc<=T; tc++) {
			cnt = 0;
			int N = sc.nextInt();
			int K = sc.nextInt();
			boolean[] sel = new boolean[N];
			int[] nums = new int[N];
			for (int i = 0; i <N; i++) {
				nums[i] = sc.nextInt();
			}//입력
			
			powerset(nums,sel,K,0);
			System.out.println("#"+tc+" "+cnt);
		}//testCase
	}//main
	
	public static void powerset(int[] nums,boolean[]sel,int K, int idx) {
		if(idx == sel.length) {
			int sum = 0;
			for (int i = 0; i<sel.length; i++) {
				if(sel[i]){
					sum += nums[i];
				}
			}
			if (sum==K) cnt++;
			return;
		}
		
		sel[idx] = true;
		powerset(nums,sel,K,idx+1);
		sel[idx]= false;
		powerset(nums,sel,K,idx+1);
	}
}//class
