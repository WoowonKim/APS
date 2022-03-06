import java.util.Scanner;
public class swea2063_중간값 {
	/*
	 * 중간값 찾기 
	 * 1. 입력 받은 배열 크기 순 정렬
	 * 2. 배열의 갯수 N은 항상 홀수이기 때문에 N/2번째 인덱스가 중간값!
	 */
	public static void main(String[] args) {
		// 배열 갯수 입력
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		//배열
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		//선택정렬
		for (int idx = 0; idx < N-1; idx++) {
			int minIdx = idx;
			for (int i = idx + 1; i < N; i++) {
				if (nums[i] < nums[minIdx]) {
					minIdx = i;
				}
			}
			int tmp = nums[idx];
			nums[idx] = nums[minIdx];
			nums[minIdx] = tmp;
		}
		System.out.printf("%d", nums[N/2]);
	}
}
