import java.util.Scanner;

public class swea1208_Flatten {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int testCase = 1; testCase <= 10; testCase++) {
			// 입력
			int dumpN = sc.nextInt();
			int[] boxes = new int[100];
			for (int i = 0; i < 100; i++) {
				boxes[i] = sc.nextInt();
			}
			int max = 0;
			int min = 0;
			int ans = 0;
			for (int i = 0; i < dumpN+1; i++) {
				int maxIdx = 0;
				int minIdx = 0;
				for (int j = 0; j < boxes.length; j++) {
					if (boxes[j] >= boxes[maxIdx])
						maxIdx = j;
					if (boxes[j] <= boxes[minIdx])
						minIdx = j;
				}
				boxes[maxIdx]--;
				boxes[minIdx]++;
				max = maxIdx;
				min = minIdx;
			}
			ans = boxes[max] - boxes[min];
			// 출력
			System.out.println("#" + testCase + " " + ans);
		}
	}
}
