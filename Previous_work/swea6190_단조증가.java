import java.util.Scanner;

public class swea6190_단조증가 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] nums = new int[N];
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			int[] mul = new int[N*(N-1)/2];
			
			int idx = 0;
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					mul[idx++] = nums[i]*nums[j];
				}
			}
			int max = 0;
			for (int i = 0; i < mul.length; i++) {
				boolean flag = true;
				int muln = mul[i];
				int digit = 0;
				while(muln !=0) {
					digit = muln%10;
					muln /= 10;
					if(digit>=muln%10) continue;
					flag = false;
					break;
				}
				if(flag == true && mul[i]>max) {
					max = mul[i];
				}
			}
			if(max==0) {
				System.out.println("#"+tc+" "+-1);
				continue;
			}
			System.out.println("#"+tc+" "+max);
		}//tc
		sc.close();
	}//main

}//class
