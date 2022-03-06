import java.util.Scanner;

public class BOJ6603_로또 {
	static int[] numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int K = sc.nextInt();
			numbers = new int[K];
			if(K==0) {
				sc.close();
				return;
			}
			int[] s = new int[K];
			for(int i = 0; i<K; i++) {
				s[i] = sc.nextInt();
			}
			recur(0,s,0);
			System.out.println();
		}

	}
	public static void recur(int cnt, int[] arr, int start) {
		if(cnt == 6) {
			for (int i = 0; i < 6; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i = start; i<arr.length; i++) {
			numbers[cnt]=arr[i];
			recur(cnt+1,arr,i+1);
		}
		
	}

}
